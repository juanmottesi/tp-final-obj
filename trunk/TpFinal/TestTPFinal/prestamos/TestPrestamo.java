package prestamos;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import installment.calculator.exceptions.InstallmentCountException;
import installment.calculator.exceptions.InvalidAmountException;

import java.util.GregorianCalendar;
import java.util.List;
import java.util.Vector;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import banco.ConfiguracionGeneral;
import cliente.Cliente;
import estadoCuotas.APagar;
import estadoCuotas.Pagada;
import estadoCuotas.Vencida;
import estadoPrestamos.EnCurso;
import estadoPrestamos.Rechazado;
import exceptions.AprobadoException;
import exceptions.EstadoClienteException;
import exceptions.EstadoCuotaException;
import exceptions.RechazadoException;

public class TestPrestamo {
	
	private Prestamo prestamo;
	private GregorianCalendar fechaDeCreacion = new GregorianCalendar();

	@Mock
	private ConfiguracionPrestamo mockedConfiguracionPrestamo = mock(ConfiguracionPrestamo.class);
	private ConfiguracionGeneral mockedConfiguracionGeneral = mock(ConfiguracionGeneral.class);
	private Cliente mockedCliente = mock(Cliente.class);
	
	@Before
	public void setUp() throws InstallmentCountException, InvalidAmountException{
		when(mockedConfiguracionGeneral.consultarTem(12)).thenReturn(3*0.01);
		prestamo = new Prestamo(mockedCliente,20000,12,fechaDeCreacion,mockedConfiguracionPrestamo,mockedConfiguracionGeneral);
	}
	
	@Test
	public void testConstructorVacio() {
		prestamo = new Prestamo();
		assertNotNull(prestamo);
	}
	
	@Test
	public void testConstructorParaAveriguarValorCuota() {
		prestamo = new Prestamo(20000,12,mockedConfiguracionGeneral);
		assertNotNull(prestamo);
		assertEquals("Chequea el monto total",20000,prestamo.getMontoTotal(),0);
		assertEquals("Chequea la cantidad de cuotas",(Integer)12,prestamo.cantidadDeCuotas());
		assertEquals("Chequea la configuracion general", mockedConfiguracionGeneral,prestamo.getConfiguracionGeneral());
	}

	@Test
	public void testConstructorCompletoSinExepciones() throws InstallmentCountException, InvalidAmountException {
		assertNotNull(prestamo);
		assertEquals("Chequea el monto total",20000,prestamo.getMontoTotal(),0);
		assertEquals("Chequea la cantidad de cuotas",(Integer)12,prestamo.cantidadDeCuotas());
		assertEquals("Chequea la configuracion general", mockedConfiguracionGeneral,prestamo.getConfiguracionGeneral());
		assertEquals("Chequea la configuracion del prestamo", mockedConfiguracionPrestamo,prestamo.getConfiguracionPrestamo());
		assertEquals("Chequea el cliente",mockedCliente, prestamo.getCliente());
		assertEquals("Chequea la fecha de creacion", fechaDeCreacion, prestamo.getFechaDeCreacion());
	}

	@Test (expected = InvalidAmountException.class)
	public void testConstructorCompletoConExepcionesMontoCero() throws InstallmentCountException, InvalidAmountException{
		when(mockedConfiguracionGeneral.consultarTem(12)).thenReturn(3*0.01);
		prestamo = new Prestamo(mockedCliente,0,12,fechaDeCreacion,mockedConfiguracionPrestamo,mockedConfiguracionGeneral);
	}

	@Test (expected = InstallmentCountException.class)
	public void testConstructorCompletoConExepcionesCeroCuotas() throws InstallmentCountException, InvalidAmountException{
		when(mockedConfiguracionGeneral.consultarTem(12)).thenReturn(3*0.01);
		prestamo = new Prestamo(mockedCliente,20000,0,fechaDeCreacion,mockedConfiguracionPrestamo,mockedConfiguracionGeneral);
	}

	@Test
	public void testActualizarGastos(){
		prestamo.actualizarGastos(25000);
		assertEquals("Chequea que sete lo que esta como parametro", 25000, prestamo.getMontoTotal(),0);
	}
	
	@Test 
	public void testObtenerDniCliente(){
		when(mockedCliente.obtenerDNI()).thenReturn("36778000");
		assertEquals("36778000", prestamo.obtenerDniCliente());
	}
	
	@Test
	public void testObtenerApellidoCliente(){
		when(mockedCliente.obtenerApellido()).thenReturn("apellido");
		assertEquals("apellido", prestamo.obtenerApellidoCliente());		
	}
	
	@Test
	public void testTengoAlgunaCuotaVencidaSinCuotasVencidas(){
		//El prestamo esta creado con cuotas en estado APAgar
		assertFalse(prestamo.tengoAlgunaCuotaVencida());
	}
	
	@Test
	public void testTengoAlgunaCuotaVencidaConCuotasVencidas(){
		List<Cuota>cuotas = new Vector<Cuota>();
		Cuota mockedCuota = mock(Cuota.class);
		cuotas.add(mockedCuota);
		when(mockedCuota.getEstadoCuota()).thenReturn(new Vencida());
		prestamo.setCuotas(cuotas);
		assertTrue(prestamo.tengoAlgunaCuotaVencida());
	}
	
	@Test
	public void testEstanTodasLasCuotasPagasConTodasPagas(){
		List<Cuota>cuotas = new Vector<Cuota>();
		Cuota mockedCuota = mock(Cuota.class);
		cuotas.add(mockedCuota);
		when(mockedCuota.getEstadoCuota()).thenReturn(new Pagada());
		prestamo.setCuotas(cuotas);
		assertTrue(prestamo.estanTodasLasCuotasPagas());
	}
	
	@Test
	public void testEstanTodasLasCuotasPagasSinCuotasPagas(){
		//El prestamo tiene las cuotas en estado APagar
		assertFalse(prestamo.estanTodasLasCuotasPagas());
		
	}
	
	
	@Test
	public void testCalcularValorCuotaConPrestamoCorrecto(){
		assertEquals(prestamo.getCuotas().get(0).getMontoCuota(), prestamo.consultarValorCuota(),0);
	}
	
	@Test
	public void testCalcularValorCuotaSinMonto(){
		when(mockedConfiguracionGeneral.consultarTem(12)).thenReturn(3*0.01);
		prestamo = new Prestamo(0,12,mockedConfiguracionGeneral);
		assertEquals(0, prestamo.consultarValorCuota(),0);
	}
	
	@Test
	public void testCalcularValorCuotaSinCantCuotas(){
		when(mockedConfiguracionGeneral.consultarTem(12)).thenReturn(3*0.01);
		prestamo = new Prestamo(20000,0,mockedConfiguracionGeneral);
		assertEquals(0, prestamo.consultarValorCuota(),0);
	}
	
	@Test
	public void testVerificarFechaCuotas() throws AprobadoException, EstadoClienteException, EstadoCuotaException{
		GregorianCalendar fechaHoy = new GregorianCalendar();
		List<Cuota>cuotas = new Vector<Cuota>();
		Cuota mockedCuota = mock(Cuota.class);
		cuotas.add(mockedCuota);
		prestamo.aceptarPrestamo();
		prestamo.setCuotas(cuotas);
		when(mockedCuota.getEstadoCuota()).thenReturn(new APagar());
		prestamo.verificarFechaDeCuotas(fechaHoy);
		verify(mockedCuota).verificarFecha(fechaHoy);
	}
	
	@Test
	public void testAceptarPrestamo() throws AprobadoException, EstadoClienteException{
		prestamo.aceptarPrestamo();
		assertEquals(new EnCurso(), prestamo.getEstado());
	}
	
	@Test
	public void testPagarCuota() throws AprobadoException, EstadoClienteException, EstadoCuotaException{
		prestamo.aceptarPrestamo();
		prestamo.pagarCuota(new GregorianCalendar());
		assertEquals(new Pagada(), prestamo.getCuotas().get(0).getEstadoCuota());
	}
	
	@Test
	public void testRechazarPrestamo() throws RechazadoException, EstadoClienteException{
		prestamo.rechazarPrestamo();
		assertEquals(new Rechazado(),prestamo.getEstado());
	}
	

}

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

import cliente.Cliente;
import estadoCuotas.APagar;
import estadoCuotas.Pagada;
import estadoCuotas.Vencida;
import estadoPrestamos.EnCurso;
import estadoPrestamos.Finalizado;
import exceptions.AprobadoException;
import exceptions.EstadoCuotaException;
import otros.ConfiguracionGeneral;

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
		when(mockedCliente.getDni()).thenReturn("36778000");
		assertEquals("36778000", prestamo.obtenerDniCliente());
	}
	
	@Test
	public void testObtenerApellidoCliente(){
		when(mockedCliente.getApellido()).thenReturn("apellido");
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
	public void testFinalizarPrestamoConCuotasPagas() throws AprobadoException {
		List<Cuota>cuotas = new Vector<Cuota>();
		Cuota mockedCuota = mock(Cuota.class);
		cuotas.add(mockedCuota);
		when(mockedCuota.getEstadoCuota()).thenReturn(new APagar());
		prestamo.aceptarPrestamo();
		prestamo.setCuotas(cuotas);
		prestamo.pagarCuota(new GregorianCalendar());
		// modifica la cuota y la pasa a pagada pero al ser mock sigue valiendo lo que esta en el when
		when(mockedCuota.getEstadoCuota()).thenReturn(new Pagada());
		prestamo.finalizarPrestamo();
		assertEquals(new Finalizado(), prestamo.getEstado());
	}
	
	@Test
	public void testFinalizarPrestamoSinCuotasPagas(){
		prestamo.finalizarPrestamo();
		assertNotEquals(new Finalizado(), prestamo.getEstado());
	}
	
	@Test
	public void testCuadroDeMarcha(){
		List<Cuota> auxiliar = prestamo.cuadroDeMarcha();
		assertEquals(auxiliar, prestamo.getCuotas());
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
	public void testVerificarFechaCuotas() throws EstadoCuotaException{
		GregorianCalendar fechaHoy = new GregorianCalendar();
		List<Cuota>cuotas = new Vector<Cuota>();
		Cuota mockedCuota = mock(Cuota.class);
		cuotas.add(mockedCuota);
		prestamo.setCuotas(cuotas);
		when(mockedCuota.getEstadoCuota()).thenReturn(new APagar());
		prestamo.verificarFechaDeCuotas(fechaHoy);
		verify(mockedCuota).verificarFecha(fechaHoy);
	}
	
	@Test
	public void testAceptarPrestamo() throws AprobadoException{
		prestamo.aceptarPrestamo();
		assertEquals(new EnCurso(), prestamo.getEstado());
	}
	
	@Test
	public void testPagarCuota() throws AprobadoException{
		prestamo.aceptarPrestamo();
		prestamo.pagarCuota(new GregorianCalendar());
		assertEquals(new Pagada(), prestamo.getCuotas().get(0).getEstadoCuota());
	}
	
}

package prestamos;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import installment.calculator.exceptions.InstallmentCountException;
import installment.calculator.exceptions.InvalidAmountException;

import java.util.Date;

import org.junit.Test;
import org.mockito.Mock;

import otros.Cliente;
import otros.ConfiguracionGeneral;

public class TestPrestamo {
	
	private Prestamo prestamo;
	private Date fechaDeCreacion = new Date();

	@Mock
	private ConfiguracionPrestamo mockedConfiguracionPrestamo = mock(ConfiguracionPrestamo.class);
	private ConfiguracionGeneral mockedConfiguracionGeneral = mock(ConfiguracionGeneral.class);
	private Cliente mockedCliente = mock(Cliente.class);
	
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
		when(mockedConfiguracionGeneral.consultarTem(12)).thenReturn(3*0.01);
		prestamo = new Prestamo(mockedCliente,20000,12,fechaDeCreacion,mockedConfiguracionPrestamo,mockedConfiguracionGeneral);
		assertNotNull(prestamo);
		assertEquals("Chequea el monto total",20000,prestamo.getMontoTotal(),0);
		assertEquals("Chequea la cantidad de cuotas",(Integer)12,prestamo.cantidadDeCuotas());
		assertEquals("Chequea la configuracion general", mockedConfiguracionGeneral,prestamo.getConfiguracionGeneral());
		assertEquals("Chequea la configuracion del prestamo", mockedConfiguracionPrestamo,prestamo.getConfiguracionPrestamo());
		assertEquals("Chequea el cliente",mockedCliente, prestamo.getCliente());
		assertEquals("Chequea la fecha de creacion", fechaDeCreacion, prestamo.getFechaDeCreacion());
	}

	@Test (expected = InvalidAmountException.class)
	public void testConstructorCompletoConExepcionesMontoCero() throws InstallmentCountException, InvalidAmountException {
		when(mockedConfiguracionGeneral.consultarTem(12)).thenReturn(3*0.01);
		prestamo = new Prestamo(mockedCliente,0,12,fechaDeCreacion,mockedConfiguracionPrestamo,mockedConfiguracionGeneral);
	}

	@Test (expected = InstallmentCountException.class)
	public void testConstructorCompletoConExepcionesCeroCuotas() throws InstallmentCountException, InvalidAmountException {
		when(mockedConfiguracionGeneral.consultarTem(12)).thenReturn(3*0.01);
		prestamo = new Prestamo(mockedCliente,20000,0,fechaDeCreacion,mockedConfiguracionPrestamo,mockedConfiguracionGeneral);
	}

}

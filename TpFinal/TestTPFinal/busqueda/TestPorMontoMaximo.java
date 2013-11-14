package busqueda;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import prestamos.Prestamo;
import busqueda.PorMontoMaximo;


public class TestPorMontoMaximo {
	
	private double monto;
	private PorMontoMaximo porMontoMaximo;
	
	@Mock
	Prestamo mockedPrestamo = mock(Prestamo.class);
	
	@Before
	public void setUp(){
		monto = 35000;
		porMontoMaximo = new PorMontoMaximo(monto);
	}
	
	@Test
	public void testConstructor() {
		assertNotNull(porMontoMaximo);
	}

	@Test
	public void testRespetaCondicionConCondicionVerdadera(){
		when(mockedPrestamo.getMontoTotal()).thenReturn(monto-1);
		assertTrue(porMontoMaximo.respetaCondicion(mockedPrestamo));
	}
	
	@Test
	public void testRespetaCondicionConCondicionFalsa(){
		when(mockedPrestamo.getMontoTotal()).thenReturn(monto);
		assertFalse(porMontoMaximo.respetaCondicion(mockedPrestamo));		
	}
	
}

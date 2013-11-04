package busqueda;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import prestamos.Prestamo;
import busqueda.PorMontoMaximo;


public class TestPorMontoMaximo {
	
	private double monto;
	private PorMontoMaximo porMontoMaximo;
	
	@Before
	public void setUp(){
		monto = 35000;
		porMontoMaximo = new PorMontoMaximo(monto);
	}
	
	
	@Test
	public void testConstructor() {
		assertNotNull(porMontoMaximo);
		assertEquals("Chequea si el seter funciona bien",monto, porMontoMaximo.getMaximo(),0);
		double montoAux = monto + monto;
		assertNotEquals("Chequea si el seter funciona bien",montoAux, porMontoMaximo.getMaximo(),0);
	}

	@Test
	public void testResetaCondicion(){
		Prestamo mockedPrestamo = mock(Prestamo.class);
		
		when(mockedPrestamo.getMontoTotal()).thenReturn(monto-1);
		assertTrue(porMontoMaximo.respetaCondicion(mockedPrestamo));
		
		when(mockedPrestamo.getMontoTotal()).thenReturn(monto);
		assertFalse(porMontoMaximo.respetaCondicion(mockedPrestamo));
		
		when(mockedPrestamo.getMontoTotal()).thenReturn(monto+monto);
		assertFalse(porMontoMaximo.respetaCondicion(mockedPrestamo));
		
	}
	
}

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import busqueda.PorMontoMinimo;
import prestamos.Prestamo;



public class TestPorMontoMinimo {

	private double monto;
	private PorMontoMinimo porMontoMinimo;
	
	@Before
	public void setUp(){
		monto = 15000;
		porMontoMinimo = new PorMontoMinimo(monto);
	}
	
	
	@Test
	public void testConstructor() {
		assertNotNull(porMontoMinimo);
		assertEquals("Chequea si el seter funciona bien",monto, porMontoMinimo.getMinimo(),0);
		double montoAux = monto + monto;
		assertNotEquals("Chequea si el seter funciona bien",montoAux, porMontoMinimo.getMinimo(),0);
	}

	@Test
	public void testResetaCondicion(){
		Prestamo mockedPrestamo = mock(Prestamo.class);
		
		when(mockedPrestamo.getMontoTotal()).thenReturn(monto+monto);
		assertTrue(porMontoMinimo.respetaCondicion(mockedPrestamo));
		
		when(mockedPrestamo.getMontoTotal()).thenReturn(monto);
		assertFalse(porMontoMinimo.respetaCondicion(mockedPrestamo));
		
		when(mockedPrestamo.getMontoTotal()).thenReturn(monto-1);
		assertFalse(porMontoMinimo.respetaCondicion(mockedPrestamo));
		
	}

}

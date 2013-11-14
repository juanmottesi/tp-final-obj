package busqueda;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import busqueda.PorMontoMinimo;
import prestamos.Prestamo;



public class TestPorMontoMinimo {

	private double monto;
	private PorMontoMinimo porMontoMinimo;

	@Mock
	Prestamo mockedPrestamo = mock(Prestamo.class);
	
	@Before
	public void setUp(){
		monto = 15000;
		porMontoMinimo = new PorMontoMinimo(monto);
	}
	
	
	@Test
	public void testConstructor() {
		assertNotNull(porMontoMinimo);
	}

	@Test
	public void testRespetaCondicionConCondicionVerdadera(){		
		when(mockedPrestamo.getMontoTotal()).thenReturn(monto+monto);
		assertTrue(porMontoMinimo.respetaCondicion(mockedPrestamo));
	}
	@Test
	public void testRespetaCondicionConCondicionFalsa(){	
		when(mockedPrestamo.getMontoTotal()).thenReturn(monto);
		assertFalse(porMontoMinimo.respetaCondicion(mockedPrestamo));
	}

}

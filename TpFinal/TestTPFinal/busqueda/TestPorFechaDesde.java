package busqueda;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.GregorianCalendar;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import prestamos.Prestamo;
import busqueda.PorFechaDesde;


public class TestPorFechaDesde {
	
	private GregorianCalendar fecha = new GregorianCalendar();
	private PorFechaDesde porFechaDesde;
	
	@Mock
	Prestamo mockedPrestamo = mock(Prestamo.class);
	
	@Before
	public void setUp(){
		porFechaDesde = new PorFechaDesde(fecha);
	}

	@Test
	public void testConstructor() {
		assertNotNull(porFechaDesde);
	}

	@Test
	public void testRespetaCondicionConCondicionVerdadera(){
		GregorianCalendar fechaDespues = new GregorianCalendar(fecha.get(1),fecha.get(2),fecha.get(5)+1);
		when(mockedPrestamo.getFechaDeCreacion()).thenReturn(fechaDespues);
		assertTrue(porFechaDesde.respetaCondicion(mockedPrestamo));
	}
	
	@Test
	public void testRespetaCondicionConCondicionFalsa(){
		GregorianCalendar fechaAntes = new GregorianCalendar(fecha.get(1),fecha.get(2),fecha.get(5)-1);
		when(mockedPrestamo.getFechaDeCreacion()).thenReturn(fechaAntes);
		assertFalse(porFechaDesde.respetaCondicion(mockedPrestamo));
	}
	
}

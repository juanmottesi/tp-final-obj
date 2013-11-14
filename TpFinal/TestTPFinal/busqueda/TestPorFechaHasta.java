package busqueda;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.GregorianCalendar;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import prestamos.Prestamo;
import busqueda.PorFechaHasta;


public class TestPorFechaHasta {

	private GregorianCalendar fecha = new GregorianCalendar();
	private PorFechaHasta porFechaHasta;
	
	@Mock
	Prestamo mockedPrestamo = mock(Prestamo.class);
	
	@Before
	public void setUp(){
		porFechaHasta = new PorFechaHasta(fecha);
	}

	@Test
	public void testConstructor() {
		assertNotNull(porFechaHasta);
	}

	@Test
	public void testRespetaCondicionConCondicionVerdadera(){
		GregorianCalendar fechaAntes = new GregorianCalendar(fecha.get(1),fecha.get(2),fecha.get(5)-1);
		when(mockedPrestamo.getFechaDeCreacion()).thenReturn(fechaAntes);
		assertTrue(porFechaHasta.respetaCondicion(mockedPrestamo));
	}
	
	@Test
	public void testRespetaCondicionConCondicionFalsa(){
		GregorianCalendar fechaDespues = new GregorianCalendar(fecha.get(1),fecha.get(2),fecha.get(5)+1);when(mockedPrestamo.getFechaDeCreacion()).thenReturn(fechaDespues);
		when(mockedPrestamo.getFechaDeCreacion()).thenReturn(fechaDespues);
		assertFalse(porFechaHasta.respetaCondicion(mockedPrestamo));
	}
	
}

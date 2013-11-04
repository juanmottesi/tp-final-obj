import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import prestamos.Prestamo;
import busqueda.PorFechaDesde;


public class TestPorFechaDesde {
	
	private Date fecha;
	private PorFechaDesde porFechaDesde;
	
	@Before
	public void setUp(){
		//Seteo la fecha de hoy.
		fecha = new Date();
		porFechaDesde = new PorFechaDesde(fecha);
	}

	@Test
	public void testConstructor() {
		assertNotNull(porFechaDesde);
		assertEquals("Se fija si la fehca es la mismo que setea en la clase PorFechaDesde", fecha, porFechaDesde.getDesde());
		@SuppressWarnings("deprecation")
		Date fechaAux = new Date(2013,11,03); 
		assertNotEquals("Se fija si la fehca no es la mismo que setea en la clase PorFechaDesde", fechaAux, porFechaDesde.getDesde());
	}

	@Test
	public void testRespetaCondicion(){
		Prestamo mockedPrestamo = mock(Prestamo.class);
		@SuppressWarnings("deprecation")
		Date fechaDespues = new Date(fecha.getYear(),fecha.getMonth(),fecha.getDate()+1);
		when(mockedPrestamo.getFechaDeCreacion()).thenReturn(fechaDespues);
		assertTrue(porFechaDesde.respetaCondicion(mockedPrestamo));
		
		@SuppressWarnings("deprecation")
		Date fechaAntes = new Date(fecha.getYear(),fecha.getMonth(),fecha.getDate()-1); 
		when(mockedPrestamo.getFechaDeCreacion()).thenReturn(fechaAntes);
		assertFalse(porFechaDesde.respetaCondicion(mockedPrestamo));
	}
	
}

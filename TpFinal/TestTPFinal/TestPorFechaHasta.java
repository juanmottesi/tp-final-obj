import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import prestamos.Prestamo;
import busqueda.PorFechaHasta;


public class TestPorFechaHasta {

	private Date fecha;
	private PorFechaHasta porFechaHasta;
	
	@Before
	public void setUp(){
		//Seteo la fecha de hoy.
		fecha = new Date();
		porFechaHasta = new PorFechaHasta(fecha);
	}

	@Test
	public void testConstructor() {
		assertNotNull(porFechaHasta);
		assertEquals("Se fija si la fehca es la mismo que setea en la clase PorFechaHasta", fecha, porFechaHasta.getHasta());
		@SuppressWarnings("deprecation")
		Date fechaAux = new Date(2013,11,03); 
		assertNotEquals("Se fija si la fehca no es la mismo que setea en la clase PorFechaHasta", fechaAux, porFechaHasta.getHasta());
	}

	@Test
	public void testRespetaCondicion(){
		Prestamo mockedPrestamo = mock(Prestamo.class);
		
		//Creo una fecha antes de la que tiene seteado porFechaHasta
		@SuppressWarnings("deprecation")
		Date fechaAntes = new Date(fecha.getYear(),fecha.getMonth(),fecha.getDate()-1);
		when(mockedPrestamo.getFechaDeCreacion()).thenReturn(fechaAntes);
		assertTrue(porFechaHasta.respetaCondicion(mockedPrestamo));
		
		//Creo una fecha despues de la que tiene seteado porFechaHasta
		@SuppressWarnings("deprecation")
		Date fechaDespues = new Date(fecha.getYear(),fecha.getMonth(),fecha.getDate()+1); 
		when(mockedPrestamo.getFechaDeCreacion()).thenReturn(fechaDespues);
		assertFalse(porFechaHasta.respetaCondicion(mockedPrestamo));
	}
	
}

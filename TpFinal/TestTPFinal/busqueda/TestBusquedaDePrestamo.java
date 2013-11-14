package busqueda;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Date;
import java.util.List;
import java.util.Vector;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import prestamos.Prestamo;
import estadoPrestamos.EnCurso;

public class TestBusquedaDePrestamo {
	
	private BusquedaDePrestamo busquedaDePrestamo;
	private List<Prestamo> prestamos;
	
	@Mock
	Prestamo mockedPrestamo = mock(Prestamo.class);
	Condicion mockedCondicion = mock(Condicion.class);
	
	@Before
	public void setUp(){
		busquedaDePrestamo = new BusquedaDePrestamo(mockedCondicion);
		prestamos = new Vector<Prestamo>();
		prestamos.add(mockedPrestamo);		
	}
	
	@Test
	public void testConstructor(){
		assertNotNull(busquedaDePrestamo);
	}
	
	@Test
	public void testBuscarConCondicionVerdadera(){
		when(mockedCondicion.respetaCondicion(mockedPrestamo)).thenReturn(true);
		assertEquals("Como la condicion es verdadere tiene que ser la misma lista",prestamos,busquedaDePrestamo.buscar(prestamos));
	} 
	
	@Test
	public void testBuscarConCondicionFalsa(){
		when(mockedCondicion.respetaCondicion(mockedPrestamo)).thenReturn(false);
		assertTrue("Como la condicion es falsa el resultado tiene que ser vacio",(busquedaDePrestamo.buscar(prestamos)).isEmpty());
	}
	
}

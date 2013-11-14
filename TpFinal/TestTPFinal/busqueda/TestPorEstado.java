package busqueda;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import org.mockito.Mock;

import prestamos.Prestamo;
import estadoPrestamos.EnCurso;
import estadoPrestamos.EnDeuda;
import estadoPrestamos.EstadoPrestamo;
import busqueda.PorEstado;


public class TestPorEstado {
	private EstadoPrestamo estadoPrestamo;
	private PorEstado porEstado;

	@Mock
	Prestamo mockedPrestamo = mock(Prestamo.class);
	
	@Before
	public void setUp(){
		estadoPrestamo = new EnCurso();
		porEstado = new PorEstado(estadoPrestamo);
	}
	
	@Test
	public void testConstructor() {
		assertNotNull(porEstado);
	}
	
	@Test
	public void testRespetaCondicionConCondicionVerdadera(){
		when(mockedPrestamo.getEstado()).thenReturn(new EnCurso());
		assertTrue(porEstado.respetaCondicion(mockedPrestamo));
	}
		
	@Test
	public void testRespetaCondicionConCondicionFalsa(){
		when(mockedPrestamo.getEstado()).thenReturn(new EnDeuda());
		assertFalse(porEstado.respetaCondicion(mockedPrestamo));
	}
	
}

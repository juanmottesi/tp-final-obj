import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;






import prestamos.Prestamo;
import estadoPrestamos.EnCurso;
import estadoPrestamos.EnDeuda;
import estadoPrestamos.EstadoPrestamo;
import estadoPrestamos.Rechazado;
import busqueda.PorEstado;


public class TestPorEstado {
	private EstadoPrestamo estadoPrestamo;
	private PorEstado porEstado;

	@Before
	public void setUp(){
		estadoPrestamo = new EnCurso();
		porEstado = new PorEstado(estadoPrestamo);
	}
	
	@Test
	public void testConstructor() {
		assertNotNull(porEstado);
		assertEquals("Se fija si el estado es el mismo que setea en la clase PorEstado",estadoPrestamo, porEstado.getEstado());
		EstadoPrestamo estadoAux = new Rechazado();
		assertNotEquals("Se fija si el estado no es el mismo que setea en la clase PorEstado",estadoAux, porEstado.getEstado());
	}

	public void testRespetaCondicion(){
		Prestamo mockedPrestamo = mock(Prestamo.class);
		
		when(mockedPrestamo.getEstado()).thenReturn(estadoPrestamo);
		assertTrue(porEstado.respetaCondicion(mockedPrestamo));
		
		when(mockedPrestamo.getEstado()).thenReturn(new Rechazado());
		assertFalse(porEstado.respetaCondicion(mockedPrestamo));
		
		
	}
	
}

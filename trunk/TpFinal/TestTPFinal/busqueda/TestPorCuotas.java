package busqueda;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import prestamos.Prestamo;
import busqueda.PorCuotas;

public class TestPorCuotas {
	
	private PorCuotas porCuotas;
	private static final Integer desde = 1;
	private static final Integer hasta = 15;
	public Integer retorno = 12;

	@Before
	public void setUp(){
		porCuotas = new PorCuotas(desde,hasta);

	}
	

	@Test
	public void testConstructor() {
		assertNotNull(porCuotas);
		assertEquals("Se fija si el desde es igual",desde, porCuotas.getDesde());
		assertEquals("Se fija si el hasta es igual",hasta, porCuotas.getHasta());
	}

	@Test
	public void testRespetaCondicion(){
		Prestamo mockedPrestamo = mock(Prestamo.class);
		
		when(mockedPrestamo.cantidadDeCuotas()).thenReturn(retorno);
		assertTrue(porCuotas.respetaCondicion(mockedPrestamo));
		
		when(mockedPrestamo.cantidadDeCuotas()).thenReturn(retorno+4);
		assertFalse(porCuotas.respetaCondicion(mockedPrestamo));
		
		
	}

}

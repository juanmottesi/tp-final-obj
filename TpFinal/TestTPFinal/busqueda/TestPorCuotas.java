package busqueda;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import prestamos.Prestamo;
import busqueda.PorCuotas;

public class TestPorCuotas {
	
	private PorCuotas porCuotas;
	private static final Integer desde = 1;
	private static final Integer hasta = 15;
	public Integer retorno = 12;

	@Mock
	Prestamo mockedPrestamo = mock(Prestamo.class);
	
	@Before
	public void setUp(){
		porCuotas = new PorCuotas(desde,hasta);
	}
	
	@Test
	public void testConstructor() {
		assertNotNull(porCuotas);
	}

	@Test
	public void testRespetaCondicionConCondicionVerdadera(){
		when(mockedPrestamo.cantidadDeCuotas()).thenReturn(retorno);
		assertTrue(porCuotas.respetaCondicion(mockedPrestamo));
	}
	
	@Test
	public void testRespetaCondicionConCondicionFalsa(){
		when(mockedPrestamo.cantidadDeCuotas()).thenReturn(retorno+4);
		assertFalse(porCuotas.respetaCondicion(mockedPrestamo));
	}

}

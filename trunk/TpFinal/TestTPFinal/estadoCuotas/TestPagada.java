package estadoCuotas;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import org.junit.Before;
import org.junit.Test;

import exceptions.PagadaException;
import prestamos.Cuota;


public class TestPagada {
	
	private Pagada pagada;
	
	@Before
	public void setUp(){
		pagada = new Pagada();		
	}

	@Test
	public void testConstructor() {
		assertNotNull(pagada);
	}

	@Test
	public void testEstaPaga() {
		assertTrue(pagada.estaPaga());
	}
	
	@Test (expected = PagadaException.class)
	public void testPagar() throws PagadaException{
		Cuota mockedCuota = mock(Cuota.class);
		pagada.pagar(mockedCuota);
		
	}
	
	@Test (expected = PagadaException.class)
	public void testAVencido() throws PagadaException{
		Cuota mockedCuota = mock(Cuota.class);
		pagada.aVencido(mockedCuota);
		
	}
	
	
}

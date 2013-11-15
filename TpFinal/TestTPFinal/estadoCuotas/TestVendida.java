package estadoCuotas;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import prestamos.Cuota;


public class TestVendida {
	
	private Vencida vencida;
	
	@Mock
	Cuota mockedCuota = mock(Cuota.class);
	
	@Before 
	public void setUp(){
		vencida = new Vencida();
	}

	@Test
	public void testConstructor() {
		assertNotNull(vencida);
	}
	
	@Test 
	public void testEstaPaga(){
		assertFalse(vencida.estaPaga());
	}
	
	@Test
	public void testPagar(){
		vencida.pagar(mockedCuota);
		verify(mockedCuota).setEstadoCuota(new Pagada());
	}
	
	@Test
	public void testAVencido(){
		vencida.aVencido(mockedCuota);
		verify(mockedCuota).setEstadoCuota(vencida);
	}

}

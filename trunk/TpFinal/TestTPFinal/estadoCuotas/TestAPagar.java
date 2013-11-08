package estadoCuotas;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

import prestamos.Cuota;

public class TestAPagar {

	private APagar aPagar;
	
	@Before 
	public void setUp(){
		aPagar = new APagar();
	}
	
	@Test
	public void testConstructor() {
		assertNotNull(aPagar);
	}

	@Test
	public void testEstaPaga(){
		assertFalse(aPagar.estaPaga());
	}
	
	@Test
	public void testPagar(){
		Cuota mockedCuota = mock(Cuota.class);
		aPagar.pagar(mockedCuota);
		verify(mockedCuota).setEstadoCuota(new Pagada());
	}
	
	@Test 
	public void testAVencida(){
		Cuota mockedCuota = mock(Cuota.class);
		aPagar.aVencido(mockedCuota);
		verify(mockedCuota).setEstadoCuota(new Vencida());
	}

}

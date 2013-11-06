import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import prestamos.Cuota;

public class TestCuota {
	
	
	private Cuota cuota;

	
	
	@SuppressWarnings("deprecation")
	@Before
	public void setUp(){
		double f = 0;
		cuota= new Cuota(new Date(2013,11,02),1500,1,f,f,f);
	}
	

	@Test
	public void testPagar() {
		
		cuota.pagar(new Date());
		assertEquals(true, cuota.estaPaga());
	}
	


}


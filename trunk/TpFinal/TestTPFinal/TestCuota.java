import static org.junit.Assert.*;
//import static org.mockito.Mockito.*;

import java.util.Date;

//import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
//import org.mockito.Mockito;

//import prestamos.APagar;
import prestamos.Cuota;
//import prestamos.EstadoCuota;
//import prestamos.Pagada;
//import prestamos.Prestamo;

public class TestCuota {
	
	
	private Cuota cuota;
	
//	private Prestamo mockPrestamo;
	
	@Before
	public void setUp(){
		double f = 0;
		cuota= new Cuota(new Date(),1500,1,f,/*f,*/f,f,f,f);
//		EstadoCuota mockEstado= mock(APagar.class);
//		cuota.setEstadoCuota(mockEstado);
		//mockPrestamo = mock(Prestamo.class);
	}

	@Test
	public void testPagar() {
		
		cuota.pagar(new Date());
		
		//verify(cuota, Mockito.times(0)).pagar(new Date());
		assertEquals(true, cuota.estaPaga());//("asd",true, cuota.estaPaga());
	}

}


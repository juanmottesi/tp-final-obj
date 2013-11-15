package estadoCuotas;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestEstadoCuota {

	private EstadoCuota estadoCuota1;
	private EstadoCuota estadoCuota2;
	
	@Before 
	public void setUp(){
		estadoCuota1 = new APagar();
		estadoCuota2 = new APagar();
	}
	
	@Test
	public void testEqualsVerdadero() {
		assertTrue(estadoCuota1.equals(estadoCuota2));
		assertTrue(estadoCuota2.equals(estadoCuota1));
	}

	@Test
	public void testEqualsFalsoConPagada() {
		estadoCuota2 = new Pagada();
		
		assertFalse(estadoCuota1.equals(estadoCuota2));
		assertFalse(estadoCuota2.equals(estadoCuota1));
	}
	
	@Test
	public void testEqualsFalsoConVencida() {
		estadoCuota2 = new Vencida();
		
		assertFalse(estadoCuota1.equals(estadoCuota2));
		assertFalse(estadoCuota2.equals(estadoCuota1));
	}
	
}

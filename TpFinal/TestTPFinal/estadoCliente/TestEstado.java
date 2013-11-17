package estadoCliente;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestEstado {

	private Estado estado1;
	private Estado estado2;
	
	@Before 
	public void setUp(){
		estado1 = new EnCurso();
		estado2 = new EnCurso();
	}
	
	@Test
	public void testEqualsVerdadero() {
		assertTrue(estado1.equals(estado2));
		assertTrue(estado2.equals(estado1));
	}

	@Test
	public void testEqualsFalsoConEnDeuda() {
		estado2 = new EnDeuda();
		
		assertFalse(estado1.equals(estado2));
		assertFalse(estado2.equals(estado1));
	}
	
	@Test
	public void testEqualsFalsoConDeudorIncobrable() {
		estado2 = new DeudorIncobrable();
		
		assertFalse(estado1.equals(estado2));
		assertFalse(estado2.equals(estado1));
	}
		
	@Test
	public void testEqualsFalsoConSolicitado() {
		estado2 = new Solicitado();
		
		assertFalse(estado1.equals(estado2));
		assertFalse(estado2.equals(estado1));
	}
		
	@Test
	public void testEqualsFalsoConSinPrestamo() {
		estado2 = new SinPrestamo();
		
		assertFalse(estado1.equals(estado2));
		assertFalse(estado2.equals(estado1));
	}
	
	@Test
	public void testEqualsConElMismoEstado(){
		assertTrue(estado1.equals(estado1));
	}
	
	@Test
	public void testEqualsConUnEstadoNull(){
		assertFalse(estado1.equals(null));
	}


}

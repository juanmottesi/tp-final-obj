package estadoPrestamo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import estadoPrestamos.DeudorIncobrable;
import estadoPrestamos.EnCurso;
import estadoPrestamos.EnDeuda;
import estadoPrestamos.EstadoPrestamo;
import estadoPrestamos.Finalizado;
import estadoPrestamos.Rechazado;
import estadoPrestamos.Solicitado;

public class TestEstadoPrestamo {

	private EstadoPrestamo estadoPrestamo1;
	private EstadoPrestamo estadoPrestamo2;
	
	@Before 
	public void setUp(){
		estadoPrestamo1 = new EnCurso();
		estadoPrestamo2 = new EnCurso();
	}
	
	@Test
	public void testEqualsVerdadero() {
		assertTrue(estadoPrestamo1.equals(estadoPrestamo2));
		assertTrue(estadoPrestamo2.equals(estadoPrestamo1));
	}

	@Test
	public void testEqualsFalsoConEnDeuda() {
		estadoPrestamo2 = new EnDeuda();
		
		assertFalse(estadoPrestamo1.equals(estadoPrestamo2));
		assertFalse(estadoPrestamo2.equals(estadoPrestamo1));
	}
	
	@Test
	public void testEqualsFalsoConDeudorIncobrable() {
		estadoPrestamo2 = new DeudorIncobrable();
		
		assertFalse(estadoPrestamo1.equals(estadoPrestamo2));
		assertFalse(estadoPrestamo2.equals(estadoPrestamo1));
	}
	
	@Test
	public void testEqualsFalsoConFinalizado() {
		estadoPrestamo2 = new Finalizado();
		
		assertFalse(estadoPrestamo1.equals(estadoPrestamo2));
		assertFalse(estadoPrestamo2.equals(estadoPrestamo1));
	}
	
	@Test
	public void testEqualsFalsoConRechazado() {
		estadoPrestamo2 = new Rechazado();
		
		assertFalse(estadoPrestamo1.equals(estadoPrestamo2));
		assertFalse(estadoPrestamo2.equals(estadoPrestamo1));
	}
	
	@Test
	public void testEqualsFalsoConSolicitado() {
		estadoPrestamo2 = new Solicitado();
		
		assertFalse(estadoPrestamo1.equals(estadoPrestamo2));
		assertFalse(estadoPrestamo2.equals(estadoPrestamo1));
	}
		
	@Test
	public void testEqualsConElMismoEstado(){
		assertTrue(estadoPrestamo1.equals(estadoPrestamo1));
	}
	
	@Test
	public void testEqualsConUnEstadoNull(){
		assertFalse(estadoPrestamo1.equals(null));
	}

}

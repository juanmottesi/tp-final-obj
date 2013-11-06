package estadoPrestamo;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import prestamos.Prestamo;
import estadoPrestamos.EnCurso;
import exceptions.DeudorIncobrableException;

public class TestEnCurso {
	private EnCurso enCurso;
	
	@Before
	public void setUp() throws Exception {
		
		enCurso= new EnCurso();
	}
	
	@Test(expected= DeudorIncobrableException.class)
	public void testADeudorIncobrable() throws DeudorIncobrableException {
	
	Prestamo mockedPrestamo= mock(Prestamo.class);
	
	when(mockedPrestamo.getEstado()).thenReturn(enCurso);
	
	mockedPrestamo.getEstado().aDeudorIncobrable(mockedPrestamo);
	
	assertSame(enCurso, mockedPrestamo.getEstado());
	}

}

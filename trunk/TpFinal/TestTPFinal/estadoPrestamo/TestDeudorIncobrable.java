package estadoPrestamo;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import prestamos.Prestamo;
import estadoPrestamos.DeudorIncobrable;
import estadoPrestamos.EstadoPrestamo;
import exceptions.AprobadoException;
import exceptions.DeudorIncobrableException;
import exceptions.EnCursoException;
import exceptions.EnDeudaException;
import exceptions.FinalizadoException;
import exceptions.RechazadoException;
import static org.mockito.Mock.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class TestDeudorIncobrable {
	
	private DeudorIncobrable enDeudorIncobrable;
	private Prestamo mockedPrestamo;
	
	@Before
	public void setUp() {
		enDeudorIncobrable= new DeudorIncobrable();
		mockedPrestamo= mock(Prestamo.class);
		
	}
	
	@Test(expected = DeudorIncobrableException.class)
	public void testADeudorIncobrable() throws DeudorIncobrableException {
		
		when(mockedPrestamo.getEstado()).thenReturn(enDeudorIncobrable);
		
		mockedPrestamo.getEstado().aDeudorIncobrable(mockedPrestamo);
		
		assertSame(enDeudorIncobrable, mockedPrestamo.getEstado());
		}
	
	@Test(expected = AprobadoException.class)
	public void testAprobar() throws AprobadoException {
		
		when(mockedPrestamo.getEstado()).thenReturn(enDeudorIncobrable);
		
		mockedPrestamo.getEstado().aprobar(mockedPrestamo);
		
		assertSame(enDeudorIncobrable, mockedPrestamo.getEstado());
		}

	@Test(expected = RechazadoException.class)
	public void testRechazar() throws RechazadoException {
		
		when(mockedPrestamo.getEstado()).thenReturn(enDeudorIncobrable);
		
		mockedPrestamo.getEstado().rechazar(mockedPrestamo);
		
		assertSame(enDeudorIncobrable, mockedPrestamo.getEstado());
		}

	@Test (expected = FinalizadoException.class)
	public void testFinalizar() throws FinalizadoException{
		
		when(mockedPrestamo.getEstado()).thenReturn(enDeudorIncobrable);
		
		mockedPrestamo.getEstado().finalizar(mockedPrestamo);
	}

	@Test (expected = EnDeudaException.class)
	public void testAEnDeuda() throws EnDeudaException{
		
		when(mockedPrestamo.getEstado()).thenReturn(enDeudorIncobrable);
		
		mockedPrestamo.getEstado().aEnDeuda(mockedPrestamo);
		
		assertSame(enDeudorIncobrable, mockedPrestamo.getEstado());
	}

	@Test 
	public void testAEnCurso() throws EnCursoException{
		
		enDeudorIncobrable.aEnCurso(mockedPrestamo);
		verify(mockedPrestamo).setEstado(any(EnCurso.class));
		
	}


}



package estadoPrestamo;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

import prestamos.Prestamo;
import estadoPrestamos.DeudorIncobrable;
import estadoPrestamos.EnCurso;
import estadoPrestamos.EnDeuda;
import exceptions.AprobadoException;
import exceptions.EnCursoException;
import exceptions.FinalizadoException;
import exceptions.RechazadoException;

public class TestEnDeuda {
	
	private EnDeuda enDeuda;
	private Prestamo mockedPrestamo;

	@Before
	public void setUp() {
		
		enDeuda = new EnDeuda();
		mockedPrestamo = mock(Prestamo.class);
	}
	
	@Test (expected = AprobadoException.class)
	public void testAprobar() throws AprobadoException{
					
		enDeuda.aprobar(mockedPrestamo);
	}
	
	@Test (expected = RechazadoException.class)
	public void testRechazar() throws RechazadoException{
					
		enDeuda.rechazar(mockedPrestamo);
	}
	
	@Test (expected = FinalizadoException.class)
	public void testFinalizar() throws FinalizadoException{
				
		enDeuda.finalizar(mockedPrestamo);
	}
	
	@Test 
	public void testADeudorIncobrable(){
		
		enDeuda.aDeudorIncobrable(mockedPrestamo);
		verify(mockedPrestamo).setEstado(any(DeudorIncobrable.class));
	}
	
	@Test 
	public void testAEnDeuda(){
		enDeuda.aEnDeuda(mockedPrestamo);
		verify(mockedPrestamo).setEstado(enDeuda);
	}
	
	@Test 
	public void testAEnCurso() throws EnCursoException{
		enDeuda.aEnCurso(mockedPrestamo);
		verify(mockedPrestamo).setEstado(new EnCurso());
	}
	
	@Test
	public void testPuedoPagar(){
		assertTrue(enDeuda.puedoPagar());
	}
	
	
}

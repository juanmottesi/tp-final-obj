package estadoPrestamo;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

import prestamos.Prestamo;
import estadoPrestamos.EnCurso;
import estadoPrestamos.EnDeuda;
import estadoPrestamos.Finalizado;
import exceptions.AprobadoException;
import exceptions.DeudorIncobrableException;
import exceptions.EnDeudaException;
import exceptions.FinalizadoException;
import exceptions.RechazadoException;

public class TestEnCurso {
	private EnCurso enCurso;
	private Prestamo mockedPrestamo;
	
	@Before
	public void setUp() throws Exception {
		enCurso= new EnCurso();
		mockedPrestamo= mock(Prestamo.class);
	}
	
	@Test(expected= DeudorIncobrableException.class)
	public void testADeudorIncobrable() throws DeudorIncobrableException {
		
	enCurso.aDeudorIncobrable(mockedPrestamo);
	}


	@Test(expected= AprobadoException.class)
	public void testAprobar() throws AprobadoException {
		
		enCurso.aprobar(mockedPrestamo);
		}  
	
	@Test(expected= RechazadoException.class)
	public void testRechazar() throws RechazadoException {
		
		enCurso.rechazar(mockedPrestamo);
	}
	
	@Test
	public void testFinalizar() throws FinalizadoException{
		
		enCurso.finalizar(mockedPrestamo);
		verify(mockedPrestamo).setEstado(any(Finalizado.class));
	}

	@Test
	public void testAEnDeuda() throws EnDeudaException{
		
		enCurso.aEnDeuda(mockedPrestamo);
		
		verify(mockedPrestamo).setEstado(any(EnDeuda.class));
	}
	
	@Test
	public void testAEnCurso(){
		enCurso.aEnCurso(mockedPrestamo);
		verify(mockedPrestamo).setEstado(enCurso);
	}
	
	@Test
	public void testPuedoPagar(){
		assertTrue(enCurso.puedoPagar());
	}
}
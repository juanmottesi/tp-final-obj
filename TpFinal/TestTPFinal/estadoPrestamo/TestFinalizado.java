package estadoPrestamo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import prestamos.Prestamo;
import estadoPrestamos.Finalizado;
import exceptions.AprobadoException;
import exceptions.DeudorIncobrableException;
import exceptions.EnCursoException;
import exceptions.EnDeudaException;
import exceptions.RechazadoException;
import static org.mockito.Mockito.*;

public class TestFinalizado {
	private Finalizado enFinalizado;
	private Prestamo mockedPrestamo;
	
	@Before
	public void setUp() {
		enFinalizado= new Finalizado();
		mockedPrestamo= mock(Prestamo.class);
	}

	@Test(expected= AprobadoException.class)
	public void testAprobar() throws AprobadoException {
	
		enFinalizado.aprobar(mockedPrestamo);
	}
	
	@Test(expected= RechazadoException.class)
	public void testRechazar() throws RechazadoException {
			
		enFinalizado.rechazar(mockedPrestamo);
	}
	
	@Test
	public void testFinalizar(){
		enFinalizado.finalizar(mockedPrestamo);
		verify(mockedPrestamo).setEstado(enFinalizado);
	}
	
	@Test(expected= DeudorIncobrableException.class)
	public void testADeudorIncobrable() throws DeudorIncobrableException {
	
			enFinalizado.aDeudorIncobrable(mockedPrestamo);
		}
	
	@Test (expected = EnDeudaException.class)
	public void testAEnDeuda() throws EnDeudaException{
			
		enFinalizado.aEnDeuda(mockedPrestamo);
	}
	
	@Test (expected = EnCursoException.class)
	public void testAEnCurso() throws EnCursoException{
				
		enFinalizado.aEnCurso(mockedPrestamo);
	}
	
	@Test
	public void testPuedoPagar(){
		assertFalse(enFinalizado.puedoPagar());
	}
}

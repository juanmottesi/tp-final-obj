package estadoPrestamo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import prestamos.Prestamo;
import estadoPrestamos.DeudorIncobrable;
import exceptions.AprobadoException;
import exceptions.EnCursoException;
import exceptions.EnDeudaException;
import exceptions.FinalizadoException;
import exceptions.RechazadoException;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


public class TestDeudorIncobrable {
	
	private DeudorIncobrable enDeudorIncobrable;
	private Prestamo mockedPrestamo;
	
	@Before
	public void setUp() {
		enDeudorIncobrable= new DeudorIncobrable();
		mockedPrestamo= mock(Prestamo.class);
		
	}
	
	@Test
	public void testADeudorIncobrable(){
		enDeudorIncobrable.aDeudorIncobrable(mockedPrestamo);
		verify(mockedPrestamo).setEstado(enDeudorIncobrable);
		}
	
	@Test(expected = AprobadoException.class)
	public void testAprobar() throws AprobadoException {
				
		enDeudorIncobrable.aprobar(mockedPrestamo);		
	}

	@Test(expected = RechazadoException.class)
	public void testRechazar() throws RechazadoException {
				
		enDeudorIncobrable.rechazar(mockedPrestamo);
	}

	@Test (expected = FinalizadoException.class)
	public void testFinalizar() throws FinalizadoException{
				
		enDeudorIncobrable.finalizar(mockedPrestamo);
	}

	@Test (expected = EnDeudaException.class)
	public void testAEnDeuda() throws EnDeudaException{
				
		enDeudorIncobrable.aEnDeuda(mockedPrestamo);
	}

	@Test (expected = EnCursoException.class)
	public void testAEnCurso() throws EnCursoException{

		enDeudorIncobrable.aEnCurso(mockedPrestamo);
		
	}
	
	@Test
	public void testPuedoPagar(){
		assertFalse(enDeudorIncobrable.puedoPagar());
	}
	
}



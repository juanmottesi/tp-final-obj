package estadoPrestamo;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import prestamos.Prestamo;
import estadoPrestamos.DeudorIncobrable;
import estadoPrestamos.EnCurso;
import estadoPrestamos.EstadoPrestamo;
import exceptions.AprobadoException;
import exceptions.DeudorIncobrableException;
import exceptions.EnCursoException;
import exceptions.EnDeudaException;
import exceptions.FinalizadoException;
import exceptions.RechazadoException;
//import static org.mockito.Mock.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;


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
				
		enDeudorIncobrable.aDeudorIncobrable(mockedPrestamo);
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
}



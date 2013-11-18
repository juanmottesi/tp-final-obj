package estadoPrestamo;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

import prestamos.Prestamo;
import estadoPrestamos.Rechazado;
import exceptions.AprobadoException;
import exceptions.DeudorIncobrableException;
import exceptions.EnCursoException;
import exceptions.EnDeudaException;
import exceptions.FinalizadoException;

public class TestRechazado {
	private Rechazado enRechazado;
	private Prestamo mockedPrestamo;
	
	@Before
	public void setUp() {
		enRechazado= new Rechazado();
		mockedPrestamo= mock(Prestamo.class);
	}

	@Test (expected = AprobadoException.class)
	public void testAprobar() throws AprobadoException{
			
		enRechazado.aprobar(mockedPrestamo);
	
	}
	
	@Test
	public void testRechazar() {
		enRechazado.rechazar(mockedPrestamo);
		verify(mockedPrestamo).setEstado(enRechazado);
	}
	
	@Test (expected = FinalizadoException.class)
	public void testFinalizar() throws FinalizadoException{
			
		enRechazado.finalizar(mockedPrestamo);
	}
	
	@Test (expected = DeudorIncobrableException.class)
	public void testADeudorIncobrable() throws DeudorIncobrableException{
					
		enRechazado.aDeudorIncobrable(mockedPrestamo);
	}
	
	@Test (expected = EnDeudaException.class)
	public void testAEnDeuda() throws EnDeudaException{
			
		enRechazado.aEnDeuda(mockedPrestamo);
	}
	
	@Test (expected = EnCursoException.class)
	public void testAEnCurso() throws EnCursoException{
				
		enRechazado.aEnCurso(mockedPrestamo);
	}
	
	@Test
	public void testPuedoPagar(){
		assertFalse(enRechazado.puedoPagar());		
	}
}

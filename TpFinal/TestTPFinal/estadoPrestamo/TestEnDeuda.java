package estadoPrestamo;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import prestamos.Prestamo;
import estadoPrestamos.DeudorIncobrable;
import estadoPrestamos.EnCurso;
import estadoPrestamos.EnDeuda;
import estadoPrestamos.EstadoPrestamo;
import estadoPrestamos.Finalizado;
import estadoPrestamos.Rechazado;
import estadoPrestamos.Solicitado;
import exceptions.AprobadoException;
import exceptions.DeudorIncobrableException;
import exceptions.EnCursoException;
import exceptions.EnDeudaException;
import exceptions.FinalizadoException;
import exceptions.RechazadoException;
import exceptions.AprobadoException;

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
	
	@Test (expected = EnDeudaException.class)
	public void testAEnDeuda() throws EnDeudaException{
				
		enDeuda.aEnDeuda(mockedPrestamo);
	}
	
	@Test 
	public void testAEnCurso() throws EnCursoException{
		
		enDeuda.aEnCurso(mockedPrestamo);
		verify(mockedPrestamo).setEstado(any(EnCurso.class));
	}
}

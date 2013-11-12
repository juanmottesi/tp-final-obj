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
			
		when(mockedPrestamo.getEstado()).thenReturn(enDeuda);
		
		mockedPrestamo.getEstado().aprobar(mockedPrestamo);
		
		assertSame(enDeuda, mockedPrestamo.getEstado());
	}
	
	@Test (expected = RechazadoException.class)
	public void testRechazar() throws RechazadoException{
			
		when(mockedPrestamo.getEstado()).thenReturn(enDeuda);
		
		mockedPrestamo.getEstado().rechazar(mockedPrestamo);
		
		assertSame(enDeuda, mockedPrestamo.getEstado());
	}
	
	@Test (expected = FinalizadoException.class)
	public void testFinalizar() throws FinalizadoException{
			
		when(mockedPrestamo.getEstado()).thenReturn(enDeuda);
		
		mockedPrestamo.getEstado().finalizar(mockedPrestamo);
		
		assertSame(enDeuda, mockedPrestamo.getEstado());
	}
	
	@Test 
	public void testADeudorIncobrable(){
		
		enDeuda.aDeudorIncobrable(mockedPrestamo);
		verify(mockedPrestamo).setEstado(any(DeudorIncobrable.class));
		//VER ESTO !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	}
	
	@Test (expected = EnDeudaException.class)
	public void testAEnDeuda() throws EnDeudaException{
		
		when(mockedPrestamo.getEstado()).thenReturn(enDeuda);
		
		mockedPrestamo.getEstado().aEnDeuda(mockedPrestamo);
		
		assertSame(enDeuda, mockedPrestamo.getEstado());
	}
}

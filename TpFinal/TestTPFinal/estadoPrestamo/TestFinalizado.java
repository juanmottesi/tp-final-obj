package estadoPrestamo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import prestamos.Prestamo;
import estadoPrestamos.Finalizado;
import exceptions.AprobadoException;
import exceptions.DeudorIncobrableException;
import exceptions.EnDeudaException;
import exceptions.FinalizadoException;
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
	
		when(mockedPrestamo.getEstado()).thenReturn(enFinalizado);
		
		mockedPrestamo.getEstado().aprobar(mockedPrestamo);
		
		assertSame(enFinalizado, mockedPrestamo.getEstado());
	}
	
	@Test(expected= RechazadoException.class)
	public void testRechazar() throws RechazadoException {
	
		when(mockedPrestamo.getEstado()).thenReturn(enFinalizado);
		
		mockedPrestamo.getEstado().rechazar(mockedPrestamo);
		
		assertSame(enFinalizado, mockedPrestamo.getEstado());
	}
	
	@Test(expected= FinalizadoException.class)
	public void testFinalizar() throws FinalizadoException {
	
		when(mockedPrestamo.getEstado()).thenReturn(enFinalizado);
		
		mockedPrestamo.getEstado().finalizar(mockedPrestamo);
		
		assertSame(enFinalizado, mockedPrestamo.getEstado());
	}
	
	@Test(expected= DeudorIncobrableException.class)
	public void testADeudorIncobrable() throws DeudorIncobrableException {
	
		when(mockedPrestamo.getEstado()).thenReturn(enFinalizado);
		
		mockedPrestamo.getEstado().aDeudorIncobrable(mockedPrestamo);
		
		assertSame(enFinalizado, mockedPrestamo.getEstado());
	}
	
	@Test (expected = EnDeudaException.class)
	public void testAEnDeuda() throws EnDeudaException{
		
		when(mockedPrestamo.getEstado()).thenReturn(enFinalizado);
		
		mockedPrestamo.getEstado().aEnDeuda(mockedPrestamo);
		
		assertSame(enFinalizado, mockedPrestamo.getEstado());
	}

}

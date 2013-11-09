package estadoPrestamo;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import prestamos.Prestamo;
import estadoPrestamos.EnCurso;
import estadoPrestamos.EstadoPrestamo;
import estadoPrestamos.Finalizado;
import estadoPrestamos.Rechazado;
import estadoPrestamos.Solicitado;
import exceptions.AprobadoException;
import exceptions.DeudorIncobrableException;
import exceptions.EnDeudaException;
import exceptions.FinalizadoException;
import exceptions.RechazadoException;

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
			
		when(mockedPrestamo.getEstado()).thenReturn(enRechazado);
		
		mockedPrestamo.getEstado().aprobar(mockedPrestamo);
		
		assertSame(enRechazado, mockedPrestamo.getEstado());
	}
	
	@Test (expected = RechazadoException.class)
	public void testRechazar() throws RechazadoException{
			
		when(mockedPrestamo.getEstado()).thenReturn(enRechazado);
		
		mockedPrestamo.getEstado().rechazar(mockedPrestamo);
		
		assertSame(enRechazado, mockedPrestamo.getEstado());
	}
	
	@Test (expected = FinalizadoException.class)
	public void testFinalizar() throws FinalizadoException{
			
		when(mockedPrestamo.getEstado()).thenReturn(enRechazado);
		
		mockedPrestamo.getEstado().finalizar(mockedPrestamo);
		
		assertSame(enRechazado, mockedPrestamo.getEstado());
	}
	
	@Test (expected = DeudorIncobrableException.class)
	public void testADeudorIncobrable() throws DeudorIncobrableException{
			
		when(mockedPrestamo.getEstado()).thenReturn(enRechazado);
		
		mockedPrestamo.getEstado().aDeudorIncobrable(mockedPrestamo);
		
		assertSame(enRechazado, mockedPrestamo.getEstado());
	}
	
	@Test (expected = EnDeudaException.class)
	public void testAEnDeuda() throws EnDeudaException{
		
		when(mockedPrestamo.getEstado()).thenReturn(enRechazado);
		
		mockedPrestamo.getEstado().aEnDeuda(mockedPrestamo);
		
		assertSame(enRechazado, mockedPrestamo.getEstado());
	}

}

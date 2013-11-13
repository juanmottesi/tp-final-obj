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
import exceptions.EnCursoException;
import exceptions.EnDeudaException;
import exceptions.FinalizadoException;
import exceptions.RechazadoException;

public class TestSolicitado {
	
	private Solicitado enSolicitud;
	private Prestamo mockedPrestamo;
	

	@Before
	public void setUp() {
		
		enSolicitud = new Solicitado();
		mockedPrestamo = mock(Prestamo.class);
	}

	@Test 
	public void testAprobar() {
		
		enSolicitud.aprobar(mockedPrestamo);
		verify(mockedPrestamo).setEstado(any(EnCurso.class));
	}
	
	@Test 
	public void testRechazar() {
		
		enSolicitud.rechazar(mockedPrestamo);
		verify(mockedPrestamo).setEstado(any(Rechazado.class));	
	}
	
	@Test (expected = FinalizadoException.class)
	public void testFinalizar() throws FinalizadoException{
				
		enSolicitud.finalizar(mockedPrestamo);
	}
	
	@Test (expected = DeudorIncobrableException.class)
	public void testADeudorIncobrable() throws DeudorIncobrableException{
				
		enSolicitud.aDeudorIncobrable(mockedPrestamo);
	}
	
	@Test (expected = EnDeudaException.class)
	public void testAEnDeuda() throws EnDeudaException{
				
		enSolicitud.aEnDeuda(mockedPrestamo);
	}
	
	@Test (expected = EnCursoException.class)
	public void testAEnCurso() throws EnCursoException{
				
		enSolicitud.aEnCurso(mockedPrestamo);
	}

	
}
	

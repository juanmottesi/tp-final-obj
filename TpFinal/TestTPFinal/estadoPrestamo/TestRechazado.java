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
	
	@Test (expected = RechazadoException.class)
	public void testRechazar() throws RechazadoException{
				
		enRechazado.rechazar(mockedPrestamo);
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
}

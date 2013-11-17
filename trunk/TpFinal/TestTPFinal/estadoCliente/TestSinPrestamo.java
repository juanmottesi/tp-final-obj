package estadoCliente;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import exceptions.EstadoClienteException;

public class TestSinPrestamo {

	private SinPrestamo sinPrestamo;
	
	@Mock
	EstadoCliente mockedEstadoCliente = mock(EstadoCliente.class);
	
	@Before
	public void setUp(){
		sinPrestamo =new SinPrestamo();
	}
	
	@Test
	public void testConstructor() {		
		assertNotNull(sinPrestamo);
	}

	@Test
	public void testPuedoAgregarPrestamo(){
		assertTrue(sinPrestamo.puedoAgregarPrestamo());
	}
	
	@Test (expected = EstadoClienteException.class)
	public void testAEnDeuda() throws EstadoClienteException{
		sinPrestamo.aEnDeuda(mockedEstadoCliente);
	}

	@Test (expected = EstadoClienteException.class)
	public void testAEnDeudorIncobrable() throws EstadoClienteException{
		sinPrestamo.aEnDeudorIncobrable(mockedEstadoCliente);
	}
	
	@Test (expected = EstadoClienteException.class)
	public void testAEnCurso() throws EstadoClienteException{
		sinPrestamo.aEnCurso(mockedEstadoCliente);
	}
	
	@Test (expected = EstadoClienteException.class)
	public void testFinalizar() throws EstadoClienteException{
		sinPrestamo.finalizar(mockedEstadoCliente);
	}
	
	@Test
	public void testSolicitar(){
		sinPrestamo.solicitar(mockedEstadoCliente);
		verify(mockedEstadoCliente).cambiarEstadoA(new Solicitado());
	}
	
	@Test (expected = EstadoClienteException.class)
	public void testRechazar() throws EstadoClienteException{
		sinPrestamo.rechazar(mockedEstadoCliente);
	}
	
	@Test
	public void testASinPrestamo(){
		sinPrestamo.aSinPrestamo(mockedEstadoCliente);
		verify(mockedEstadoCliente).cambiarEstadoA(sinPrestamo);
	}


}

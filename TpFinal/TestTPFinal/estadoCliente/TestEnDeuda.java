package estadoCliente;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import exceptions.EstadoClienteException;

public class TestEnDeuda {

private EnDeuda enDeuda;
	
	@Mock
	EstadoCliente mockedEstadoCliente = mock(EstadoCliente.class);
	
	@Before
	public void setUp(){
		enDeuda =new EnDeuda();
	}
	
	@Test
	public void testConstructor() {		
		assertNotNull(enDeuda);
	}

	@Test
	public void testPuedoAgregarPrestamo(){
		assertFalse(enDeuda.puedoAgregarPrestamo());
	}
	
	@Test
	public void testAEnDeuda() throws EstadoClienteException{
		enDeuda.aEnDeuda(mockedEstadoCliente);
		verify(mockedEstadoCliente).cambiarEstadoA(enDeuda);
	}

	@Test
	public void testAEnDeudorIncobrable(){
		enDeuda.aEnDeudorIncobrable(mockedEstadoCliente);
		verify(mockedEstadoCliente).cambiarEstadoA(new DeudorIncobrable());
	}
	
	@Test
	public void testAEnCurso() throws EstadoClienteException{
		enDeuda.aEnCurso(mockedEstadoCliente);
		verify(mockedEstadoCliente).cambiarEstadoA(new EnCurso());
	}
	
	@Test
	public void testFinalizar() throws EstadoClienteException{
		enDeuda.finalizar(mockedEstadoCliente);
		verify(mockedEstadoCliente).seFinalizoUnPrestamo(enDeuda);
	}
	
	@Test (expected = EstadoClienteException.class)
	public void testSolicitar() throws EstadoClienteException{
		enDeuda.solicitar(mockedEstadoCliente);
	}
	
	@Test (expected = EstadoClienteException.class)
	public void testRechazar() throws EstadoClienteException{
		enDeuda.rechazar(mockedEstadoCliente);
	}
	
	@Test (expected = EstadoClienteException.class)
	public void testASinPrestamo() throws EstadoClienteException{
		enDeuda.aSinPrestamo(mockedEstadoCliente);
	}


}

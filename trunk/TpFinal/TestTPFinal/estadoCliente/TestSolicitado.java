package estadoCliente;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import exceptions.EstadoClienteException;

public class TestSolicitado {

private Solicitado solicitado;
	
	@Mock
	EstadoCliente mockedEstadoCliente = mock(EstadoCliente.class);
	
	@Before
	public void setUp(){
		solicitado =new Solicitado();
	}
	
	@Test
	public void testConstructor() {		
		assertNotNull(solicitado);
	}

	@Test
	public void testPuedoAgregarPrestamo(){
		assertFalse(solicitado.puedoAgregarPrestamo());
	}
	
	@Test (expected = EstadoClienteException.class)
	public void testAEnDeuda() throws EstadoClienteException{
		solicitado.aEnDeuda(mockedEstadoCliente);
	}

	@Test (expected = EstadoClienteException.class)
	public void testAEnDeudorIncobrable() throws EstadoClienteException{
		solicitado.aEnDeudorIncobrable(mockedEstadoCliente);
	}
	
	@Test
	public void testAEnCurso(){
		solicitado.aEnCurso(mockedEstadoCliente);
		verify(mockedEstadoCliente).cambiarEstadoA(new EnCurso());
	}
	
	@Test (expected = EstadoClienteException.class)
	public void testFinalizar() throws EstadoClienteException{
		solicitado.finalizar(mockedEstadoCliente);
	}
	
	@Test
	public void testSolicitar(){
		solicitado.solicitar(mockedEstadoCliente);
		verify(mockedEstadoCliente).cambiarEstadoA(solicitado);
	}
	
	@Test 
	public void testRechazar() throws EstadoClienteException{
		solicitado.rechazar(mockedEstadoCliente);
		verify(mockedEstadoCliente).seRechazoUnPrestamo(solicitado);
	}
	
	@Test (expected = EstadoClienteException.class)
	public void testASinPrestamo() throws EstadoClienteException{
		solicitado.aSinPrestamo(mockedEstadoCliente);
	}


}

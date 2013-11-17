package estadoCliente;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import exceptions.EstadoClienteException;

public class TestEnCurso {

	private EnCurso enCurso;
	
	@Mock
	EstadoCliente mockedEstadoCliente = mock(EstadoCliente.class);
	
	@Before
	public void setUp(){
		enCurso =new EnCurso();
	}
	
	@Test
	public void testConstructor() {		
		assertNotNull(enCurso);
	}

	@Test
	public void testPuedoAgregarPrestamo(){
		assertTrue(enCurso.puedoAgregarPrestamo());
	}
	
	@Test
	public void testAEnDeuda() throws EstadoClienteException{
		enCurso.aEnDeuda(mockedEstadoCliente);
		verify(mockedEstadoCliente).cambiarEstadoA(new EnDeuda());
	}

	@Test(expected = EstadoClienteException.class)
	public void testAEnDeudorIncobrable() throws EstadoClienteException{
		enCurso.aEnDeudorIncobrable(mockedEstadoCliente);
	}
	
	@Test
	public void testAEnCurso() throws EstadoClienteException{
		enCurso.aEnCurso(mockedEstadoCliente);
		verify(mockedEstadoCliente).cambiarEstadoA(enCurso);
	}
	
	@Test
	public void testFinalizar() throws EstadoClienteException{
		enCurso.finalizar(mockedEstadoCliente);
		verify(mockedEstadoCliente).seFinalizoUnPrestamo(enCurso);
	}
	
	@Test (expected = EstadoClienteException.class)
	public void testSolicitar() throws EstadoClienteException{
		enCurso.solicitar(mockedEstadoCliente);
	}
	
	@Test (expected = EstadoClienteException.class)
	public void testRechazar() throws EstadoClienteException{
		enCurso.rechazar(mockedEstadoCliente);
	}
	
	@Test (expected = EstadoClienteException.class)
	public void testASinPrestamo() throws EstadoClienteException{
		enCurso.aSinPrestamo(mockedEstadoCliente);
	}

}

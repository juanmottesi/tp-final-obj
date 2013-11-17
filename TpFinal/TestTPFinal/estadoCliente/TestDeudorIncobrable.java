package estadoCliente;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import exceptions.EstadoClienteException;

public class TestDeudorIncobrable {

	private DeudorIncobrable deudorIncobrable;
	
	@Mock
	EstadoCliente mockedEstadoCliente = mock(EstadoCliente.class);
	
	@Before
	public void setUp(){
		deudorIncobrable =new DeudorIncobrable();
	}
	
	@Test
	public void testConstructor() {		
		assertNotNull(deudorIncobrable);
	}
	
	@Test
	public void testPuedoAgregarPrestamo(){
		assertFalse(deudorIncobrable.puedoAgregarPrestamo());
	}
	
	@Test (expected = EstadoClienteException.class)
	public void testAEnDeuda() throws EstadoClienteException{
		deudorIncobrable.aEnDeuda(mockedEstadoCliente);
	}

	@Test
	public void testAEnDeudorIncobrable(){
		deudorIncobrable.aEnDeudorIncobrable(mockedEstadoCliente);
		verify(mockedEstadoCliente).cambiarEstadoA(deudorIncobrable);
	}
	
	@Test (expected = EstadoClienteException.class)
	public void testAEnCurso() throws EstadoClienteException{
		deudorIncobrable.aEnCurso(mockedEstadoCliente);
	}
	
	@Test (expected = EstadoClienteException.class)
	public void testFinalizar() throws EstadoClienteException{
		deudorIncobrable.finalizar(mockedEstadoCliente);
	}
	
	@Test (expected = EstadoClienteException.class)
	public void testSolicitar() throws EstadoClienteException{
		deudorIncobrable.solicitar(mockedEstadoCliente);
	}
	
	@Test (expected = EstadoClienteException.class)
	public void testRechazar() throws EstadoClienteException{
		deudorIncobrable.rechazar(mockedEstadoCliente);
	}
	
	@Test (expected = EstadoClienteException.class)
	public void testASinPrestamo() throws EstadoClienteException{
		deudorIncobrable.aSinPrestamo(mockedEstadoCliente);
	}
	
}

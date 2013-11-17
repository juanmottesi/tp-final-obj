package estadoCliente;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import exceptions.EstadoClienteException;

public class TestEstadoCliente {
	
	private EstadoCliente estadoCliente;
	
	@Mock
	Estado mockedEstado = mock(Estado.class);
	
	@Before
	public void setUp(){
		estadoCliente = new EstadoCliente();
		estadoCliente.setEstados(mockedEstado);
	}

	@Test
	public void testConstructor() {
		assertNotNull(estadoCliente);
	}
	
	@Test
	public void testPuedoAgregarPrestamoConCondicionVerdadera(){
		when(mockedEstado.puedoAgregarPrestamo()).thenReturn(true);
		assertTrue(estadoCliente.puedoAgregarPrestamo());
	}
	
	@Test
	public void testPuedoAgregarPrestamoConCondicionFalsa(){
		when(mockedEstado.puedoAgregarPrestamo()).thenReturn(false);
		assertFalse(estadoCliente.puedoAgregarPrestamo());
	}
	
	@Test
	public void testPuedoAgregarPrestamoConDosPrestamos(){
		when(mockedEstado.puedoAgregarPrestamo()).thenReturn(true);
		estadoCliente.setCantidadPrestamos(2);
		assertFalse(estadoCliente.puedoAgregarPrestamo());
	}

	@Test
	public void testAEnDeuda() throws EstadoClienteException{
		estadoCliente.aEnDeuda();
		verify(mockedEstado).aEnDeuda(estadoCliente);
	}
	
	@Test
	public void testAEnDeudorIncobrable()throws EstadoClienteException{
		estadoCliente.aEnDeudorIncobrable();
		verify(mockedEstado).aEnDeudorIncobrable(estadoCliente);
	}
	
	@Test
	public void testAEnCurso()throws EstadoClienteException{
		estadoCliente.aEnCurso();
		verify(mockedEstado).aEnCurso(estadoCliente);
	}
	
	@Test
	public void testFinalizar()throws EstadoClienteException{
		estadoCliente.finalizar();
		verify(mockedEstado).finalizar(estadoCliente);
	}
	
	@Test
	public void testSolicitar()throws EstadoClienteException{
		estadoCliente.solicitar();
		verify(mockedEstado).solicitar(estadoCliente);
	}
	
	@Test
	public void testRechazar()throws EstadoClienteException{
		estadoCliente.rechazar();
		verify(mockedEstado).rechazar(estadoCliente);
	}
	
	@Test
	public void testASinPrestamo() throws EstadoClienteException{
		estadoCliente.aSinPrestamo();
		verify(mockedEstado).aSinPrestamo(estadoCliente);
	}
	
	@Test
	public void testCambiarEstadoA(){
		estadoCliente.cambiarEstadoA(mockedEstado);
		assertEquals(mockedEstado, estadoCliente.getEstados());
	}
	
	@Test
	public void testSeFinalizoUnPrestamoConUnPrestamo() throws EstadoClienteException{
		estadoCliente.agregarPrestamo();
		estadoCliente.seFinalizoUnPrestamo(mockedEstado);
		verify(mockedEstado).aSinPrestamo(estadoCliente);		
	}
	
	@Test
	public void testSeFinalizoUnPrestamoConDosPrestamos() throws EstadoClienteException{
		estadoCliente.agregarPrestamo();
		estadoCliente.agregarPrestamo();
		estadoCliente.seFinalizoUnPrestamo(mockedEstado);
		assertEquals(mockedEstado, estadoCliente.getEstados());		
	}
	
	@Test
	public void testSeRechazoUnPrestamoConUnPrestamo() throws EstadoClienteException{
		estadoCliente.agregarPrestamo();
		estadoCliente.seRechazoUnPrestamo(mockedEstado);
		verify(mockedEstado).aSinPrestamo(estadoCliente);
		
		
	}
	
	@Test
	public void testSeRechazoUnPrestamoConDosPrestamos() throws EstadoClienteException{
		estadoCliente.agregarPrestamo();
		estadoCliente.agregarPrestamo();
		estadoCliente.seRechazoUnPrestamo(mockedEstado);
		assertEquals(new EnCurso(), estadoCliente.getEstados());
	}
	
	@Test
	public void testUpdate() throws EstadoClienteException{
		estadoCliente.update(estadoCliente, estadoCliente);
		verify(mockedEstado).aEnDeuda(estadoCliente);	
	}
}


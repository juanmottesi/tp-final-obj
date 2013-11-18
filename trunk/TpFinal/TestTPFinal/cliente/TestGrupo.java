package cliente;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Vector;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import prestamos.Prestamo;
import estadoCliente.EstadoCliente;
import exceptions.EstadoClienteException;

public class TestGrupo {

private Grupo grupo;
	
	@Mock
	Persona mockedPersona = mock(Persona.class);
	Persona mockedPersona2 = mock(Persona.class);
	EstadoCliente mockedEstadoCliente = mock(EstadoCliente.class);
	Prestamo mockedPrestamo = mock(Prestamo.class);
	
	@Before
	public void setUp(){
		List<Cliente> personas = new Vector<Cliente>();
		personas.add(mockedPersona2);
		grupo = new Grupo(mockedPersona, personas);
		grupo.setEstadoCliente(mockedEstadoCliente);
	}

	@Test
	public void testConstructor(){
		assertNotNull(grupo);
	}
	
	@Test
	public void testAgregarPrestamoConCondicionVerdadera(){
		when(mockedEstadoCliente.puedoAgregarPrestamo()).thenReturn(true);
		grupo.agregarPrestamo(mockedPrestamo);
		verify(mockedPersona).agregarPrestamo(mockedPrestamo);
		verify(mockedPersona2).agregarPrestamo(mockedPrestamo);
	}
	
	@Test
	public void testAgregarPrestamoConCondicionFalsa(){
		when(mockedEstadoCliente.puedoAgregarPrestamo()).thenReturn(false);
		grupo.agregarPrestamo(mockedPrestamo);
		verify(mockedPersona, Mockito.never()).agregarPrestamo(mockedPrestamo);
		verify(mockedPersona2, Mockito.never()).agregarPrestamo(mockedPrestamo);
	}
	
	@Test
	public void testSuscribirAlSistemaDeAviso(){
		grupo.suscribirAlSistemaDeAviso();
		verify(mockedPersona).suscribirAlSistemaDeAviso();
	}
	
	@Test
	public void testSalirSistemaDeAviso(){
		grupo.salirSistemaDeAviso();
		verify(mockedPersona).salirSistemaDeAviso();
	}
	
	@Test
	public void testObtenerDNI(){
		grupo.obtenerDNI();
		verify(mockedPersona).obtenerDNI();	
	}
	
	@Test
	public void testObtenerApellido(){
		grupo.obtenerApellido();
		verify(mockedPersona).obtenerApellido();	
	}
	
	@Test
	public void testObtenerDireccion(){
		grupo.obtenerDireccion();
		verify(mockedPersona).obtenerDireccion();	
	}
	
	@Test
	public void testFinalizar() throws EstadoClienteException{
		grupo.finalizar();
		verify(mockedPersona).finalizar();
	}
	
	@Test
	public void testAEnDeuda() throws EstadoClienteException{
		grupo.aEnDeuda();
		verify(mockedPersona).aEnDeuda();
	}
	
	@Test
	public void testAEnCurso() throws EstadoClienteException{
		grupo.aEnCurso();
		verify(mockedPersona).aEnCurso();
	}
	
	
}

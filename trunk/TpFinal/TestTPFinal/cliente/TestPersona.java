package cliente;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import prestamos.Prestamo;
import estadoCliente.EstadoCliente;

public class TestPersona {

	private Persona persona;
	
	@Mock
	EstadoCliente mockedEstadoCliente = mock(EstadoCliente.class);
	Prestamo mockedPrestamo = mock(Prestamo.class);
	
	@Before
	public void setUp(){
		persona = new Persona("nombre","apellido","36778000","direccion");
		persona.setEstadoCliente(mockedEstadoCliente);
	}

	@Test
	public void testConstructor(){
		assertNotNull(persona);		
		assertEquals("nombre",persona.getNombre());
	}
	
	@Test
	public void testAgregarPrestamoConCondicionVerdadera(){
		when(mockedEstadoCliente.puedoAgregarPrestamo()).thenReturn(true);
		persona.agregarPrestamo(mockedPrestamo);
		assertFalse(persona.getPrestamos().isEmpty());
	}
	
	@Test
	public void testAgregarPrestamoConCondicionFalsa(){
		when(mockedEstadoCliente.puedoAgregarPrestamo()).thenReturn(false);
		persona.agregarPrestamo(mockedPrestamo);
		assertTrue(persona.getPrestamos().isEmpty());
	}
	
	@Test
	public void testSuscribirAlSistemaDeAviso(){
		persona.suscribirAlSistemaDeAviso();
		verify(mockedEstadoCliente).addObserver(persona);
	}
	
	@Test
	public void testSalirSistemaDeAviso(){
		persona.salirSistemaDeAviso();
		verify(mockedEstadoCliente).deleteObserver(persona);
	}
	
	@Test
	public void testObtenerDNI(){
		assertEquals("36778000",persona.obtenerDNI());
	}
	
	@Test
	public void testObtenerApellido(){
		assertEquals("apellido",persona.obtenerApellido());
	}
	
	@Test
	public void testObtenerDireccion(){
		assertEquals("direccion",persona.obtenerDireccion());
	}
	
	@Test
	public void testAgregarObservadores(){
		persona.agregarObservadores(mockedEstadoCliente);
		verify(mockedEstadoCliente).addObserver(mockedEstadoCliente);
	}
}

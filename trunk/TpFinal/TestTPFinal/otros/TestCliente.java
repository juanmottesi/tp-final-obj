package otros;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;

import estadoPrestamos.EnCurso;
import estadoPrestamos.Solicitado;
import exceptions.AgregarPrestamoAClienteException;
import prestamos.Prestamo;

public class TestCliente {
	
	private Cliente cliente;

	@Before
	public void setUp() throws Exception {
		cliente = new Cliente("apellido","nombre","direccion",36778000);
	}

	@Test
	public void testContructor() {
		assertNotNull(cliente);
		assertEquals("apellido", cliente.getApellido());
		assertEquals("nombre", cliente.getNombre());
		assertEquals("direccion", cliente.getDireccion());
		assertEquals((Integer)36778000, cliente.getDni());
	}
	
	@Test (expected = AgregarPrestamoAClienteException.class)
	public void testPuedoAgregarPrestamo() throws AgregarPrestamoAClienteException{
		Prestamo mockedPrestamo = mock(Prestamo.class);
		
		when(mockedPrestamo.getEstado()).thenReturn(new Solicitado());
		cliente.agregarPrestamo(mockedPrestamo);
		//Test agregar
		assertEquals(1,cliente.getPrestamos().size());
		
		cliente.puedoAgregarPrestamo();
	}
	
	
	@Test
	public void testAgregarPrestamo(){
		Prestamo mockedPrestamo = mock(Prestamo.class);
		Prestamo mockedPrestamo1 = mock(Prestamo.class);
		
		when(mockedPrestamo.getEstado()).thenReturn(new EnCurso());
		when(mockedPrestamo1.getEstado()).thenReturn(new Solicitado());
		
		cliente.agregarPrestamo(mockedPrestamo);
		cliente.agregarPrestamo(mockedPrestamo);
		//No podria agregar otro prestamo.
		cliente.agregarPrestamo(mockedPrestamo);
		
		assertEquals("Chequea la longitud de la lista de gastos",2 , cliente.getPrestamos().size());
	}

	@Test 
	public void testSuscribirAlSistemaDeAviso(){
		Prestamo mockedPrestamo = mock(Prestamo.class);
		cliente.suscribirAlSistemaDeAviso(mockedPrestamo);
		verify(mockedPrestamo).addObserver(cliente);
	}
	
	@Test 
	public void testSalirSistemaDeAviso(){
		Prestamo mockedPrestamo = mock(Prestamo.class);
		cliente.salirSistemaDeAviso(mockedPrestamo);
		verify(mockedPrestamo).deleteObserver(cliente);
	}
	
	
	
}

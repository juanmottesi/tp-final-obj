package busqueda;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import prestamos.Prestamo;
import busqueda.PorApellido;


public class TestPorApellido {
	
	private String texto;
	private PorApellido porApellido;
	
	@Mock
	Prestamo mockedPrestamo = mock(Prestamo.class);
	
	@Before
	public void setUp(){
		texto = "Pe";
		porApellido = new PorApellido(texto);
		
	}

	@Test
	public void testConstructor() {
		assertNotNull(porApellido);
	}

	@Test 
	public void testRespetaCondicionConApellidoIgual(){
		when(mockedPrestamo.obtenerApellidoCliente()).thenReturn("Pe");
		assertTrue(porApellido.respetaCondicion(mockedPrestamo));
	}
	
	@Test 
	public void testRespetaCondicionConApellidoQueEmpieceIgual(){
		when(mockedPrestamo.obtenerApellidoCliente()).thenReturn("Pelufo");
		assertTrue(porApellido.respetaCondicion(mockedPrestamo));
	}
	
	@Test 
	public void testRespetaCondicionConApellidoQueContengaElString(){
		when(mockedPrestamo.obtenerApellidoCliente()).thenReturn("Lopez");
		assertTrue(porApellido.respetaCondicion(mockedPrestamo));
	}
	
	@Test 
	public void testRespetaCondicionConCondicionFalsa(){
		when(mockedPrestamo.obtenerApellidoCliente()).thenReturn("Garcia");
		assertFalse(porApellido.respetaCondicion(mockedPrestamo));
	}
}

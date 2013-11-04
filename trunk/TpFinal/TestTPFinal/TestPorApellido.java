import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import prestamos.Prestamo;
import busqueda.PorApellido;


public class TestPorApellido {
	
	private String texto;
	private PorApellido porApellido;
	
	@Before
	public void setUp(){
		texto = "Pe";
		porApellido = new PorApellido(texto);
	}

	@Test
	public void testConstructor() {
		assertNotNull(porApellido);
		assertEquals("Se fija si el apellido es igual al pasado", texto , porApellido.getApellido());
		String textoAux = texto.toLowerCase();
		assertNotEquals("Se fija si el apellido es diferente al pasado", textoAux , porApellido.getApellido());
	}

	@Test 
	public void testRespetaCondicion(){
		Prestamo mockedPrestamo = mock(Prestamo.class);
		
		//Apellido igual al del PorApellido
		when(mockedPrestamo.obtenerApellidoCliente()).thenReturn("Pe");
		assertTrue(porApellido.respetaCondicion(mockedPrestamo));
		
		//Apellido que empiesa igual al del PorApellido
		when(mockedPrestamo.obtenerApellidoCliente()).thenReturn("Pelufo");
		assertTrue(porApellido.respetaCondicion(mockedPrestamo));
		
		//Apellido que contenga el string de PorApellido
		when(mockedPrestamo.obtenerApellidoCliente()).thenReturn("Lopez");
		assertTrue(porApellido.respetaCondicion(mockedPrestamo));
		
		//Apellido distinto al del PorApellido
		when(mockedPrestamo.obtenerApellidoCliente()).thenReturn("Garcia");
		assertFalse(porApellido.respetaCondicion(mockedPrestamo));

	}
}

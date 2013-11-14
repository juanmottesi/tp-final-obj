package busqueda;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;




import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import prestamos.Prestamo;
import busqueda.PorDNI;


public class TestPorDNI {
	
	private PorDNI porDNI;
	private String dni;
	
	@Mock
	Prestamo mockedPrestamo = mock(Prestamo.class);
	
	@Before
	public void setUp(){
		dni = "36778000";
		porDNI= new PorDNI(dni);
		
	}	

	@Test
	public void testConstructor() {
		assertNotNull(porDNI);
	}
	
	@Test 
	public void testRespetaCondicionConCondicionVerdadera(){
		when(mockedPrestamo.obtenerDniCliente()).thenReturn("36778000");
		assertTrue(porDNI.respetaCondicion(mockedPrestamo));
	}
	
	@Test 
	public void testRespetaCondicionConCondicionFalsa(){
		when(mockedPrestamo.obtenerDniCliente()).thenReturn("36778001");
		assertFalse(porDNI.respetaCondicion(mockedPrestamo));
	}

}

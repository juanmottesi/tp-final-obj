package busqueda;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;



import org.junit.Before;
import org.junit.Test;

import prestamos.Prestamo;
import busqueda.PorDNI;


public class TestPorDNI {
	
	private PorDNI porDNI;
	private Integer dni;
	
	@Before
	public void setUp(){
		dni = 36778000;
		porDNI= new PorDNI(dni);
		
	}
	
	

	@Test
	public void testConstructor() {
		assertNotNull(porDNI);
		assertEquals("Se fija si el dni es el mismo que setea en la clase PorDNI",dni, porDNI.getDni());
		Integer dniAux = dni +1;
		assertNotEquals("Se fija si el dni no es el mismo que setea en la clase PorDNI",dniAux, porDNI.getDni());
	}
	
	@Test 
	public void testRespetaCondicion(){
		Prestamo mockedPrestamo = mock(Prestamo.class);
		
		when(mockedPrestamo.obtenerDniCliente()).thenReturn(36778000);
		assertTrue(porDNI.respetaCondicion(mockedPrestamo));
		
		Integer dniAux = dni +1;
		when(mockedPrestamo.obtenerDniCliente()).thenReturn(dniAux);
		assertFalse(porDNI.respetaCondicion(mockedPrestamo));
	}

}

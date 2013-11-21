package tipoDeImpresion;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import prestamos.Cuota;
import prestamos.Prestamo;

public class TestTipoDeImpresion {

	private TipoDeImpresion tipoDeImpresion;
	
	@Mock
	Cuota mockedCuota = mock(Cuota.class);
	Prestamo mockedPrestamo = mock(Prestamo.class);
	
	@Before
	public void setUp(){
		tipoDeImpresion = new PorXML();
	}
	
	@Test
	public void testGenerarCuadroDeMarcha() {
		tipoDeImpresion.generarCuadroDeMarcha(mockedPrestamo);
	
	}
	
	@Test
	public void testImprimir(){
		
		fail("faltaTest");
	}

}

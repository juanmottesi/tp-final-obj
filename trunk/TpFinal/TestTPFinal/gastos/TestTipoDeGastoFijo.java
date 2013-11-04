package gastos;
import static org.junit.Assert.*;
import gastos.Fijo;
import gastos.TipoDeGasto;

import org.junit.Before;
import org.junit.Test;


public class TestTipoDeGastoFijo {

	private TipoDeGasto fijo;
	private double numeroAux;
	
	@Before
	public void setUp(){
		numeroAux = 10;
		fijo = new Fijo(numeroAux);
	}
	
	@Test
	public void testConstructor(){
		assertNotNull(fijo);
		assertNotEquals((numeroAux/100), fijo.getMonto(), 0);
		assertEquals(numeroAux, fijo.getMonto(),0);
		
	}
	
	
	@Test
	public void testCalcularGasto() {
		assertEquals(numeroAux,fijo.calcularGasto(10000),0);
		assertEquals(numeroAux,fijo.calcularGasto(0),0);
	}

}

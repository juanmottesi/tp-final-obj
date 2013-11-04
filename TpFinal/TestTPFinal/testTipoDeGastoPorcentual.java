import static org.junit.Assert.*;
import gastos.Porcentual;
import gastos.TipoDeGasto;

import org.junit.Before;
import org.junit.Test;


public class testTipoDeGastoPorcentual {

	private TipoDeGasto porcentual;
	private double numeroAux;
	
	@Before 
	public void setUp(){
		numeroAux = 5;
		porcentual = new Porcentual(numeroAux);
		
	}
	
	@Test 
	public void testConstructor(){
		assertNotNull(porcentual);
		assertEquals(numeroAux/100, porcentual.getMonto(),0);
		assertNotEquals(numeroAux, porcentual.getMonto(),0);

		
	}
	
	@Test
	public void testCalcularGasto() {
		assertEquals(0*(numeroAux/100), porcentual.calcularGasto(0),0);
		assertEquals(10000*(numeroAux/100), porcentual.calcularGasto(10000),0);
		assertEquals(2500*(numeroAux/100), porcentual.calcularGasto(2500),0);
		
		
		
	}

}

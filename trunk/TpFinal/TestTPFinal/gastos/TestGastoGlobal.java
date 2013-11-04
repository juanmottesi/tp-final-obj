package gastos;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import gastos.Fijo;
import gastos.GastoGlobal;
import gastos.Porcentual;
import gastos.TipoDeGasto;

import org.junit.Before;
import org.junit.Test;

import prestamos.Prestamo;


public class TestGastoGlobal {
  
	private GastoGlobal gastoGlobalFijo;
	private GastoGlobal gastoGlobalPorcentual;
	
	@Before 
	public void setUp(){
		gastoGlobalFijo = new GastoGlobal(new Fijo(8));
		gastoGlobalPorcentual = new GastoGlobal(new Porcentual(10));
	}
	
	@Test
	public void testCalcularGasto() {
		Prestamo mockedPrestamo = mock(Prestamo.class);
		//when(mockedPrestamo.getMontoTotal()).thenReturn((double) 25000); 
		gastoGlobalFijo.calcularGasto(mockedPrestamo);
		verify(mockedPrestamo).setMontoTotal(anyDouble());
		
		//fail("Not yet implemented");
	}

}

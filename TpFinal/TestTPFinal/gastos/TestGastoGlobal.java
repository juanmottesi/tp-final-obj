package gastos;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import gastos.Fijo;
import gastos.GastoGlobal;
import gastos.Porcentual;
import gastos.TipoDeGasto;

import org.junit.Test;
import org.mockito.Mock;

import prestamos.Prestamo;


public class TestGastoGlobal {
  
	private GastoGlobal gastoGlobal;
	
	
	@Mock
	TipoDeGasto mockedTipoDeGasto = mock(TipoDeGasto.class);
	
	public void initializeFijo(){
		mockedTipoDeGasto = mock(Fijo.class);
		gastoGlobal = new GastoGlobal(mockedTipoDeGasto);
	}

	public void initializePorcentual(){
		mockedTipoDeGasto = mock(Porcentual.class);
		gastoGlobal = new GastoGlobal(mockedTipoDeGasto);
	}
	
	
	@Test
	public void testConstructor(){
		this.initializeFijo();
		assertNotNull(gastoGlobal);
		double monto = 25;
		when(mockedTipoDeGasto.getMonto()).thenReturn(monto);
		assertEquals(monto, gastoGlobal.getTipoDeGasto().getMonto(),0);
		
		this.initializePorcentual();
		assertNotNull(gastoGlobal);
		monto = 5;
		when(mockedTipoDeGasto.getMonto()).thenReturn(monto);
		assertEquals(monto, gastoGlobal.getTipoDeGasto().getMonto(),0);
	
	}
	
	@Test
	public void testCalcularGasto() {
		this.initializeFijo();
		
		Prestamo mockedPrestamo = mock(Prestamo.class);
		
		//seteo el monto del mockedTipoDeGasto en 25.
		when(mockedTipoDeGasto.getMonto()).thenReturn((double)25);
		//creo un auxilir para saber corroborar que seteo el monto.
		double auxiliar = gastoGlobal.getTipoDeGasto().getMonto();
		//seteo el montoTotal del prestamo en 25000.
		when(mockedPrestamo.getMontoTotal()).thenReturn((double) 25000);
		//creo el resultado del calcularGasto del tipoDeGasto.
		when(mockedTipoDeGasto.calcularGasto(25000)).thenReturn(auxiliar);
		//Llamo al metodo a testear
		gastoGlobal.calcularGasto(mockedPrestamo);
		//corroboro que el metodo tenga que devolver 25000 - 25 = 24975.
		verify(mockedPrestamo).actualizarGastos(24975);
		
		
		this.initializePorcentual();
		
		//seteo el monto del mockedTipoDeGasto en 10%.
		when(mockedTipoDeGasto.getMonto()).thenReturn((double)10/100);
		
		//creo un auxilir para saber corroborar que seteo el monto.
		auxiliar = gastoGlobal.getTipoDeGasto().getMonto();
		
		//seteo el montoTotal del prestamo en 25000.
		when(mockedPrestamo.getMontoTotal()).thenReturn((double) 25000);
		
		//creo el resultado del calcularGasto del tipoDeGasto.
		when(mockedTipoDeGasto.calcularGasto(25000)).thenReturn(25000* auxiliar);
		
		//Llamo al metodo a testear
		gastoGlobal.calcularGasto(mockedPrestamo);
		//corroboro que el metodo tenga que devolver 25000 * 10%(2500) = 22500.
		verify(mockedPrestamo).actualizarGastos(22500);
		
	}

}

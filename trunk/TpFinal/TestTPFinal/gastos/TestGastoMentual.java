package gastos;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.List;
import java.util.Vector;

import org.junit.Test;
import org.mockito.Mock;

import prestamos.Cuota;
import prestamos.Prestamo;

public class TestGastoMentual {
	
	private GastoMensual gastoMensual;

	@Mock
	TipoDeGasto mockedTipoDeGasto = mock(TipoDeGasto.class);
	
	public void initializeFijo(){
		mockedTipoDeGasto = mock(Fijo.class);
		gastoMensual = new GastoMensual(mockedTipoDeGasto);
	}

	public void initializePorcentual(){
		mockedTipoDeGasto = mock(Porcentual.class);
		gastoMensual = new GastoMensual(mockedTipoDeGasto);
	}
	
	

	@Test
	public void testConstructor() {
		this.initializeFijo();
		assertNotNull(gastoMensual);
		double monto = 25;
		when(mockedTipoDeGasto.getMonto()).thenReturn(monto);
		assertEquals(monto, gastoMensual.getTipoDeGasto().getMonto(),0);
		
		
		this.initializePorcentual();
		assertNotNull(gastoMensual);
		monto = 10/100;
		//monto es porcentual por eso se dividi en 100, esto el metodo de crar lo hace solo.
		when(mockedTipoDeGasto.getMonto()).thenReturn(monto);
		assertEquals(monto, gastoMensual.getTipoDeGasto().getMonto(),0);	
	}

	
	@Test 
	public void testCalcularGasto(){
		//Creamos un prestamo.
		Prestamo mockedPrestamo = mock(Prestamo.class);
		//Creamos una cuota.
		Cuota mockedCuota = mock(Cuota.class);
		//Creamos un vector de una cuota.
		List<Cuota>cuotas = new Vector<Cuota>();
		cuotas.add(mockedCuota);
		
		//Test con gasto fijo.
		this.initializeFijo();
		when(mockedPrestamo.getCuotas()).thenReturn(cuotas);
		//seteo el valor total de los gastos en la cuota
		when(mockedCuota.getGastoTotal()).thenReturn((double)0);
		when(mockedCuota.getMontoCuota()).thenReturn((double)1500);
		double auxiliarCostoCuota = mockedCuota.getMontoCuota();
		
		//seteo el monto de mockedTipoDeGasto.
		when(mockedTipoDeGasto.getMonto()).thenReturn((double)25);
		double auxiliar = mockedTipoDeGasto.getMonto();
		when(mockedTipoDeGasto.calcularGasto(auxiliarCostoCuota)).thenReturn(auxiliar);
		
		gastoMensual.calcularGasto(mockedPrestamo);
		
		verify(mockedCuota).actualizarGastoTotal(auxiliar);
		
		//Test con gasto fijo.
		this.initializePorcentual();
		
		//seteo el monto de mockedTipoDeGasto.
		when(mockedTipoDeGasto.getMonto()).thenReturn((double)10/100);
		auxiliar = mockedTipoDeGasto.getMonto();
		when(mockedTipoDeGasto.calcularGasto(auxiliarCostoCuota)).thenReturn(auxiliarCostoCuota * auxiliar);
				
		gastoMensual.calcularGasto(mockedPrestamo);
		//El resultado seria: 0 + auxiliarCostoCuota * auxiliar.
		verify(mockedCuota).actualizarGastoTotal(auxiliarCostoCuota * auxiliar);
		
		
		
		
	}
	
}

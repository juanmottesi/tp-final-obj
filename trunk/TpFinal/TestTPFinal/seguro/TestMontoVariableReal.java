package seguro;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
//import static org.mockito.Mockito.when;
//import static org.mockito.Mockito.verify;

import java.util.List;
import java.util.Vector;

import org.junit.Before;
import org.junit.Test;

import prestamos.Cuota;
import prestamos.Prestamo;

public class TestMontoVariableReal {
	
	private MontoVariableReal montoVariableReal;
	private double coeficiente;

	@Before 
	public void setUp(){
		coeficiente = 0.07;
		montoVariableReal = new MontoVariableReal(coeficiente);
	}
	
	@Test
	public void testConstructor() {
		assertNotNull(montoVariableReal);
		//El coeficiente al ser porcentual se tiene que dividir en 100
		assertEquals("Revisa el monto", coeficiente/100, montoVariableReal.getCoeficiente(), 0);
		assertNotEquals("Revisa el monto",coeficiente, montoVariableReal.getCoeficiente(),0);
	}
	
	@Test
	public void testCalcularSeguro(){
		List<Cuota>cuotas = new Vector<Cuota>();
		Cuota mockedCuota = mock(Cuota.class);
		Prestamo mockedPrestamo = mock(Prestamo.class);
		when(mockedCuota.getSaldoDeuda()).thenReturn((double) 18500);
		cuotas.add(mockedCuota);
		when(mockedPrestamo.getCuotas()).thenReturn(cuotas);
		
		
		montoVariableReal.calcularSeguro(mockedPrestamo);
		

		// setea el seguro con 18500 * montoVariableReal.getCoeficiente() = 12.950000000000001
		verify(mockedCuota).setSeguro(12.950000000000001);
		
	}

}

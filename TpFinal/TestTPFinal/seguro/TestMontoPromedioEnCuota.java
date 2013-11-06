package seguro;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.List;
import java.util.Vector;

import org.junit.Before;
import org.junit.Test;

import prestamos.Cuota;
import prestamos.Prestamo;

public class TestMontoPromedioEnCuota {
	
	private MontoPromedioEnCuota montoPromedioEnCuota;
	private double coeficiente;
	
	@Before
	public void setUp(){
		coeficiente = 0.07;
		montoPromedioEnCuota = new MontoPromedioEnCuota(coeficiente);
	}

	@Test
	public void testConstructor() {
		assertNotNull(montoPromedioEnCuota);
		assertEquals("Revisa el monto",coeficiente/100 , montoPromedioEnCuota.getCoeficiente(),0);
		assertNotEquals("Revisa el monto", coeficiente, montoPromedioEnCuota.getCoeficiente(),0);		
	}
	
	@Test
	public void testSumaDeSeguroDeVida(){
		List<Cuota>cuotas = new Vector<Cuota>();
		Cuota mockedCuota1 = mock(Cuota.class);
		Cuota mockedCuota2 = mock(Cuota.class);
		Prestamo mockedPrestamo = mock(Prestamo.class);
		
		cuotas.add(mockedCuota1);
		cuotas.add(mockedCuota2);
		
		when(mockedPrestamo.getCuotas()).thenReturn(cuotas);
		
		when(mockedCuota1.getSaldoDeuda()).thenReturn((double)18000);
		when(mockedCuota2.getSaldoDeuda()).thenReturn((double)20000);
		
		// Suma el saldoDeuda de las dos cuotas 18000+ 20000 = 38000
		assertEquals("Revisa el retorno de la funcion",38000, montoPromedioEnCuota.sumaDeSeguroDeVida(mockedPrestamo),0);
	}
	
	@Test
	public void testCalcularSeguro(){
		List<Cuota>cuotas = new Vector<Cuota>();
		Cuota mockedCuota1 = mock(Cuota.class);
		Cuota mockedCuota2 = mock(Cuota.class);
		Prestamo mockedPrestamo = mock(Prestamo.class);
		
		cuotas.add(mockedCuota1);
		cuotas.add(mockedCuota2);
		
		when(mockedPrestamo.getCuotas()).thenReturn(cuotas);
		
		when(mockedCuota1.getSaldoDeuda()).thenReturn((double)18000);
		when(mockedCuota2.getSaldoDeuda()).thenReturn((double)20000);
		
		when(mockedPrestamo.cantidadDeCuotas()).thenReturn(cuotas.size());
		
		montoPromedioEnCuota.calcularSeguro(mockedPrestamo);
		// 
		double auxiliar = montoPromedioEnCuota.sumaDeSeguroDeVida(mockedPrestamo);
		auxiliar /= mockedPrestamo.cantidadDeCuotas();
		auxiliar *= montoPromedioEnCuota.getCoeficiente(); 
		verify(mockedCuota1).setSeguro(auxiliar);
		verify(mockedCuota2).setSeguro(auxiliar);
		
		
	}

}

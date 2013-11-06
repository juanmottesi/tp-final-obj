package seguro;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

import java.util.List;
import java.util.Vector;

import org.junit.Before;
import org.junit.Test;

import prestamos.Cuota;
import prestamos.Prestamo;

public class TestSinSeguroDeVida {
	
	private SinSeguroDeVida sinSeguroDeVida;

	@Before
	public void setUp(){
		sinSeguroDeVida = new SinSeguroDeVida();
	}
	
	@Test
	public void testConstructor() {
		assertNotNull(sinSeguroDeVida);
		assertEquals("Revisa el monto",0,sinSeguroDeVida.getCoeficiente(), 0 );
	}

	@Test
	public void testCalcularSeguro(){
		List<Cuota>cuotas = new Vector<Cuota>();
		Cuota mockedCuota = mock(Cuota.class);
		Prestamo mockedPrestamo = mock(Prestamo.class);
		cuotas.add(mockedCuota);
		when(mockedPrestamo.getCuotas()).thenReturn(cuotas);
		
		sinSeguroDeVida.calcularSeguro(mockedPrestamo);
		
		verify(mockedCuota).setSeguro(sinSeguroDeVida.getCoeficiente());
		
	}
}

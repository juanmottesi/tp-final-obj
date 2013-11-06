package prestamos;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.List;
import java.util.Vector;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import seguro.ModoSeguroDeVida;
import gastos.Gasto;

public class TestConfiguracionPrestamo {

	private ConfiguracionPrestamo configuracionPrestamo;
	
	@Mock
	private Prestamo mockedPrestamo = mock(Prestamo.class);
	private ModoSeguroDeVida mockedSeguro = mock(ModoSeguroDeVida.class);
	private Gasto mockedGasto = mock(Gasto.class);
	
	@Before
	public void setUp(){
		List<Gasto> gastos = new Vector<Gasto>();
		gastos.add(mockedGasto);
		configuracionPrestamo = new ConfiguracionPrestamo(mockedSeguro,gastos);
	}
	

	@Test
	public void testConstructor(){
		assertNotNull(configuracionPrestamo);
		assertNotNull(configuracionPrestamo.getModoSeguro());
		assertNotNull(configuracionPrestamo.getGastos());
		assertEquals("Se fija la cantidad de elementos en la lista de gastos",1,configuracionPrestamo.getGastos().size());	
	}
	
	@Test
	public void testCalcularSeguro() {
		configuracionPrestamo.calcularSeguro(mockedPrestamo);
		verify(mockedSeguro).calcularSeguro(mockedPrestamo);
	}
	
	@Test
	public void testCalcularGasto() {
		configuracionPrestamo.calcularGasto(mockedPrestamo);;
		verify(mockedGasto).calcularGasto(mockedPrestamo);
	}

}

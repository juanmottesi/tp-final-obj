package otros;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import gastos.Gasto;
import gastos.GastoGlobal;
import gastos.GastoMensual;

import java.util.Date;
import java.util.List;
import java.util.SortedMap;
import java.util.Vector;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import prestamos.Prestamo;

public class TestConfiguracionGeneral {
	
	private ConfiguracionGeneral configuracionGeneral;
	
	@Mock
	private Gasto mockedGasto1;
	private Gasto mockedGasto2;
	
	@Before
	public void setUp(){
		
		List<Gasto> gastos = new Vector<Gasto>();
		mockedGasto1 = mock(GastoGlobal.class);
		mockedGasto2 = mock(GastoMensual.class);
		gastos.add(mockedGasto1);
		gastos.add(mockedGasto2);
		configuracionGeneral = new ConfiguracionGeneral(new Date(),gastos);		
	}

	@Test
	public void testConstructor() {
	
		assertNotNull(configuracionGeneral);
		assertEquals("Cantidad de elementos en la lista de gastos", 2, configuracionGeneral.getGastos().size());
		assertTrue("Si el tem esta vacio",configuracionGeneral.getTem().isEmpty());
	}

	@Test
	public void testAgregarClaveValorATem(){

		configuracionGeneral.agregarClaveValorATem(12, 3);
		assertEquals("Se fija si el tem tiene un elemento",1, configuracionGeneral.getTem().size());
	}
	
	@Test
	public void testConsultarTem(){

		//Agrego un valor al tem.
		configuracionGeneral.agregarClaveValorATem(12, 3);
		//Acordarse que el agregarClaveValorATem la clave es porcentual y la guarda haciendo el monto/100.
		assertEquals("se fija que el valor sea el correcto",(Integer)(3/100),configuracionGeneral.consultarTem(12));
		//Si el numero de cuotas es menor al que se encuentra como clave tiene que dar el siguiente
		assertEquals("se fija que el valor sea el correcto",(Integer)(3/100),configuracionGeneral.consultarTem(10));
	}
	
	@Test
	public void testCalcularGasto(){
		Prestamo mockedPrestamo = mock(Prestamo.class);
		configuracionGeneral.calcularGasto(mockedPrestamo);
		
		verify(mockedGasto1).calcularGasto(mockedPrestamo);
		verify(mockedGasto2).calcularGasto(mockedPrestamo);
		
		
		
	}
}

package tipoDeImpresion;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.GregorianCalendar;
import java.util.List;
import java.util.Vector;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import prestamos.Cuota;
import prestamos.Prestamo;

public class TestPorHTML {
	
	private PorHTML porHTML;

	@Mock
	Cuota mockedCuota = mock(Cuota.class);
	Prestamo mockedPrestamo = mock(Prestamo.class);
	
	@Before
	public void setUp(){
		porHTML = new PorHTML();
	}
	
	@Test
	public void testConstructor() {
		assertNotNull(porHTML);
	}

	@Test
	public void testGenerarCabecera(){
		String nuevalinea = System.getProperty("line.separator");
		String texto = "<html lang =\"en\">" + nuevalinea;
		texto = texto + nuevalinea;
		texto = texto + "<head>" + nuevalinea;
		texto = texto + nuevalinea + "    " + "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">"+ nuevalinea;
		texto = texto + nuevalinea + "    " + "<title>Cuadro de Marcha</title>" +nuevalinea;
		texto = texto + nuevalinea + "</head>" + nuevalinea;
		texto = texto + nuevalinea + "<body>" + nuevalinea;
		texto = texto + nuevalinea + "    " +"<div id = \"cuadro\">" + nuevalinea;	
		
		assertEquals(texto, porHTML.generarCabecera());
		
	}
	
	@Test
	public void testGenerarFinCabecera(){
		String nuevalinea = System.getProperty("line.separator");
		String texto = "";
		texto = texto + "    " + "</div>" + nuevalinea;
		texto = texto + nuevalinea + "</div>" + nuevalinea;
		texto = texto + nuevalinea + "</html>";
		
		assertEquals(texto, porHTML.generarFinCabecera());
	}
	
	@Test
	public void testGenerarCuerpo(){
		String nuevalinea = System.getProperty("line.separator");
		String nuevalinea2 = nuevalinea+"       ";
		String texto = "";
		texto = texto+nuevalinea2+"<ul>";
		
		assertEquals(texto, porHTML.generarCuerpo());
	}
	
	@Test 
	public void testGenerarFinCuerpo(){
		String nuevalinea = System.getProperty("line.separator");
		String nuevalinea2 = nuevalinea+"       ";
		String texto = "";
		texto = texto+nuevalinea2+"</ul>"+nuevalinea;
		
		assertEquals(texto, porHTML.generarFinCuerpo());		
	}
	
	@Test
	public void testGenerarCuota(){
		when(mockedCuota.getNroCuota()).thenReturn(0);
		String nuevalinea = System.getProperty("line.separator");
		String nuevalinea2 = nuevalinea+"            ";
		String s = nuevalinea2+"<li>";
		s = s + "Cuota " + 0;
		s = s+"</li>";	
		
		assertEquals(s, porHTML.generarCuota(mockedCuota));
		verify(mockedCuota).getNroCuota();
	}
	
	@Test
	public void testGenerarVencimiento(){
		when(mockedCuota.mostrarFecha(mockedCuota.getFechaVencimiento())).thenReturn("fecha");
		String nuevalinea = System.getProperty("line.separator");
		String nuevalinea2 = nuevalinea+"            ";
		String s = nuevalinea2+"<li>";
		s = s + "Vencimiento " + "fecha";
		s = s+"</li>";	
		
		assertEquals(s, porHTML.generarVencimiento(mockedCuota));
		verify(mockedCuota).mostrarFecha((GregorianCalendar) any());
	}
	
	@Test
	public void testGenerarAmortizacion(){
		when(mockedCuota.getAmortizacion()).thenReturn((double) 1);
		String nuevalinea = System.getProperty("line.separator");
		String nuevalinea2 = nuevalinea+"            ";
		String s = nuevalinea2+"<li>";
		s = s + "Amortizacion " + 1.00;
		s = s+"</li>";	
		
		assertEquals(s, porHTML.generarAmortizacion(mockedCuota));
		verify(mockedCuota).getAmortizacion();
	}
	
	@Test
	public void testGenerarInteres(){
		when(mockedCuota.getInteres()).thenReturn((double) 1);
		String nuevalinea = System.getProperty("line.separator");
		String nuevalinea2 = nuevalinea+"            ";
		String s = nuevalinea2+"<li>";
		s = s + "Interes " + 1.00;
		s = s+"</li>";	
		
		assertEquals(s, porHTML.generarInteres(mockedCuota));
		verify(mockedCuota).getInteres();		
	}
	
	@Test
	public void testGenerarSaldoDeuda(){
		when(mockedCuota.getSaldoDeuda()).thenReturn((double) 1);
		String nuevalinea = System.getProperty("line.separator");
		String nuevalinea2 = nuevalinea+"            ";
		String s = nuevalinea2+"<li>";
		s = s + "Saldo Deuda " + 1.00;
		s = s+"</li>";
		
		assertEquals(s, porHTML.generarSaldoDeuda(mockedCuota));
		verify(mockedCuota).getSaldoDeuda();	
	}
	
	@Test
	public void testGenerarSeguro(){
		when(mockedCuota.getSeguro()).thenReturn((double) 1);
		String nuevalinea = System.getProperty("line.separator");
		String nuevalinea2 = nuevalinea+"            ";
		String s = nuevalinea2+"<li>";
		s = s + "Seguro " + 1.00;
		s = s+"</li>";	
		
		assertEquals(s, porHTML.generarSeguro(mockedCuota));
		verify(mockedCuota).getSeguro();	
	}
	
	@Test
	public void testGenerarGastos(){
		when(mockedCuota.getGastoTotal()).thenReturn((double) 1);
		String nuevalinea = System.getProperty("line.separator");
		String nuevalinea2 = nuevalinea+"            ";
		String s = nuevalinea2+"<li>";
		s = s + "Gastos " + 1.00;
		s = s+"</li>";	
		
		assertEquals(s, porHTML.generarGastos(mockedCuota));
		verify(mockedCuota).getGastoTotal();	
	}
	
	@Test
	public void testGenerarValorCuota(){
		when(mockedCuota.getMontoCuota()).thenReturn((double) 1);
		String nuevalinea = System.getProperty("line.separator");
		String nuevalinea2 = nuevalinea+"            ";
		String s = nuevalinea2+"<li>";
		s = s + "Valor Cuota " + 1.00;
		s = s+"</li>";	
		
		assertEquals(s, porHTML.generarValorCuota(mockedCuota));
		verify(mockedCuota).getMontoCuota();	
	}
	
	@Test
	public void testGenerarValorTotalCuota(){
		when(mockedCuota.getValorTotalCuota()).thenReturn((double) 1);
		String nuevalinea = System.getProperty("line.separator");
		String nuevalinea2 = nuevalinea+"            ";
		String s = nuevalinea2+"<li>";
		s = s + "Valor Total Cuota " +1.00;
		s = s+"</li>";	
		
		assertEquals(s, porHTML.generarValorTotalCuota(mockedCuota));
		verify(mockedCuota).getValorTotalCuota();	
	}
	
	@Test
	public void testGenerarFechaPago(){
		when(mockedCuota.mostrarFecha(mockedCuota.getFechaDePago())).thenReturn("fecha");
		String nuevalinea = System.getProperty("line.separator");
		String nuevalinea2 = nuevalinea+"            ";
		String s = nuevalinea2+"<li>";
		s = s + "Fecha de Pago " + "fecha";
		s = s+"</li>";	
		
		assertEquals(s, porHTML.generarFechaPago(mockedCuota));
		verify(mockedCuota).mostrarFecha((GregorianCalendar) any());	
	}
	
	@Test
	public void testGenerarInteresPorMora(){
		when(mockedCuota.getInteresPorMora()).thenReturn((double) 1);
		String nuevalinea = System.getProperty("line.separator");
		String nuevalinea2 = nuevalinea+"            ";
		String s = nuevalinea2+"<li>";
		s = s + "Interes Por Mora " + 1.00;
		s = s+"</li>";	
		
		assertEquals(s, porHTML.generarInteresPorMora(mockedCuota));
		verify(mockedCuota).getInteresPorMora();	
	}
	
	@Test
	public void testNombreArchivo(){
		assertEquals("Prestamo.html", porHTML.nombreArchivo());
	}
	
	@Test
	public void testImrimir(){
		String texto = "";
		texto = texto + porHTML.generarCabecera();
		texto = texto + this.generarTextoParaTestGenerarCuerpo();
		texto = texto + porHTML.generarFinCabecera();
		
		assertEquals(texto, porHTML.imprimir(mockedPrestamo));
	}
	
	public String generarTextoParaTestGenerarCuerpo(){
		List<Cuota> cuotas = new Vector<Cuota>();
		cuotas.add(mockedCuota);
		when(mockedPrestamo.getCuotas()).thenReturn(cuotas);
		String texto = "";
		texto = texto + porHTML.generarCuerpo();
		texto = texto + this.generarTextoParaTestGenerarInfo();
		texto = texto + porHTML.generarFinCuerpo();
		return texto;
	}
	
	@Test
	public void testGenerarCurpo(){
		
		String texto = this.generarTextoParaTestGenerarCuerpo();
		assertEquals(texto, porHTML.generarCuerpo(mockedPrestamo));
	}
	
	public String generarTextoParaTestGenerarInfo(){
		when(mockedCuota.getNroCuota()).thenReturn(1);
		when(mockedCuota.mostrarFecha(mockedCuota.getFechaVencimiento())).thenReturn("fecha");
		when(mockedCuota.getAmortizacion()).thenReturn((double) 1);
		when(mockedCuota.getInteres()).thenReturn((double) 1);
		when(mockedCuota.getSaldoDeuda()).thenReturn((double) 1);
		when(mockedCuota.getSeguro()).thenReturn((double) 1);
		when(mockedCuota.getGastoTotal()).thenReturn((double) 1);
		when(mockedCuota.getMontoCuota()).thenReturn((double) 1);
		when(mockedCuota.getValorTotalCuota()).thenReturn((double) 1);
		when(mockedCuota.mostrarFecha(mockedCuota.getFechaDePago())).thenReturn("fecha");
		when(mockedCuota.getInteresPorMora()).thenReturn((double) 1);
		
		String nuevalinea = System.getProperty("line.separator");
		String nuevalinea2 = nuevalinea+"            ";
		String s = "";

		s = s+ nuevalinea2+"<li>";
		s = s + "Cuota " + 1;
		s = s+"</li>";
		s = s+ nuevalinea2+"<li>";
		s = s + "Vencimiento " + "fecha";
		s = s+"</li>";	
		s = s+ nuevalinea2+"<li>";
		s = s + "Amortizacion " + 1.00;
		s = s+"</li>";	
		s = s+ nuevalinea2+"<li>";
		s = s + "Interes " + 1.00;
		s = s+"</li>";	
		s = s+ nuevalinea2+"<li>";
		s = s + "Saldo Deuda " + 1.00;
		s = s+"</li>";	
		s = s+ nuevalinea2+"<li>";
		s = s + "Seguro " + 1.00;
		s = s+"</li>";	
		s = s+ nuevalinea2+"<li>";
		s = s + "Gastos " + 1.00;
		s = s+"</li>";	
		s = s+ nuevalinea2+"<li>";
		s = s + "Valor Cuota " + 1.00;
		s = s+"</li>";	
		s = s+ nuevalinea2+"<li>";
		s = s + "Valor Total Cuota " + 1.00;
		s = s+"</li>";	
		s = s+ nuevalinea2+"<li>";
		s = s + "Fecha de Pago " + "fecha";
		s = s+"</li>";	
		s = s+ nuevalinea2+"<li>";
		s = s + "Interes Por Mora " + 1.00;
		s = s+"</li>";	
		
		return s;
	}
	
	@Test
	public void testGenerarInfo(){
		String s = this.generarTextoParaTestGenerarInfo();
		assertEquals(s, porHTML.generarInfo(mockedCuota));
		
	}
}

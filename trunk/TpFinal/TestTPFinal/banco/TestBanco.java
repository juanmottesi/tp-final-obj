package banco;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.*;

import java.util.GregorianCalendar;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import prestamos.ConfiguracionPrestamo;
import prestamos.Prestamo;
import busqueda.Condicion;
import cliente.Cliente;
import exceptions.AprobadoException;
import exceptions.EstadoClienteException;
import exceptions.EstadoCuotaException;
import exceptions.RechazadoException;

public class TestBanco {

	private Banco banco;
	
	@Mock
	Cliente mockedCliente = mock(Cliente.class);
	ConfiguracionGeneral mockedConfiguracionGeneral = mock(ConfiguracionGeneral.class);
	Condicion mockedCondicion = mock(Condicion.class);
	Prestamo mockedPrestamo = mock(Prestamo.class);
	ConfiguracionPrestamo mockedConfiguracionPrestamo = mock(ConfiguracionPrestamo.class);
	
	@Before 
	public void setUp(){
		banco = new Banco();
		banco.agregarConfiguracionGeneral(mockedConfiguracionGeneral);
		
	}
	
	@Test
	public void testConstructor(){
		assertNotNull(banco);
	}
	
	@Test
	public void testConsultarPrestamoSinException(){
		GregorianCalendar hoy = new GregorianCalendar();
		GregorianCalendar fechaInicio = new GregorianCalendar(hoy.get(1),hoy.get(2),hoy.get(5)-1);
		GregorianCalendar fechaFin = new GregorianCalendar(hoy.get(1)+100,hoy.get(2),hoy.get(5)-1);
		when(mockedConfiguracionGeneral.consultarTem(12)).thenReturn(3*0.01);
		when(mockedConfiguracionGeneral.getFechaInicio()).thenReturn(fechaInicio);
		when(mockedConfiguracionGeneral.getFechaFin()).thenReturn(fechaFin);
		assertEquals(2511.5521368240734,banco.consultarPrestamo(25000, 12, hoy),0);
	}
	
	@Test
	public void testConsultarPrestamoConExceptionDeMonto(){
		GregorianCalendar hoy = new GregorianCalendar();
		GregorianCalendar fechaInicio = new GregorianCalendar(hoy.get(1),hoy.get(2),hoy.get(5)-1);
		GregorianCalendar fechaFin = new GregorianCalendar(hoy.get(1)+100,hoy.get(2),hoy.get(5)-1);
		when(mockedConfiguracionGeneral.consultarTem(12)).thenReturn(3*0.01);
		when(mockedConfiguracionGeneral.getFechaInicio()).thenReturn(fechaInicio);
		when(mockedConfiguracionGeneral.getFechaFin()).thenReturn(fechaFin);
		assertEquals(0,banco.consultarPrestamo(0, 12, hoy),0);
	}
	
	@Test
	public void testConsultarPrestamoConExceptionDeCantCuotas(){
		GregorianCalendar hoy = new GregorianCalendar();
		GregorianCalendar fechaInicio = new GregorianCalendar(hoy.get(1),hoy.get(2),hoy.get(5)-1);
		GregorianCalendar fechaFin = new GregorianCalendar(hoy.get(1)+100,hoy.get(2),hoy.get(5)-1);
		when(mockedConfiguracionGeneral.consultarTem(12)).thenReturn(3*0.01);
		when(mockedConfiguracionGeneral.getFechaInicio()).thenReturn(fechaInicio);
		when(mockedConfiguracionGeneral.getFechaFin()).thenReturn(fechaFin);
		assertEquals(0,banco.consultarPrestamo(25000, 0, hoy),0);
	}
	
	@Test
	public void  testFiltradosPorCondicionesVerdaderas(){
		when(mockedCondicion.respetaCondicion(mockedPrestamo)).thenReturn(true);
		banco.getPrestamos().add(mockedPrestamo);
		assertEquals(1,banco.filtradosPorCondiciones(mockedCondicion).size());
		
	}
	
	@Test
	public void  testFiltradosPorCondicionesFalsas(){
		when(mockedCondicion.respetaCondicion(mockedPrestamo)).thenReturn(false);
		banco.getPrestamos().add(mockedPrestamo);
		assertTrue(banco.filtradosPorCondiciones(mockedCondicion).isEmpty());
	}
	
	@Test
	public void testAgregarConfiguracionGeneral(){
		GregorianCalendar hoy = new GregorianCalendar();
		GregorianCalendar fechaFin = new GregorianCalendar(hoy.get(1)+100,hoy.get(2),hoy.get(5)-1);
		//Segunda config general.
		ConfiguracionGeneral mockedConfiguracionGeneral2 = mock(ConfiguracionGeneral.class);
		//Seteo la fecha inicion de la segunda
		when(mockedConfiguracionGeneral2.getFechaInicio()).thenReturn(fechaFin);
		
		banco.agregarConfiguracionGeneral(mockedConfiguracionGeneral2);
		
		verify(mockedConfiguracionGeneral).finConfiguracionGeneral(fechaFin);
	}
	
	@Test
	public void testAceptarPrestamo() throws AprobadoException, EstadoClienteException{
		banco.aceptarPrestamo(mockedPrestamo);
		verify(mockedPrestamo).aceptarPrestamo();
	}
	
	@Test
	public void testRechazarPrestamo() throws RechazadoException, EstadoClienteException{
		banco.rechazarPrestamo(mockedPrestamo);
		verify(mockedPrestamo).rechazarPrestamo();
	}
	
	 @Test
	 public void testPagarCuota() throws EstadoCuotaException{
		 GregorianCalendar hoy = new GregorianCalendar();
		 banco.pagarCuota(mockedPrestamo,hoy);
		 verify(mockedPrestamo).pagarCuota(hoy);
	 }
	 
	 @Test
	 public void testGenerarCuadroDeMarchaXMLDe(){
		 banco.generarCuadroDeMarchaXMLDe(mockedPrestamo);
		 verify(mockedPrestamo).genererarCuotasXML();
	 }
	 
	 @Test
	 public void testGenerarCuadroDeMarchaHTMLDe(){
		 banco.generarCuadroDeMarchaHTMLDe(mockedPrestamo);
		 verify(mockedPrestamo).genererarCuotasHTML();
	 }
	 
	 @Test
	 public void testAgregarPrestamoConClienteValido(){
		when(mockedCliente.puedoAgregarPrestamo()).thenReturn(true);
		
		GregorianCalendar hoy = new GregorianCalendar();
		GregorianCalendar fechaInicio = new GregorianCalendar(hoy.get(1),hoy.get(2),hoy.get(5)-1);
		GregorianCalendar fechaFin = new GregorianCalendar(hoy.get(1)+100,hoy.get(2),hoy.get(5)-1);
		
		when(mockedConfiguracionGeneral.consultarTem(12)).thenReturn(3*0.01);
		when(mockedConfiguracionGeneral.getFechaInicio()).thenReturn(fechaInicio);
		when(mockedConfiguracionGeneral.getFechaFin()).thenReturn(fechaFin);
		  
		 banco.agregarPrestamo(25000, 12, new GregorianCalendar(), mockedCliente, mockedConfiguracionPrestamo);
		 verify(mockedCliente).agregarPrestamo((Prestamo) any());
		 assertEquals(1,banco.getPrestamos().size());
	 }
	 
	 @Test
	 public void testAgregarPrestamoConClienteNoValido(){
		when(mockedCliente.puedoAgregarPrestamo()).thenReturn(false);
		
		GregorianCalendar hoy = new GregorianCalendar();
		GregorianCalendar fechaInicio = new GregorianCalendar(hoy.get(1),hoy.get(2),hoy.get(5)-1);
		GregorianCalendar fechaFin = new GregorianCalendar(hoy.get(1)+100,hoy.get(2),hoy.get(5)-1);
		
		when(mockedConfiguracionGeneral.consultarTem(12)).thenReturn(3*0.01);
		when(mockedConfiguracionGeneral.getFechaInicio()).thenReturn(fechaInicio);
		when(mockedConfiguracionGeneral.getFechaFin()).thenReturn(fechaFin);
		  
		 banco.agregarPrestamo(25000, 12, new GregorianCalendar(), mockedCliente, mockedConfiguracionPrestamo);
		 assertEquals(0,banco.getPrestamos().size());
	 }
}


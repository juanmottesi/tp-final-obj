package banco;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

import java.util.GregorianCalendar;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import prestamos.Prestamo;
import busqueda.Condicion;
import cliente.Cliente;

public class TestBanco {

	private Banco banco;
	
	@Mock
	Cliente mockedCliente = mock(Cliente.class);
	ConfiguracionGeneral mockedConfiguracionGeneral = mock(ConfiguracionGeneral.class);
	Condicion mockedCondicion = mock(Condicion.class);
	Prestamo mockedPrestamo = mock(Prestamo.class);
	
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
	
	
}


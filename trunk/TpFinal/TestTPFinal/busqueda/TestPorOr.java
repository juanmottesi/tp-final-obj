package busqueda;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Vector;

import org.junit.Test;
import org.mockito.Mock;

import prestamos.Prestamo;
import exceptions.EmptyConditionException;
import busqueda.Condicion;
import busqueda.PorOr;

public class TestPorOr {
	
	private PorOr porOr;
	
	@Mock
	Prestamo mockedPrestamo = mock(Prestamo.class);
	Condicion mockedCondicion = mock(Condicion.class);
	
	
	public void initializeConlistaVacia() throws EmptyConditionException{
		List<Condicion> lista = new Vector<Condicion>();
		porOr = new PorOr(lista);
	}
	
	public void initializeConlista() throws EmptyConditionException{
		List<Condicion> lista = new Vector<Condicion>();
		lista.add(mockedCondicion);
		porOr = new PorOr(lista);
	}
	
	@Test
	public void testConstructorCorrecto() throws EmptyConditionException{
		this.initializeConlista();
		assertNotNull(porOr);
	}
	
	@Test (expected = EmptyConditionException.class)
	public void testConstructorConException() throws EmptyConditionException{
		this.initializeConlistaVacia();		
	}
	
	@Test
	public void testRespetaCondicionConCondicionVerdadera() throws EmptyConditionException{
		this.initializeConlista();
		when(mockedCondicion.respetaCondicion(mockedPrestamo)).thenReturn(true);
		assertTrue(porOr.respetaCondicion(mockedPrestamo));
	}
	
	@Test
	public void testRespetaCondicionConCondicionFalsa() throws EmptyConditionException{
		this.initializeConlista();
		when(mockedCondicion.respetaCondicion(mockedPrestamo)).thenReturn(false);
		assertFalse(porOr.respetaCondicion(mockedPrestamo));
	}

}

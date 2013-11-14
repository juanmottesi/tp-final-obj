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
import busqueda.PorAnd;


public class TestPorAnd {
	
	private PorAnd porAnd;

	@Mock
	Prestamo mockedPrestamo = mock(Prestamo.class);
	Condicion mockedCondicion = mock(Condicion.class);
	
	public void initializeConlistaVacia() throws EmptyConditionException{
		List<Condicion> lista = new Vector<Condicion>();
		porAnd = new PorAnd(lista);
	}
	
	public void initializeConlista() throws EmptyConditionException{
		List<Condicion> lista = new Vector<Condicion>();
		lista.add(mockedCondicion);
		porAnd = new PorAnd(lista);
	}
	
	@Test
	public void testConstructorCorrecto() throws EmptyConditionException {
		this.initializeConlista();
		assertNotNull(porAnd);
	}

	@Test (expected = EmptyConditionException.class)
	public void testConstructorConException() throws EmptyConditionException{
		this.initializeConlistaVacia();		
	}
	
	@Test
	public void testRespetaCondicionConCondicionVerdadera() throws EmptyConditionException{
		this.initializeConlista();
		when(mockedCondicion.respetaCondicion(mockedPrestamo)).thenReturn(true);
		assertTrue(porAnd.respetaCondicion(mockedPrestamo));
	}
	
	@Test
	public void testRespetaCondicionConCondicionFalsa() throws EmptyConditionException{
		this.initializeConlista();
		when(mockedCondicion.respetaCondicion(mockedPrestamo)).thenReturn(false);
		assertFalse(porAnd.respetaCondicion(mockedPrestamo));
	}

}

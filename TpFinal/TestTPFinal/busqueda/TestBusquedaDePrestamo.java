package busqueda;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Date;
import java.util.List;
import java.util.Vector;

import org.junit.Before;
import org.junit.Test;

import prestamos.Prestamo;
import estadoPrestamos.EnCurso;

public class TestBusquedaDePrestamo {
	
	private BusquedaDePrestamo busquedaDePrestamo;
	private Condicion condicion;
	
	@Before
	public void setUp(){
		condicion = new PorApellido("Pe");
		busquedaDePrestamo = new BusquedaDePrestamo(condicion);	
	}
	
	public void initializeConAnd(){
		List<Condicion> condiciones = new Vector<Condicion>();
		Date hoy = new Date();
		@SuppressWarnings("deprecation")
		Date desde = new Date(hoy.getYear(),hoy.getMonth(),hoy.getDay()-1);
		@SuppressWarnings("deprecation")
		Date hasta = new Date(hoy.getYear(),hoy.getMonth()+1,hoy.getDay());
	
		condiciones.add(new PorDNI((Integer)36778000));
		PorEstado estado = new PorEstado(new EnCurso());
		condiciones.add(estado);
		condiciones.add(new PorApellido("Pe"));
		condiciones.add(new PorCuotas(1,15));
		condiciones.add(new PorFechaDesde(desde));
		condiciones.add(new PorFechaHasta(hasta));
		condiciones.add(new PorMontoMaximo(40000));
		condiciones.add(new PorMontoMinimo(10000));
		
		condicion = new PorAnd(condiciones);
		busquedaDePrestamo = new BusquedaDePrestamo(condicion);
		
	}
	
	
	@Test
	public void testConstructor() {
		assertNotNull(busquedaDePrestamo);
		assertEquals(condicion, busquedaDePrestamo.getCondicion());

		//Test initializeConAnd
		this.initializeConAnd();
		assertEquals(condicion, busquedaDePrestamo.getCondicion());
		
	}

	@Test
	public void testBuscar(){
		
		Prestamo mockedPrestamo1 = mock(Prestamo.class);
		Prestamo mockedPrestamo2 = mock(Prestamo.class);
		List<Prestamo> prestamos = new Vector<Prestamo>();
		//Test con lista vacia de prestamos
		assertTrue(busquedaDePrestamo.buscar(prestamos).isEmpty());
		
		//Test con dos prestamos		
		prestamos.add(mockedPrestamo1);
		prestamos.add(mockedPrestamo2);
		
		//Test con apellido de los dos prestamos que cumplen la condicion
		when(mockedPrestamo1.obtenerApellidoCliente()).thenReturn("Pe");
		when(mockedPrestamo2.obtenerApellidoCliente()).thenReturn("Pe");
		
		assertFalse(busquedaDePrestamo.buscar(prestamos).isEmpty());
		assertEquals(2, busquedaDePrestamo.buscar(prestamos).size());
		
		//Test con apellido con uno de los prestamos que cumplen la condicion
		when(mockedPrestamo1.obtenerApellidoCliente()).thenReturn("Pe");
		when(mockedPrestamo2.obtenerApellidoCliente()).thenReturn("Garcia");
				
		assertFalse(busquedaDePrestamo.buscar(prestamos).isEmpty());
		assertEquals(1, busquedaDePrestamo.buscar(prestamos).size());
		
		//Test con apellido con uno de los prestamos que cumplen la condicion
		when(mockedPrestamo1.obtenerApellidoCliente()).thenReturn("Gar");
		when(mockedPrestamo2.obtenerApellidoCliente()).thenReturn("Garcia");
						
		assertTrue(busquedaDePrestamo.buscar(prestamos).isEmpty());
				
		//Test con and
		this.initializeConAnd();
		
		//Test con and y todas las condiciones verdaderas.
		when(mockedPrestamo1.obtenerApellidoCliente()).thenReturn("Pe");
		when(mockedPrestamo1.cantidadDeCuotas()).thenReturn(12);
		when(mockedPrestamo1.obtenerDniCliente()).thenReturn((Integer)36778000);
		when(mockedPrestamo1.getEstado()).thenReturn(new EnCurso());
		when(mockedPrestamo1.getFechaDeCreacion()).thenReturn(new Date());
		when(mockedPrestamo1.getMontoTotal()).thenReturn((double) 25000);
		
		when(mockedPrestamo2.obtenerApellidoCliente()).thenReturn("Pe");
		when(mockedPrestamo2.cantidadDeCuotas()).thenReturn(12);
		when(mockedPrestamo2.obtenerDniCliente()).thenReturn((Integer)36778000);
		when(mockedPrestamo2.getEstado()).thenReturn(new EnCurso());
		when(mockedPrestamo2.getFechaDeCreacion()).thenReturn(new Date());
		when(mockedPrestamo2.getMontoTotal()).thenReturn((double) 25000);
		
		assertFalse(busquedaDePrestamo.buscar(prestamos).isEmpty());
		assertEquals(2, busquedaDePrestamo.buscar(prestamos).size());
		
		//Test con and y con un prestamo que cumple todas las condiciones.
		when(mockedPrestamo1.obtenerApellidoCliente()).thenReturn("Pe");
		when(mockedPrestamo1.cantidadDeCuotas()).thenReturn(12);
		when(mockedPrestamo1.obtenerDniCliente()).thenReturn((Integer)36778000);
		when(mockedPrestamo1.getEstado()).thenReturn(new EnCurso());
		when(mockedPrestamo1.getFechaDeCreacion()).thenReturn(new Date());
		when(mockedPrestamo1.getMontoTotal()).thenReturn((double) 25000);
		
		when(mockedPrestamo2.obtenerApellidoCliente()).thenReturn("Garcia");
		when(mockedPrestamo2.cantidadDeCuotas()).thenReturn(12);
		when(mockedPrestamo2.obtenerDniCliente()).thenReturn((Integer)36778000);
		when(mockedPrestamo2.getEstado()).thenReturn(new EnCurso());
		when(mockedPrestamo2.getFechaDeCreacion()).thenReturn(new Date());
		when(mockedPrestamo2.getMontoTotal()).thenReturn((double) 25000);
				
		assertFalse(busquedaDePrestamo.buscar(prestamos).isEmpty());
		assertEquals(1, busquedaDePrestamo.buscar(prestamos).size());
		
		//Test con and y ningun prestamo cumple las condiciones.
		when(mockedPrestamo1.obtenerApellidoCliente()).thenReturn("Pe");
		when(mockedPrestamo1.cantidadDeCuotas()).thenReturn(20);
		when(mockedPrestamo1.obtenerDniCliente()).thenReturn((Integer)36778000);
		when(mockedPrestamo1.getEstado()).thenReturn(new EnCurso());
		when(mockedPrestamo1.getFechaDeCreacion()).thenReturn(new Date());
		when(mockedPrestamo1.getMontoTotal()).thenReturn((double) 25000);
			
		when(mockedPrestamo2.obtenerApellidoCliente()).thenReturn("Garcia");
		when(mockedPrestamo2.cantidadDeCuotas()).thenReturn(12);
		when(mockedPrestamo2.obtenerDniCliente()).thenReturn((Integer)36778000);
		when(mockedPrestamo2.getEstado()).thenReturn(new EnCurso());
		when(mockedPrestamo2.getFechaDeCreacion()).thenReturn(new Date());
		when(mockedPrestamo2.getMontoTotal()).thenReturn((double) 25000);
						
		assertTrue(busquedaDePrestamo.buscar(prestamos).isEmpty());
		
		
		
		
	}
	
}

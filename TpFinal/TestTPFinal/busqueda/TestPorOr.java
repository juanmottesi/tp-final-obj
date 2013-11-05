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
import estadoPrestamos.Rechazado;
import busqueda.Condicion;
import busqueda.PorApellido;
import busqueda.PorCuotas;
import busqueda.PorDNI;
import busqueda.PorEstado;
import busqueda.PorFechaDesde;
import busqueda.PorFechaHasta;
import busqueda.PorMontoMaximo;
import busqueda.PorMontoMinimo;
import busqueda.PorOr;


public class TestPorOr {
	
	private List<Condicion>condiciones;
	private PorOr porOr;

	
	@Before
	public void setUp(){
		condiciones = new Vector<Condicion>();	
		porOr = new PorOr(condiciones);
	}
	
	public void initialize(){
		condiciones = new Vector<Condicion>();
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
		
		porOr = new PorOr(condiciones);
		}
	
	public void initializeParaQueElOrSeaFalso(){
		condiciones = new Vector<Condicion>();
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
		
		condiciones.add(new PorMontoMaximo(40000));
		
		
		porOr = new PorOr(condiciones);
		}
	

	@Test
	public void testConstructor() {
		assertNotNull(porOr);
		assertTrue(porOr.getCondiciones().isEmpty());
		this.initialize();
		//Prueba de que initialize funcione.
		assertFalse(porOr.getCondiciones().isEmpty());
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testRespetaCondicion(){
		Prestamo mockedPrestamo = mock(Prestamo.class);
		
		//Lista vacia, siempre es verdadero.
		assertTrue(porOr.respetaCondicion(mockedPrestamo));
		
		this.initialize();
		
		//Prestamo con condiciones todas verdaderas.
		when(mockedPrestamo.obtenerApellidoCliente()).thenReturn("Pe");
		when(mockedPrestamo.cantidadDeCuotas()).thenReturn(12);
		when(mockedPrestamo.obtenerDniCliente()).thenReturn((Integer)36778000);
		when(mockedPrestamo.getEstado()).thenReturn(new EnCurso());
		when(mockedPrestamo.getFechaDeCreacion()).thenReturn(new Date());
		when(mockedPrestamo.getMontoTotal()).thenReturn((double) 25000);
		
		assertTrue(porOr.respetaCondicion(mockedPrestamo));
		
		//Prestamo con una condicion falsa.
		when(mockedPrestamo.obtenerApellidoCliente()).thenReturn("Garcia"); // condicion falsa
		when(mockedPrestamo.cantidadDeCuotas()).thenReturn(12);
		when(mockedPrestamo.obtenerDniCliente()).thenReturn(36778000);
		when(mockedPrestamo.getEstado()).thenReturn(new EnCurso());
		when(mockedPrestamo.getFechaDeCreacion()).thenReturn(new Date());
		when(mockedPrestamo.getMontoTotal()).thenReturn((double) 25000);				
		
		assertTrue(porOr.respetaCondicion(mockedPrestamo));
		
		//Prestamo con todas las condiciones falsas
		this.initializeParaQueElOrSeaFalso();
		
		when(mockedPrestamo.obtenerApellidoCliente()).thenReturn("Garcia");
		when(mockedPrestamo.cantidadDeCuotas()).thenReturn(20);
		when(mockedPrestamo.obtenerDniCliente()).thenReturn(36778010);
		when(mockedPrestamo.getEstado()).thenReturn(new Rechazado());
		when(mockedPrestamo.getFechaDeCreacion()).thenReturn(new Date("2013/05/05"));
		when(mockedPrestamo.getMontoTotal()).thenReturn((double) 50000); 
		assertFalse(porOr.respetaCondicion(mockedPrestamo));
		
	}

}

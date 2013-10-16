package prestamos;

import java.util.List;

import otros.*;
import estadoPrestamos.*;
import gastos.Gasto;

public class Prestamo {

	private EstadoPrestamo estado;
	private List<Cuota> cuotas; 
	private Cliente cliente;
	private float montoTotal;
	private List<Gasto> gastos;
	
}

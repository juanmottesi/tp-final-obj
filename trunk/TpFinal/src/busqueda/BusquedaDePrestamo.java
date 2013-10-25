package busqueda;

import java.util.List;

import prestamos.Prestamo;

public class BusquedaDePrestamo {
	
	private Condicion condicion;
	
	public Condicion getCondicion() {
		return condicion;
	}

	public void setCondicion(Condicion condicion) {
		this.condicion = condicion;
	}
	
	public BusquedaDePrestamo(Condicion condiciones){
		
		this.setCondicion(condiciones);
		
	}


	public List<Prestamo> buscar(List<Prestamo> prestamos){
		
		return this.getCondicion().buscar(prestamos);
		
	}


	
}

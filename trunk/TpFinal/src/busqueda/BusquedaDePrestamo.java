package busqueda;

import java.util.List;
import java.util.Vector;

import prestamos.Prestamo;

public class BusquedaDePrestamo {
	
	private List<Condicion>condiciones;

	public List<Condicion> getCondiciones() {
		return condiciones;
	}

	public void setCondiciones(List<Condicion> condiciones) {
		this.condiciones = condiciones;
	}

	public BusquedaDePrestamo(){
		
		this.setCondiciones(new Vector<Condicion>());
		
	}
	
	public BusquedaDePrestamo(List<Condicion>condiciones){
		
		this.setCondiciones(condiciones);
		
	}
	
	public void agregarCondicion(Condicion c){
		
		this.getCondiciones().add(c);

	}

	public List<Prestamo> buscar(List<Prestamo> prestamos){
		if(this.getCondiciones().isEmpty()){
			return prestamos;
		}
		else{
			Condicion c = this.getCondiciones().get(0);
			this.getCondiciones().remove(0);
			return this.buscar(c.buscar(prestamos));
		}
	}
	
}

package busqueda;


import java.util.List;
import java.util.Vector;

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
		List<Prestamo> ret = new Vector<Prestamo>(); 
		for(Prestamo p : prestamos){
			if(this.getCondicion().respetaCondicion(p)){
				ret.add(p);
			}
		}
		return ret;
	}


	
}

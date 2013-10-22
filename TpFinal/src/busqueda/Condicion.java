package busqueda;

import java.util.List;
import java.util.Vector;

import prestamos.Prestamo;

public abstract class Condicion {
	
	public List<Prestamo> buscar(List<Prestamo> prestamos){
		
		List<Prestamo> ret = new Vector<Prestamo>();
		for(Prestamo p : prestamos){
			if(this.respetaCondicion(p)){
				ret.add(p);
			}
		}
		return ret;
	}
		
	public abstract boolean respetaCondicion(Prestamo p);


}

package busqueda;

import java.util.List;
import java.util.Vector;

import prestamos.Prestamo;

public class PorOr extends Condicion {
	
	private List<Condicion> condiciones;
	
	public List<Condicion> getCondiciones() {
		return this.condiciones;
	}
	
	public void setCondiciones(List<Condicion> condiciones) {
		this.condiciones = condiciones;
	}
		
	public void agregarPrestamosA(List<Prestamo>p1, List<Prestamo>p2){
		if(p1.isEmpty()){
			p1.addAll(p2);
		}
		else{
			for(Prestamo p : p2){
				if(p1.contains(p2)){}
				else{
					p1.add(p);
				}
			}
		}
	}
	
	@Override
	
	public List<Prestamo> buscar(List<Prestamo> prestamos){
		List<Prestamo> ret = new Vector<Prestamo>();
		for(Condicion c : this.getCondiciones()){
			this.agregarPrestamosA(ret,c.buscar(prestamos));
		}
		return ret;
	}

	@Override
	public boolean respetaCondicion(Prestamo p) {
		return false;
	}
}

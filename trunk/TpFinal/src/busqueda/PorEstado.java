package busqueda;

import java.util.List;
import java.util.Vector;

import prestamos.Prestamo;
import estadoPrestamos.EstadoPrestamo;

public class PorEstado extends Condicion {
	
	private EstadoPrestamo estado;

	public EstadoPrestamo getEstado() {
		return estado;
	}

	public void setEstado(EstadoPrestamo estado) {
		this.estado = estado;
	}
	
	public PorEstado(EstadoPrestamo ep){
		
		this.setEstado(ep);
		
	}

	@Override
	public List<Prestamo> buscar(List<Prestamo> prestamos) {
		
		List<Prestamo> ret = new Vector<Prestamo>();
		for(Prestamo p : prestamos){
			if(p.getEstado() == this.getEstado()){
				ret.add(p);
			}
		}
		return ret;
	}
	
	

}

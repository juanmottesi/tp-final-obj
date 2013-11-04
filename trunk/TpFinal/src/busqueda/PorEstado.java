package busqueda;


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
	public boolean respetaCondicion(Prestamo p){
		return(p.getEstado().equals(this.getEstado()));
	}
	
	

}

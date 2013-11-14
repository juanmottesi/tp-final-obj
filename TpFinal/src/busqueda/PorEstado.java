package busqueda;


import prestamos.Prestamo;
import estadoPrestamos.EstadoPrestamo;

public class PorEstado extends Condicion {
	
	private EstadoPrestamo estado;

	private EstadoPrestamo getEstado() {
		return estado;
	}

	private void setEstado(EstadoPrestamo estado) {
		this.estado = estado;
	}
	
	public PorEstado(EstadoPrestamo ep){
		
		this.setEstado(ep);
		
	}

	@Override
	/**
	 * respetaCondicion se fija que el estado del prestamo sea igual al que se encuentra
	 * en su variable.
	 * 
	 * @return boolean
	 */
	public boolean respetaCondicion(Prestamo p){
		return(p.getEstado().equals(this.getEstado()));
	}
	
	

}

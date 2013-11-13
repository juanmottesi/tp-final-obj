package busqueda;

import java.util.Date;



import prestamos.Prestamo;

public class PorFechaDesde extends Condicion {
	
	private Date desde;
	
	private Date getDesde() {
		return desde;
	}
	
	private void setDesde(Date desde) {
		this.desde = desde;
	}


	public PorFechaDesde(Date desde){
		
		this.setDesde(desde);
		
	}

	@Override
	/**
	 * respetaCondicion se fija que la fecha del prestamo sea despues que la fecha
	 * de PorFechaDesde.
	 * 
	 * @return boolean 
	 */
	public boolean respetaCondicion(Prestamo p){	
		return(p.getFechaDeCreacion().after(this.getDesde()));

	}
	
	
	
	
	
	
	
}

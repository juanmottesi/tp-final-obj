package busqueda;




import java.util.GregorianCalendar;

import prestamos.Prestamo;

public class PorFechaDesde extends Condicion {
	
	private GregorianCalendar desde;
	
	private GregorianCalendar getDesde() {
		return desde;
	}
	
	private void setDesde(GregorianCalendar desde) {
		this.desde = desde;
	}


	public PorFechaDesde(GregorianCalendar desde){
		
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

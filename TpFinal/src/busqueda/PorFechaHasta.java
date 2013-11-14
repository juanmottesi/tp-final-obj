package busqueda;

import java.util.GregorianCalendar;

import prestamos.Prestamo;

public class PorFechaHasta extends Condicion {
	
	private GregorianCalendar hasta;

	private GregorianCalendar getHasta() {
		return hasta;
	}

	private void setHasta(GregorianCalendar hasta) {
		this.hasta = hasta;
	}
	
	public PorFechaHasta(GregorianCalendar hasta){
		this.setHasta(hasta);
	}
	
	@Override
	/**
	 * respetaCondicion se fija que la fecha del prestamo sea antes que la fecha
	 * de PorFechaHasta.
	 * 
	 * @return boolean 
	 */
	public boolean respetaCondicion(Prestamo p){
		return p.getFechaDeCreacion().before(this.getHasta());
	}

}

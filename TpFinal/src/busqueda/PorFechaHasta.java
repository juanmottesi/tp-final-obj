package busqueda;

import java.util.Date;

import prestamos.Prestamo;

public class PorFechaHasta extends Condicion {
	
	private Date hasta;

	public Date getHasta() {
		return hasta;
	}

	public void setHasta(Date hasta) {
		this.hasta = hasta;
	}
	
	public PorFechaHasta(Date hasta){
		
		this.setHasta(hasta);
		
	}
	
	@Override
	/**
	 * respetaCondicion se fija que la fecha del prestamo sea antes que la fecha
	 * de PorFechaHasta.
	 * 
	 */
	public boolean respetaCondicion(Prestamo p){
		return p.getFechaDeCreacion().before(this.getHasta());
	}

}

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
	
	public boolean respetaCondicion(Prestamo p){
		return p.getFechaDeCreacion().after(this.getHasta());
	}

}

package busqueda;

import java.util.Date;



import prestamos.Prestamo;

public class PorFechaDesde extends Condicion {
	
	private Date desde;
	
	public Date getDesde() {
		return desde;
	}
	
	public void setDesde(Date desde) {
		this.desde = desde;
	}


	public PorFechaDesde(Date desde){
		
		this.setDesde(desde);
		
	}

	@Override
	public boolean respetaCondicion(Prestamo p){	
		return(p.getFechaDeCreacion().after(this.getDesde()));

	}
	
	
	
	
	
	
	
}

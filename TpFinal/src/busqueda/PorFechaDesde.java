package busqueda;

import java.util.Date;
import java.util.List;
import java.util.Vector;

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
	public List<Prestamo> buscar(List<Prestamo> prestamos) {

	}
	
	
	
	
	
	
	
}

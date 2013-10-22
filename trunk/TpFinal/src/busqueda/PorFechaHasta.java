package busqueda;

import java.util.Date;

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
	

}

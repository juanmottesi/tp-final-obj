package busqueda;



import prestamos.Prestamo;

public class PorCuotas extends Condicion {
	
	private Integer desde;
	private Integer hasta;
	
	public Integer getDesde() {
		return desde;
	}
	
	public void setDesde(Integer desde) {
		this.desde = desde;
	}
	
	public Integer getHasta() {
		return hasta;
	}
	
	public void setHasta(Integer hasta) {
		this.hasta = hasta;
	}
	
	public PorCuotas(Integer desde, Integer hasta){
		
		this.setDesde(desde);
		this.setHasta(hasta);	
		
	}

	public boolean respetaCondicion(Prestamo p){	
			Integer n = p.cantidadDeCuotas();
			return (n>this.getDesde() && n<this.getHasta());
	}
	
	
	
	
	

	

}

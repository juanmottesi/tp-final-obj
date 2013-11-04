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
	
	/**
	 * @param desde 
	 * @param hasta 
	 */
	public PorCuotas(Integer desde, Integer hasta){
		this.setDesde(desde);
		this.setHasta(hasta);	
		
	}

	/**
	 * pregunta si ese prestamo respeta la condicion de cantidad de coutas,
	 * estas tienen que ser mayores y menores pero no iguales a ninguno de los
	 * dos variables.
	 * 
	 * @return boolean 
	 */
	public boolean respetaCondicion(Prestamo p){	
			Integer n = p.cantidadDeCuotas();
			return (n>this.getDesde() && n<this.getHasta());
	}
	
	
	
	
	

	

}

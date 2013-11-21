package busqueda;

import prestamos.Prestamo;

/**
 * La condicion de cantidad de cuotas, recibe dos Integer.
 * Estas tienen que ser mayores y menores pero no iguales a ninguno de los
 * dos variables.
 * 
 * @author Juan
 *
 */
public class PorCuotas extends Condicion {
	
	private Integer desde;
	private Integer hasta;
	
	private Integer getDesde() {
		return desde;
	}
	
	private void setDesde(Integer desde) {
		this.desde = desde;
	}
	
	private Integer getHasta() {
		return hasta;
	}
	
	private void setHasta(Integer hasta) {
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

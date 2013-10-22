package busqueda;

import java.util.List;
import java.util.Vector;

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

	@Override
	public List<Prestamo> buscar(List<Prestamo> prestamos) {
		List<Prestamo> ret = new Vector<Prestamo>();
		for(Prestamo p : prestamos){
			Integer n = p.cantidadDeCuotas();
			if(n>this.getDesde() && n<this.getHasta()){
				ret.add(p);
			}
		}
		return ret;
	}
	
	
	
	
	
	
	

}

package busqueda;

import java.util.List;
import java.util.Vector;

import prestamos.Prestamo;

public class PorMontoMinimo extends Condicion {
	
	private float  minimo;
	
	public float getMinimo() {
		return minimo;
	}
	
	public void setMinimo(float minimo) {
		this.minimo = minimo;
	}
	
	public PorMontoMinimo(float minimo){
		
		this.setMinimo(minimo);
		
	}

	@Override
	public List<Prestamo> buscar(List<Prestamo> prestamos) {
		
		List<Prestamo> ret = new Vector<Prestamo>();
		for(Prestamo p : prestamos){
			float montoAux = p.getMontoTotal();
			if(montoAux> this.getMinimo()){
				ret.add(p);
			}
		}
		return ret;
	}
	
	
	
	

}

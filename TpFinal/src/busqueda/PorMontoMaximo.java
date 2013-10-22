package busqueda;

import java.util.List;
import java.util.Vector;

import prestamos.Prestamo;

public class PorMontoMaximo extends Condicion{
	
	private float maximo;

	public float getMaximo() {
		return maximo;
	}

	public void setMaximo(float maximo) {
		this.maximo = maximo;
	}
	
	public PorMontoMaximo(float maximo){
		
		this.setMaximo(maximo);
		
	}

	@Override
	public List<Prestamo> buscar(List<Prestamo> prestamos) {
		
		List<Prestamo> ret = new Vector<Prestamo>();
		for(Prestamo p : prestamos){
			float montoAux = p.getMontoTotal();
			if(montoAux< this.getMaximo()){
				ret.add(p);
			}
		}
		return ret;
	}

}

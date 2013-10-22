package busqueda;


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
	public boolean respetaCondicion(Prestamo p){	
	
		float montoAux = p.getMontoTotal();
		return(montoAux> this.getMinimo());
	}
	
	
	
	

}

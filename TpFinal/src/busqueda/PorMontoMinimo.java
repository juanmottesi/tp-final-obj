package busqueda;


import prestamos.Prestamo;

public class PorMontoMinimo extends Condicion {
	
	private double  minimo;
	
	public double getMinimo() {
		return minimo;
	}
	
	public void setMinimo(double minimo) {
		this.minimo = minimo;
	}
	
	public PorMontoMinimo(double minimo){
		
		this.setMinimo(minimo);
		
	}

	@Override
	public boolean respetaCondicion(Prestamo p){	
	
		double montoAux = p.getMontoTotal();
		return(montoAux> this.getMinimo());
	}
	
	
	
	

}

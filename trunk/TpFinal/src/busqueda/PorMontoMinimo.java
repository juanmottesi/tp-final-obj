package busqueda;


import prestamos.Prestamo;

public class PorMontoMinimo extends Condicion {
	
	private double  minimo;
	
	private double getMinimo() {
		return minimo;
	}
	
	private void setMinimo(double minimo) {
		this.minimo = minimo;
	}
	
	public PorMontoMinimo(double minimo){
		
		this.setMinimo(minimo);
		
	}

	@Override
	/**
	 * respetaCondicion se fija que el monto del prestamo sea meyor estricto al
	 * del PorMontoMinimo.
	 * 
	 */
	public boolean respetaCondicion(Prestamo p){	
	
		double montoAux = p.getMontoTotal();
		return(montoAux> this.getMinimo());
	}
	
	
	
	

}

package busqueda;


import prestamos.Prestamo;
/**
 * Se fija que el monto del prestamo sea menor estricto al
 * del PorMontoMaximo.
 * 
 * @author Juan
 *
 */
public class PorMontoMaximo extends Condicion{
	
	private double maximo;

	private double getMaximo() {
		return maximo;
	}

	private void setMaximo(double maximo) {
		this.maximo = maximo;
	}
	
	public PorMontoMaximo(double maximo){
		this.setMaximo(maximo);
		
	}

	@Override
	/**
	 * respetaCondicion se fija que el monto del prestamo sea menor estricto al
	 * del PorMontoMaximo.
	 * 
	 * @return boolean 
	 */
	public boolean respetaCondicion(Prestamo p){	
			double montoAux = p.getMontoTotal();
			return (montoAux< this.getMaximo());
	}
	
	
}

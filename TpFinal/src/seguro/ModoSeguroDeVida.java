package seguro;

import prestamos.Prestamo;

/**
 * Modela los tipos de seguro de vida
 * 
 * @author Juan
 *
 */
public abstract class ModoSeguroDeVida {
	
	private double coeficiente;
	
	public double getCoeficiente() {
		return coeficiente;
	}

	public void setCoeficiente(double coeficiente) {
		this.coeficiente = coeficiente;
	}

	public abstract void calcularSeguro(Prestamo prestamo);
}

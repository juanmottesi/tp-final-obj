package seguro;

import prestamos.Cuota;
import prestamos.Prestamo;

/**
 * Es un modo de seguro de vida en el que el coeficiente es constante y es 0.
 * 
 * @author Juan
 *
 */
public class SinSeguroDeVida extends ModoSeguroDeVida {
	
	public SinSeguroDeVida(){
		this.setCoeficiente(0);
	}
	

	@Override
	public void calcularSeguro(Prestamo prestamo) {
		for(Cuota c : prestamo.getCuotas()){
			c.setSeguro(this.getCoeficiente());
		}
	}
	
	

}

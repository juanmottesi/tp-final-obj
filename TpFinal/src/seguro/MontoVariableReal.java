package seguro;

import prestamos.Cuota;
import prestamos.Prestamo;

/**
 * Es un modo de seguro de vida en el que multiplica el saldo deuda por el coeficiente
 * 
 * @author Juan
 *
 */
public class MontoVariableReal extends ModoSeguroDeVida {
	
	public MontoVariableReal(double coeficiente){
		this.setCoeficiente(coeficiente /100);		
	}

	@Override
	public void calcularSeguro(Prestamo prestamo) {
		for(Cuota c : prestamo.getCuotas()){
			c.setSeguro(this.getCoeficiente() * c.getSaldoDeuda());
		}
		
	}

}

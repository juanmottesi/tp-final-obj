package seguro;

import prestamos.Cuota;
import prestamos.Prestamo;

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

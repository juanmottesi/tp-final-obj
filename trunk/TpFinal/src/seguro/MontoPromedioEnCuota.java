package seguro;

import prestamos.Cuota;
import prestamos.Prestamo;

public class MontoPromedioEnCuota extends ModoSeguroDeVida {
	
	public MontoPromedioEnCuota(double coeficiente){
		this.setCoeficiente(coeficiente/100);
	}
	

	@Override
	public void calcularSeguro(Prestamo prestamo) {
		double auxiliar = this.sumaDeSeguroDeVida(prestamo) / prestamo.cantidadDeCuotas();
		for(Cuota c : prestamo.getCuotas()){
			c.setSeguro(auxiliar * this.getCoeficiente());
		}
		
	}

	public double sumaDeSeguroDeVida(Prestamo prestamo) {
		double ret = 0;
		for(Cuota c : prestamo.getCuotas()){
			ret+= c.getSaldoDeuda();
		}
		return ret;
	}

}

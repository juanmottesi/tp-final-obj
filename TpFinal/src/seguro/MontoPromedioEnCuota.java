package seguro;

import prestamos.Cuota;
import prestamos.Prestamo;

public class MontoPromedioEnCuota extends ModoSeguroDeVida {

	@Override
	public void calcularSeguro(Prestamo prestamo) {
		double auxiliar = this.sumaDeSeguroDeVida(prestamo) / prestamo.cantidadDeCuotas();
		for(Cuota c : prestamo.getCuotas()){
			c.setSeguro(auxiliar);
		}
		
	}

	private double sumaDeSeguroDeVida(Prestamo prestamo) {
		double ret = 0;
		for(Cuota c : prestamo.getCuotas()){
			ret+= c.getSaldoDeuda();
		}
		return ret;
	}

}

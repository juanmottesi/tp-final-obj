package gastos;

import prestamos.Cuota;
import prestamos.Prestamo;
/**
 * Modela un gasto mensual con un tipo de gasto que puede ser fijo o porcentual
 * 
 * @author Juan
 *
 */
public class GastoMensual extends Gasto {

	public GastoMensual(TipoDeGasto tipoDeGasto){
		this.setTipoDeGasto(tipoDeGasto);
	
	}

	@Override
	public void calcularGasto(Prestamo prestamo) {
		for(Cuota c : prestamo.getCuotas()){
			double aux = c.getGastoTotal();
			c.actualizarGastoTotal(aux + (this.getTipoDeGasto().calcularGasto(c.getMontoCuota())));
			
		}
	}
	


}

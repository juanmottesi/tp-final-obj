package gastos;

import prestamos.Cuota;
import prestamos.Prestamo;

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

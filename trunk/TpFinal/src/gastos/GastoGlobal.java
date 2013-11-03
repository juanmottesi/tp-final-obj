package gastos;

import prestamos.Prestamo;

public class GastoGlobal extends Gasto {
	
	public GastoGlobal(TipoDeGasto tipoDeGasto){
		this.setTipoDeGasto(tipoDeGasto);
	}

	@Override
	public void calcularGasto(Prestamo prestamo) {
		prestamo.setMontoTotal(prestamo.getMontoTotal() - this.getTipoDeGasto().calcularGasto(prestamo.getMontoTotal()));
	}



	
	
	
	

}

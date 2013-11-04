package gastos;

import prestamos.Prestamo;

public class GastoGlobal extends Gasto {
	
	public GastoGlobal(TipoDeGasto tipoDeGasto){
		this.setTipoDeGasto(tipoDeGasto);
	}


	@Override
	public void calcularGasto(Prestamo prestamo){
		double aux = prestamo.getMontoTotal();
		prestamo.actualizarGastos(aux - (this.getTipoDeGasto().calcularGasto(aux)));
	}


	
	
	
	

}

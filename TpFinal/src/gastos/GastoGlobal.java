package gastos;

import prestamos.Prestamo;
/**
 * Modela un gasto global con un tipo de gasto que puede ser fijo o porcentual
 * 
 * @author Juan
 *
 */
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

package gastos;
/**
 * Modela un tipo de gasto Fijo con un monto
 * 
 * @author Juan
 *
 */
public class Fijo extends TipoDeGasto {

	public Fijo(double monto){
		this.setMonto(monto);
	}
	
	@Override
	/**
	 * CalcularGasto es un metodo que retorna el valor que tiene guardado
	 * en su variable privada.
	 * El paramatro montoAAplicarGastos no se usa.
	 */
	public double calcularGasto(double montoAAplicarGastos) {
		return this.getMonto();		
	}
		
}

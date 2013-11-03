package gastos;

public class Fijo extends TipoDeGasto {

	public Fijo(double monto){
		this.setMonto(monto);
	}

	@Override
	public double calcularGasto(double montoAAplicarGastos) {
		
		return this.getMonto();
		
	}
	
	
}

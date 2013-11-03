package gastos;

public abstract class TipoDeGasto {

	private double monto;
	
	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}
	
	public abstract double calcularGasto(double montoAAplicarGastos);


	
}

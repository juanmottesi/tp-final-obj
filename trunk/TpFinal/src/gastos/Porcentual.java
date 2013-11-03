package gastos;

public class Porcentual extends TipoDeGasto {
	
	public Porcentual(double monto){
		this.setMonto(monto /100);
	}

	@Override
	public double calcularGasto(double montoAAplicarGastos) {
		
		return montoAAplicarGastos * this.getMonto();
	}
	

}

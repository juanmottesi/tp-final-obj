package gastos;

public abstract class Gasto {
	
	private float monto;
	private TipoDeGasto tipoDeGasto;
	
	public float getMonto() {
		return monto;
	}

	public void setMonto(float monto) {
		this.monto = monto;
	}

	public TipoDeGasto getTipoDeGasto() {
		return tipoDeGasto;
	}

	public void setTipoDeGasto(TipoDeGasto tipoDeGasto) {
		this.tipoDeGasto = tipoDeGasto;
	}

	public abstract float calcularGasto();
	
	
}

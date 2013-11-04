package gastos;

import prestamos.Prestamo;

public abstract class Gasto {
	
	private TipoDeGasto tipoDeGasto;
	
	public TipoDeGasto getTipoDeGasto() {
		return tipoDeGasto;
	}

	public void setTipoDeGasto(TipoDeGasto tipoDeGasto) {
		this.tipoDeGasto = tipoDeGasto;
	}

	public abstract void calcularGasto(Prestamo prestamo);
	

	
	
}

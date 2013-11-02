package cuotaEstados;

import prestamos.Cuota;

public abstract class EstadoCuota {
	public abstract boolean estaPaga();
	public abstract void pagar(Cuota cuota);
	public abstract void aVencido(Cuota cuota);
}

package cuotaEstados;

import exceptions.EstadoCuotaException;
import prestamos.Cuota;

public abstract class EstadoCuota {
	public abstract boolean estaPaga();
	public abstract void pagar(Cuota cuota) throws EstadoCuotaException;
	public abstract void aVencido(Cuota cuota)throws EstadoCuotaException;
}

package cuotaEstados;

import prestamos.Cuota;

public class Vencida extends EstadoCuota{

	@Override
	public boolean estaPaga() {
		return false;
	}

	@Override
	public void pagar(Cuota cuota) {
		cuota.setEstadoCuota(new Pagada());
	}

	@Override
	public void aVencido(Cuota cuota) {
	}
	


}

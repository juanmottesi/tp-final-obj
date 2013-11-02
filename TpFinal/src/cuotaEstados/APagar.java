package cuotaEstados;

import prestamos.Cuota;

public class APagar extends EstadoCuota{

	@Override
	public boolean estaPaga() {
		return false;
	}

	@Override
	public void pagar(Cuota cuota) {
		cuota.setEstadoCuota(new Pagada());
	}

	public void aVencido(Cuota cuota){
		cuota.setEstadoCuota(new Vencida());
		
	}
}

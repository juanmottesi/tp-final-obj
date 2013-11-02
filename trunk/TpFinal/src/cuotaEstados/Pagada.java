package cuotaEstados;

import prestamos.Cuota;

public class Pagada extends EstadoCuota{

	@Override
	public boolean estaPaga() {
		return true;
	}

	@Override
	public void pagar(Cuota cuota) {
		// ACA HAY QUE HACER UNA EXCEPCION !!!!!!!!!!!!!!!!!!!!!!!!!!!!
	}

	@Override
	public void aVencido(Cuota cuota) {
		// ACA HAY QUE HACER UNA EXCEPCION !!!!!!!!!!!!!!!!!!!!!!!!!!!!
		
	}

	
}

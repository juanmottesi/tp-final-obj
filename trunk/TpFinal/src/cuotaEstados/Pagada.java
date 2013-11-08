package cuotaEstados;

import exceptions.PagadaException;
import prestamos.Cuota;

public class Pagada extends EstadoCuota{

	@Override
	public boolean estaPaga() {
		return true;
	}

	@Override
	public void pagar(Cuota cuota) throws PagadaException{
		throw new PagadaException("Usted ya realizo el pago de esta cuota");
	}

	@Override
	public void aVencido(Cuota cuota) throws PagadaException {
		throw new PagadaException("La cuota no puede pasar a vencido");
	}

	
}

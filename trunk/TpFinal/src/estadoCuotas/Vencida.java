package estadoCuotas;

import prestamos.Cuota;
/**
 * Modela una cuota que esta vencida
 * 
 * @author Juan
 *
 */
public class Vencida extends EstadoCuota{
	
	public Vencida(){
		super();
	}

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
		cuota.setEstadoCuota(this);
	}
	


}

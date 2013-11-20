package estadoCuotas;

import prestamos.Cuota;
/**
 * Modela una cuota que no esta vencida ni pagada
 * 
 * @author Juan
 *
 */
public class APagar extends EstadoCuota{
	
	public APagar(){
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
	public void aVencido(Cuota cuota){
		cuota.setEstadoCuota(new Vencida());
		
	}
	
}

package estadoCuotas;

import exceptions.EstadoCuotaException;
import prestamos.Cuota;

public abstract class EstadoCuota {
	public abstract boolean estaPaga();
	public abstract void pagar(Cuota cuota) throws EstadoCuotaException;
	public abstract void aVencido(Cuota cuota)throws EstadoCuotaException;
	
	public boolean equals(EstadoCuota estadoCuota){
		if(estadoCuota == null){
			return false;
		}
		if(this == estadoCuota){
			return true;
		}	
		if(this.getClass() != estadoCuota.getClass()){
			return false;
		}
		
		return true;
	}
	
}

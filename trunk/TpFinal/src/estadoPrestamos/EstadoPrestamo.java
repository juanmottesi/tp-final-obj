package estadoPrestamos;

import exceptions.AprobadoException;
import exceptions.DeudorIncobrableException;
import exceptions.FinalizadoException;
import exceptions.RechazadoException;
import prestamos.Prestamo;

public abstract class EstadoPrestamo {
	
	public abstract void aprobar(Prestamo p) throws AprobadoException;
	
	public abstract void rechazar(Prestamo p) throws RechazadoException;
	
	public abstract void finalizar(Prestamo p) throws FinalizadoException ;
	
	public abstract void aDeudorIncobrable(Prestamo p) throws DeudorIncobrableException;
	
	
	public boolean equals(EstadoPrestamo estadoPrestamo){
		if(estadoPrestamo == null){
			return false;
		}
		if(this == estadoPrestamo){
			return true;
		}	
		if(this.getClass() != estadoPrestamo.getClass()){
			return false;
		}
		
		return true;
	}
}
	
	
	

    

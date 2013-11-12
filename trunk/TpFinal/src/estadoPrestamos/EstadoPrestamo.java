package estadoPrestamos;

import exceptions.AprobadoException;
import exceptions.DeudorIncobrableException;
import exceptions.EnCursoException;
import exceptions.EnDeudaException;
import exceptions.FinalizadoException;
import exceptions.RechazadoException;
import prestamos.Prestamo;

public abstract class EstadoPrestamo {
	
	public abstract void aprobar(Prestamo p) throws AprobadoException;
	
	public abstract void rechazar(Prestamo p) throws RechazadoException;
	
	public abstract void finalizar(Prestamo p) throws FinalizadoException ;
	
	public abstract void aDeudorIncobrable(Prestamo p) throws DeudorIncobrableException;
	
	public abstract void aEnDeuda(Prestamo p) throws EnDeudaException; 
	
	public abstract boolean puedoPagar(Prestamo p);
	
	public abstract void aEnCurso(Prestamo p) throws EnCursoException;

	@Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
       return true;
	}	
	
}
	
	
	

    

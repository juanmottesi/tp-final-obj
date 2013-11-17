package estadoCliente;

import exceptions.EstadoClienteException;

public abstract class Estado {

	public abstract boolean puedoAgregarPrestamo();
	
	public abstract void aEnDeuda(EstadoCliente estadoCliente)throws EstadoClienteException;
	
	public abstract void aEnDeudorIncobrable(EstadoCliente estadoCliente)throws EstadoClienteException;
	
	public abstract void aEnCurso(EstadoCliente estadoCliente)throws EstadoClienteException;
	
	public abstract void finalizar(EstadoCliente estadoCliente)throws EstadoClienteException;
	
	public abstract void solicitar(EstadoCliente estadoCliente)throws EstadoClienteException;

	public abstract void rechazar(EstadoCliente estadoCliente)throws EstadoClienteException;
	
	public abstract void aSinPrestamo(EstadoCliente estadoCliente)throws EstadoClienteException;

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

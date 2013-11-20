package estadoCliente;

import exceptions.EstadoClienteException;
/**
 * Modela si el cliente es un Deudor Incobrable
 * 
 * @author Juan
 *
 */
public class DeudorIncobrable extends Estado{
	
	public DeudorIncobrable(){
		super();
	}
	
	@Override
	public boolean puedoAgregarPrestamo() {
		return false;
	}

	@Override
	public void aEnDeuda(EstadoCliente estadoCliente) throws EstadoClienteException {
		throw new EstadoClienteException("Usted esta en DeudorIncobrable");
	}

	@Override
	public void aEnDeudorIncobrable(EstadoCliente estadoCliente) {
		estadoCliente.cambiarEstadoA(this);
	}

	@Override
	public void aEnCurso(EstadoCliente estadoCliente)  throws EstadoClienteException {
		throw new EstadoClienteException("Usted esta en DeudorIncobrable");
	}

	@Override
	public void finalizar(EstadoCliente estadoCliente)  throws EstadoClienteException {
		throw new EstadoClienteException("Usted esta en DeudorIncobrable");
	}
	
	@Override
	public void solicitar(EstadoCliente estadoCliente)  throws EstadoClienteException {
		throw new EstadoClienteException("Usted esta en DeudorIncobrable");
	}
	
	@Override
	public void rechazar(EstadoCliente estadoCliente)  throws EstadoClienteException {
		throw new EstadoClienteException("Usted esta en DeudorIncobrable");
	}
	
	@Override
	public void aSinPrestamo(EstadoCliente estadoCliente)  throws EstadoClienteException {
		throw new EstadoClienteException("Usted esta en DeudorIncobrable");
	}

}

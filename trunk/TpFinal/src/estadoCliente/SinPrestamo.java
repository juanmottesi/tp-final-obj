package estadoCliente;

import exceptions.EstadoClienteException;
/**
 *  Modela a un cliente sin prestamos
 * 
 * @author Juan
 *
 */
public class SinPrestamo extends Estado{

	@Override
	public boolean puedoAgregarPrestamo() {
		return true;
	}

	@Override
	public void aEnDeuda(EstadoCliente estadoCliente) throws EstadoClienteException {
		throw new EstadoClienteException("Usted no tiene prestamos");		
	}

	@Override
	public void aEnDeudorIncobrable(EstadoCliente estadoCliente) throws EstadoClienteException {
		throw new EstadoClienteException("Usted no tiene prestamos");		
	}

	@Override
	public void aEnCurso(EstadoCliente estadoCliente) throws EstadoClienteException {
		throw new EstadoClienteException("Usted no tiene prestamos");		
	}

	@Override
	public void finalizar(EstadoCliente estadoCliente) throws EstadoClienteException {
		throw new EstadoClienteException("Usted no tiene prestamos");		
	}

	@Override
	public void solicitar(EstadoCliente estadoCliente) {
		estadoCliente.cambiarEstadoA(new Solicitado());
	}

	@Override
	public void rechazar(EstadoCliente estadoCliente) throws EstadoClienteException {
		throw new EstadoClienteException("Usted no tiene prestamos");		
	}

	@Override
	public void aSinPrestamo(EstadoCliente estadoCliente) {
		estadoCliente.cambiarEstadoA(this);
	}

}

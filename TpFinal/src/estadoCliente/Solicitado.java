package estadoCliente;

import exceptions.EstadoClienteException;

public class Solicitado extends Estado{
	
	public Solicitado(){
		super();
	}

	@Override
	public boolean puedoAgregarPrestamo() {
		return false;
	}

	@Override
	public void aEnDeuda(EstadoCliente estadoCliente) throws EstadoClienteException {
		throw new EstadoClienteException("Usted esta en Solicitado");
	}

	@Override
	public void aEnDeudorIncobrable(EstadoCliente estadoCliente)throws EstadoClienteException {
		throw new EstadoClienteException("Usted esta en Solicitado");
	}

	@Override
	public void aEnCurso(EstadoCliente estadoCliente) {
		estadoCliente.cambiarEstadoA(new EnCurso());
	}

	@Override
	public void finalizar(EstadoCliente estadoCliente) throws EstadoClienteException {
		throw new EstadoClienteException("Usted esta en Solicitado");
	}

	@Override
	public void solicitar(EstadoCliente estadoCliente) {
		estadoCliente.cambiarEstadoA(new Solicitado());
	}

	@Override
	public void rechazar(EstadoCliente estadoCliente) {
		estadoCliente.cambiarEstadoA(new EnCurso());
	}

	@Override
	public void aSinPrestamo(EstadoCliente estadoCliente) {
		estadoCliente.cambiarEstadoA(new SinPrestamo());	
	}

}

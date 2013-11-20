package estadoCliente;

import exceptions.EstadoClienteException;
/**
 *  Modela si el cliente tiene algun prestamo vencido
 * 
 * @author Juan
 *
 */
public class EnDeuda extends Estado{

	public EnDeuda(){
		super();
	}
	
	@Override
	public boolean puedoAgregarPrestamo() {
		return false;
	}

	@Override
	public void aEnDeuda(EstadoCliente estadoCliente) {
		estadoCliente.cambiarEstadoA(new EnDeuda());		
	}

	@Override
	public void aEnDeudorIncobrable(EstadoCliente estadoCliente) {
		estadoCliente.cambiarEstadoA(new DeudorIncobrable());
	}

	@Override
	public void aEnCurso(EstadoCliente estadoCliente) {
		estadoCliente.cambiarEstadoA(new EnCurso());
	}

	@Override
	public void finalizar(EstadoCliente estadoCliente) {
		estadoCliente.seFinalizoUnPrestamo(this);
	}

	@Override
	public void solicitar(EstadoCliente estadoCliente) throws EstadoClienteException {
		throw new EstadoClienteException("Usted esta en Deuda");		
	}

	@Override
	public void rechazar(EstadoCliente estadoCliente) throws EstadoClienteException {
		throw new EstadoClienteException("Usted esta en Deuda");		
	}

	@Override
	public void aSinPrestamo(EstadoCliente estadoCliente) throws EstadoClienteException {
		throw new EstadoClienteException("Usted esta en Deuda");		
	}

}

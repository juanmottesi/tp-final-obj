package estadoCliente;

import exceptions.EstadoClienteException;
/**
 *  Modela si el cliente tiene sus prestamos al dia
 * 
 * @author Juan
 *
 */
public class EnCurso extends Estado{

	public EnCurso(){
		super();
	}
	
	@Override
	public boolean puedoAgregarPrestamo() {
		return true;
	}

	@Override
	public void aEnDeuda(EstadoCliente estadoCliente) {
		estadoCliente.cambiarEstadoA(new EnDeuda());
	}

	@Override
	public void aEnDeudorIncobrable(EstadoCliente estadoCliente) throws EstadoClienteException {
		throw new EstadoClienteException("Usted esta en Curso");		
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
		throw new EstadoClienteException("Usted esta en Curso");		
	}

	@Override
	public void rechazar(EstadoCliente estadoCliente) throws EstadoClienteException {
		throw new EstadoClienteException("Usted esta en Curso");		
	}
	
	@Override
	public void aSinPrestamo(EstadoCliente estadoCliente) throws EstadoClienteException {
		throw new EstadoClienteException("Usted esta en Curso");		
	}

}

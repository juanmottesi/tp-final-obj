package estadoCliente;

import cliente.Cliente;

public class DeudorIncobrable extends EstadoCliente {
	
	public DeudorIncobrable(int cantidadPrestamos){
		this.setCantidadPrestamos(cantidadPrestamos);
	}
	
	@Override
	public boolean puedoAgregarPrestamo() {
		return false;
	}

	@Override
	public void aEnDeuda(Cliente cliente) {
		throw new EstadoClienteExeption("Usted esta en DeudorIncobrable");
	}

	@Override
	public void aEnDeudorIncobrable(Cliente cliente) {
		cliente.cambiarEstadoA(new DeudorIncobrable(this.getCantidadPrestamos()));
	}

	@Override
	public void aEnCurso(Cliente cliente) {
		throw new EstadoClienteExeption("Usted esta en DeudorIncobrable");
	}

	@Override
	public void finalizar(Cliente cliente) {
		throw new EstadoClienteExeption("Usted esta en DeudorIncobrable");
	}

	@Override
	public void solicitar(Cliente cliente) {
		throw new EstadoClienteExeption("Usted esta en DeudorIncobrable");
	}

	@Override
	public void rechazar(Cliente cliente) {
		throw new EstadoClienteExeption("Usted esta en DeudorIncobrable");
	}

	@Override
	public void aSinPrestamo(Cliente cliente) {
		throw new EstadoClienteExeption("Usted esta en DeudorIncobrable");
	}

	@Override
	public EstadoCliente verificarEstadoCliente(Cliente cliente) {
		throw new EstadoClienteExeption("Usted esta en DeudorIncobrable");
	}

}

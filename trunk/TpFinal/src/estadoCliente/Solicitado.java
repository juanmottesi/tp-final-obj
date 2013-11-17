package estadoCliente;

import cliente.Cliente;

public class Solicitado extends EstadoCliente {
	
	public Solicitado(int cantidadPrestamo){
		this.setCantidadPrestamos(cantidadPrestamo+1);
	}

	@Override
	public boolean puedoAgregarPrestamo() {
		return false;
	}

	@Override
	public void aEnDeuda(Cliente cliente) {
		throw new EstadoClienteExeption("Usted esta en Solicitado");
	}

	@Override
	public void aEnDeudorIncobrable(Cliente cliente) {
		throw new EstadoClienteExeption("Usted esta en Solicitado");
	}

	@Override
	public void aEnCurso(Cliente cliente) {
		cliente.cambiarEstadoA(new EnCurso());
	}

	@Override
	public void finalizar(Cliente cliente) {
		throw new EstadoClienteExeption("Usted esta en Solicitado");
	}

	@Override
	public void solicitar(Cliente cliente) {
		cliente.cambiarEstadoA(new Solicitado(this.getCantidadPrestamos()-1));
	}

	@Override
	public void rechazar(Cliente cliente) {
		if(this.getCantidadPrestamos() == 1){
			this.aSinPrestamo(cliente);
		}
		else{
			cliente.cambiarEstadoA(this.verificarEstadoCliente(cliente));
		}
	}

	@Override
	public void aSinPrestamo(Cliente cliente) {
		cliente.cambiarEstadoA(new SinPrestamo());	
	}

	@Override
	public EstadoCliente verificarEstadoCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		return null;
	}

}

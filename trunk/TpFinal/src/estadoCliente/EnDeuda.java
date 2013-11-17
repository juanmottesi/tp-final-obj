package estadoCliente;

import cliente.Cliente;

public class EnDeuda extends EstadoCliente {

	public EnDeuda(int cantidadPrestamos){
		this.setCantidadPrestamos(cantidadPrestamos);
	}
	
	@Override
	public boolean puedoAgregarPrestamo() {
		return false;
	}

	@Override
	public void aEnDeuda(Cliente cliente) {
		cliente.cambiarEstadoA(new EnDeuda(this.getCantidadPrestamos()));		
	}

	@Override
	public void aEnDeudorIncobrable(Cliente cliente) {
		cliente.cambiarEstadoA(new DeudorIncobrable(this.getCantidadPrestamos()));
		
	}

	@Override
	public void aEnCurso(Cliente cliente) {
		cliente.cambiarEstadoA(new EnCurso(this.getCantidadPrestamos()-1));
		
	}

	@Override
	public void finalizar(Cliente cliente) {
		if(this.getCantidadPrestamos() == 1){
			this.aSinPrestamo(cliente);
		}
		else{
			cliente.cambiarEstadoA(this.verificarEstadoCliente(cliente));
		}
	}

	@Override
	public void solicitar(Cliente cliente) {
		throw new EstadoClienteExeption("Usted esta en Deuda");		
	}

	@Override
	public void rechazar(Cliente cliente) {
		throw new EstadoClienteExeption("Usted esta en Deuda");		
	}

	@Override
	public void aSinPrestamo(Cliente cliente) {
		throw new EstadoClienteExeption("Usted esta en Deuda");
	}

	@Override
	public EstadoCliente verificarEstadoCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		return null;
	}

}

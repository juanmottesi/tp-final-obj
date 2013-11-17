package estadoCliente;

import java.util.List;

import cliente.Cliente;

public class EnCurso extends EstadoCliente {

	public EnCurso(int cantidadPrestamos){
		this.setCantidadPrestamos(cantidadPrestamos+1);
	}
	
	@Override
	public boolean puedoAgregarPrestamo() {
		return true;
	}

	@Override
	public void aEnDeuda(Cliente cliente) {
		cliente.cambiarEstadoA(new EnDeuda(this.getCantidadPrestamos()));
	}

	@Override
	public void aEnDeudorIncobrable(Cliente cliente) {
		throw new EstadoClienteExeption("Usted esta en Curso");		
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
		throw new EstadoClienteExeption("Usted esta en Curso");
	}

	@Override
	public void rechazar(Cliente cliente) {
		throw new EstadoClienteExeption("Usted esta en Curso");
	}

	@Override
	public void aSinPrestamo(Cliente cliente) {
		throw new EstadoClienteExeption("Usted esta en Solicitado");
	}

	@Override
	public EstadoCliente verificarEstadoCliente(Cliente cliente) {
		List<EstadoCliente> estados = cliente.obtenerEstadoCliente();
		for(EstadoCliente estadoCliente : estados){
			
		}
		
		
	}

}

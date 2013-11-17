package estadoCliente;



import java.util.Observable;
import java.util.Observer;

import cliente.Cliente;

public abstract class EstadoCliente extends Observable implements Observer {

	private int cantidadPrestamos;

	public int getCantidadPrestamos() {
		return cantidadPrestamos;
	}

	public void setCantidadPrestamos(int cantidadPrestamos) {
		this.cantidadPrestamos = cantidadPrestamos;
	}
	
	public abstract boolean puedoAgregarPrestamo();
	
	public abstract void aEnDeuda(Cliente cliente);
	
	public abstract void aEnDeudorIncobrable(Cliente cliente);
	
	public abstract void aEnCurso(Cliente cliente);
	
	public abstract void finalizar(Cliente cliente);
	
	public abstract void solicitar(Cliente cliente);
	
	public abstract void rechazar(Cliente cliente);
	
	public abstract void aSinPrestamo(Cliente cliente);
	
	
}

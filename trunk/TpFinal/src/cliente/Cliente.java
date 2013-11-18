package cliente;


import java.util.Observable;
import java.util.Observer;

import estadoCliente.EstadoCliente;
import exceptions.EstadoClienteException;
import prestamos.Prestamo;

public abstract class Cliente implements Observer {
	
	private EstadoCliente estadoCliente;
	
	public EstadoCliente getEstadoCliente() {
		return estadoCliente;
	}

	public void setEstadoCliente(EstadoCliente estadoCliente) {
		this.estadoCliente = estadoCliente;
	}
	
	public boolean puedoAgregarPrestamo(){
		return this.getEstadoCliente().puedoAgregarPrestamo();
	}
	
	public abstract void agregarPrestamo(Prestamo prestamo);

	@Override
	public void update(Observable o, Object arg){
		System.out.println("Usted se encuentr en dueda");
	}
	
	public abstract void suscribirAlSistemaDeAviso();
	
	public abstract void salirSistemaDeAviso();
	
	public abstract String obtenerDNI();
	
	public abstract String obtenerApellido();
	
	public abstract String obtenerDireccion();

	public abstract void agregarObservadores(EstadoCliente ec);
	
	public abstract void finalizar()throws EstadoClienteException ;
	
	public abstract void aEnDeuda()throws EstadoClienteException ;
	
	public abstract void aEnCurso()throws EstadoClienteException ;
	
	public abstract void rechazar()throws EstadoClienteException ;
}


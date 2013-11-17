package cliente;


import java.util.Observable;
import java.util.Observer;

import estadoCliente.EstadoCliente;
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
		System.out.println("Su esteado cambio a deudor");
	}
	
	public abstract void suscribirAlSistemaDeAviso();
	
	public abstract void salirSistemaDeAviso();
	
	public abstract String obtenerDNI();
	
	public abstract String obtenerApellido();
	
	public abstract String obtenerDireccion();

}

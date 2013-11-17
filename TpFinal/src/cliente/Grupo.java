package cliente;

import java.util.List;


import estadoCliente.EstadoCliente;
import prestamos.Prestamo;

public class Grupo extends Cliente {

	private List<Cliente> clientes;
	private Persona personaResponsable;
	
	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public Persona getPersonaResponsable() {
		return personaResponsable;
	}

	public void setPersonaResponsable(Persona personaResponsable) {
		this.personaResponsable = personaResponsable;
	}
	
	public Grupo(Persona personaResponsable, List<Cliente>clientes){
		this.setClientes(clientes);
		this.setPersonaResponsable(personaResponsable);
		this.setEstadoCliente(new EstadoCliente());
		this.agregarObservadores(this.getEstadoCliente());
		
	}
	
	public void agregarObservadores(EstadoCliente ec){
		ec.addObserver(this.getPersonaResponsable());
		for(Cliente c : this.getClientes()){
			c.agregarObservadores(ec);
		}
	}
	
	
	@Override
	public void agregarPrestamo(Prestamo prestamo) {
		if(this.puedoAgregarPrestamo()){
			this.getPersonaResponsable().agregarPrestamo(prestamo);
			for(Cliente c : this.getClientes()){
				c.agregarPrestamo(prestamo);
			}
		}		
	}

	@Override
	public void suscribirAlSistemaDeAviso() {
		this.getPersonaResponsable().suscribirAlSistemaDeAviso();		
	}

	@Override
	public void salirSistemaDeAviso() {
		this.getPersonaResponsable().salirSistemaDeAviso();		
	}

	@Override
	public String obtenerDNI() {
		return this.getPersonaResponsable().obtenerDNI();
	}

	@Override
	public String obtenerApellido() {
		return this.getPersonaResponsable().obtenerApellido();
	}

	@Override
	public String obtenerDireccion() {
		return this.getPersonaResponsable().obtenerDireccion();
	}


}

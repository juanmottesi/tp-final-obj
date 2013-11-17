package cliente;

import java.util.List;
import java.util.Observable;

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
	
	@Override
	public boolean puedoAgregarPrestamo() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void agregarPrestamo(Prestamo prestamo) {
		if(this.puedoAgregarPrestamo()){
			for(Cliente c : this.getClientes()){
				c.agregarPrestamo(prestamo);
			}
		}		
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void suscribirAlSistemaDeAviso(Prestamo prestamo) {
		this.getPersonaResponsable().suscribirAlSistemaDeAviso(prestamo);		
	}

	@Override
	public void salirSistemaDeAviso(Prestamo prestamo) {
		this.getPersonaResponsable().salirSistemaDeAviso(prestamo);		
	}

	@Override
	public String obtenerDNI() {
		return this.getPersonaResponsable().obtenerDNI();
	}

	@Override
	public String obtenerApellido() {
		return this.getPersonaResponsable().obtenerApellido();
	}


	
	
	
}

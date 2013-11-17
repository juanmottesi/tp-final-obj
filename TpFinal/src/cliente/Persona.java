package cliente;

import java.util.List;


import java.util.Vector;




import estadoCliente.EstadoCliente;
import exceptions.EstadoClienteException;
import prestamos.Prestamo;

public class Persona extends Cliente {
	
	private String apellido;
	private String dni;
	private String direccion;
	private String nombre;
	private List<Prestamo> prestamos;
	
	
	public List<Prestamo> getPrestamos() {
		return prestamos;
	}

	public void setPrestamos(List<Prestamo> prestamos) {
		this.prestamos = prestamos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}
	
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public String getDni() {
		return dni;
	}
	
	public void setDni(String dni) {
		this.dni = dni;
	}
	
	public String getDireccion() {
		return direccion;
	}
	
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Persona(String nombre, String apellido, String dni, String direccion){
		this.setNombre(nombre);
		this.setApellido(apellido);
		this.setDni(dni);
		this.setDireccion(direccion);
		this.setEstadoCliente(new EstadoCliente());
		this.setPrestamos(new Vector<Prestamo>());
	}
	
	@Override
	public void agregarPrestamo(Prestamo prestamo) {
		if(this.puedoAgregarPrestamo()){
			try {
				this.agregarPrestamoEstadoCliente();
				this.getPrestamos().add(prestamo);
				prestamo.addObserver(this.getEstadoCliente());
			} catch (EstadoClienteException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	private void agregarPrestamoEstadoCliente() throws EstadoClienteException{
		this.getEstadoCliente().solicitar();
	}
	
	@Override
	public void suscribirAlSistemaDeAviso() {
		this.getEstadoCliente().addObserver(this);
		
	}

	@Override
	public void salirSistemaDeAviso() {
		this.getEstadoCliente().deleteObserver(this);		
	}

	@Override
	public String obtenerDNI() {
		return this.getDni();
	}

	@Override
	public String obtenerApellido() {
		return this.getApellido();
	}

	@Override
	public String obtenerDireccion() {
		return this.getDireccion();
	}

	
}

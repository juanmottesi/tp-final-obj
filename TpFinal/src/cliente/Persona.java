package cliente;

import java.util.List;
import java.util.Observable;

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

	@Override
	public boolean puedoAgregarPrestamo() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void agregarPrestamo(Prestamo prestamo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void suscribirAlSistemaDeAviso(Prestamo prestamo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void salirSistemaDeAviso(Prestamo prestamo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String obtenerDNI() {
		return this.getDni();
	}

	@Override
	public String obtenerApellido() {
		return this.getApellido();
	}

	
	
}

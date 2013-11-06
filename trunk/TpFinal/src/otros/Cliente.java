package otros;

import java.util.List;
import java.util.Vector;

import estadoPrestamos.DeudorIncobrable;
import estadoPrestamos.EnDeuda;
import estadoPrestamos.Solicitado;
import prestamos.Prestamo;

public class Cliente {
	
	private String apellido;
	private Integer dni;
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
	
	public Integer getDni() {
		return dni;
	}
	
	public void setDni(Integer dni) {
		this.dni = dni;
	}
	
	public String getDireccion() {
		return direccion;
	}
	
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public Cliente(String apellido, String nombre, String direccion, Integer documento){
		this.setApellido(apellido);
		this.setNombre(nombre);
		this.setDireccion(direccion);
		this.setDni(documento);	
		this.setPrestamos(new Vector<Prestamo>());
	}
	
	public boolean puedoAgregarPrestamo()throws AgregarPrestamoAClienteException{
		int contarPrestamos = 0;
		for(Prestamo p : this.getPrestamos()){
			if(contarPrestamos == 2){
				if(p.getEstado().equals(new Solicitado()) || p.getEstado().equals(new EnDeuda()) ){
					contarPrestamos+=1;
				}
				if(p.getEstado().equals(new DeudorIncobrable())) throw new AgregarPrestamoAClienteException{
					return false;
				}
			}
			else{
				return false;
			}
		
		}
		return true;
	}
	
	public void agregarPrestamo(Prestamo prestamo){
		try{
			if(this.puedoAgregarPrestamo()){
				this.getPrestamos().add(prestamo);
			}
			
		}
		catch(AgregarPrestamoAClienteException e){
			System.out.println(e);
		}
	}
}

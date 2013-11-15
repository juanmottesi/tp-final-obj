package busqueda;

import prestamos.Prestamo;

/**
 * La condicion por dni recibe un dni y solo devuelve los prestamos con el mismo dni
 * 
 * @author Juan
 *
 */
public class PorDNI extends Condicion {
	
	private String dni;

	private String getDni() {
		return dni;
	}

	private void setDni(String dni) {
		this.dni = dni;
	}
	
	public PorDNI(String dni){
		this.setDni(dni);
	}
	
	@Override
	/**
	 * respetaCondicion se fija que el dni del prestamo sea igual al que se encuentra
	 * en su variable.
	 * 
	 * @return boolean 
	 */
	public boolean respetaCondicion(Prestamo p){
			return (p.obtenerDniCliente().equals(this.getDni()));
			
	}

	
	

}

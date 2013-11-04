package busqueda;

import prestamos.Prestamo;


public class PorDNI extends Condicion {
	
	private Integer dni;

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}
	
	public PorDNI(Integer dni){
		
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
			return (p.obtenerDniCliente() == this.getDni());
			
	}

	
	

}

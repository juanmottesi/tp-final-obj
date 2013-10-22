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
	public boolean respetaCondicion(Prestamo p){
			return (p.getCliente().getDni() == this.getDni());
			
	}

	
	

}

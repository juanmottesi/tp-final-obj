package busqueda;

import prestamos.Prestamo;


public class PorApellido extends Condicion {

	private String apellido;
	
	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public PorApellido(String apellido){
		this.setApellido(apellido);
		
	}

	@Override
	public boolean respetaCondicion(Prestamo p){
		return (p.getCliente().getApellido() == this.getApellido());
	}
	
	
}

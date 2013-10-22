package busqueda;

import java.util.List;
import java.util.Vector;

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
	public List<Prestamo> buscar(List<Prestamo> prestamos) {
		List<Prestamo> ret = new Vector<Prestamo>();
		for(Prestamo p : prestamos){
			if(p.getCliente().getApellido() == this.getApellido()){
				ret.add(p);
			}
			
		}
		return ret;
	}
	
	
}

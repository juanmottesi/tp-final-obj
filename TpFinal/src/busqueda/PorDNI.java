package busqueda;

import java.util.List;
import java.util.Vector;

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
	public List<Prestamo> buscar(List<Prestamo> prestamos) {
		List<Prestamo> ret = new Vector<Prestamo>();
		for(Prestamo p : prestamos){
			if(p.getCliente().getDni() == this.getDni()){
				ret.add(p);
			}
		}
		return ret;
	}
	
	

}

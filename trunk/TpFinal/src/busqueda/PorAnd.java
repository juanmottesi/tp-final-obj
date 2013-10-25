package busqueda;

import java.util.List;

import prestamos.Prestamo;

public class PorAnd extends Condicion {

	private List<Condicion> condiciones;
	
	public List<Condicion> getCondiciones() {
		return this.condiciones;
	}
	
	public void setCondiciones(List<Condicion> condiciones) {
		this.condiciones = condiciones;
	}
		
	@Override
	
	public List<Prestamo> buscar(List<Prestamo> prestamos){
		
		if(this.getCondiciones().isEmpty()){
			return prestamos;
		}
		else{
			Condicion c =this.getCondiciones().get(0);
			this.getCondiciones().remove(0);
			return this.buscar(c.buscar(prestamos));		
		}		
	}
	
	@Override
	public boolean respetaCondicion(Prestamo p) {
		return false;
	}
	
	
	
	
}

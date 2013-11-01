package busqueda;

import java.util.List;

import prestamos.Prestamo;

public class PorAnd extends PorOperadorLogico {

	public PorAnd(List<Condicion> condiciones){
		this.setCondiciones(condiciones);
	}
	
	@Override
	public boolean respetaCondicion(Prestamo p) {
		boolean ret = true;
		for(Condicion c : this.getCondiciones()){
			ret = ret && c.respetaCondicion(p); 
		}
		
	return ret;
	}
	
	
	
	
}

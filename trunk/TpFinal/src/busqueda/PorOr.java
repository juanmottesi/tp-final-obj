package busqueda;

import java.util.List;

import prestamos.Prestamo;

public class PorOr extends PorOperadorLogico {

	public PorOr(List<Condicion> condiciones){
		this.setCondiciones(condiciones);		
	}

	@Override
	public boolean respetaCondicion(Prestamo p) {
		
		boolean ret = false;
		for(Condicion c : this.getCondiciones()){
			ret = c.respetaCondicion(p) || ret ;
		}	
		return ret;
	}
	
	
}

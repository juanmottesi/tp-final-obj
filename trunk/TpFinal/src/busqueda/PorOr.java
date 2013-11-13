package busqueda;

import java.util.List;

import prestamos.Prestamo;

public class PorOr extends PorOperadorLogico {

	
	
	public PorOr(List<Condicion> condiciones){
		if(condiciones.isEmpty()){
			throw EmptyConditionException();
		}
		this.setCondiciones(condiciones);		
	}

	@Override
	public boolean respetaCondicion(Prestamo p) {
		if(this.getCondiciones().isEmpty()){
			return true;
		}
		boolean ret = false;
		for(Condicion c : this.getCondiciones()){
			ret = c.respetaCondicion(p) || ret ;
		}	
		return ret;
	}
	
	
}

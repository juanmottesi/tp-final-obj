package busqueda;

import java.util.List;

import exceptions.EmptyConditionException;

import prestamos.Prestamo;

public class PorOr extends PorOperadorLogico {

	
	
	public PorOr(List<Condicion> condiciones) throws EmptyConditionException{
		if(condiciones.isEmpty()){
			throw new EmptyConditionException();
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

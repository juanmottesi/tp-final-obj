package busqueda;

import java.util.List;

import exceptions.EmptyConditionException;

import prestamos.Prestamo;

/**
 * La condicion de or chequea que alguna de las condiciones de la 
 * lista sean verdaderas.
 * 
 * @author Juan
 *
 */
public class PorOr extends PorOperadorLogico {

	public PorOr(List<Condicion> condiciones) throws EmptyConditionException{
		if(condiciones.isEmpty()){
			throw new EmptyConditionException();
		}
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

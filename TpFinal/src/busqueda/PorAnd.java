package busqueda;

import java.util.List;

import exceptions.EmptyConditionException;
import prestamos.Prestamo;
/**
 * La condicion de and chequea que todas las condiciones de la 
 * lista sean verdaderas
 * 
 * @author Juan
 *
 */
public class PorAnd extends PorOperadorLogico {

	public PorAnd(List<Condicion> condiciones) throws EmptyConditionException{
		if(condiciones.isEmpty()){
			throw new EmptyConditionException();
		}
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

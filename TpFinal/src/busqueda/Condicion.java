package busqueda;

import prestamos.Prestamo;
/**
 * Modela la consulta de un prestamo con una condicion
 * 
 * @author Juan
 *
 */
public abstract class Condicion {
	
	public abstract boolean respetaCondicion(Prestamo p);


}

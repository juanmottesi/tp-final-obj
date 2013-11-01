package busqueda;

import java.util.List;

import prestamos.Prestamo;

public abstract class PorOperadorLogico extends Condicion {
	
	private List<Condicion> condiciones;

	public List<Condicion> getCondiciones() {
		return condiciones;
	}

	public void setCondiciones(List<Condicion> condiciones) {
		this.condiciones = condiciones;
	}

	public abstract boolean respetaCondicion(Prestamo p);
	
	
}

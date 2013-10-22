package busqueda;

import java.util.List;

import prestamos.Prestamo;

public abstract class Condicion {
	
	public abstract List<Prestamo> buscar(List<Prestamo> prestamos);

}

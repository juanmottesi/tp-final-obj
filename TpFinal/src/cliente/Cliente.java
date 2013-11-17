package cliente;

import java.util.Observable;
import java.util.Observer;

import prestamos.Prestamo;

public abstract class Cliente implements Observer {
	
	public abstract boolean puedoAgregarPrestamo();
	
	public abstract void agregarPrestamo(Prestamo prestamo);

	@Override
	public abstract void update(Observable o, Object arg);
	
	public abstract void suscribirAlSistemaDeAviso(Prestamo prestamo);
	
	public abstract void salirSistemaDeAviso(Prestamo prestamo);
	
	public abstract String obtenerDNI();
	
	public abstract String obtenerApellido();
}

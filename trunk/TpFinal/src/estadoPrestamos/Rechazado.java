package estadoPrestamos;

import prestamos.Prestamo;

public class Rechazado extends EstadoPrestamo {
	
	public void seAprobo(Prestamo p){}
	
	public void noSeAprobo(Prestamo p){}
	
	public void sePago(Prestamo p){}
	
	public void noSePago(Prestamo p){}
	
	public void seFinalizo(Prestamo p){}
	
	public void aDeudorIncobrable(Prestamo p){}
}
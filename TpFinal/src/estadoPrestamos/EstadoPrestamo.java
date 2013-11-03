package estadoPrestamos;

public abstract class EstadoPrestamo {
	
	public abstract void seAprobo(Prestamo p){}
	
	public abstract void noSeAprobo(Prestamo p){}
	
	public abstract void sePago(Prestamos p){}
	
	public abstract void noSePago(Prestamos p){}
	
	public abstract void seFinalizo(Prestamos p){}
	
	public abstract void aDeudorIncobrable(Prestamos p){}
}

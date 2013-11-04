package estadoPrestamos;

import prestamos.Prestamo;

public abstract class EstadoPrestamo {
	
	public abstract void seAprobo(Prestamo p);
	
	public abstract void noSeAprobo(Prestamo p);
	
	public abstract void sePago(Prestamo p);
	
	public abstract void noSePago(Prestamo p);
	
	public abstract void seFinalizo(Prestamo p);
	
	public abstract void aDeudorIncobrable(Prestamo p);
	
	
	public boolean equals(EstadoPrestamo estadoPrestamo){
		if(estadoPrestamo == null){
			return false;
		}
		if(this == estadoPrestamo){
			return true;
		}	
		if(this.getClass() != estadoPrestamo.getClass()){
			return false;
		}
		
		return true;
	}
}

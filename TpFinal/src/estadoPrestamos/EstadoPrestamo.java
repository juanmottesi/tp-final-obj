package estadoPrestamos;

import prestamos.Prestamo;

public abstract class EstadoPrestamo {
	
	public abstract void aprobar(Prestamo p);
	
	public abstract void desaprobar(Prestamo p);
	
	public abstract void finalizar(Prestamo p);
	
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

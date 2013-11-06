package estadoPrestamos;

import prestamos.Prestamo;

public class Solicitado extends EstadoPrestamo {
	
	
	public void seAprobo(Prestamo p){
		
		p.setEstado ( new EnCurso());
	}
	
	public void noSeAprobo(Prestamo p){
		
		p.setEstado(new Rechazado());
	}
	
	public void sePago(Prestamo p){}
		//Levantar una excepcion!!!
	
	public void noSePago(Prestamo p){}
		//Levantar una excepcion!!!
	
	public void seFinalizo(Prestamo p){
		//Excepcion no puedo finalizar algo que no tengo ni aprobado
	}
	
	public void aDeudorIncobrable(Prestamo p){
		
		p.setEstado(new Rechazado());
	}



}

package estadoPrestamos;

public class Finalizado extends EstadoPrestamo {
	
	public void seAprobo(Prestamo p){}
	
	public void noSeAprobo(Prestamo p){}
	
	public void sePago(Prestamo p){}
	
	public void noSePago(Prestamo p){}
	
	public void seFinalizo(Prestamo p){
		
		if(p.estanTodasLasCuotasPagas()){
			
			p.setEstado(new Finalizado());
	}
}
	
	public void aDeudorIncobrable(Prestamo p){}
}

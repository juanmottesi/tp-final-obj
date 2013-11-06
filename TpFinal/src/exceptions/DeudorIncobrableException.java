package exceptions;

public class DeudorIncobrableException extends EstadoPrestamoException {

	public DeudorIncobrableException(){}
	
	public DeudorIncobrableException(String mensajeError){
		System.out.println(mensajeError);
	}
}

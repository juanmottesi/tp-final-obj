package exceptions;

public class RechazadoException extends EstadoPrestamoException {

	public RechazadoException(){}
	
	public RechazadoException(String mensajeError){
		System.out.println(mensajeError);
	}

}

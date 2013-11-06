package exceptions;

public class FinalizadoException extends EstadoPrestamoException {

	public FinalizadoException(){}
	
	public FinalizadoException(String mensajeError){
		System.out.println(mensajeError);
	}
}

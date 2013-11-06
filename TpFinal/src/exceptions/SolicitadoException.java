package exceptions;


public class SolicitadoException extends EstadoPrestamoException {
	
	public SolicitadoException(){}
	
	public SolicitadoException(String mensajeError){
		System.out.println(mensajeError);
	}	
}

package exceptions;

public class AprobadoException extends TpException {

	public AprobadoException(){}
	
	public AprobadoException(String mensajeError){
		System.out.println(mensajeError);
	}
}

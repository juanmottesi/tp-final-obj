package exceptions;

public class EnCursoException extends EstadoPrestamoException {

	public EnCursoException(){}
	
	public EnCursoException(String mensajeError){
		System.out.println(mensajeError);
	}
}

package exceptions;

public class EnDeudaException extends EstadoPrestamoException {

	public EnDeudaException(){}
	
	public EnDeudaException(String mensajeError){
		System.out.println(mensajeError);
	}

}

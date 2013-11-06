package exceptions;


public class AgregarPrestamoAClienteException extends ClienteException {

	public AgregarPrestamoAClienteException(){
		super();
	}
	
	public AgregarPrestamoAClienteException(String mensaje){
		super(mensaje);
		
	}

}

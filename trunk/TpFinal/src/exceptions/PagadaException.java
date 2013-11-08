package exceptions;

public class PagadaException extends EstadoCuotaException {
	
	public PagadaException(){
		super();
	}

	public PagadaException(String mensaje){
		super(mensaje);
	}

}

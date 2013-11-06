package otros;

import exceptions.ClienteException;
import exceptions.TpException;

public class AgregarPrestamoAClienteException extends ClienteException {

	public AgregarPrestamoAClienteException(){
		super();
	}
	
	public AgregarPrestamoAClienteException(String mensaje){
		super(mensaje);
		
	}

}

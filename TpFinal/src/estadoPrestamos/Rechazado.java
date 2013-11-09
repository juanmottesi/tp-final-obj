package estadoPrestamos;

import exceptions.AprobadoException;
import exceptions.DeudorIncobrableException;
import exceptions.EnDeudaException;
import exceptions.FinalizadoException;
import exceptions.RechazadoException;
import prestamos.Prestamo;

public class Rechazado extends EstadoPrestamo {
	
	@Override
	public void aDeudorIncobrable(Prestamo p) throws DeudorIncobrableException{
		
		throw new DeudorIncobrableException
		("Estado Rechazado: el prestamo no esta");
	}

	@Override
	public void aprobar(Prestamo p) throws AprobadoException  {

		throw new AprobadoException
		("Estado Rechazado: el prestamo no esta");
		
	}

	@Override
	public void rechazar(Prestamo p) throws RechazadoException {

		throw new RechazadoException
		("Estado Rechazado: el prestamo no esta");
		
	}

	@Override
	public void finalizar(Prestamo p) throws FinalizadoException  {
		
		throw new FinalizadoException 
		("Estado Rechazado: el prestamo no esta");
	}
	
	@Override
	public void aEnDeuda(Prestamo p) throws EnDeudaException {

		throw  new EnDeudaException
			("Estado Rechazado: Un prestamo Rechazado no puede caer En Deuda ");
	}
}


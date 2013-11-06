package estadoPrestamos;

import exceptions.AprobadoException;
import exceptions.DeudorIncobrableException;
import exceptions.FinalizadoException;
import exceptions.RechazadoException;
import prestamos.Prestamo;

public class Finalizado extends EstadoPrestamo {
	

	@Override
	public void aDeudorIncobrable(Prestamo p) throws DeudorIncobrableException{
		
		throw new DeudorIncobrableException
		("Estado Finalizado:  El prestamo ya esta Finalizado");
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
}

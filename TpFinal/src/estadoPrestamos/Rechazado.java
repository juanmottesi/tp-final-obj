package estadoPrestamos;

import exceptions.AprobadoException;
import exceptions.DeudorIncobrableException;
import exceptions.EnCursoException;
import exceptions.EnDeudaException;
import exceptions.FinalizadoException;
import prestamos.Prestamo;

public class Rechazado extends EstadoPrestamo {
	
	/**
	 * Este estado representa lo que le pasa a un Prestamo cuando no es 
	 * Aprobado.
	 */
	
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
	public void rechazar(Prestamo p){
		p.setEstado(this);	
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

	@Override
	public boolean puedoPagar() {
		
		return false;
	}

	@Override
	public void aEnCurso(Prestamo p) throws EnCursoException {

		throw  new EnCursoException
		("Estado Rechazado: Un prestamo Rechazado  no se puede poner en Curso ");
		
	}
}


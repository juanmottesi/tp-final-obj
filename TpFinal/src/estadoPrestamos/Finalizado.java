package estadoPrestamos;

import exceptions.AprobadoException;
import exceptions.DeudorIncobrableException;
import exceptions.EnCursoException;
import exceptions.EnDeudaException;
import exceptions.FinalizadoException;
import exceptions.RechazadoException;
import prestamos.Prestamo;

public  class Finalizado extends EstadoPrestamo {
	

	@Override
	public void aDeudorIncobrable(Prestamo p) throws DeudorIncobrableException{
		
		throw new DeudorIncobrableException
		("Estado Finalizado:  El préstamo ya esta Finalizado");
	}

	@Override
	public void aprobar(Prestamo p) throws AprobadoException  {

		throw new AprobadoException
		("Estado Finalizado: el prestamo ya está finalizado");
		
	}

	@Override
	public void rechazar(Prestamo p) throws RechazadoException {

		throw new RechazadoException
		("Estado Finalizado: el prestamo ya está finalizado");
		
	}

	@Override
	public void finalizar(Prestamo p) throws FinalizadoException  {
		
		throw new FinalizadoException 
			("Estado Finalizado: el prestamo ya está finalizado");
	}
	
	@Override
	public void aEnDeuda(Prestamo p) throws EnDeudaException {

		throw  new EnDeudaException
			("Estado Finalizado: Un prestamo finalizado no puede volver a En Deuda ");
	}

	@Override
	public boolean puedoPagar() {
		
		return false;
	}

	@Override
	public void aEnCurso(Prestamo p) throws EnCursoException {
		
		throw  new EnCursoException
		("Estado Finalizado: Un prestamo finalizado ya no puede estar en Curso ");

	}
}

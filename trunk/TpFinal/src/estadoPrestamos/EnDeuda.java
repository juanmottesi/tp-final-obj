package estadoPrestamos;

import exceptions.AprobadoException;
import exceptions.EnCursoException;
import exceptions.EnDeudaException;
import exceptions.FinalizadoException;
import exceptions.RechazadoException;
import prestamos.Prestamo;

public class EnDeuda extends EstadoPrestamo {
	
	/**
	 * Este estado es el que toma el prestamo una ves que alguna cuota
	 * no es pagada a tiempo. 
	 */
	

	@Override
	public void aDeudorIncobrable(Prestamo p){
		p.setEstado(new DeudorIncobrable());
	}

	@Override
	public void aprobar(Prestamo p) throws AprobadoException {

		throw new AprobadoException
		("Estado En Deuda: no se lo puede volver a Aprobar ");
		
	}

	@Override
	public void rechazar(Prestamo p) throws RechazadoException {

		throw new RechazadoException
		("Estado En Deuda: no se lo puedo rechazar ");
		
	}

	@Override
	public void finalizar(Prestamo p) throws FinalizadoException{

		throw new FinalizadoException
		("Estado En Deuda: No se lo puedo finalizar ");
		
	}
	
	@Override
	public void aEnDeuda(Prestamo p) throws EnDeudaException {

		throw  new EnDeudaException
			("Estado En Deuda: Ya a está En Deuda ");
	}

	@Override
	public boolean puedoPagar() {
		
		return true;
	}

	@Override
	public void aEnCurso(Prestamo p) throws EnCursoException{
		
		p.setEstado(new EnCurso());
		
	}
}

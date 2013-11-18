package estadoPrestamos;

import exceptions.AprobadoException;
import exceptions.DeudorIncobrableException;
import exceptions.EnDeudaException;
import exceptions.RechazadoException;
import prestamos.Prestamo;

public class EnCurso extends EstadoPrestamo {
	
	/**
	 * Este Estado es le que toma el prestamo una ves Aprobado.
	 */
	
	@Override
	public void aDeudorIncobrable(Prestamo p) throws DeudorIncobrableException{
		throw new DeudorIncobrableException
		("Estado En Curso: Este prestamo no a estado en deuda");
		
	}

	@Override
	public void aprobar(Prestamo p) throws AprobadoException {
		throw new AprobadoException
		("Estado En Curso: Ya esta Aprobado ");
		
	}

	@Override
	public void rechazar(Prestamo p) throws RechazadoException {

		throw new RechazadoException
		("Estado En Curso: Ya esta Aprobado y no se lo puedo rechazar ");		
	}

	@Override
	public void finalizar(Prestamo p){

		p.setEstado(new Finalizado());
	
	}
	
	@Override
	public void aEnDeuda(Prestamo p) throws EnDeudaException {

		p.setEstado(new EnDeuda());
	}

	@Override
	public boolean puedoPagar() {
		
		return true;
	}

	@Override
	public void aEnCurso(Prestamo p){
		p.setEstado(this);
	}

}

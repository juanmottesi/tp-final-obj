package estadoPrestamos;

import exceptions.AprobadoException;
import exceptions.DeudorIncobrableException;
import exceptions.FinalizadoException;
import exceptions.RechazadoException;
import prestamos.Prestamo;

public class EnCurso extends EstadoPrestamo {
	
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

}

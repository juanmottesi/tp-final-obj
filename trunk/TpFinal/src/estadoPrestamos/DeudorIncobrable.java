package estadoPrestamos;

import exceptions.AprobadoException;
import exceptions.DeudorIncobrableException;
import exceptions.EnCursoException;
import exceptions.EnDeudaException;
import exceptions.FinalizadoException;
import exceptions.RechazadoException;
import prestamos.Prestamo;


public class DeudorIncobrable extends EstadoPrestamo {
	
	@Override
	public void aDeudorIncobrable(Prestamo p) throws DeudorIncobrableException{
		throw new DeudorIncobrableException
				("Estado Deudor Incobreble: Ya esta en este estado");
		
	}

	@Override
	public void aprobar(Prestamo p) throws AprobadoException{
		throw new AprobadoException
		("Estado Deudor Incobreble: Este prestamo no se puede Aprobar");
		
	}

	@Override
	public void rechazar(Prestamo p) throws RechazadoException {
		throw new RechazadoException
		("Estado Deudor Incobreble: Este prestamo no se puede Rechazar");
		
	}

	@Override
	public void finalizar(Prestamo p) throws FinalizadoException{
		throw new FinalizadoException
		("Estado Deudor Incobreble: Este prestamo no se puede Finalizar");
		
	}

	@Override
	public void aEnDeuda(Prestamo p) throws EnDeudaException {

		throw  new EnDeudaException  
			("Estado Deudor Incobrable: Ya a pasado del estado En Deuda "
					+ "alestado Deudor incobrable");
		
	}

	@Override
	public boolean puedoPagar() {
		return false;
	}

	@Override
	public void aEnCurso(Prestamo p) throws EnCursoException {
		throw new EnCursoException("Estado Deudor Incobrable");
		//p.setEstado(new EnCurso());
		
	}
}

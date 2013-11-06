package estadoPrestamos;

import exceptions.AprobadoException;
import exceptions.DeudorIncobrableException;
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
}

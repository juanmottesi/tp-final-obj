package estadoPrestamos;

import exceptions.DeudorIncobrableException;
import exceptions.FinalizadoException;
import exceptions.SolicitadoException;
import prestamos.Prestamo;

public class Solicitado extends EstadoPrestamo {

	@Override
	public void aprobar(Prestamo p) {
		
		p.setEstado(new EnCurso());
	}

	@Override
	public void rechazar(Prestamo p) {
		
		p.setEstado(new Rechazado());
	}

	@Override
	public void finalizar(Prestamo p) throws FinalizadoException {
		
		throw new FinalizadoException("Estado Solicitado: No se puede finalizar");
		
	}

	@Override
	public void aDeudorIncobrable(Prestamo p) throws DeudorIncobrableException {
		
		throw new DeudorIncobrableException("Estado Solicitado: No se puede pasar a Deudor incobrable");
	}
}

package prestamos;

public abstract class EstadoCuota {
	public abstract boolean estaPaga();
	public abstract void pagar(Cuota cuota);
}

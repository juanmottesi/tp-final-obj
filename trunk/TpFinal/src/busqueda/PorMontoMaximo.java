package busqueda;


import prestamos.Prestamo;

public class PorMontoMaximo extends Condicion{
	
	private float maximo;

	public float getMaximo() {
		return maximo;
	}

	public void setMaximo(float maximo) {
		this.maximo = maximo;
	}
	
	public PorMontoMaximo(float maximo){
		
		this.setMaximo(maximo);
		
	}

	@Override
	public boolean respetaCondicion(Prestamo p){	
			float montoAux = p.getMontoTotal();
			return (montoAux< this.getMaximo());
	}
	
	
}

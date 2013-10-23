package gastos;

public abstract class Gasto {
	
	private String nombre;
	private float porcentual;
	private float fijo;

	public String getNombre(){
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getPorcentual() {
		return porcentual;
	}

	public void setPorcentual(float porcentual) {
		this.porcentual = porcentual;
	}

	public float getFijo() {
		return fijo;
	}

	public void setFijo(float fijo) {
		this.fijo = fijo;
	}

	
	public float gastoPorcentual() {
		
		return this.getPorcentual();
	}

	
	public float gastoFijo() {
		
		return this.gastoFijo();
	}
	
}

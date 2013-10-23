package gastos;

public class GastoMensual extends Gasto {

	public GastoMensual(float fijo, float porcentual){
		
		this.setFijo(fijo);
		this.setNombre("Mensual");
		this.setPorcentual(porcentual/100);
		
	}
	
	

}

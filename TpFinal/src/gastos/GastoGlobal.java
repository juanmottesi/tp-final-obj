package gastos;

public class GastoGlobal extends Gasto {
	
	public GastoGlobal(float fijo, float porcentual){
		
		this.setFijo(fijo);
		this.setNombre("Global");
		this.setPorcentual(porcentual/100);
		
	}


	
	
	
	

}

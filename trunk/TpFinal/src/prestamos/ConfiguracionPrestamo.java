package prestamos;

import gastos.Gasto;

import java.util.List;

import seguro.ModoSeguroDeVida;

public class ConfiguracionPrestamo {
	
	private ModoSeguroDeVida modoSeguro;
	private List<Gasto> gastos;
	
	public ModoSeguroDeVida getModoSeguro() {
		return modoSeguro;
	}
	
	public void setModoSeguro(ModoSeguroDeVida modoSeguro) {
		this.modoSeguro = modoSeguro;
	}
	
	public List<Gasto> getGastos() {
		return gastos;
	}
	
	public void setGastos(List<Gasto> gastos) {
		this.gastos = gastos;
	}
	
	public ConfiguracionPrestamo(ModoSeguroDeVida modoSeguro, List<Gasto> gastos){
		this.setModoSeguro(modoSeguro);
		this.setGastos(gastos);
	}
	
	public void calcularGasto(Prestamo prestamo){
		for(Gasto g : this.getGastos()){
			g.calcularGasto(prestamo);
		}
	}
	
	public void calcularSeguro(Prestamo prestamo){
		this.getModoSeguro().calcularSeguro(prestamo);
	}
	

}

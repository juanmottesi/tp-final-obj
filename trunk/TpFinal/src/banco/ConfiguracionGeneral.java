
package banco;


import java.util.GregorianCalendar;
import java.util.List;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import exceptions.ConfiguracionGeneralException;
import prestamos.Prestamo;
import gastos.Gasto;
/**
 * Modela la informacion de gastos comun a todos los prestamos
 * 
 * @author Juan
 *
 */
public class ConfiguracionGeneral {

	private GregorianCalendar fechaInicio;
	private GregorianCalendar fechaFin;
	private SortedMap<Integer,Double> tem;
	private List<Gasto> gastos;
	
	public GregorianCalendar getFechaInicio() {
		return fechaInicio;
	}
	
	public void setFechaInicio(GregorianCalendar fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	
	public GregorianCalendar getFechaFin() {
		return fechaFin;
	}
	
	public void setFechaFin(GregorianCalendar fechaFin) {
		this.fechaFin = fechaFin;
	}
	
	public SortedMap<Integer, Double> getTem() {
		return tem;
	}
	
	public void setTem(SortedMap<Integer, Double> tem) {
		this.tem = tem;
	}
	
	public List<Gasto> getGastos() {
		return gastos;
	}

	public void setGastos(List<Gasto> gastos) {
		this.gastos = gastos;
	}
	
	/**
	 * @param fechaInicio
	 * @param tem
	 * @param gastos
	 */
	public ConfiguracionGeneral(GregorianCalendar fechaInicio, SortedMap<Integer,Double>tem, List<Gasto>gastos){
		this.setFechaInicio(fechaInicio);
		this.setTem(tem);
		this.setGastos(gastos);
		GregorianCalendar fechaPasada = new GregorianCalendar(fechaInicio.get(1)+100,fechaInicio.get(2),fechaInicio.get(5));
		this.setFechaFin(fechaPasada);
	}
	/**
	 * @param fechaInicio
	 * @param gastos
	 * tem vacio.
	 */
	public ConfiguracionGeneral(GregorianCalendar fechaInicio,List<Gasto>gastos){
		this.setFechaInicio(fechaInicio);
		this.setTem(new TreeMap<Integer,Double>());
		this.setGastos(gastos);
		GregorianCalendar fechaPasada = new GregorianCalendar(fechaInicio.get(1)+100,fechaInicio.get(2),fechaInicio.get(5));
		this.setFechaFin(fechaPasada);

	}
	
	/**
	 * @param cuotas
	 * @return Integer correspondiente al valor del tem segun la cantidad de cuotas
	 * si la cantidad de cuotas supera a los valores que estan en el tem toma el valor mas grande
	 */
	public Double consultarTem(Integer cuotas){
		Integer ret = 0;
		Set<Integer> claves = this.getTem().keySet();
		for(Integer i : claves){
			if(i >= cuotas){
				return this.getTem().get(i);
			}
			else{
				ret = i;
			}
		}
		return this.getTem().get(ret); 
	} 
	
	/**
	 * @param Integer clave
	 * @param Integer valor
	 */
	public void agregarClaveValorATem(Integer clave, Integer valor){
		this.getTem().put(clave,(double)(valor*0.01));
	}

	
	/**
	 * @param prestamo
	 * calcula el gasto al prestamo y se lo agrega. 
	 */
	public void calcularGasto(Prestamo prestamo){
		for(Gasto gasto : this.getGastos()){
			gasto.calcularGasto(prestamo);
		}
	}
	
	public void finConfiguracionGeneral(ConfiguracionGeneral configuracionGeneral) throws ConfiguracionGeneralException{
		if(this.getFechaInicio().after(configuracionGeneral.getFechaInicio())){
			throw new ConfiguracionGeneralException("la fecha inicio es anterior a la configuracion actual");
		}
		else{
			this.setFechaFin(configuracionGeneral.getFechaInicio());
		}
	}
}
	
	


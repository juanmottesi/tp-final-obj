
package otros;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import prestamos.Prestamo;
import gastos.Gasto;

public class ConfiguracionGeneral {

	private Date fechaInicio;
	private Date fechaFin;
	private SortedMap<Integer,Integer> tem;
	private List<Gasto> gastos;
	
	public Date getFechaInicio() {
		return fechaInicio;
	}
	
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	
	public Date getFechaFin() {
		return fechaFin;
	}
	
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	
	public SortedMap<Integer, Integer> getTem() {
		return tem;
	}
	
	public void setTem(SortedMap<Integer, Integer> tem) {
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
	public ConfiguracionGeneral(Date fechaInicio, SortedMap<Integer,Integer>tem, List<Gasto>gastos){
		this.setFechaInicio(fechaInicio);
		this.setTem(tem);
		this.setGastos(gastos);
	}
	/**
	 * @param fechaInicio
	 * @param gastos
	 * tem vacio.
	 */
	public ConfiguracionGeneral(Date fechaInicio,List<Gasto>gastos){
		this.setFechaInicio(fechaInicio);
		this.setTem(new TreeMap<Integer,Integer>());
		this.setGastos(gastos);
	}
	
	/**
	 * @param cuotas
	 * @return Integer correspondiente al valor del tem segun la cantidad de cuotas
	 */
	public Integer consultarTem(Integer cuotas){
		Set<Integer> claves = this.getTem().keySet();
		for(Integer i : claves){
			if(i >= cuotas){
				return this.getTem().get(i);
			}	
		}
		Integer ret = this.getTem().size() - 1;
		return this.getTem().get(ret); 
	} 
	
	/**
	 * @param Integer clave
	 * @param Integer valor
	 */
	public void agregarClaveValorATem(Integer clave, Integer valor){
		this.getTem().put(clave, valor/100);
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
}
	
	

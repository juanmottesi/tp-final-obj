
package otros;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

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
	
	
	public ConfiguracionGeneral(Date fechaInicio, SortedMap<Integer,Integer>tem){
		
		this.setFechaInicio(fechaInicio);
		this.setTem(tem);
		
	}
	
	public ConfiguracionGeneral(Date fechaInicio){
		
		this.setFechaInicio(fechaInicio);
		this.setTem(new TreeMap<Integer,Integer>());
	}
	
	
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
	
	public void agregarClaveValorATem(Integer c, Integer v){
		
		this.getTem().put(c, v/100);
		
	}

	
}
	
	


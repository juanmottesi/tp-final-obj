package prestamos;

import java.util.Date;
import java.util.List;
import java.util.Vector;

import otros.*;
import estadoPrestamos.*;
import gastos.Gasto;

public class Prestamo {

	private EstadoPrestamo estado;
	private List<Cuota> cuotas; 
	private Cliente cliente;
	private float montoTotal;
	private List<Gasto> gastos;
	private Date fechaDeCreacion;
	
	public EstadoPrestamo getEstado() {
		return estado;
	}
	
	public void setEstado(EstadoPrestamo estado) {
		this.estado = estado;
	}
	
	public List<Cuota> getCuotas() {
		return cuotas;
	}
	
	public void setCuotas(List<Cuota> cuotas) {
		this.cuotas = cuotas;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public float getMontoTotal() {
		return montoTotal;
	}
	
	public void setMontoTotal(float montoTotal) {
		this.montoTotal = montoTotal;
	}
	
	public List<Gasto> getGastos() {
		return gastos;
	}
	
	public void setGastos(List<Gasto> gastos) {
		this.gastos = gastos;
	}
	
	public Integer cantidadDeCuotas(){	
		return this.getCuotas().size();
	}

	public Date getFechaDeCreacion() {
		return fechaDeCreacion;
	}

	public void setFechaDeCreacion(Date fechaDeCreacion) {
		this.fechaDeCreacion = fechaDeCreacion;
	}
	
	public List<Cuota> generarCuotas(Integer cantCoutas, ConfiguracionGeneral cg, float montoTotal){
		List<Cuota> cuotas = new Vector<Cuota>();
		Integer temCorrespondiente = cg.consultarTem(cantCoutas);
		float valorCuota = this.getCalcularCuota().calcularCuota(temCorrespondiente,cantCoutas,montoTotal);
		
		return cuotas;
	}
	
	
	public Prestamo(float montoTotal, Integer cuotas, Date fechaDeCreacion,ConfiguracionGeneral cg){
		
		this.setEstado(new Solicitado());
		this.setMontoTotal(montoTotal);
		this.setFechaDeCreacion(fechaDeCreacion);
		this.setCuotas(this.generarCuotas(cuotas,cg,montoTotal));
		
	}
	
	
	
}

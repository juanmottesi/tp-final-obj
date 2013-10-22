package prestamos;

import java.util.List;

import otros.*;
import estadoPrestamos.*;
import gastos.Gasto;

public class Prestamo {

	private EstadoPrestamo estado;
	private List<Cuota> cuotas; 
	private Cliente cliente;
	private float montoTotal;
	private List<Gasto> gastos;
	
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
	
	
	
	
}

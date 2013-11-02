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
	private ConfiguracionPrestamo configuracionPrestamo;
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
	
	public Integer cantidadDeCuotas(){	
		return this.getCuotas().size();
	}

	public Date getFechaDeCreacion() {
		return fechaDeCreacion;
	}

	public void setFechaDeCreacion(Date fechaDeCreacion) {
		this.fechaDeCreacion = fechaDeCreacion;
	}
	
	public ConfiguracionPrestamo getConfiguracionPrestamo() {
		return configuracionPrestamo;
	}

	public void setConfiguracionPrestamo(ConfiguracionPrestamo configuracionPrestamo) {
		this.configuracionPrestamo = configuracionPrestamo;
	}
	
	/**
	 * PagarCuota: realiza el pago de la primer cuota no paga que puede estar en 
	 * cualquier estado.
	 */
	public void pagarCuota(Date fechaDelPago){
		for(Cuota c : this.getCuotas()){
			if(!c.estaPagada()){
				c.pagar(fechaDelPago);
				break; // mirar!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
			}
		}
	}
	
	public float calcularCuota(){}
	
	public List<Cuota> cuadroDeMarcha(){}
	
	public float calcularSaldoDeuda(int nroCuota){}
	
	public void agregarCuota(){}
	
	public float calcularSeguroDeVida(){}
	
	
	
}

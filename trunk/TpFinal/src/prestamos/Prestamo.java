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
	private double montoTotal;
	private ConfiguracionPrestamo configuracionPrestamo;
	private Date fechaDeCreacion;
	private ConfiguracionGeneral configuracionGeneral;
	
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
	
	public double getMontoTotal() {
		return montoTotal;
	}
	
	public void setMontoTotal(double montoTotal) {
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
	
	public ConfiguracionGeneral getConfiguracionGeneral() {
		return configuracionGeneral;
	}

	public void setConfiguracionGeneral(ConfiguracionGeneral configuracionGeneral) {
		this.configuracionGeneral = configuracionGeneral;
	}
	
	public Prestamo(Cliente cliente, double montoTotal, Integer cantCuotas, Date fechaDeCreacion, ConfiguracionPrestamo configuracionPrestamo, ConfiguracionGeneral configGeneral){
		this.setCliente(cliente);
		this.setMontoTotal(montoTotal);
		this.setFechaDeCreacion(fechaDeCreacion);
		this.setConfiguracionPrestamo(configuracionPrestamo);
		this.setConfiguracionGeneral(configGeneral);
		this.setEstado(new Solicitado());
		this.setCuotas(this.crearCuotas(montoTotal,cantCuotas,configuracionPrestamo, configGeneral,fechaDeCreacion));
		this.calcularGasto();
	}
	
	/**
	 * PagarCuota: realiza el pago de la primer cuota no paga que puede estar en 
	 * cualquier estado.
	 */
	public void pagarCuota(Date fechaDelPago){
		for(Cuota c : this.getCuotas()){
			if(!c.estaPaga()){
				c.pagar(fechaDelPago);
				break; // mirar!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
			}
		}
	}
	/**
	 * CalcularGasto suma las gastos mensuales para pasarselos a las cuotas y decrementa el montoTotal si el gasto es Global
	 * ademas como ya las cuotas conocen sus gastos este agrega a la cuota el interes por mora, el valor total de la cuota.
	 */
	public void calcularGasto(){
		this.getConfiguracionGeneral().calcularGastos(this);
		this.getConfiguracionPrestamo().calcularGastos(this);
		this.agregarACuotasInteresPorMora();
		this.agregarValorTotalACuotas();
	}
	
	public float calcularCuota(){}
	
	public List<Cuota> cuadroDeMarcha(){}
	
	public float calcularSaldoDeuda(int nroCuota){}
	
	
	@SuppressWarnings("deprecation")
	public List<Cuota> crearCuotas(double montoTotal,Integer cantCuotas,ConfiguracionPrestamo configuracionPrestamo, ConfiguracionGeneral configuracionGeneral, Date fechaActual){
		List<Cuota> ret = new Vector<Cuota>();
		
		Date fechaCuota = new Date(fechaActual.getYear(),fechaActual.getMonth()+2, 10);
		
		if(fechaActual.before(new Date(fechaActual.getYear(),fechaActual.getMonth(), 15))){
			fechaCuota = new Date(fechaActual.getYear(),fechaActual.getMonth()+1, 10);
		}
		
		float monto = montoTotal;
		
		double montoCuota = CalculoValorCuota.calcularCuota(montoTotal,configuracionGeneral.consultarTem(cantCuotas), cantCuotas);
		
		for(int i = 0 ; i < cantCuotas; i++){
			fechaCuota = new Date(fechaActual.getYear(),fechaActual.getMonth()+i, 10);
			double interes = monto * configuracionGeneral.consultarTem(cantCuotas);
			double amortizacion = this.calcularAmortizacion(montoCuota,interes);
			double saldoDeuda = monto - amortizacion;
			Cuota c = new Cuota(fechaCuota, montoCuota,(Integer)i,amortizacion,interes,configuracionPrestamo.getSeguro(),saldoDeuda);
			monto = monto - amortizacion;
			ret.add(c);
		}
		
		return ret;
	}
	
	public float calcularAmortizacion(double valorCuota, double interes){
		return valorCuota - interes;
		
	}
	
	
	public float calcularSeguroDeVida(){}
	
	
	/**
	 * @param fechaActual 
	 * chequea todas sus cuotas si estas se encuentran vencidas.
	 */
	public void verificarFechaDeCuotas(Date fechaActual){
		for(Cuota c : this.getCuotas()){
			c.verificarFecha(fechaActual);
		}
		
	}

	
	
}

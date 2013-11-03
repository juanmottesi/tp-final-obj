package prestamos;

import java.util.Date;

import cuotaEstados.APagar;
import cuotaEstados.EstadoCuota;


public class Cuota {
	
	private Date fechaVencimiento;
	private double montoCuota;
	private Integer nroCuota;
	private double interesPorMora;
	private Date fechaDePago;
	private double amortizacion;
	private double interes;
	private double gastoTotal;
	private double saldoDeuda;
	private double seguro;
	
	public double getSeguro() {
		return seguro;
	}
	public void setSeguro(double seguro) {
		this.seguro = seguro;
	}

	private EstadoCuota estadoCuota;
	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}
	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}
	public double getMontoCuota() {
		return montoCuota;
	}
	public void setMontoCuota(double montoCuota) {
		this.montoCuota = montoCuota;
	}
	public Integer getNroCuota() {
		return nroCuota;
	}
	public void setNroCuota(Integer nroCuota) {
		this.nroCuota = nroCuota;
	}
	public double getInteresPorMora() {
		return interesPorMora;
	}
	public void setInteresPorMora(double interesPorMora) {
		this.interesPorMora = interesPorMora;
	}
	public Date getFechaDePago() {
		return fechaDePago;
	}
	public void setFechaDePago(Date fechaDePago) {
		this.fechaDePago = fechaDePago;
	}
	public double getAmortizacion() {
		return amortizacion;
	}
	public void setAmortizacion(double amortizacion) {
		this.amortizacion = amortizacion;
	}
	public double getInteres() {
		return interes;
	}
	public void setInteres(double interes) {
		this.interes = interes;
	}
	public double getGastoTotal() {
		return gastoTotal;
	}
	public void setGastoTotal(double gastoTotal) {
		this.gastoTotal = gastoTotal;
	}
	public double getSaldoDeuda() {
		return saldoDeuda;
	}
	public void setSaldoDeuda(double saldoDeuda) {
		this.saldoDeuda = saldoDeuda;
	}
	public EstadoCuota getEstadoCuota() {
		return estadoCuota;
	}
	public void setEstadoCuota(EstadoCuota estadoCuota) {
		this.estadoCuota = estadoCuota;
	}
	/**
	 * Orden de los parametros:
	 * @param fechaVencimiento
	 * @param monto
	 * @param nroCuota
	 * @param interesPorMora --
	 * @param amortizacion
	 * @param interes
	 * @param seguro
	 * @param gasto --
	 * @param saldoDeuda
	 */
	public Cuota(Date fechaVencimiento, double monto, Integer nroCuota, /*float interesPorMora,*/ double amortizacion, double interes,double seguro,/* double gasto,*/ double saldoDeuda){
		this.setAmortizacion(amortizacion);
		this.setFechaVencimiento(fechaVencimiento);
		//this.setGastoTotal(gasto);
		//this.setInteresPorMora(interesPorMora);
		this.setInteres(interes);
		this.setMontoCuota(monto);
		this.setSaldoDeuda(saldoDeuda);
		this.setSeguro(seguro);
		this.setNroCuota(nroCuota);
		this.setEstadoCuota(new APagar());
	}
	
	
	/**
	 * EstaPaga realiza una inspeccion del estado
	 * 
	 * @return un bool que chequea el estado
	 */
	public boolean estaPaga(){
		return this.getEstadoCuota().estaPaga();
	}
	
	/**
	 * @param fechaPago
	 * Pagar recibe la fecha en la que se efectua el pago
	 */
	public void pagar(Date fechaPago){
		this.getEstadoCuota().pagar(this);
		this.setFechaDePago(fechaPago);
	}
	
	
	/**
	 * cambia el estado a vencido.
	 * 
	 */
	public void aVencido(){
		this.getEstadoCuota().aVencido(this);
	}
	
	/**
	 * @param fechaActual 
	 * chequea si la fecha de vencimiento es menor que la pasada por parametro
	 * si es asi la pasa a vencida.
	 * 
	 */
	public void verificarFecha(Date fechaActual){
		if(this.getFechaVencimiento().before(fechaActual)){
			this.aVencido();
		}
		
	}
}

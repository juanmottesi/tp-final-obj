package prestamos;

import java.util.Date;


public class Cuota {
	
	private Date fechaVencimiento;
	private float montoCuota;
	private Integer nroCuota;
	private float interesPorMora;
	private Date fechaDePago;
	private float amortizacion;
	private float interes;
	private float gastoTotal;
	private float saldoDeuda;
	private float seguro;
	
	public float getSeguro() {
		return seguro;
	}
	public void setSeguro(float seguro) {
		this.seguro = seguro;
	}

	private EstadoCuota estadoCuota;
	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}
	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}
	public float getMontoCuota() {
		return montoCuota;
	}
	public void setMontoCuota(float montoCuota) {
		this.montoCuota = montoCuota;
	}
	public Integer getNroCuota() {
		return nroCuota;
	}
	public void setNroCuota(Integer nroCuota) {
		this.nroCuota = nroCuota;
	}
	public float getInteresPorMora() {
		return interesPorMora;
	}
	public void setInteresPorMora(float interesPorMora) {
		this.interesPorMora = interesPorMora;
	}
	public Date getFechaDePago() {
		return fechaDePago;
	}
	public void setFechaDePago(Date fechaDePago) {
		this.fechaDePago = fechaDePago;
	}
	public float getAmortizacion() {
		return amortizacion;
	}
	public void setAmortizacion(float amortizacion) {
		this.amortizacion = amortizacion;
	}
	public float getInteres() {
		return interes;
	}
	public void setInteres(float interes) {
		this.interes = interes;
	}
	public float getGastoTotal() {
		return gastoTotal;
	}
	public void setGastoTotal(float gastoTotal) {
		this.gastoTotal = gastoTotal;
	}
	public float getSaldoDeuda() {
		return saldoDeuda;
	}
	public void setSaldoDeuda(float saldoDeuda) {
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
	 * @param interesPorMora
	 * @param amortizacion
	 * @param interes
	 * @param seguro
	 * @param gasto
	 * @param saldoDeuda
	 * 
	 *  
	 */
	public Cuota(Date fechaVencimiento, float monto, Integer nroCuota, float interesPorMora, float amortizacion, float interes,float seguro, float gasto, float saldoDeuda){
		this.setAmortizacion(amortizacion);
		this.setFechaVencimiento(fechaVencimiento);
		this.setGastoTotal(gasto);
		this.setInteresPorMora(interesPorMora);
		this.setInteres(interes);
		this.setMontoCuota(monto);
		this.setSaldoDeuda(saldoDeuda);
		this.setSeguro(seguro);
		this.setNroCuota(nroCuota);
		this.setEstadoCuota(new APagar());
	}
	public boolean estaPaga(){
		return this.getEstadoCuota().estaPaga();
	}
	public void pagar(Date fechaPago){
		this.getEstadoCuota().pagar(this);
		this.setFechaDePago(fechaPago);
	}
}

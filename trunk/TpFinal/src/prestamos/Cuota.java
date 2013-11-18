package prestamos;

import java.util.GregorianCalendar;

import estadoCuotas.APagar;
import estadoCuotas.EstadoCuota;
import exceptions.EstadoCuotaException;


/**
  *  
  * 
  * @author juan
  *
  */

public class Cuota {
	
	private GregorianCalendar fechaVencimiento; 
	private double montoCuota;
	private Integer nroCuota; 
	private double interesPorMora; 
	private GregorianCalendar fechaDePago;
	private double amortizacion;
	private double interes;
	private double gastoTotal;
	private double saldoDeuda;
	private double seguro;
	private double valorTotalCuota;
	private EstadoCuota estadoCuota;
	
	
	public double getValorTotalCuota() {
		return valorTotalCuota;
	}
	public void setValorTotalCuota(double valorTotalCuota) {
		this.valorTotalCuota = valorTotalCuota;
	}
	public double getSeguro() {
		return seguro;
	}
	public void setSeguro(double seguro) {
		this.seguro = seguro;
	}
	public GregorianCalendar getFechaVencimiento() {
		return fechaVencimiento;
	}
	public void setFechaVencimiento(GregorianCalendar fechaVencimiento) {
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
	public GregorianCalendar getFechaDePago() {
		return fechaDePago;
	}
	public void setFechaDePago(GregorianCalendar fechaDePago) {
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
	 * Usar solo cuando se consulta el valor cuota.
	 */
	public Cuota(){
		super();
	}
	
	/**
	 * Orden de los parametros:
	 * @param fechaVencimiento
	 * @param monto
	 * @param nroCuota
	 * @param amortizacion
	 * @param interes
	 * @param saldoDeuda
	 */
	public Cuota(GregorianCalendar fechaVencimiento, double monto, Integer nroCuota, double amortizacion, double interes,double saldoDeuda){
		this.setAmortizacion(amortizacion);
		this.setFechaVencimiento(fechaVencimiento);
		this.setInteres(interes);
		this.setMontoCuota(monto);
		this.setSaldoDeuda(saldoDeuda);
		
		this.setNroCuota(nroCuota);
		this.setEstadoCuota(new APagar());
		this.setFechaDePago(null);
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
	 * @throws EstadoCuotaException 
	 */
	public void pagar(GregorianCalendar fechaPago) throws EstadoCuotaException{
		this.getEstadoCuota().pagar(this);
		this.setFechaDePago(fechaPago);
	}
	
	
	/**
	 * cambia el estado a vencido.
	 * @throws EstadoCuotaException 
	 * 
	 */
	public void aVencido() throws EstadoCuotaException{
		this.getEstadoCuota().aVencido(this);
	}
	

	
	
	/**
	 * @param fechaActual 
	 * chequea si la fecha de vencimiento es menor que la pasada por parametro
	 * si es asi la pasa a vencida.
	 * @throws EstadoCuotaException 
	 * 
	 */
	public void verificarFecha(GregorianCalendar fechaActual) throws EstadoCuotaException{
		if(this.getFechaVencimiento().before(fechaActual)){
			this.aVencido();
		}
		
	}
	
	public void actualizarGastoTotal(double montoActuralizado){
		this.setGastoTotal(montoActuralizado);
	}
	
	public String generarInfoCuotaXML(){
		String nuevalinea = System.getProperty("line.separator");
		String nuevalinea2 = nuevalinea+"        ";
		String s = nuevalinea2+"<numero>";
		s = s + this.getNroCuota();
		s = s + "</numero>";		
		s = s + nuevalinea2;
		s = s + "<vencimiento>";
		s = s + this.getFechaVencimiento().toString();
		s = s + "</vencimiento>";
		s = s + nuevalinea2;
		s = s + "<amortizacion>";
		s = s + this.getAmortizacion();
		s = s + "</amortizacion>";	
		s = s + nuevalinea2;
		s = s + "<interes>";
		s = s + this.getInteres();
		s = s + "</interes>";
		s = s + nuevalinea2;
		s = s + "<saldodeuda>";
		s = s + this.getSaldoDeuda();
 	 	s = s + "</saldodeuda>";	
		s = s + nuevalinea2;
 	 	s = s + "<seguro>";
 	 	s = s + this.getSeguro();
	 	s = s + "</seguro>";	
		s = s + nuevalinea2;
 	 	s = s + "<gastos>";
 	 	s = s + this.getGastoTotal();
 	 	s = s + "</gastos>";	
		s = s + nuevalinea2;
		s = s + "<valorcuota>";
		s = s + this.getMontoCuota();
		s = s + "</valorcuota>";	
		s = s + nuevalinea2;
 	 	s = s + "<valortotalcuota>";
 	 	s = s + this.getValorTotalCuota();
 	 	s = s + "</valortotalcuota>";	
 	 	s = s + nuevalinea2;
 	 	s = s + "<fechadepago>";
 	 	s = s + this.getFechaDePago().toString();
 	 	s = s + "</fechadepago>";	
 	 	s = s + nuevalinea2;
 	 	s = s + "<interesmora>";
 	 	s = s + this.getInteresPorMora();
 	 	s = s + "</interesmora>";
		s = s + nuevalinea2;
		return s;
	}

	public String generarInfoCuotaHTML(){
		String nuevalinea = System.getProperty("line.separator");
		String nuevalinea2 = nuevalinea+"            ";
		String s = nuevalinea2+"<li>";
		s = s + "Cuota " + this.getNroCuota();
		s = s+"</li>";		
		s = s+nuevalinea2;
		s = s+"<li>";
		s= s+"Vencimiento "+ this.getFechaVencimiento();
		s = s +"</li>";
		s = s+nuevalinea2;
		s = s +"<li>";
		s = s+"Amortizacion "+ this.getAmortizacion();
		s = s +"</li>";	
		s = s+nuevalinea2;
		s = s +"<li>";
		s = s+"Interes "+ this.getInteres();
		s = s +"</li>";
		s = s+nuevalinea2;
		s = s +"<li>";
		s = s+"Saldo Deuda "+ this.getSaldoDeuda();
 	 	s = s +"</li>";	
		s = s+nuevalinea2;
 	 	s = s +"<li>";
 	 	s = s+"Seguro "+ this.getSeguro();
	 	s = s +"</li>";	
		s = s+nuevalinea2;
 	 	s = s +"<li>";
 	 	s = s+"Gastos "+ this.getGastoTotal();
 	 	s = s +"</li>";	
		s = s+nuevalinea2;
		s = s +"<li>";
		s = s+"Valor Cuota "+ this.getMontoCuota();
		s = s +"</li>";	
		s = s+nuevalinea2;
 	 	s = s +"<li>";
 	 	s = s+"Valor Total Cuota "+ this.getValorTotalCuota();
 	 	s = s +"</li>";	
 	 	s = s+nuevalinea2;
 	 	s = s +"<li>";
 	 	s = s+"Fecha de Pago "+ this.getFechaDePago();
 	 	s = s +"</li>";	
 	 	s = s+nuevalinea2;
 	 	s = s +"<li>";
 	 	s = s+"Interes por Mora "+ this.getInteresPorMora();
 	 	s = s +"</li>";
		s = s+nuevalinea2;
		return s;
	}
	
}

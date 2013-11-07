package prestamos;

import installment.calculator.exceptions.InstallmentCountException;
import installment.calculator.exceptions.InvalidAmountException;

import java.util.Date;
import java.util.List;
import java.util.Observable;
import java.util.Vector;

import cuotaEstados.Vencida;
import otros.*;
import estadoPrestamos.*;
import gastos.Gasto;

public class Prestamo extends Observable {

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
	/**
	 * @param cliente
	 * @param montoTotal
	 * @param cantCuotas
	 * @param fechaDeCreacion
	 * @param configuracionPrestamo
	 * @param configGeneral
	 * @throws InstallmentCountException
	 * @throws InvalidAmountException
	 */
	public Prestamo(Cliente cliente, double montoTotal, Integer cantCuotas, Date fechaDeCreacion, ConfiguracionPrestamo configuracionPrestamo, ConfiguracionGeneral configGeneral) throws InstallmentCountException, InvalidAmountException{
		this.setCliente(cliente);
		this.setMontoTotal(montoTotal);
		this.setFechaDeCreacion(fechaDeCreacion);
		this.setConfiguracionPrestamo(configuracionPrestamo);
		this.setConfiguracionGeneral(configGeneral);
		this.setEstado(new Solicitado());
		try{
			this.setCuotas(this.crearCuotas(montoTotal,cantCuotas,configuracionPrestamo, configGeneral,fechaDeCreacion));
			this.calcularGastoYSeguro();
		}
		catch(InstallmentCountException exception){
			System.out.println(exception.getMessage());
		}
		catch(InvalidAmountException exception){
			System.out.println(exception.getMessage());
		}
	}
	/**
	 * Usar este constructor solo cuando quieran saber el valor de la cuota.
	 * @param montoTotal
	 * @param cantCuotas
	 * @param configGeneral
	 */
	public Prestamo(double montoTotal, Integer cantCuotas,ConfiguracionGeneral configGeneral){
		this.setMontoTotal(montoTotal);
		this.setConfiguracionGeneral(configGeneral);
		List<Cuota> cuotas = new Vector<Cuota>();
		for(int i = 0 ; i < cantCuotas ; i++){
			Cuota c = new Cuota();
			cuotas.add(c);			
		}
	}
	
	public double consultarValorCuota(){
		Integer temCorrespondiente = this.consultarTem();
		Integer cantCuotas = this.cantidadDeCuotas();
		try{
		return CalculoValorCuota.calcularCuota(this.getMontoTotal(),temCorrespondiente, cantCuotas);
		}
		catch(InstallmentCountException exception){
			System.out.println(exception.getMessage());
			return 0;
		}
		catch(InvalidAmountException exception){
			System.out.println(exception.getMessage());
			return 0;
		}
		
	}
	
	
	/**
	 * PagarCuota: realiza el pago de la primer cuota no paga que puede estar en 
	 * cualquier estado.
	 */
	public void pagarCuota(Date fechaDelPago){
		// mirar estados!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		for(Cuota c : this.getCuotas()){
			if(!c.estaPaga()){
				c.pagar(fechaDelPago);
				break; // mirar!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
			}
		}
	}
	/**
	 * CalcularGasto suma las gastos mensuales para pasarselos a las cuotas y decrementa el montoTotal si el gasto es Global
	 * ademas como ya las cuotas conocen sus gastos este agrega a la cuota el interes por mora y el valor total de la cuota.
	 */
	public void calcularGastoYSeguro(){
		this.getConfiguracionGeneral().calcularGasto(this);
		this.getConfiguracionPrestamo().calcularGasto(this);
		this.getConfiguracionPrestamo().calcularSeguro(this);
		this.agregarValorTotalACuotas();
		this.agregarACuotasInteresPorMora();
		
	}
	
	public double calcularCuota(double montoTotal, Integer temCorrespondiente, Integer cantCuotas) throws InstallmentCountException, InvalidAmountException{
		return CalculoValorCuota.calcularCuota(montoTotal,temCorrespondiente, cantCuotas);	
	}
	
	public List<Cuota> cuadroDeMarcha(){
		return this.getCuotas();
	}
	
	public double calcularSaldoDeuda(Integer nroCuota){
		return this.getCuotas().get(nroCuota).getSaldoDeuda();	
	}
	
	@SuppressWarnings("deprecation")
	public List<Cuota> crearCuotas(double montoTotal,Integer cantCuotas,ConfiguracionPrestamo configuracionPrestamo, ConfiguracionGeneral configuracionGeneral, Date fechaActual) throws InstallmentCountException, InvalidAmountException{
		List<Cuota> ret = new Vector<Cuota>();
		
		Date fechaVencimiento= this.calcularFecha(fechaActual);
	
		double monto = montoTotal;
		
		double montoCuota = this.calcularCuota(montoTotal,configuracionGeneral.consultarTem(cantCuotas), cantCuotas);
		
		for(int i = 0 ; i < cantCuotas; i++){
			
			fechaVencimiento = new Date(fechaActual.getYear(),fechaActual.getMonth()+i, 10);
			
			double interes = this.calcularInteres(monto, this.getConfiguracionGeneral().consultarTem(cantCuotas));
			
			double amortizacion = this.calcularAmortizacion(montoCuota,interes);
			
			double saldoDeuda = this.calcularSaloDeuda(monto, amortizacion);
			
			Cuota c = new Cuota(fechaVencimiento, montoCuota,(Integer)i,amortizacion,interes,saldoDeuda);
			
			monto = saldoDeuda;
			
			ret.add(c);
		}

		return ret;
	}
	
	public double calcularInteres(double montoTotal, Integer valorTemCorrespondiente){
		return montoTotal * (valorTemCorrespondiente);		
	}
	
	public double calcularAmortizacion(double valorCuota, double interes){
		return valorCuota - interes;	
	}
	
	public double calcularSaloDeuda(double montoTotal, double amortizacion){
		return montoTotal - amortizacion;
	}
	
	/**
	 * 
	 * @param fechaActual
	 * @return la fecha en la cual se crea la primer cuota.
	 */
	@SuppressWarnings("deprecation")
	public Date calcularFecha(Date fechaActual){
		Date nuevaFecha = new Date(fechaActual.getYear(),fechaActual.getMonth()+2, 10);
		
		if(fechaActual.before(new Date(fechaActual.getYear(),fechaActual.getMonth(), 15))){
			nuevaFecha = new Date(fechaActual.getYear(),fechaActual.getMonth()+1, 10);
		}
		return nuevaFecha;
	}
	
	
	/**
	 * @param fechaActual 
	 * chequea todas sus cuotas si estas se encuentran vencidas.
	 */
	public void verificarFechaDeCuotas(Date fechaActual){
		for(Cuota c : this.getCuotas()){
			c.verificarFecha(fechaActual);
		}
		
	}
	
	public Integer consultarTem(){
		return this.getConfiguracionGeneral().consultarTem(this.cantidadDeCuotas());
	}
	
	public void agregarACuotasInteresPorMora(){
		Integer tem = this.consultarTem();
		for(Cuota c : this.getCuotas()){
			c.setInteresPorMora(c.getValorTotalCuota()* tem);
		}
	}
	
	
	public void agregarValorTotalACuotas(){
		for(Cuota c : this.getCuotas()){
			c.setValorTotalCuota(c.getSeguro()+ c.getGastoTotal()+ c.getMontoCuota());
		}
		
		
	}
	
	public boolean estanTodasLasCuotasPagas(){
		
		boolean estanTodasPagas= true;
		
		for(Cuota c: this.getCuotas()){
			if(c.getEstadoCuota().equals(new Vencida())){
				return false;
			}
		}	
		return estanTodasPagas;	
	}
	
	
	public void actualizarGastos(double gastos){
		this.setMontoTotal(gastos);
		
	}
	
	public Integer obtenerDniCliente(){
		return this.getCliente().getDni();
	}
	

	public String obtenerApellidoCliente(){
		return this.getCliente().getApellido();
	}

	public void finalizarPrestamo(){
	
		if(this.estanTodasLasCuotasPagas()){
			
			this.setEstado(new Finalizado());
		}
	}
}

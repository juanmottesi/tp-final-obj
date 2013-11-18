package prestamos;

import installment.calculator.exceptions.InstallmentCountException;
import installment.calculator.exceptions.InvalidAmountException;

import java.util.GregorianCalendar;
import java.util.List;
import java.util.Observable;
import java.util.Vector;

import cliente.Cliente;
import otros.*;
import estadoCuotas.APagar;
import estadoCuotas.Vencida;
import estadoPrestamos.*;
import exceptions.AprobadoException;
import exceptions.EnCursoException;
import exceptions.EnDeudaException;
import exceptions.EstadoClienteException;
import exceptions.EstadoCuotaException;
import exceptions.FinalizadoException;
import exceptions.RechazadoException;

/**
 * Al crear un prestamo genera automaticamente las cuotas necesarias segun lo pedido. Esto tambien genera 
 * los gastos automaticamente
 * 
 * @author juan
 *
 */

public class Prestamo extends Observable {

	private EstadoPrestamo estado;
	private List<Cuota> cuotas; 
	private Cliente cliente;
	private double montoTotal;
	private ConfiguracionPrestamo configuracionPrestamo;
	private GregorianCalendar fechaDeCreacion;
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

	public GregorianCalendar getFechaDeCreacion() {
		return fechaDeCreacion;
	}

	public void setFechaDeCreacion(GregorianCalendar fechaDeCreacion) {
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
	// Metodos de creacion
	
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
	public Prestamo(Cliente cliente, double montoTotal, Integer cantCuotas, GregorianCalendar fechaDeCreacion, ConfiguracionPrestamo configuracionPrestamo, ConfiguracionGeneral configGeneral) throws InstallmentCountException, InvalidAmountException{
		this.setCliente(cliente);
		this.setMontoTotal(montoTotal);
		this.setFechaDeCreacion(fechaDeCreacion);
		this.setConfiguracionPrestamo(configuracionPrestamo);
		this.setConfiguracionGeneral(configGeneral);
		this.setEstado(new Solicitado());
		this.setCuotas(this.crearCuotas(montoTotal,cantCuotas,configuracionPrestamo, configGeneral,fechaDeCreacion));
		this.calcularGastoYSeguro();
	}
	
	public Prestamo() {
		super();
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
		this.setCuotas(cuotas);
	}

	
	//Metodos que complementan la creacion
	/**
	 * CalcularGastoYSeguro suma las gastos mensuales para pasarselos a las cuotas y decrementa el montoTotal si el gasto es Global
	 * ademas como ya las cuotas conocen sus gastos este agrega a la cuota el interes por mora, el valor total de la cuota y el seguro.
	 */
	private void calcularGastoYSeguro(){
		this.getConfiguracionGeneral().calcularGasto(this);
		this.getConfiguracionPrestamo().calcularGasto(this);
		this.getConfiguracionPrestamo().calcularSeguro(this);
		this.agregarValorTotalACuotas();
		this.agregarACuotasInteresPorMora();
		
	}
	
	
	private List<Cuota> crearCuotas(double montoTotal,Integer cantCuotas,ConfiguracionPrestamo configuracionPrestamo, ConfiguracionGeneral configuracionGeneral, GregorianCalendar fechaActual) throws InstallmentCountException, InvalidAmountException{
		List<Cuota> ret = new Vector<Cuota>();
		
		GregorianCalendar fechaVencimiento= this.calcularFecha(fechaActual);
	
		double monto = montoTotal;
		
		double montoCuota = this.calcularCuota(montoTotal,configuracionGeneral.consultarTem(cantCuotas), cantCuotas);
		
		for(int i = 0 ; i < cantCuotas; i++){
			
			fechaVencimiento = new GregorianCalendar(fechaActual.get(1),fechaActual.get(2)+i, 10);
			
			double interes = this.calcularInteres(monto, this.getConfiguracionGeneral().consultarTem(cantCuotas));
			
			double amortizacion = this.calcularAmortizacion(montoCuota,interes);
			
			double saldoDeuda = this.calcularSaloDeuda(monto, amortizacion);
			
			Cuota c = new Cuota(fechaVencimiento, montoCuota,(Integer)i,amortizacion,interes,saldoDeuda);
			
			monto = saldoDeuda;
			
			ret.add(c);
		}

		return ret;
	}

	/**
	 * @param fechaActual
	 * @return la fecha en la cual se crea la primer cuota.
	 */
	
	private GregorianCalendar calcularFecha(GregorianCalendar fechaActual){
		GregorianCalendar nuevaFecha = new GregorianCalendar(fechaActual.get(1),fechaActual.get(2)+2, 10);
		
		if(fechaActual.before(new GregorianCalendar(fechaActual.get(1),fechaActual.get(2), 15))){
			nuevaFecha = new GregorianCalendar(fechaActual.get(1),fechaActual.get(2)+1, 10);
		}
		return nuevaFecha;
	}
	
	private double calcularInteres(double montoTotal, Double valorTemCorrespondiente){
		return montoTotal * (valorTemCorrespondiente);		
	}
	
	private double calcularAmortizacion(double valorCuota, double interes){
		return valorCuota - interes;	
	}
	
	private double calcularSaloDeuda(double montoTotal, double amortizacion){
		return montoTotal - amortizacion;
	}
	
	private void agregarACuotasInteresPorMora(){
		Double tem = this.consultarTem();
		for(Cuota c : this.getCuotas()){
			c.setInteresPorMora(c.getValorTotalCuota()* tem);
		}
	}
		
	private void agregarValorTotalACuotas(){
		for(Cuota c : this.getCuotas()){
			c.setValorTotalCuota(c.getSeguro()+ c.getGastoTotal()+ c.getMontoCuota());
		}		
	}
	
	public void actualizarGastos(double montoMasgastos){
	this.setMontoTotal(montoMasgastos);
}
	
	//Metodos de consulta
	
	public double consultarValorCuota(){
		Double temCorrespondiente = this.consultarTem();
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
		
	public Double consultarTem(){
		return this.getConfiguracionGeneral().consultarTem(this.cantidadDeCuotas());
	}
	
	public String obtenerDniCliente(){
		return this.getCliente().obtenerDNI();
	}
	
	public String obtenerApellidoCliente(){
		return this.getCliente().obtenerApellido();
	}

	/**
	 * tengoAlgunaCuotaVencida retorna un booleano si tene alguna cuota vencida.
	 */
	public boolean tengoAlgunaCuotaVencida(){
		for(Cuota c : this.getCuotas()){
			if(c.getEstadoCuota().equals(new Vencida())){
				return true;
			}
		}
		return false;
	}
	
	private void verificarEstado(){
		if(this.estanTodasLasCuotasPagas()){
			this.finalizarPrestamo();
		}
		else{
			this.verificarSiQuendaSinPagarOVencidas();
		}
	}
	
	private void verificarSiQuendaSinPagarOVencidas(){
		if(this.tengoAlgunaCuotaVencida()){
			this.prestamoAEnDeuda();
		}
		else{
			this.prestamoAEnCurso();
		}
	}
	
	private void prestamoAEnCurso(){
		try {
			this.getEstado().aEnCurso(this);
			this.getCliente().aEnCurso();
		} catch (EnCursoException e) {
			System.out.println(e.getMessage());
		}  catch (EstadoClienteException e) {
			System.out.println(e.getMessage());
		}				
	}
	
	private void prestamoAEnDeuda(){
		try {
			this.getEstado().aEnDeuda(this);
			this.getCliente().aEnDeuda();
		} catch (EnDeudaException e) {
			System.out.println(e.getMessage());
		}  catch (EstadoClienteException e) {
			System.out.println(e.getMessage());
		}		
	}
	
	private void finalizarPrestamo(){
		try {
			this.getEstado().finalizar(this);
			this.getCliente().finalizar();				
		} catch (FinalizadoException e) {
			System.out.println(e.getMessage());
		} catch (EstadoClienteException e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * @param fechaActual 
	 * chequea todas sus cuotas si estas se encuentran vencidas.
	 */
	public void verificarFechaDeCuotas(GregorianCalendar fechaActual){
		for(Cuota c : this.getCuotas()){
			try {
				c.verificarFecha(fechaActual);
			} catch (EstadoCuotaException e) {
				System.out.println(e.getMessage());
			}
		}
		this.verificarEstado();
	}
	
	public boolean estanTodasLasCuotasPagas(){		
		for(Cuota c: this.getCuotas()){
			if(c.getEstadoCuota().equals(new Vencida()) || c.getEstadoCuota().equals(new APagar())){
				return false;
			}
		}	
		return true;	
	}
		
	// Metodos usados por el banco
	
	/**
	 * PagarCuota: realiza el pago de la primer cuota no paga que puede estar en 
	 * cualquier estado.
	 * @throws EstadoCuotaException 
	 */
	public void pagarCuota(GregorianCalendar fechaDelPago) throws EstadoCuotaException{
		if(this.getEstado().puedoPagar()){
			for(Cuota c : this.getCuotas()){
				if(!c.estaPaga()){
					c.pagar(fechaDelPago);
					this.verificarEstado();
					break;
				}
			}
		}
	}
	
	public double calcularCuota(double montoTotal, Double temCorrespondiente, Integer cantCuotas) throws InstallmentCountException, InvalidAmountException{
		return CalculoValorCuota.calcularCuota(montoTotal,temCorrespondiente, cantCuotas);	
	}
	
	public List<Cuota> cuadroDeMarcha(){
		return this.getCuotas();
	}
	
	public void aceptarPrestamo() throws AprobadoException{
		this.getEstado().aprobar(this);
	}
	
	public void rechazarPrestamo() throws RechazadoException{
		this.getEstado().rechazar(this);
	}

}

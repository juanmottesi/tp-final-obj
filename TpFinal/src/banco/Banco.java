package banco;


import installment.calculator.exceptions.InstallmentCountException;
import installment.calculator.exceptions.InvalidAmountException;

import java.util.GregorianCalendar;
import java.util.List;
import java.util.Vector;

import cliente.Cliente;
import exceptions.AprobadoException;
import exceptions.EstadoClienteException;
import exceptions.EstadoCuotaException;
import exceptions.RechazadoException;
import busqueda.BusquedaDePrestamo;
import busqueda.Condicion;
import prestamos.ConfiguracionPrestamo;
import prestamos.Prestamo;
import tipoDeImpresion.TipoDeImpresion;
/**
 * Modela la base de datos del banco.
 * @author Juan
 *
 */
public class Banco {
	
	private List<Cliente>clientes;
	private List<Prestamo>prestamos;
	private List<ConfiguracionGeneral> configGeneral;
	private BusquedaDePrestamo busqueda;
	
	public List<Cliente> getClientes() {
		return clientes;
	}
	
	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public List<Prestamo> getPrestamos() {
		return prestamos;
	}
	
	public void setPrestamos(List<Prestamo> prestamos) {
		this.prestamos = prestamos;
	}

	public List<ConfiguracionGeneral> getConfigGeneral() {
		return configGeneral;
	}

	public void setConfigGeneral(List<ConfiguracionGeneral> configGeneral) {
		this.configGeneral = configGeneral;
	}

	public BusquedaDePrestamo getBusqueda() {
		return busqueda;
	}

	public void setBusqueda(BusquedaDePrestamo busqueda) {
		this.busqueda = busqueda;
	}
	
	public Banco(){
		this.setBusqueda(null);
		this.setClientes(new Vector<Cliente>()); 
		this.setConfigGeneral(new Vector<ConfiguracionGeneral>());
		this.setPrestamos(new Vector<Prestamo>());
	}
	
	public void pagarCuota(Prestamo prestamo, GregorianCalendar fechaDelPago){
		try {
			prestamo.pagarCuota(fechaDelPago);
		} catch (EstadoCuotaException e) {
			System.out.println(e.getMessage());
		}
	}
		
	public void aceptarPrestamo(Prestamo p){
		try {
			p.aceptarPrestamo();
		} catch (AprobadoException e) {
			System.out.println(e.getMessage());
		} catch (EstadoClienteException e){
			System.out.println(e.getMessage());
		}
	}
	
	public void rechazarPrestamo(Prestamo p){
		try {
			p.rechazarPrestamo();
		} catch (RechazadoException e) {
			System.out.println(e.getMessage());
		}catch (EstadoClienteException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public List<Prestamo> filtradosPorCondiciones(Condicion condicion){
		this.setBusqueda(new BusquedaDePrestamo(condicion));
		return this.getBusqueda().buscar(this.getPrestamos());
	}
	
	public void generarCuadroDeMarcha(Prestamo prestamo, TipoDeImpresion tipoDeImpresion){
		tipoDeImpresion.generarCuadroDeMarcha(prestamo);
	}
	
	public double consultarPrestamo(double monto, Integer cantCuotas, GregorianCalendar fecha){
		ConfiguracionGeneral configGeneral = this.buscarConfiguracionGeneral(fecha);
		Prestamo  p = new Prestamo(monto, cantCuotas, configGeneral);
		try {
			return p.calcularCuota(monto, configGeneral.consultarTem(cantCuotas), cantCuotas);
		} catch (InstallmentCountException e) {
			System.out.println(e.getMessage());
			return 0;
		} catch (InvalidAmountException e) {
			System.out.println(e.getMessage());
			return 0;
		}
	}
	
	private ConfiguracionGeneral buscarConfiguracionGeneral(GregorianCalendar fecha){
		ConfiguracionGeneral ret = this.getConfigGeneral().get(0);
		for(ConfiguracionGeneral cg : this.getConfigGeneral()){
			if(cg.getFechaInicio().before(fecha) && cg.getFechaFin().after(fecha)){
				ret = cg;
			}
		}
		return  ret;
	}
	
	public void agregarABancoPrestamo(Prestamo prestamo){
		this.getPrestamos().add(prestamo);
	}
	
	public void agregarPrestamo(double monto, Integer cantCuotas, GregorianCalendar fecha, Cliente cliente, ConfiguracionPrestamo configuracionPrestamo){
		if(cliente.puedoAgregarPrestamo()){
			try {
				Prestamo prestamoNuevo = new Prestamo(cliente, monto,cantCuotas,fecha,configuracionPrestamo,this.buscarConfiguracionGeneral(fecha));
				cliente.agregarPrestamo(prestamoNuevo);
				this.agregarABancoPrestamo(prestamoNuevo);
			} catch (InstallmentCountException | InvalidAmountException e) {
				System.out.println(e.getMessage());
			} 
		}
	}
	
	public void agregarConfiguracionGeneral(ConfiguracionGeneral configuracionGeneral){
		if(this.getConfigGeneral().isEmpty()){
			this.getConfigGeneral().add(configuracionGeneral);
		}
		else{
			this.getConfigGeneral().get(this.getConfigGeneral().size()-1).finConfiguracionGeneral(configuracionGeneral.getFechaInicio());
			this.getConfigGeneral().add(configuracionGeneral);
		}
	}

}
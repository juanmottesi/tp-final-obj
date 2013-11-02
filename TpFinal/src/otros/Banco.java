package otros;


import java.util.Date;
import java.util.List;

import busqueda.BusquedaDePrestamo;
import prestamos.Prestamo;

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
	

	public void pagarCuota(Prestamo prestamo, Date fechaDelPago){
		prestamo.pagarCuota(fechaDelPago);
	}
		

	
}

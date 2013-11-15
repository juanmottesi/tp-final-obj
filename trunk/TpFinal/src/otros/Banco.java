package otros;


import java.util.GregorianCalendar;
import java.util.List;

import exceptions.AprobadoException;
import exceptions.RechazadoException;
import busqueda.BusquedaDePrestamo;
import busqueda.Condicion;
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
	
	public void pagarCuota(Prestamo prestamo, GregorianCalendar fechaDelPago){
		prestamo.pagarCuota(fechaDelPago);
	}
		
	public void aceptarPrestamo(Prestamo p){
		try {
			p.aceptarPrestamo();
		} catch (AprobadoException e) {
			e.getMessage();
		}
	}
	
	public void rechazarPrestamo(Prestamo p){
		try {
			p.rechazarPrestamo();
		} catch (RechazadoException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
	}
	
	public List<Prestamo> filtradosPorCondiciones(Condicion condicion){
		
		this.setBusqueda(new BusquedaDePrestamo(condicion));
		
		return this.getBusqueda().buscar(this.getPrestamos());
	}
}

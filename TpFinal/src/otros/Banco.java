package otros;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.GregorianCalendar;
import java.util.List;

import cliente.Cliente;
import exceptions.AprobadoException;
import exceptions.EstadoClienteException;
import exceptions.EstadoCuotaException;
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
	
	public void generarCuadroDeMarchaXMLDe(Prestamo prestamo){
		java.io.BufferedWriter bufferedWriter;
		try {
			String texto = this.cuadroDeMarchaXML(prestamo);
			bufferedWriter = new BufferedWriter(new FileWriter("Prestamo.xml"));
			bufferedWriter.append(texto);
			bufferedWriter.flush();
			
			System.out.print(texto);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private String cuadroDeMarchaXML(Prestamo prestamo){
		String nuevalinea = System.getProperty("line.separator");
		String texto = "<cuadroMarcha>";
		texto = texto + nuevalinea;
		texto = texto + prestamo.genererarCuotasXML();
		return texto+nuevalinea+"</cuadroMarcha>";
	}
	
	
	public void generarCuadroDeMarchaHTMLDe(Prestamo prestamo){
		java.io.BufferedWriter bufferedWriter;
	
		try {
			String texto = this.cuadroDeMarchaHTML(prestamo);
			bufferedWriter = new BufferedWriter(new FileWriter("Prestamo.html"));
			bufferedWriter.append(texto);
			bufferedWriter.flush();
			
			System.out.print(texto);

		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}
	
	private String cuadroDeMarchaHTML(Prestamo prestamo){
		String nuevalinea = System.getProperty("line.separator");
		String texto = "<html lang =\"en\">" + nuevalinea;
		texto = texto + nuevalinea;
		texto = texto + "<head>" + nuevalinea;
		texto = texto + nuevalinea + "    " + "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">"+ nuevalinea;
		texto = texto + nuevalinea + "    " + "<title>Cuadro de Marcha</title>" +nuevalinea;
		texto = texto + nuevalinea + "</head>" + nuevalinea;
		texto = texto + nuevalinea + "<body>" + nuevalinea;
		texto = texto + nuevalinea + "    " +"<div id = \"cuadro\">" + nuevalinea;		
		texto = texto + prestamo.genererarCuotasHTML();
		texto = texto + "    " + "</div>" + nuevalinea;
		texto = texto + nuevalinea + "</div>" + nuevalinea;
		return texto + nuevalinea + "</html>";
	}
}
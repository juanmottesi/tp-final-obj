package Ejemplo;

import java.util.GregorianCalendar;
import java.util.List;
import java.util.Vector;

import prestamos.ConfiguracionPrestamo;
import prestamos.Prestamo;
import seguro.SinSeguroDeVida;
import cliente.Cliente;
import cliente.Persona;
import estadoCliente.EstadoCliente;
import exceptions.EstadoClienteException;
import banco.Banco;
import banco.ConfiguracionGeneral;
import gastos.Fijo;
import gastos.Gasto;
import gastos.GastoGlobal;

public class Ejemplo {

	
	public static void main(String[] args) {
		GregorianCalendar fechaHoy = new GregorianCalendar();
		GregorianCalendar fechaDeCreacionBanco = new GregorianCalendar(fechaHoy.get(1), fechaHoy.get(2), fechaHoy.get(5)-1);
		Banco banco = new Banco();
		List<Gasto> gastosConfiguracionGeneral = new Vector<Gasto>();
		gastosConfiguracionGeneral.add(new GastoGlobal(new Fijo(3)));
		ConfiguracionGeneral configuracionGeneral = new ConfiguracionGeneral(fechaDeCreacionBanco, gastosConfiguracionGeneral);
		configuracionGeneral.agregarClaveValorATem(12, 3);
		banco.agregarConfiguracionGeneral(configuracionGeneral);
		Persona primerCliente = new Persona("apellido","nombre","36778000","direccion");
		ConfiguracionPrestamo configuracionPrestamo = new ConfiguracionPrestamo(new SinSeguroDeVida(), gastosConfiguracionGeneral);
		banco.agregarPrestamo(25000, 12, fechaHoy, primerCliente, configuracionPrestamo);
		
		Prestamo primerPrestamo = banco.getPrestamos().get(0);
		banco.aceptarPrestamo(primerPrestamo);
		banco.pagarCuota(primerPrestamo, fechaHoy);
		banco.generarCuadroDeMarchaHTMLDe(primerPrestamo);
		banco.generarCuadroDeMarchaXMLDe(primerPrestamo);
	}
}

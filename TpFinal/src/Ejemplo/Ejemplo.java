package Ejemplo;

import java.util.GregorianCalendar;
import java.util.List;
import java.util.Vector;

import prestamos.ConfiguracionPrestamo;
import prestamos.Prestamo;
import seguro.MontoVariableReal;
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
import gastos.GastoMensual;

public class Ejemplo {

	
	public static void main(String[] args) {
		//Creo dos fechas
		GregorianCalendar fechaHoy = new GregorianCalendar();
		GregorianCalendar fechaDeCreacionBanco = new GregorianCalendar(fechaHoy.get(1), fechaHoy.get(2), fechaHoy.get(5)-1);
		//Creo el banco
		Banco banco = new Banco();
		//Creo una configuracion General
		List<Gasto> gastosConfiguracionGeneral = new Vector<Gasto>();
		gastosConfiguracionGeneral.add(new GastoGlobal(new Fijo(3)));
		ConfiguracionGeneral configuracionGeneral = new ConfiguracionGeneral(fechaDeCreacionBanco, gastosConfiguracionGeneral);
		configuracionGeneral.agregarClaveValorATem(12, 3);
		//Agrego al banco la configuracion general
		banco.agregarConfiguracionGeneral(configuracionGeneral);
		//Creo un cliente
		Persona primerCliente = new Persona("apellido","nombre","36778000","direccion");
		//Creo la configuracion prestamo
		List<Gasto> gastosConfiguracionPrestamo = new Vector<Gasto>();
		gastosConfiguracionPrestamo.add(new GastoMensual(new Fijo(3)));
		ConfiguracionPrestamo configuracionPrestamo = new ConfiguracionPrestamo(new MontoVariableReal(2), gastosConfiguracionPrestamo);
		//Agrego un prestamo al banco y al cliente
		banco.agregarPrestamo(25000, 12, fechaHoy, primerCliente, configuracionPrestamo);
		//me guardo el prestamo en una variable auxiliar
		Prestamo primerPrestamo = banco.getPrestamos().get(0);
		//aceptamos el prestamo 
		banco.aceptarPrestamo(primerPrestamo);
		//generamos el cuadro de marcha html
		banco.generarCuadroDeMarchaHTMLDe(primerPrestamo);
		// pagamos una cuota del prestamo
		banco.pagarCuota(primerPrestamo, fechaHoy);
		//generamos el cuadro de marcha xml
		banco.generarCuadroDeMarchaXMLDe(primerPrestamo);
	}
}

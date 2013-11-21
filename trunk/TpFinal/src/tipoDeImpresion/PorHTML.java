package tipoDeImpresion;

import prestamos.Cuota;

public class PorHTML extends TipoDeImpresion {

	public PorHTML(){
		super();
	}

	@Override
	public String generarCabecera() {
		String nuevalinea = System.getProperty("line.separator");
		String texto = "<html lang =\"en\">" + nuevalinea;
		texto = texto + nuevalinea;
		texto = texto + "<head>" + nuevalinea;
		texto = texto + nuevalinea + "    " + "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">"+ nuevalinea;
		texto = texto + nuevalinea + "    " + "<title>Cuadro de Marcha</title>" +nuevalinea;
		texto = texto + nuevalinea + "</head>" + nuevalinea;
		texto = texto + nuevalinea + "<body>" + nuevalinea;
		texto = texto + nuevalinea + "    " +"<div id = \"cuadro\">" + nuevalinea;	
		return texto;
	}

	@Override
	public String generarFinCabecera() {
		String nuevalinea = System.getProperty("line.separator");
		String texto = "";
		texto = texto + "    " + "</div>" + nuevalinea;
		texto = texto + nuevalinea + "</div>" + nuevalinea;
		return texto + nuevalinea + "</html>";
	}

	@Override
	public String generarCuerpo() {
		String nuevalinea = System.getProperty("line.separator");
		String nuevalinea2 = nuevalinea+"       ";
		String texto = "";
		texto = texto+nuevalinea2+"<ul>";
		return texto;
	}

	@Override
	public String generarFinCuerpo() {
		String nuevalinea = System.getProperty("line.separator");
		String nuevalinea2 = nuevalinea+"       ";
		String texto = "";
		texto = texto+nuevalinea2+"</ul>"+nuevalinea;
		return texto;
	}

	@Override
	public String generarCuota(Cuota cuota) {
		String nuevalinea = System.getProperty("line.separator");
		String nuevalinea2 = nuevalinea+"            ";
		String s = nuevalinea2+"<li>";
		s = s + "Cuota " + cuota.getNroCuota();
		s = s+"</li>";	
		
		return s;
	}

	@Override
	public String generarVencimiento(Cuota cuota) {
		String nuevalinea = System.getProperty("line.separator");
		String nuevalinea2 = nuevalinea+"            ";
		String s = nuevalinea2+"<li>";
		s = s + "Vencimiento " + cuota.mostrarFecha(cuota.getFechaVencimiento());
		s = s+"</li>";	
		
		return s;
	}

	@Override
	public String generarAmortizacion(Cuota cuota) {
		String nuevalinea = System.getProperty("line.separator");
		String nuevalinea2 = nuevalinea+"            ";
		String s = nuevalinea2+"<li>";
		s = s + "Amortizacion " + cuota.getAmortizacion();
		s = s+"</li>";	
		
		return s;
	}

	@Override
	public String generarInteres(Cuota cuota) {
		String nuevalinea = System.getProperty("line.separator");
		String nuevalinea2 = nuevalinea+"            ";
		String s = nuevalinea2+"<li>";
		s = s + "Interes " + cuota.getInteres();
		s = s+"</li>";	
		
		return s;
	}

	@Override
	public String generarSaldoDeuda(Cuota cuota) {
		String nuevalinea = System.getProperty("line.separator");
		String nuevalinea2 = nuevalinea+"            ";
		String s = nuevalinea2+"<li>";
		s = s + "Saldo Deuda " + cuota.getSaldoDeuda();
		s = s+"</li>";	
		
		return s;
	}

	@Override
	public String generarSeguro(Cuota cuota) {
		String nuevalinea = System.getProperty("line.separator");
		String nuevalinea2 = nuevalinea+"            ";
		String s = nuevalinea2+"<li>";
		s = s + "Seguro " + cuota.getSeguro();
		s = s+"</li>";	
		
		return s;
	}

	@Override
	public String generarGastos(Cuota cuota) {
		String nuevalinea = System.getProperty("line.separator");
		String nuevalinea2 = nuevalinea+"            ";
		String s = nuevalinea2+"<li>";
		s = s + "Gastos " + cuota.getGastoTotal();
		s = s+"</li>";	
		
		return s;
	}

	@Override
	public String generarValorCuota(Cuota cuota) {
		String nuevalinea = System.getProperty("line.separator");
		String nuevalinea2 = nuevalinea+"            ";
		String s = nuevalinea2+"<li>";
		s = s + "Valor Cuota " + cuota.getMontoCuota();
		s = s+"</li>";	
		
		return s;
	}

	@Override
	public String generarValorTotalCuota(Cuota cuota) {
		String nuevalinea = System.getProperty("line.separator");
		String nuevalinea2 = nuevalinea+"            ";
		String s = nuevalinea2+"<li>";
		s = s + "Valor Total Cuota " + cuota.getValorTotalCuota();
		s = s+"</li>";	
		
		return s;
	}

	@Override
	public String generarFechaPago(Cuota cuota) {
		String nuevalinea = System.getProperty("line.separator");
		String nuevalinea2 = nuevalinea+"            ";
		String s = nuevalinea2+"<li>";
		s = s + "Fecha de Pago " + cuota.mostrarFecha(cuota.getFechaDePago());
		s = s+"</li>";	
		
		return s;
	}

	@Override
	public String generarInteresPorMora(Cuota cuota) {
		String nuevalinea = System.getProperty("line.separator");
		String nuevalinea2 = nuevalinea+"            ";
		String s = nuevalinea2+"<li>";
		s = s + "Interes Por Mora " + cuota.getInteresPorMora();
		s = s+"</li>";	
		
		return s;
	}

	@Override
	public String nombreArchivo() {
		return "Prestamo.html";
	}

}

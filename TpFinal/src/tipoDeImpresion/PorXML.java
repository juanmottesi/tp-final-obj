package tipoDeImpresion;

import prestamos.Cuota;

public class PorXML extends TipoDeImpresion {

	public PorXML(){
		super();
	}

	@Override
	public String generarCabecera() {
		String nuevalinea = System.getProperty("line.separator");
		String texto = "<cuadroMarcha>";
		texto = texto + nuevalinea;
		return texto;
	}

	@Override
	public String generarFinCabecera() {
		String nuevalinea = System.getProperty("line.separator");
		String texto ="";
		return texto+nuevalinea+"</cuadroMarcha>";
	}

	@Override
	public String generarCuerpo() {
		String nuevalinea = System.getProperty("line.separator");
		String nuevalinea2 = nuevalinea+"    ";
		String texto = "";
		texto = texto + nuevalinea2+"<cuota>";
		return texto;
	}

	@Override
	public String generarFinCuerpo() {
		String nuevalinea = System.getProperty("line.separator");
		String nuevalinea2 = nuevalinea+"    ";
		String texto = "";
		texto = texto + nuevalinea2 + "</cuota>" + nuevalinea;
		return texto;
	}

	@Override
	public String generarCuota(Cuota cuota) {
		String nuevalinea = System.getProperty("line.separator");
		String nuevalinea2 = nuevalinea+"        ";
		String texto = nuevalinea2+"<numero>";
		texto = texto + cuota.getNroCuota();
		texto = texto + "</numero>";
		return texto;
	}

	@Override
	public String generarVencimiento(Cuota cuota) {
		String nuevalinea = System.getProperty("line.separator");
		String nuevalinea2 = nuevalinea+"        ";
		String texto = nuevalinea2+"<vencimiento>";
		texto = texto + cuota.mostrarFecha(cuota.getFechaVencimiento());
		texto = texto + "</vencimiento>";
		return texto;
	}

	@Override
	public String generarAmortizacion(Cuota cuota) {
		String nuevalinea = System.getProperty("line.separator");
		String nuevalinea2 = nuevalinea+"        ";
		String texto = nuevalinea2+"<amortizacion>";
		texto = texto + cuota.getAmortizacion();
		texto = texto + "</amortizacion>";
		return texto;
	}

	@Override
	public String generarInteres(Cuota cuota) {
		String nuevalinea = System.getProperty("line.separator");
		String nuevalinea2 = nuevalinea+"        ";
		String texto = nuevalinea2+"<interes>";
		texto = texto + cuota.getInteres();
		texto = texto + "</interes>";
		return texto;
	}

	@Override
	public String generarSaldoDeuda(Cuota cuota) {
		String nuevalinea = System.getProperty("line.separator");
		String nuevalinea2 = nuevalinea+"        ";
		String texto = nuevalinea2+"<saldodeuda>";
		texto = texto + cuota.getSaldoDeuda();
		texto = texto + "</saldodeuda>";
		return texto;	
	}

	@Override
	public String generarSeguro(Cuota cuota) {
		String nuevalinea = System.getProperty("line.separator");
		String nuevalinea2 = nuevalinea+"        ";
		String texto = nuevalinea2+"<seguro>";
		texto = texto + cuota.getSeguro();
		texto = texto + "</seguro>";
		return texto;	
	}

	@Override
	public String generarGastos(Cuota cuota) {
		String nuevalinea = System.getProperty("line.separator");
		String nuevalinea2 = nuevalinea+"        ";
		String texto = nuevalinea2+"<gastos>";
		texto = texto + cuota.getGastoTotal();
		texto = texto + "</gastos>";
		return texto;
	}

	@Override
	public String generarValorCuota(Cuota cuota) {
		String nuevalinea = System.getProperty("line.separator");
		String nuevalinea2 = nuevalinea+"        ";
		String texto = nuevalinea2+"<valorcuota>";
		texto = texto + cuota.getMontoCuota();
		texto = texto + "</valorcuota>";
		return texto;
	}

	@Override
	public String generarValorTotalCuota(Cuota cuota) {
		String nuevalinea = System.getProperty("line.separator");
		String nuevalinea2 = nuevalinea+"        ";
		String texto = nuevalinea2+"<valortotalcuota>";
		texto = texto + cuota.getValorTotalCuota();
		texto = texto + "</valortotalcuota>";
		return texto;	
	}

	@Override
	public String generarFechaPago(Cuota cuota) {
		String nuevalinea = System.getProperty("line.separator");
		String nuevalinea2 = nuevalinea+"        ";
		String texto = nuevalinea2+"<fechadepago>";
		texto = texto + cuota.mostrarFecha(cuota.getFechaDePago());
		texto = texto + "</fechadepago>";
		return texto;
	}

	@Override
	public String generarInteresPorMora(Cuota cuota) {
		String nuevalinea = System.getProperty("line.separator");
		String nuevalinea2 = nuevalinea+"        ";
		String texto = nuevalinea2+"<interesmora>";
		texto = texto + cuota.getInteresPorMora();
		texto = texto + "</interesmora>";
		return texto;
	}

	@Override
	public String nombreArchivo() {
		return "Prestamo.xml";
	}


}

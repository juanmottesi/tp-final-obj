package tipoDeImpresion;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import prestamos.Cuota;
import prestamos.Prestamo;

public abstract class TipoDeImpresion {

	public void generarCuadroDeMarcha(Prestamo prestamo){
		java.io.BufferedWriter bufferedWriter;
		try {
			bufferedWriter = new BufferedWriter(new FileWriter(this.nombreArchivo()));
			
			bufferedWriter.append(this.imprimir(prestamo));
			bufferedWriter.flush();
			
			System.out.println(this.imprimir(prestamo));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String imprimir(Prestamo prestamo){
		String texto = "";
		texto = texto+ this.generarTexto(prestamo);		
		return texto;
	}
	
	public String generarTexto(Prestamo prestamo){
		String texto = "";
		texto = texto + this.generarCabecera();
		texto = texto + this.generarCuerpo(prestamo);
		texto = texto + this.generarFinCabecera();
		return texto;
	}
	
	public String generarCuerpo(Prestamo prestamo){
		String texto = "";
		
		for(Cuota cuota : prestamo.getCuotas()){
			texto = texto + this.generarCuerpo();
			texto = texto + this.generarInfo(cuota);
			texto = texto + this.generarFinCuerpo();
		}
		
		return texto;
	}
	
	public String generarInfo(Cuota cuota){
		String texto = "";
		texto = texto +this.generarCuota(cuota);
		texto = texto +this.generarVencimiento(cuota);
		texto = texto +this.generarAmortizacion(cuota);
		texto = texto +this.generarInteres(cuota);
		texto = texto +this.generarSaldoDeuda(cuota);
		texto = texto +this.generarSeguro(cuota);
		texto = texto +this.generarGastos(cuota);
		texto = texto +this.generarValorCuota(cuota);
		texto = texto +this.generarValorTotalCuota(cuota);
		texto = texto +this.generarFechaPago(cuota);
		texto = texto +this.generarInteresPorMora(cuota);		
		return texto;
	}
	
	public abstract String  generarCabecera();
	
	public abstract String  generarFinCabecera();
	
	public abstract String  generarCuerpo();
	
	public abstract String  generarFinCuerpo();
	
	public abstract String  generarCuota(Cuota cuota);
	
	public abstract String  generarVencimiento(Cuota cuota);
	
	public abstract String  generarAmortizacion(Cuota cuota);
	
	public abstract String  generarInteres(Cuota cuota);
	
	public abstract String  generarSaldoDeuda(Cuota cuota);
	
	public abstract String  generarSeguro(Cuota cuota);
	
	public abstract String  generarGastos(Cuota cuota);
	
	public abstract String  generarValorCuota(Cuota cuota);
	
	public abstract String  generarValorTotalCuota(Cuota cuota);
	
	public abstract String  generarFechaPago(Cuota cuota);
	
	public abstract String  generarInteresPorMora(Cuota cuota);
	
	public abstract String nombreArchivo();
	
	
}

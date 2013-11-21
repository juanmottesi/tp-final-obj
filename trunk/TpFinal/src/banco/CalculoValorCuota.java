package banco;

import installment.calculator.exceptions.InstallmentCountException;
import installment.calculator.exceptions.InvalidAmountException;
import installment.calculator.model.AdvanceModeInstallment;
/**
 * Modela la creacion del monto de la cuota.
 * 
 * @author Juan
 *
 */
public class CalculoValorCuota {

	public CalculoValorCuota(){
		super();
	}
	
	public static double calcularCuota(double montoTotal, Double temCorrespondiente, Integer cantCuotas) throws InstallmentCountException, InvalidAmountException{
		//(double amount, double interest, int installmentCount);
		return AdvanceModeInstallment.calculateInstallmentValue(montoTotal, temCorrespondiente, cantCuotas);
	}
}

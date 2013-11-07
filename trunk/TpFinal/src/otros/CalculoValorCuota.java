package otros;

import installment.calculator.exceptions.InstallmentCountException;
import installment.calculator.exceptions.InvalidAmountException;
import installment.calculator.model.AdvanceModeInstallment;

public class CalculoValorCuota {

	public CalculoValorCuota(){
		super();
	}
	
	public static double calcularCuota(double montoTotal, Integer temCorrespondiente, Integer cantCuotas) throws InstallmentCountException, InvalidAmountException{
		//(double amount, double interest, int installmentCount);
		return AdvanceModeInstallment.calculateInstallmentValue(montoTotal, temCorrespondiente, cantCuotas);
	}
}

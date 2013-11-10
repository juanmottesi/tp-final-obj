package otros;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import installment.calculator.exceptions.InstallmentCountException;
import installment.calculator.exceptions.InvalidAmountException;
import installment.calculator.model.AdvanceModeInstallment;

import org.junit.Before;
import org.junit.Test;

public class TestCalculoValorCuota {
	
	private CalculoValorCuota calculoValorCuota;
	private Double temCorrespondiente;
	private double montoTotal;
	private Integer cantCuotas;
	
	@Before
	public void setUp(){
		calculoValorCuota = new CalculoValorCuota();
		temCorrespondiente = (3*0.01);
		montoTotal = 20000; 
		cantCuotas = 12;
	}


	
	@Test
	public void testConstructor() {
		assertNotNull(calculoValorCuota);
	}

	@SuppressWarnings("static-access")
	@Test
	public void testCalcularCuotaCasoCorrecto() throws InstallmentCountException, InvalidAmountException{
		AdvanceModeInstallment mockedAdvanceModeInstallment = mock(AdvanceModeInstallment.class);
		calculoValorCuota.calcularCuota(montoTotal, temCorrespondiente, cantCuotas);
		verify(mockedAdvanceModeInstallment).calculateInstallmentValue(montoTotal, temCorrespondiente , cantCuotas);
		
	}
	
	@Test (expected = InvalidAmountException.class)
	public void testCalcularCuotaCasoConMontoTotalIncorrecto() throws InstallmentCountException, InvalidAmountException{
		CalculoValorCuota.calcularCuota(0, temCorrespondiente, cantCuotas);	
	}
	
	@Test (expected = InstallmentCountException.class)
	public void testCalcularCuotaCasoConCantCuotasIncorrecto() throws InstallmentCountException, InvalidAmountException{
		CalculoValorCuota.calcularCuota(montoTotal, temCorrespondiente, 0);	
	}
	
}

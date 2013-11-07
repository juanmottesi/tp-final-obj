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
	
	@Before
	public void setUp(){
		calculoValorCuota = new CalculoValorCuota();
	}


	
	@Test
	public void testConstructor() {
		assertNotNull(calculoValorCuota);
	}

	@SuppressWarnings("static-access")
	@Test
	public void testCalcularCuota() throws InstallmentCountException, InvalidAmountException{
		AdvanceModeInstallment mockedAdvanceModeInstallment = mock(AdvanceModeInstallment.class);
		System.out.println((double)CalculoValorCuota.calcularCuota(20000,(Integer)(3/100), 12));
		verify(mockedAdvanceModeInstallment).calculateInstallmentValue(20000, (3/100), 12);
		
	}
	
}

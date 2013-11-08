package prestamos;
import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import estadoCuotas.Pagada;
import exceptions.EstadoCuotaException;
import exceptions.PagadaException;
import prestamos.Cuota;

public class TestCuota {
	
	private Cuota cuota;
	private Date fechaVencimiento = new Date();
	private Integer nroCuota = 1;
	private double montoCuota = 1833.60;
	private double amortizacion = 1533.60;
	private double interes = 300;
	private double saldoDeuda = 18466.40;
	
	@SuppressWarnings("deprecation")
	@Before
	public void setUp(){
	//(Date , double , Integer , double amortizacion, double interes,double saldoDeuda){
		
		cuota= new Cuota(fechaVencimiento,montoCuota,nroCuota,amortizacion,interes,saldoDeuda);
	}
	
	@Test
	public void testConstructor(){
		assertNotNull(cuota);
		assertEquals("Chequea el nroCuota",nroCuota,cuota.getNroCuota());
		assertEquals("Chequea el montoCuota",montoCuota,cuota.getMontoCuota(),0);
		assertEquals("Chequea el amortizacion",amortizacion,cuota.getAmortizacion(),0);
		assertEquals("Chequea el interes",interes,cuota.getInteres(),0);
		assertEquals("Chequea el saldoDeuda",saldoDeuda,cuota.getSaldoDeuda(),0);
	}
	@Test
	public void testConstructor2(){
		cuota = new Cuota();
		assertNotNull(cuota);		
	}
	
		
	@Test
	public void testEstaPagaConEstadoAPagar() {
		assertFalse(cuota.estaPaga());
	}
	
	@Test
	public void testEstaPagaConEstadoPagada() {
		cuota.setEstadoCuota(new Pagada());
		assertTrue(cuota.estaPaga());
	}
	
	@Test
	public void testEstaPagaConEstadoVencida() throws EstadoCuotaException {
		cuota.aVencido();
		assertFalse(cuota.estaPaga());
	}
	
	@Test 
	public void testPagarConCuotaVencida() throws EstadoCuotaException{
		cuota.aVencido();
		cuota.pagar(new Date());
		assertEquals("Chequea que fecha de pago sea seteada", new Date(), cuota.getFechaDePago());
		assertEquals("Chequea que se cambie el estado", new Pagada(), cuota.getEstadoCuota());
	}

	@Test 
	public void testPagarConCuotaAPagar() throws EstadoCuotaException{
		cuota.pagar(new Date());
		assertEquals("Chequea que fecha de pago sea seteada", new Date(), cuota.getFechaDePago());
		assertEquals("Chequea que se cambie el estado", new Pagada(), cuota.getEstadoCuota());
	}
	
	@Test (expected = PagadaException.class)
	public void testPagarConCuotaPagada() throws EstadoCuotaException{
		cuota.setEstadoCuota(new Pagada());
		cuota.pagar(new Date());
	}
	

}


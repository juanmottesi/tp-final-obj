package estadoCliente;



import java.util.Observable;
import java.util.Observer;

import exceptions.EstadoClienteException;
/**
 * Modela la cantidad de prestamos que tiene en este momento el cliente y el estado.
 * 
 * @author Juan
 *
 */
public class EstadoCliente extends Observable implements Observer{

	private int cantidadPrestamos;
	private Estado estados;

	public int getCantidadPrestamos() {
		return cantidadPrestamos;
	}

	public void setCantidadPrestamos(int cantidadPrestamos) {
		this.cantidadPrestamos = cantidadPrestamos;
	}
	
	public Estado getEstados() {
		return estados;
	}

	public void setEstados(Estado estados) {
		this.estados = estados;
	}
	
	public EstadoCliente(){
		this.setCantidadPrestamos(0);
		this.setEstados(new SinPrestamo());
	}
	
	public boolean puedoAgregarPrestamo(){
		return this.getCantidadPrestamos()<2 && this.getEstados().puedoAgregarPrestamo();
	}
	
	public void aEnDeuda() throws EstadoClienteException{
		this.getEstados().aEnDeuda(this);
	}
	
	public void aEnDeudorIncobrable() throws EstadoClienteException{
		this.getEstados().aEnDeudorIncobrable(this);
	}
	
	public void aEnCurso() throws EstadoClienteException{
		this.getEstados().aEnCurso(this);
	}
	
	public void finalizar() throws EstadoClienteException{
		this.getEstados().finalizar(this);
		this.setChanged();
		if(this.getCantidadPrestamos() == 1){
			this.setCantidadPrestamos(this.getCantidadPrestamos() -1);
			this.notifyObservers(new SinPrestamo());
		}
		else{
			this.setCantidadPrestamos(this.getCantidadPrestamos() -1);
			this.notifyObservers(new EnCurso());
		}
	}
	
	public void solicitar() throws EstadoClienteException{
		this.getEstados().solicitar(this);
		this.notifyObservers(new Solicitado());
	}
	
	public void rechazar() throws EstadoClienteException{
		this.getEstados().rechazar(this);
		if(this.getCantidadPrestamos() == 1){
			this.setCantidadPrestamos(this.getCantidadPrestamos() -1);
			this.notifyObservers(new SinPrestamo());
		}
		else{
			this.setCantidadPrestamos(this.getCantidadPrestamos() -1);
			this.notifyObservers(new EnCurso());
		}
	}
	
	public void aSinPrestamo() throws EstadoClienteException{
		this.getEstados().aSinPrestamo(this);
	}
	
	public void cambiarEstadoA(Estado estado){
		this.setEstados(estado);
	}

	public void seFinalizoUnPrestamo(Estado estado){
		this.setCantidadPrestamos(this.getCantidadPrestamos() -1);
		if(this.getCantidadPrestamos() == 0){
			try {
				this.aSinPrestamo();
			} catch (EstadoClienteException e) {
				System.out.println(e.getMessage());
			}
		}
		else{
			this.cambiarEstadoA(estado);
		}
	}
	
	public void seRechazoUnPrestamo(Estado estado){
		this.setCantidadPrestamos(this.getCantidadPrestamos() -1);
		if(this.getCantidadPrestamos() == 0){
			try {
				this.aSinPrestamo();
			} catch (EstadoClienteException e) {
				System.out.println(e.getMessage());
			}
		}
		else{
			this.cambiarEstadoA(new EnCurso());
		}
	}

	public void agregarPrestamo() throws EstadoClienteException{
		this.setCantidadPrestamos(this.getCantidadPrestamos() +1);
		this.solicitar();
		this.setChanged();
		this.notifyObservers(new Solicitado());
	}

	@Override
	public void update(Observable o, Object arg) {
		this.cambiarEstadoA((Estado) arg);
		this.setChanged();
		this.notifyObservers(arg);
	}
		
}

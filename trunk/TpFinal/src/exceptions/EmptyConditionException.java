package exceptions;

public class EmptyConditionException extends Exception {
	
	public EmptyConditionException(){}
	
	public EmptyConditionException(String mensaje){
		
		System.out.println(mensaje);
		
	}

}

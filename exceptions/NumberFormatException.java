package es.ucm.tp1.supercars.exceptions;

public class NumberFormatException extends CommandParseException{

	public NumberFormatException() {
		super ();
	}
	
	public NumberFormatException(String message) {
		super (message);
	}
	
	public NumberFormatException(Throwable reason) {
		super (reason);
	}
	
	public NumberFormatException(String message,Throwable reason) {
		super (message, reason);
	}
	public NumberFormatException(String message,Throwable reason, boolean enableSupresion,boolean writableStackTrace) {
		super (message, reason, enableSupresion, writableStackTrace);
	}

}

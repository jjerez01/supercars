package es.ucm.tp1.supercars.exceptions;

public class InvalidPositionException extends CommandExecuteException{
	
	public InvalidPositionException() {
		super ();
	}
	
	public InvalidPositionException(String message) {
		super (message);
	}
	
	public InvalidPositionException(Throwable reason) {
		super (reason);
	}
	
	public InvalidPositionException(String message,Throwable reason) {
		super (message, reason);
	}
	public InvalidPositionException(String message,Throwable reason, boolean enableSupresion,boolean writableStackTrace) {
		super (message, reason, enableSupresion, writableStackTrace);
	}
}
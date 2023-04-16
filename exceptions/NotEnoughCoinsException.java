package es.ucm.tp1.supercars.exceptions;

public class NotEnoughCoinsException extends CommandExecuteException{

	public NotEnoughCoinsException() {
		super ();
	}
	
	public NotEnoughCoinsException(String message) {
		super (message);
	}
	
	public NotEnoughCoinsException(Throwable reason) {
		super (reason);
	}
	
	public NotEnoughCoinsException(String message,Throwable reason) {
		super (message, reason);
	}
	
	public NotEnoughCoinsException(String message,Throwable reason, boolean enableSupresion,boolean writableStackTrace) {
		super (message, reason, enableSupresion, writableStackTrace);
	}
}

package es.ucm.tp1.supercars.exceptions;

public class GameException extends Exception{
	
	public GameException() {
		super ();
	}
	
	public GameException(String message) {
		super (message);
	}
	
	public GameException(Throwable reason) {
		super (reason);
	}
	
	public GameException(String message,Throwable reason) {
		super (message, reason);
	}
	public GameException(String message,Throwable reason, boolean enableSupresion,boolean writableStackTrace) {
		super (message, reason, enableSupresion, writableStackTrace);
	}
}

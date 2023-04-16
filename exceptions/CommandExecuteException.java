package es.ucm.tp1.supercars.exceptions;

public class CommandExecuteException extends GameException {

	public CommandExecuteException() {
		super ();
	}
	
	public CommandExecuteException(String message) {
		super (message);
	}
	
	public CommandExecuteException(Throwable reason) {
		super (reason);
	}
	
	public CommandExecuteException(String message,Throwable reason) {
		super (message, reason);
	}
	
	public CommandExecuteException(String message,Throwable reason, boolean enableSupresion,boolean writableStackTrace) {
		super (message, reason, enableSupresion, writableStackTrace);
	}
}

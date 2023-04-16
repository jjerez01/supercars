package es.ucm.tp1.supercars.exceptions;

public class CommandParseException extends GameException {
	
	public CommandParseException() {
		super ();
	}
	
	public CommandParseException(String message) {
		super (message);
	}
	
	public CommandParseException(Throwable reason) {
		super (reason);
	}
	
	public CommandParseException(String message,Throwable reason) {
		super (message, reason);
	}
	public CommandParseException(String message,Throwable reason, boolean enableSupresion,boolean writableStackTrace) {
		super (message, reason, enableSupresion, writableStackTrace);
	}

}

package es.ucm.tp1.supercars.exceptions;

public class InputOutputRecordException extends CommandExecuteException {

	public InputOutputRecordException() {
		super ();
	}
	
	public InputOutputRecordException(String message) {
		super (message);
	}
	
	public InputOutputRecordException(Throwable reason) {
		super (reason);
	}
	
	public InputOutputRecordException(String message,Throwable reason) {
		super (message, reason);
	}
	
	public InputOutputRecordException(String message,Throwable reason, boolean enableSupresion,boolean writableStackTrace) {
		super (message, reason, enableSupresion, writableStackTrace);
	}

}

package es.ucm.tp1.supercars.control.commands;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import es.ucm.tp1.supercars.exceptions.CommandExecuteException;
import es.ucm.tp1.supercars.logic.Game;

public class RecordCommand extends Command {
	
	private static final String NAME = "record";

	private static final String DETAILS = "rec[o]rd";

	private static final String SHORTCUT = "o";

	private static final String HELP = "show level record.";

	public RecordCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}

	@Override
	public boolean execute(Game game) throws CommandExecuteException {
		try(BufferedReader archivo = new BufferedReader(new FileReader("Record.txt"))) {
			String a = archivo.readLine();
			while(a != null ) {
				String divideString[] = a.split(":");
				if(divideString[0].equals(game.getLevel().name())) {
					System.out.println(a);
				}
				a = archivo.readLine();
			}
			
		} catch (IOException ioe) {
			System.out.println("error to dump");
			throw new CommandExecuteException("aaa",ioe);
		}
		return false;
	}
}

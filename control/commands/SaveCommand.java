package es.ucm.tp1.supercars.control.commands;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import es.ucm.tp1.supercars.exceptions.CommandExecuteException;
import es.ucm.tp1.supercars.exceptions.CommandParseException;
import es.ucm.tp1.supercars.logic.Game;
import es.ucm.tp1.supercars.view.GameSerialize;

public class SaveCommand extends Command {
	
	private static final String NAME = "save";

	private static final String DETAILS = "sa[v]e";

	private static final String SHORTCUT = "v";

	private static final String HELP = "Save the state of the game to a file.";

	private String filename;
	
	public SaveCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}

	@Override
	public boolean execute(Game game) throws CommandExecuteException {
		GameSerialize serialize = new GameSerialize(game);
		try (BufferedWriter archivo = new BufferedWriter( new FileWriter(filename))){
			archivo.write(serialize.toString());
			System.out.println("Saved game");
			
		} catch (IOException ioe) {
			System.out.println("error to save");
			throw new CommandExecuteException("aaa",ioe);
		}
		return false;
	}
	@Override
	protected Command parse(String[] commandWords) throws CommandParseException {
		try {
	        if (matchCommandName(commandWords[0])) {
	            if(commandWords.length != 2) {
	                throw new CommandParseException(String.format("[ERROR]: Command %s: %s", NAME, INCORRECT_NUMBER_OF_ARGS_MSG));
	            }
	            else {
	                filename = commandWords[1] + ".txt";
	                return this;
	            }
	
	        }
        return null;

		} catch (CommandParseException ce) {
			System.out.println(ce.getMessage());
			throw new CommandParseException("wrong format"+ '\n');
		}


    }
}

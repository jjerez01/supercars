package es.ucm.tp1.supercars.control.commands;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import es.ucm.tp1.supercars.exceptions.CommandExecuteException;
import es.ucm.tp1.supercars.exceptions.CommandParseException;
import es.ucm.tp1.supercars.logic.Game;

public class DumpCommand extends Command {
	
	private static final String NAME = "dump";

	private static final String DETAILS = "[d]ump";

	private static final String SHORTCUT = "d";

	private static final String HELP = "Shows the content of a saved file";

	private String filename;
	
	public DumpCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}

	@Override
	public boolean execute(Game game) throws CommandExecuteException {
		try(BufferedReader archivo = new BufferedReader(new FileReader(filename))) {
			while(archivo.readLine() != null) {
				System.out.println(archivo.readLine());
			}
			
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
		} catch(CommandParseException cpe) {
			System.out.println(cpe.getMessage());
			throw new CommandParseException("wrong format"+ '\n');
		}

    }
}

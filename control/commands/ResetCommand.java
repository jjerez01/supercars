package es.ucm.tp1.supercars.control.commands;

import es.ucm.tp1.supercars.control.Level;
import es.ucm.tp1.supercars.exceptions.CommandExecuteException;
import es.ucm.tp1.supercars.exceptions.CommandParseException;
import es.ucm.tp1.supercars.logic.Game;


public class ResetCommand extends Command {

	private static final String NAME = "reset";

	private static final String DETAILS = "[r]eset [<level> <seed>]";

	private static final String SHORTCUT = "r";

	private static final String HELP = "reset game";
	
	private static Long seed;
	
	private static String levString;
	
	private static Boolean r1char;

	public ResetCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
		r1char = false;
	}

	@Override
	public boolean execute(Game game) {
		game.clear();
		if(r1char) {
			game.reset1char();
		}else {
			game.reset(Level.valueOfIgnoreCase(levString),seed);
		}
		
		return true;
	}
		
	@Override
	protected Command parse(String[] commandWords) throws CommandParseException {
		try {
			if(matchCommandName(commandWords[0])) {
				if(commandWords.length == 1) {
					r1char = true;
					return this;
				}
				else if(commandWords.length != 3) {
					throw new CommandParseException("incorrect number of arguments");
				}
				else if(Level.valueOfIgnoreCase(commandWords[1]) == null){
					throw new CommandParseException("ERROR, level incorrect");
				}
				else {
					
					levString = commandWords[1];
					seed = Long.parseLong(commandWords[2]);		
					return this;
				}
			}
			return null;
		}catch (NumberFormatException fe) {
			System.out.println(fe.getMessage());
			throw new CommandParseException("Seed format is incorrect" + '\n');
		}catch(CommandParseException ce){
			System.out.println(ce.getMessage());
			throw new CommandParseException("wrong format" + '\n');
		}
	}
}
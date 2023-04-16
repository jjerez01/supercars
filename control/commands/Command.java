package es.ucm.tp1.supercars.control.commands;

import es.ucm.tp1.supercars.exceptions.CommandExecuteException;
import es.ucm.tp1.supercars.exceptions.CommandParseException;
import es.ucm.tp1.supercars.exceptions.GameException;
import es.ucm.tp1.supercars.logic.Game;

public abstract class Command {

	private static final String UNKNOWN_COMMAND_MSG = "Unknown command";

	protected static final String INCORRECT_NUMBER_OF_ARGS_MSG = "Incorrect number of arguments";

	/* @formatter:off */
	protected static final Command[] AVAILABLE_COMMANDS = {
		new HelpCommand(),
		new InfoCommand(),
		new UpdateCommand(),
		new ResetCommand(),
		new GoUpCommand(),
		new GoDownCommand(),
		new ExitCommand(),
		new TestModeCommand(),
		new ShootCommand(),
		new ClearCommand(),
		new GrenadeCommand(),
		new CheatCommand(),
		new WaveCommand(),
		new SerializeCommand(),
		new SaveCommand(),
		new DumpCommand(),
		new RecordCommand(),
		new ExamCommand()
	};
	/* @formatter:on */

	public static Command getCommand(String[] commandWords) throws GameException {
		Command command = null;
		
		for (Command aux : AVAILABLE_COMMANDS) {
			if (command == null) {
				command = aux.parse(commandWords);
			}
		}
		
		if (command == null) { 
			throw new GameException("[ERROR]: " +  UNKNOWN_COMMAND_MSG +"\n"+"\n");
		}
		
		return command;
	}

	private final String name;

	private final String shortcut;

	private final String details;

	private final String help;

	public Command(String name, String shortcut, String details, String help) {
		this.name = name;
		this.shortcut = shortcut;
		this.details = details;
		this.help = help;
	}

	public abstract boolean execute(Game game) throws CommandExecuteException;

	protected boolean matchCommandName(String name) {
		return this.shortcut.equalsIgnoreCase(name) || this.name.equalsIgnoreCase(name);
	}

	protected Command parse(String[] words) throws GameException {
		if (matchCommandName(words[0])) {
			if (words.length != 1) {
				System.out.format("[ERROR]: Command %s: %s%n%n", name, INCORRECT_NUMBER_OF_ARGS_MSG);
				return null;
			} else {
				return this;
			}
		}
		return null;
	}

	protected String getLine() {
		return details + ": " + help;
	}

}
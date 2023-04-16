package es.ucm.tp1.supercars.control.commands;

import es.ucm.tp1.supercars.exceptions.CommandParseException;
import es.ucm.tp1.supercars.logic.Game;
import es.ucm.tp1.supercars.logic.GameObjectGenerator;

public class CheatCommand extends Command{
	
	private static final String NAME = "Cheat";

	private static final String DETAILS = "Cheat [1..5]";

	private static final String SHORTCUT = "[1,2,3,4,5]";

	private static final String HELP = "Removes all elements of last visible column, and adds an Advanced Object";
	
	private static int cheat;

	public CheatCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}
	
	@Override
	public boolean execute(Game game) {
		game.clearColumn(game.getPlayerX() + game.getVisibility()-1);
		//game.clearGOContainer();
		GameObjectGenerator.forceAdvanceObject(game, cheat, game.getPlayerX() + game.getVisibility() - 1 );
		return true;
	}
	
	@Override
	protected Command parse(String[] commandWords) throws CommandParseException {
//		if (commandWords.length != 1) {
//			System.out.println("error, only one character");
//		}
//		else {
//			try {
//				cheat = Integer.parseInt(commandWords[0]);
//				if(cheat < 6 && cheat > 0) {
//					return this;
//				}
//				
//			} catch (NumberFormatException e) {
//				return null;
//			}
//		}
		try {
			if(Integer.parseInt(commandWords[0]) < 7 && Integer.parseInt(commandWords[0]) > 0 ){
				if (commandWords.length != 1) {
					throw new CommandParseException("error, only one character");
				}
				else {
					cheat = Integer.parseInt(commandWords[0]);
					return this;
				}
			}

		} catch (NumberFormatException ne) {

		} catch (CommandParseException ce) {
			System.out.println(ce.getMessage());
			throw new CommandParseException("wrong format"+ '\n');
		}
		return null;


		
	}
}

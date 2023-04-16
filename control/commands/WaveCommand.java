package es.ucm.tp1.supercars.control.commands;

import es.ucm.tp1.supercars.control.Buyable;
import es.ucm.tp1.supercars.exceptions.CommandExecuteException;
import es.ucm.tp1.supercars.exceptions.NotEnoughCoinsException;
import es.ucm.tp1.supercars.logic.Game;
import es.ucm.tp1.supercars.logic.actions.WaveAction;

public class WaveCommand extends Command implements Buyable{
	
	
	private static final String NAME = "Wave";

	private static final String DETAILS = "[w]ave";

	private static final String SHORTCUT = "w";

	private static final String HELP = "do wave";
	
	
	public WaveCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}
	
	@Override
	public boolean execute(Game game) throws CommandExecuteException {
		try {
			buy(game);
			game.execute(new WaveAction());
			game.update("other");
		}
		catch(NotEnoughCoinsException ce) {
			System.out.println("ERROR, not enough coins");
			throw new CommandExecuteException("aaa",ce);
			
		}	
		return true;
	}

	@Override
	public int cost() {
		return 5;
	}
}
	



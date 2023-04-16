package es.ucm.tp1.supercars.control.commands;

import es.ucm.tp1.supercars.control.Buyable;
import es.ucm.tp1.supercars.exceptions.CommandExecuteException;
import es.ucm.tp1.supercars.exceptions.InvalidPositionException;
import es.ucm.tp1.supercars.exceptions.NotEnoughCoinsException;
import es.ucm.tp1.supercars.logic.Game;
import es.ucm.tp1.supercars.logic.gameobjects.Grenade;

public class GrenadeCommand extends Command implements Buyable{
	private static final String NAME = "grenade";

	private static final String DETAILS = "[g]renade <x> <y>";

	private static final String SHORTCUT = "g";

	private static final String HELP = "add a grenade in position x, y";
	
	private int grX;
	
	private int grY;
	
	public GrenadeCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}
	
	@Override
	public boolean execute(Game game) throws CommandExecuteException {
		try {
			if(!game.isEmptyVisiblePosition(grX,grY)) {
				throw new InvalidPositionException("position grenade error");
			}
			try {
				buy(game);
				game.add(new Grenade(game, game.getPlayerX() + grX, grY));
				game.update("other");
			}
			catch(NotEnoughCoinsException ce){
				System.out.println(ce.getMessage());
				throw new CommandExecuteException("cannot put granade" + '\n',ce);
			}
		}
		catch(InvalidPositionException ie) {
			System.out.println(ie.getMessage());
			throw new CommandExecuteException("cannot put granade" + '\n',ie);
		}
		return true;
	}

	@Override
	protected Command parse(String[] commandWords) {
		if(matchCommandName(commandWords[0])) {
			if(commandWords.length != 3) {
				System.out.println("command error");
				return null;
			}
			else {
				try {
					grX = Integer.parseInt(commandWords[1]);
					grY = Integer.parseInt(commandWords[2]);
				}
				catch (NumberFormatException e) {
					System.out.println("no grenade launched");
					return null;
				}
				return this;
			}
		}
		return null;
	}

	@Override
	public int cost() {
		return 3;
	}
}

package es.ucm.tp1.supercars.control;

import es.ucm.tp1.supercars.exceptions.NotEnoughCoinsException;
import es.ucm.tp1.supercars.logic.Game;

public interface Buyable {
	public int cost();
	public default boolean buy(Game game) throws NotEnoughCoinsException{

		if(!game.hasCoins(cost()))  {
			
			throw new NotEnoughCoinsException("no coins");
		}
		else {
			game.addCoins(-cost()); //substracts coins from player
			return true;
		}
	};
}



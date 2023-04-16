package es.ucm.tp1.supercars.logic.actions;

import es.ucm.tp1.supercars.logic.Game;

public class ShootAction implements InstantAction{

	@Override
	public void execute(Game game) {
		int i = game.getPlayerX()+1;
		boolean found = false;
		while(i < game.getVisibility()+ game.getPlayerX() && !found) {
			if(!game.isPositionEmpty(i, game.getPlayerY())) {
				if(game.getColliderInPosition(i, game.getPlayerY()).receiveShoot()) {
					//el game.getCollider te devuelve una referencia de ese objeto
					found = true;
				}
			}
			i++;
		}		
	}
}

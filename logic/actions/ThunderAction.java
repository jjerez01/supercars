package es.ucm.tp1.supercars.logic.actions;

import es.ucm.tp1.supercars.logic.Collider;
import es.ucm.tp1.supercars.logic.Game;
import es.ucm.tp1.supercars.logic.gameobjects.GameObject;

public class ThunderAction implements InstantAction {

	@Override
	public void execute(Game game) {
		int i = game.getRandomIntThunderX();
		int j = game.getRandomIntThunderY();
		
		
		System.out.println("Thunder hit position: " + "( " +  i + " , " + j + " )   ");
		
		Collider C = null;
		if(!game.isPositionEmpty(game.getPlayerX()+i, j)) {
			C = game.getColliderInPosition(game.getPlayerX()+i, j);
			GameObject a = (GameObject) C;
			if(C != null) {
				String obj = a.toString();
				if(C.receiveThunder()) {
					System.out.println("hit -> " + obj);
				}
			}
		}
	}

}


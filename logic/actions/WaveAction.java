package es.ucm.tp1.supercars.logic.actions;

import es.ucm.tp1.supercars.logic.Collider;
import es.ucm.tp1.supercars.logic.Game;

public class WaveAction implements InstantAction{

	@Override
	public void execute(Game game) {
		for(int x = game.getVisibility()-1; x > 0; x--) {
			int relativeX = game.getPlayerX() + x;
			for(int y = 0; y < game.getRoadWidth();y++) {
				Collider c = game.getColliderInPosition(relativeX, y);
				if(c != null) {
					c.receiveWave();
				}
			}	
		}
	}
}

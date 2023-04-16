package es.ucm.tp1.supercars.logic.actions;

import es.ucm.tp1.supercars.logic.Collider;
import es.ucm.tp1.supercars.logic.Game;

public class ExplosionAction implements InstantAction{
	private int x;
	private int y;
	public ExplosionAction(int x, int y) {
		this.x = x;
		this.y = y;
	}
	@Override
	public void execute(Game game) {
		Collider other;
		for(int x = this.x - 1; x <= this.x + 1; x++) {
			for(int y = this.y - 1; y <=  this.y + 1; y++) {
				other = game.getColliderInPosition(x, y);
				if(other != null) {
					other.receiveExplosion();
				}
			}
		}
	}
}

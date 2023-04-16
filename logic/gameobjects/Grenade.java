package es.ucm.tp1.supercars.logic.gameobjects;

import es.ucm.tp1.supercars.logic.Game;
import es.ucm.tp1.supercars.logic.actions.ExplosionAction;

public class Grenade extends GameObject {

	public static final String INFO = "[GRENADE] Explodes in 3 cycles, harming everyone around";
	private static final String GRENADE = "ð";
	
	private static int countDown;
	
	public Grenade(Game game, int x, int y) {
		super(game, x, y);
		symbol = GRENADE;
		countDown = 4;
		alive = true;
	}

	@Override
	public boolean doCollision() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean receiveCollision(Player player) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean receiveShoot() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAlive() {
		return alive;
	}

	@Override
	public void onEnter() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		countDown--;
		if(countDown == 0) {
			onDelete();
		}
		
		
	}

	@Override
	public void onDelete() {
		this.alive = false;
		game.execute(new ExplosionAction (this.x,this.y));
		
	}

	@Override
	public boolean receiveExplosion() {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public String toString() {
		if (isAlive()) {
			return getSymbol() + "[" + countDown + "]";
		}

		return "";
	}

	@Override
	public boolean receiveThunder() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean receiveWave() {
		if(game.isPositionEmpty(x+1,y))
			x++;
		return true;
	}

	@Override
	public String serial() {
		return getSymbol() +"[" + countDown + "]" + "( " + x + "," + y + " )" + countDown;
	}
	
	
}

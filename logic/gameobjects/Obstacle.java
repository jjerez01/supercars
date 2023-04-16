package es.ucm.tp1.supercars.logic.gameobjects;

import es.ucm.tp1.supercars.logic.Game;

public class Obstacle extends GameObject {
	
	public static final String INFO = "[Obstacle] hits car\r\n" + "";
	
	private static final String OBS = "░";
	
	private static int count = 0;
	
	public static int getObstaclesCount() {
		return count;
	}
	
	public static void reset() {
		count = 0;
	}
	
	public Obstacle(Game game, int x, int y) {
		super(game, x, y);
		symbol = OBS;
	}
	
	@Override
	public boolean isAlive() {
		return alive;
	}
	
	@Override
	public void onEnter() {
		count++;
	}

	@Override
	public void onDelete() {
		count--;
	}

	@Override
	public boolean receiveCollision(Player player) {
		if(!player.getTurboCrashException())
			alive = false;
		player.setCrashed();
		
		return true;
	}
	
	@Override
	public boolean doCollision() {
		return false;
	}
	
	@Override
	public void update() {
		
	}

	@Override
	public boolean receiveShoot() {

		alive = false;
		
		return true;
	}

	@Override
	public boolean receiveExplosion() {
		alive = false;
		return true;
	}

	@Override
	public boolean receiveThunder() {
		alive = false;
		return true;
	}

	@Override
	public boolean receiveWave() {
		if(game.isPositionEmpty(x+1,y))
			x++;
		return true;
	}

	@Override
	public String serial() {
		return getSymbol() + "( " + x + "," + y + " )";
	}
}
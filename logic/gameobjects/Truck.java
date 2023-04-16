package es.ucm.tp1.supercars.logic.gameobjects;

import es.ucm.tp1.supercars.logic.Game;

public class Truck extends GameObject {

	public static final String INFO = "[TRUCK] moves towards the player\r\n" + 
			"";
	
	private static final String TRUCK = "←";
	
	public Truck(Game game, int x, int y) {
		super(game, x, y);
		symbol = TRUCK;
		alive = true;
	}

	@Override
	public boolean doCollision() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean receiveCollision(Player player) {
		if(!player.getTurboCrashException())
			alive = false;
		player.setCrashed();
		return true;
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
	public boolean isAlive() {
		// TODO Auto-generated method stub
		return alive;
	}

	@Override
	public void onEnter() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		x--;
		
	}

	@Override
	public void onDelete() {
		// TODO Auto-generated method stub
		
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
		return getSymbol() + "( " + x + "," + y + " )";
	}

}

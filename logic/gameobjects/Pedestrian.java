package es.ucm.tp1.supercars.logic.gameobjects;

import es.ucm.tp1.supercars.logic.Game;

public class Pedestrian extends GameObject{
	
	public static final String INFO = "[PEDESTRIAN] person crossing the road up and down";
	
	private static final String PEDESTRIAN = "☺";

	private Boolean goDown;
	
	public Pedestrian(Game game, int x, int y) {
		super(game, x, y);
		this.y = y;
		symbol = PEDESTRIAN;
		alive = true;
		goDown = true;
	}

	public String getDirection() {
		String ret;
		if(goDown) {
			ret = "Down";
		}
		else {
			ret = "Up";
		}
		return ret;
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
		game.addCoins( - game.playerCoins());
		return true;
	}

	@Override
	public boolean receiveShoot() {
		alive = false;
		game.addCoins( - game.playerCoins());
		return true;
	}

	@Override
	public boolean receiveExplosion() {
		alive = false;
		game.addCoins( - game.playerCoins());
		return true;
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
		
		if(goDown) {
			this.y++;
			if(this.y == game.getRoadWidth()-1) {
				goDown = false;
			}
		}
		else {
			this.y--;
			if(this.y == 0) {
				goDown = true;
			}
		} 
	}

	@Override
	public void onDelete() {
		// TODO Auto-generated method stub
		
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
		return getSymbol() + "( " + x + "," + y + " ) " + getDirection();
	}

}

package es.ucm.tp1.supercars.logic.gameobjects;

import es.ucm.tp1.supercars.logic.Collider;
import es.ucm.tp1.supercars.logic.Game;

public class Player extends GameObject {
	
	private static final String CAR = ">";
	
	private static final String CRASHED = "@";
	
	private int coins;
	
	private boolean crash;
	
	private boolean turboCrashException;
	
	public Player(Game game, int x, int y) {
		super(game, x, y);
		
		symbol = CAR;
		coins = 5;
		crash = false;
		turboCrashException = false;
	}
	
	@Override
	public void update() {
		doCollision();
	}
	
	@Override
	public boolean doCollision() {
		Collider other = game.getColliderInPosition(x, y);
		
		if (other != null) {
			return other.receiveCollision(this);
		}
		
		return true;
	}
	
	public void setCrashed() {
		this.symbol = CRASHED;
		crash = true;
	}
	
	public boolean getCrash() {
		return crash;
	}
	
	public int distanceToGoal() {
		return game.getRoadLength() - x;
	}
	
	public boolean hasArrived() {
		return x == game.getRoadLength() + 1;
	}
	
	public void takeTurbo() {
		this.x += 3;
		turboCrashException = true;
	}
	
	public boolean getTurboCrashException() {
		return turboCrashException;		
	}
	
	public void goUp() {
		if(y > 0) {
			y--;
		}
	}
	
	public void goDown() {
		if (y < (game.getRoadWidth() - 1)) {
			y++;
		}
	}
	public void goFoward() {
		x++;
	}
	
	public void addCoins(int num) {
		coins += num;
	}

	
	public int getCoins() {
		return coins;
	}
	
	@Override
	public boolean isAlive() {
		return alive;
	}
	
	@Override
	public void onDelete() {
		
	}
	
	@Override
	public void onEnter() {
		
	}

	@Override
	public boolean receiveCollision(Player player) {
		return false;
	}

	@Override
	public boolean receiveShoot() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean receiveExplosion() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean receiveThunder() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean receiveWave() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String serial() {
		return getSymbol() + "( " + x + "," + y + " )";
	}

}
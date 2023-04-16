package es.ucm.tp1.supercars.logic.gameobjects;

import es.ucm.tp1.supercars.logic.Game;

public class Wall extends GameObject {
	
	private Game game;

	public static final String INFO = "[WALL] hard obstacle";

	private static final String[] WALL = {" ","░","▒","█"};
	
	private int hp;
	
	public Wall(Game game, int x, int y) {
		super(game,x,y);
		hp = 3;
		symbol = WALL[hp];
		this.game = game;
		
	}
	
	public int getHP() {
		return hp;
	}

	@Override
	public boolean doCollision() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean receiveCollision(Player player) {
		/*if(!player.getTurboCrashException()) {
			hp = 0;
		}*/
		player.setCrashed();
		
		return true;
	}

	@Override
	public boolean isAlive() {
		
		return hp != 0;
	}

	@Override
	public void onEnter() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onDelete() {
		game.addCoins(5);
		
	}


	@Override
	public boolean receiveShoot() {
		hp -= 1; 
		symbol = WALL[hp];
		
		return true;
	}


	@Override
	public boolean receiveExplosion() {
		hp = 0;
		return true;
	}


	@Override
	public boolean receiveThunder() {
		hp = 0;
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
		return getSymbol() + "( " + x + "," + y + " )" + hp;
	}
}

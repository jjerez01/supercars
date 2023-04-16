package es.ucm.tp1.supercars.logic.gameobjects;

import es.ucm.tp1.supercars.logic.Game;

public class SuperCoin extends GameObject {
	
	private Game game;
	
	
	private static boolean placedSC;
	
	public static final String INFO = "[SUPERCOIN] gives 1000 coins";

	private static final String SUPERCOIN = "$";
	
	public SuperCoin(Game game, int x, int y) {
		super(game, x, y);
		symbol = SUPERCOIN;
		this.game = game;
		placedSC = false;
	}

	@Override
	public boolean doCollision() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean receiveCollision(Player player) {
		alive = false;
		game.addCoins(1000);
		return true;
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
		placedSC = true;
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onDelete() {
	
		placedSC = false;
	}

	public static boolean hasSuperCoin() {
		return placedSC;
		
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
		if(game.isPositionEmpty(x+1,y))
			x++;
		return true;
	}

	@Override
	public String serial() {
		return getSymbol() + "( " + x + "," + y + " )";
	}
}

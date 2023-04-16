package es.ucm.tp1.supercars.logic.gameobjects;

import es.ucm.tp1.supercars.logic.Game;

public class examenGO extends GameObject {
	
	public static final String INFO = "[Coin] gives 1 coin to the player";

	private static final String EXAMEN = "H";
	
	public examenGO(Game game, int x, int y) {
		super(game, x, y);
		symbol = EXAMEN;
	}
	
	@Override
	public boolean isAlive() {
		return alive;
	}
	
	@Override
	public void onEnter() {

	}

	@Override
	public void onDelete() {

	}

	@Override
	public boolean receiveCollision(Player player) {
		
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
		if(game.isPositionEmpty(x+1,y))
			x++;
		return true;
	}

	@Override
	public String serial() {
		return  getSymbol() + "( " + x + "," + y + " )";
	}
}

package es.ucm.tp1.supercars.logic;

import es.ucm.tp1.supercars.control.Level;
import es.ucm.tp1.supercars.exceptions.CommandExecuteException;
import es.ucm.tp1.supercars.logic.actions.InstantAction;
import es.ucm.tp1.supercars.logic.gameobjects.GameObject;
import es.ucm.tp1.supercars.logic.gameobjects.GameObjectContainer;
import es.ucm.tp1.supercars.logic.gameobjects.Grenade;
import es.ucm.tp1.supercars.logic.gameobjects.Pedestrian;
import es.ucm.tp1.supercars.logic.gameobjects.Player;
import es.ucm.tp1.supercars.logic.gameobjects.Wall;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;

public class Game {
	
	private static final String FINISH_LINE_SYMBOL = "¦";
	
	private Level level;
	
	private Random rand;
	
	private GameObjectContainer gameObjects;
	
	private Player player;
	
	private boolean testMode;
	
	private boolean doExit;
	
	private boolean forceTheFinish;
	
	private boolean isNewRecord;
	
	private long record;
	
	private int cycle;
	
	private long initTime;

	private Long seed;
	
	public Game (Long seed, Level level) {
		reset(level, seed);
	}
	
	
	public void reset(Level level,Long seed) {
		
		this.level = level;
		this.seed = seed;
		
		gameObjects = new GameObjectContainer();

		testMode = false;

		initTime = System.currentTimeMillis();
			
		GameObjectGenerator.reset(level);
		
		rand = new Random(seed);
		
		player = new Player(this, 0, (level.getWidth() / 2));
		
		cycle = 0;
		
		forceTheFinish = false;
		
		GameObjectGenerator.generateGameObjects(this, level);
	}
	public void reset1char() {
		
		gameObjects = new GameObjectContainer();

		testMode = false;
		
		rand = new Random(seed);

		initTime = System.currentTimeMillis();
			
		GameObjectGenerator.reset(level);
		
		player = new Player(this, 0, (level.getWidth() / 2));
		
		cycle = 0;
		
		forceTheFinish = false;
		
		GameObjectGenerator.generateGameObjects(this, level);
	}
	public void clear() {
		gameObjects.clearobjects();
	}
	
	public void update(String instruction) {
		
		if(instruction == "up") {
			player.update();
			player.goUp();
			player.goFoward();
			GameObjectGenerator.generateRuntimeObjects(this);
			player.update();
		}
		if(instruction == "down") {
			player.update();
			player.goDown();
			player.goFoward();
			GameObjectGenerator.generateRuntimeObjects(this);
			player.update();
		}
		if(instruction == "foward") {
			player.update();
			player.goFoward();
			GameObjectGenerator.generateRuntimeObjects(this);
			player.update();
		}
		if(instruction == "other") {
			player.update();
			GameObjectGenerator.generateRuntimeObjects(this);
		}
		gameObjects.update();
		gameObjects.removeDead();

		cycle++;
	}
	
	public int getRoadWidth() {
		return level.getWidth();
	}
	
	public int getRoadLength() {
		return level.getLength();
	}
	
	public int getVisibility() {
		return level.getVisibility();
	}
	
	public boolean isUserExit() {
		return doExit;
	}
	
	public boolean isFinished() {
		boolean result = false;
		
		if (player.getCrash() || player.hasArrived() || doExit|| forceTheFinish) {
			result = true;
		}
		
		return result;
	}
	
	public void forceFinish() {
		forceTheFinish = true;
	}
	
	public String positionToString(int x, int y) {
		String result = "";
		int relativeX = (player.getX() + x);
		
		if (player.isInPosition(relativeX, y)) {
			result += player.toString() ;
		} if (level.getLength() == relativeX) {
			result += FINISH_LINE_SYMBOL;
		} if(!gameObjects.isPositionEmpty(relativeX, y)) {
			result += gameObjects.getObjectToString(relativeX, y);
		}
		
		return result;
	}
	
	public long elapsedTime() {
		long result = -1;
		
		if (testMode) {
			result = 0;
		} else {
			result = (System.currentTimeMillis() - initTime);
		}
		
		return result;
	}
	
	private double getRandomNumber() {
		return rand.nextDouble();
	}
	
	public int getRandomIntThunderX() {
		return rand.nextInt(level.getVisibility()-1) + 1;
	}
	
	public int getRandomIntThunderY() {
		return rand.nextInt(level.getWidth()-1);
	}
	
	public void add(GameObject object) {
		gameObjects.add(object);
	}
	
	
	public void setUserExit() {
		doExit = true;
	}
	
	public Collider getColliderInPosition(int x, int y) {
		return gameObjects.getColliderInPosition(x, y);
	}
	
	public String getPositionToString(int x, int y) {
		return gameObjects.getPositionToString(x, y);
	}
	
	public boolean isPositionEmpty(int x, int y) {
		return gameObjects.isPositionEmpty(x, y) && !player.isInPosition(x, y);
	}
	
	public void addCoins(int num) {
		player.addCoins(num);
	}
	
	public int getRandomLane() {
		return (int) (rand.nextDouble() * level.getWidth());
	}
	
	public int getPlayerX() {
		return player.getX();
	}
	
	public int getPlayerY() {
		return player.getY();
	}
	
	public void tryToAddObject(GameObject object, double frequency) {
		if (getRandomNumber() < frequency) {
			if (gameObjects.isPositionEmpty(object.getX(), object.getY())) {
				gameObjects.add(object);
			}
		}
	}
	
	public void forceAddObject(GameObject object) {
		gameObjects.add(object);
	}
	
	public void toggleTest() {
		testMode = !testMode;
	}
	
	public boolean isTestMode() {
		return testMode;
	}
	
	public void clearColumn(int i) {
		gameObjects.clearColumn(this,i);
	}
	
	public Level getLevel() {
		return level;
	}
	
	public void doRecord() {
		  Record.loadRecord(this);
	}
	
	public int getCycle() {
		return cycle;
	}
	
	public int playerCoins() {
		return player.getCoins();
	}
	
	public int distanceToGoal() {
		return player.distanceToGoal();
	}
	
	public boolean hasArrived() {
		return player.hasArrived();
	}
	
	public boolean isNewRecord() {
		return isNewRecord;
	}
	
	public boolean execute(InstantAction action) {

		action.execute(this);
		
		return true;
	}
	
	public boolean hasCoins(int cost) {
		if(player.getCoins() - cost >= 0 ) {
			return true;
		}else {
			return false;
		}
	}
	
	public int getRandomVisibleColumn() {
		return -1;
	}
	
	public boolean inVisibleLimits() {
		return false;
	}
	
	public boolean isEmptyVisiblePosition(int x, int y) {
		Boolean ret = false;
		if(gameObjects.isPositionEmpty(x, y) && x < level.getVisibility() && x > 4 && y < level.getWidth() && y >= 0) {
			ret= true;
		}
		return ret;
	}
	
	public void clearGOContainer() {
		gameObjects.clearobjects();
	}
	
	public String doSerialize(int x, int y) {
		return gameObjects.doSerialize(x, y);
	}

	

}
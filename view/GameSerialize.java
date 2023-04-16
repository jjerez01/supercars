package es.ucm.tp1.supercars.view;


import es.ucm.tp1.supercars.control.Level;
import es.ucm.tp1.supercars.logic.Game;
import es.ucm.tp1.supercars.logic.gameobjects.Coin;
import es.ucm.tp1.supercars.logic.gameobjects.Grenade;
import es.ucm.tp1.supercars.logic.gameobjects.Obstacle;
import es.ucm.tp1.supercars.logic.gameobjects.Pedestrian;
import es.ucm.tp1.supercars.logic.gameobjects.SuperCoin;
import es.ucm.tp1.supercars.logic.gameobjects.Truck;
import es.ucm.tp1.supercars.logic.gameobjects.Turbo;
import es.ucm.tp1.supercars.logic.gameobjects.Wall;
import es.ucm.tp1.supercars.utils.StringUtils;

public class GameSerialize {

	private static final String SUPERCOIN_PRESENT = "Supercoin is present";
	
	private static final String DISTANCE_MSG = "Distance: ";

	private static final String COINS_MSG = "Coins: ";

	private static final String CYCLE_MSG = "Cycle: ";

	private static final String TOTAL_OBSTACLES_MSG = "Total obstacles: ";

	private static final String TOTAL_COINS_MSG = "Total coins: ";
	
	private static final String GAME_OBJECTS_MSG = "Game Objects: ";

	private static final String ELAPSED_TIME_MSG = "Elapsed Time: ";

	private static String formatTime(long t) {
		return String.format("%.2f s", t / 1000.0);
	}

	private Game game;
	
	public GameSerialize(Game game) {
		this.game = game;
		
		game.getLevel(); 
		
		//whenLevelChanged(); 
	}

	protected String getInfo() {
		StringBuilder buffer = new StringBuilder();
		/* @formatter:off */
		buffer
		.append(DISTANCE_MSG).append(game.distanceToGoal()).append(StringUtils.LINE_SEPARATOR)
		.append(COINS_MSG).append(game.playerCoins()).append(StringUtils.LINE_SEPARATOR)
		.append(CYCLE_MSG).append(game.getCycle()).append(StringUtils.LINE_SEPARATOR)
		.append(TOTAL_OBSTACLES_MSG).append(Obstacle.getObstaclesCount()).append(StringUtils.LINE_SEPARATOR)
		.append(TOTAL_COINS_MSG).append(Coin.getCoinsCount()).append(StringUtils.LINE_SEPARATOR);
		/* @formatter:on */
		
		if (game.getLevel().hasAdvancedObjects()) {
			if (SuperCoin.hasSuperCoin()) {
				buffer.append(SUPERCOIN_PRESENT);
			}
		}

		if (!game.isTestMode()) {
			/* @formatter:off */
			buffer
			.append(StringUtils.LINE_SEPARATOR)
			.append(ELAPSED_TIME_MSG).append(formatTime(game.elapsedTime()));
			/* @formatter:on */
		}

		return buffer.toString();
	}
	
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder("---- ROAD FIGHTER SERIALIZED ----");

		// Game Status

		str.append(getInfo()).append(StringUtils.LINE_SEPARATOR)
		.append(GAME_OBJECTS_MSG).append(StringUtils.LINE_SEPARATOR);
		
		for(int x = 0; x < game.getRoadLength(); x++) {
			for(int y = 0; y < game.getRoadWidth(); y++) {
				str.append(game.doSerialize(x, y));
			}
		}
		return str.toString();
	}
}

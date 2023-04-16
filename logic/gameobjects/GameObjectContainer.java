package es.ucm.tp1.supercars.logic.gameobjects;

import java.util.ArrayList;
import java.util.List;

import es.ucm.tp1.supercars.logic.Collider;
import es.ucm.tp1.supercars.logic.Game;

public class GameObjectContainer {
	
	private List<GameObject> gameObjects;
	
	public GameObjectContainer() {
		
		gameObjects = new ArrayList<>();
	
	}
	
	public void add(GameObject object) {
		object.onEnter();
		gameObjects.add(object);
	}
	
	public GameObject getObjectInPosition(int x, int y) {
		GameObject result = null;
		
		for (GameObject aux : gameObjects) {
			if (aux.isInPosition(x, y)) {
				result = aux;
			}
		}
		
		return result;
	}
	
	public boolean isPositionEmpty(int x, int y) {
		boolean result = true;
		
		for (GameObject aux : gameObjects) {
			if (result) {
				result = !aux.isInPosition(x, y);
			}
		}
		
		return result;
	}
	
	public String getPositionToString(int x, int y) {
		String result = "";
		
		for (GameObject aux : gameObjects) {
			if (aux.isInPosition(x, y)) {
				result = aux.toString();
			}
		}
		
		return result;
	}
	
	public Collider getColliderInPosition(int x, int y) {
		Collider result = null;
		
		for (GameObject aux : gameObjects) {
			if (aux.isInPosition(x, y)) {
				result = aux;
			}
		}
		
		return result;
	}
	
	public String getObjectToString(int x, int y) {
		String obj = "";
		for(GameObject aux : gameObjects) {
			if(aux.isInPosition(x, y)) {
				obj += aux.toString() + " ";
			}
		}
		return obj;
	}
	
	public void clearobjects() {
        int a = gameObjects.size();
        int i = 0;
        while(i != a) {
            gameObjects.get(0).onDelete();
            gameObjects.remove(0);
            i++;
        }


    }
	
	public void removeDead() {
		List<GameObject> auxList = new ArrayList<>();
		
		for (GameObject aux : gameObjects) {
			if (!aux.isAlive()) {
				auxList.add(aux);
			}
		}
		
		for (GameObject aux : auxList) {
			aux.onDelete();
			gameObjects.remove(aux);
		}
	}
	
	public void clearColumn(Game game,int i) {
		for(int j = 0; j < game.getVisibility(); j++) {
			if (!this.isPositionEmpty(i, j)) {
				gameObjects.remove(this.getObjectInPosition(i, j));
			}
		}
	}
	
	
	
	public void update() {
		for (GameObject aux : gameObjects) {
			aux.update();
		}
	}
	
	public String doSerialize(int x, int y) {
		String serial = "";
		for(GameObject aux : gameObjects) {
			if(aux.isInPosition(x, y)) {
				serial += aux.serial() + "\n"; //cambiar
			}
		}
		return serial;
	}
}
package game;

import game.settings.GameSettings;

public class Game {

	private GameSettings gameSettings;
	
	public Game() {
		gameSettings = new GameSettings();
	}
	
	public GameSettings getGameSettings(){
		return gameSettings;
	}
	
}

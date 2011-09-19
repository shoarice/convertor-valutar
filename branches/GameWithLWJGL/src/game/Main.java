package game;


public class Main {

	public static void main(String[] args) {
		Game game = new Game();
		GameLoop gameLoop = new GameLoop(game);
		
		gameLoop.start();
	}

	

}

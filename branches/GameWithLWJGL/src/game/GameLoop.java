package game;

import game.settings.GameSettings;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;

public class GameLoop extends Thread {

	private Game game;

	public GameLoop(Game game) {
		this.game = game;
	}

	@Override
	public void run() {

		try {
			GameSettings gameSettings = game.getGameSettings();
			
			Display.setDisplayMode(gameSettings.getDisplayMode());
			Display.setFullscreen(game.getGameSettings().getFullscreen());
			Display.setVSyncEnabled(game.getGameSettings().getVsync());
			
			Display.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
		}

		setUpOpenGL();

		while (!Display.isCloseRequested()) {
			render();
			Display.update();
		}
	}

	private void setUpOpenGL() {
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		GL11.glOrtho(0, 800, 600, 0, 1, -1);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
	}

	private void render() {
		// Clear the screen and depth buffer
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
		GL11.glColor3f(0.5f, 0.5f, 1.0f);

		GL11.glBegin(GL11.GL_TRIANGLES);
		GL11.glVertex2f(100, 100);
		GL11.glVertex2f(100 + 200, 100);
		GL11.glVertex2f(100 + 200, 100 + 200);
		GL11.glEnd();
	}
}

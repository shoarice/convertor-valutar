package game;

import static org.lwjgl.opengl.GL11.*;
import game.settings.GameSettings;

import java.nio.FloatBuffer;
import java.util.Random;

import org.lwjgl.BufferUtils;
import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;

public class GameLoop extends Thread {

	private static final long LONG_10E6 = 1000000L;
	private Game game;
	Random rand = new Random();

	float dx = 1.0f, dy = 1.0f;
	float x1 = 10, y1 = 10, x2 = 20, y2 = 20;
	private int width;
	private int height;
	private float xRot;
	private float yRot;
	private float zRot;
	private FloatBuffer sizes = BufferUtils.createFloatBuffer(16);
	private float step;

	public GameLoop(Game game) {
		this.game = game;
		width = game.getGameSettings().getDisplayMode().getWidth();
		height = game.getGameSettings().getDisplayMode().getHeight();

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

		long before = 0, after = 0, delta = 0;
		while (!Display.isCloseRequested()) {
			before = System.nanoTime();
			update();
			render();
			Display.update();

			after = System.nanoTime();

			delta = (after - before) / LONG_10E6;
			if (delta > 0)
				System.out.println("FPS: " + 1000 / delta);
			else
				System.out.println("FPS: " + Double.POSITIVE_INFINITY);

			// System.out.println("before: "+ before/LONG_10E6 +" *** after: "+
			// after/LONG_10E6);
		}
	}

	private void update() {
		if (Keyboard.isKeyDown(Keyboard.KEY_UP))
			xRot -= 1f;
		if (Keyboard.isKeyDown(Keyboard.KEY_DOWN))
			xRot += 1f;
		if (Keyboard.isKeyDown(Keyboard.KEY_RIGHT))
			yRot += 1f;
		if (Keyboard.isKeyDown(Keyboard.KEY_LEFT))
			yRot -= 1f;
		if (Keyboard.isKeyDown(Keyboard.KEY_E))
			zRot -= 5f;
		if (Keyboard.isKeyDown(Keyboard.KEY_Q))
			zRot += 5f;
	}

	private void setUpOpenGL() {
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(-100 * width / height, 100 * width / height, -100, 100, 100,
				-100);

		// glViewport(0, 0, 200, 200);
		glMatrixMode(GL_MODELVIEW);

		// glColor3f(rand.nextFloat(), rand.nextFloat(), rand.nextFloat());
		glColor3f(0f, 1f, 0f);

		glGetFloat(GL_POINT_SIZE_RANGE, sizes);
		step = glGetFloat(GL_POINT_SIZE_GRANULARITY);
		
		//glEnable(GL_LINE_STIPPLE);
		//glLineStipple(5, (short) 0xaaaa);
		glShadeModel(GL_FLAT);
		
	}

	private void render() {
		// Clear the screen and depth buffer
		glClearColor(0f, 0f, 0f, 1f);
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

		/*
		 * if (rand.nextBoolean() && rand.nextBoolean())
		 * glColor3f(rand.nextFloat(), rand.nextFloat(), rand.nextFloat());
		 * 
		 * glRectf(x1, y1,x2, y2);
		 */

		glPushMatrix();
		glRotatef(xRot, 1f, 0f, 0f);
		glRotatef(yRot, 0f, 1f, 0f);
		glRotatef(zRot, 0f, 0f, 1f);

		//drawCone();
		//drawSpokedWheel();
		// drawLines1();
		// drawSpiral();

		glPopMatrix();
	}

	private void drawCone() {
		glEnable(GL_CULL_FACE);
		//glDisable(GL_CULL_FACE);
		glEnable(GL_DEPTH_TEST);
		//glDisable(GL_DEPTH_TEST);
		//glPolygonMode(GL_BACK, GL_LINE);
		//glPolygonMode(GL_BACK, GL_FILL);
		
		float x;
		float y;
		float z;
		float angle;
		int i;
		
		glFrontFace(GL_CW);
		glBegin(GL_TRIANGLE_FAN);
		
		glVertex3f(0f, 0f, 75f); //cone "nose"
		
		z=0f;
		for (i=0,angle = 0f; angle <= 2f * Math.PI + Math.PI / 8f; angle += Math.PI / 20f,i++) {
			x = (float) (50f * Math.sin(angle));
			y = (float) (50f * Math.cos(angle));
			
			if(i % 2 == 0)
				glColor3f(0f, 1f, 0f);
			else
				glColor3f(1f, 0f, 0f);
			
			glVertex3f(x, y, z);
			
		}
		glEnd();
		
		glFrontFace(GL_CCW);
		glBegin(GL_TRIANGLE_FAN);
		
		glVertex2f(0f, 0f); //cone "nose"
		
		z=0f;
		for (i=0,angle = 0f; angle <= 2f * Math.PI + Math.PI / 8f; angle += Math.PI / 20f,i++) {
			x = (float) (50f * Math.sin(angle));
			y = (float) (50f * Math.cos(angle));
			
			if(i % 2 == 0)
				glColor3f(0f, 1f, 0f);
			else
				glColor3f(1f, 0f, 0f);
			
			glVertex3f(x, y, z);
			
		}
		glEnd();
	}

	private void drawSpokedWheel() {
		float x;
		float y;
		float z;
		float angle;
		
		glBegin(GL_LINE_LOOP);
		z = 0f;
		for (angle = 0f; angle <= 2 * Math.PI; angle += Math.PI / 20f) {
			x = (float) (50f * Math.sin(angle));
			y = (float) (50f * Math.cos(angle));

			glVertex3f(x, y, z);

		}
		glEnd();
		
		z = 0f;
		for (angle = 0f; angle <= 2 * Math.PI; angle += Math.PI / 20f) {
			x = (float) (50f * Math.sin(angle));
			y = (float) (50f * Math.cos(angle));
			
			glBegin(GL_LINES);
				glVertex3f(0f, 0f, 0f);
				glVertex3f(x, y, z);
			glEnd();

		}
	}

	private void drawLines1() {
		float x;
		float y;
		float z;
		float angle;

		z = 0f;
		for (angle = 0f; angle <= 2 * Math.PI; angle += Math.PI / 20f) {
			x = (float) (50f * Math.sin(angle));
			y = (float) (50f * Math.cos(angle));

			glBegin(GL_LINES);
				glVertex3f(0f, 0f, 0f);
				glVertex3f(x, y, z);
			glEnd();

		}
	}

	private void drawSpiral() {
		float x;
		float y;
		float z;
		float angle;
		z = -50f;

		int i;
		for (i = 0, angle = 0f; angle <= (2f * Math.PI) * 3f; angle += 0.1, i++) {
			x = (float) (50f * Math.sin(angle));
			y = (float) (50f * Math.cos(angle));

			glPointSize(sizes.get(0) + (step * i));
			glBegin(GL_POINTS);
			glVertex3f(x, y, z);
			glEnd();
			z += 0.5f;
		}

	}
}

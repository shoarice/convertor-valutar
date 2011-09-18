package configurator;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

import javax.swing.JOptionPane;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

public class ConfigModel implements Serializable {

	private static final String FILE = "res/config/settings.properties";

	private static final long serialVersionUID = -7171012141066693905L;

	private DisplayMode[] displayModes;
	private int selectedDisplayMode = -1;
	private boolean vsync;
	private boolean fullscreen;

	public ConfigModel() {
		try {
			displayModes = Display.getAvailableDisplayModes();
			selectedDisplayMode = findDisplayMode(Display.getDisplayMode());
		} catch (LWJGLException e) {
			e.printStackTrace();
		}

		Arrays.sort(displayModes, new DisplayModeComparator());

		loadInfo();
	}

	public int getSelectedDisplayMode() {
		return selectedDisplayMode;
	}

	public void setSelectedDisplayMode(int selectedDisplayMode) {
		if (selectedDisplayMode < displayModes.length) {
			this.selectedDisplayMode = selectedDisplayMode;
		}
	}

	public boolean isVsync() {
		return vsync;
	}

	public void setVsync(boolean vsync) {
		this.vsync = vsync;
	}

	public boolean isFullscreen() {
		return fullscreen;
	}

	public void setFullscreen(boolean fullscreen) {
		this.fullscreen = fullscreen;
	}

	public void setListener(ConfigListener listener) {
		listener.update(this);
	}

	public DisplayMode[] getDisplayModes() {
		return displayModes;
	}

	public void saveInfo(boolean b) {
		Properties prop = new Properties();
		String width = String.valueOf(displayModes[selectedDisplayMode]
				.getWidth());
		String height = String.valueOf(displayModes[selectedDisplayMode]
				.getHeight());
		String depth = String.valueOf(displayModes[selectedDisplayMode]
				.getBitsPerPixel());
		String freq = String.valueOf(displayModes[selectedDisplayMode]
				.getFrequency());
		String vsync = String.valueOf(this.vsync);
		String fullscreen = String.valueOf(this.fullscreen);

		prop.setProperty("width", width);
		prop.setProperty("height", height);
		prop.setProperty("depth", depth);
		prop.setProperty("freq", freq);
		prop.setProperty("vsync", vsync);
		prop.setProperty("fullscreen", fullscreen);

		OutputStream stream = null;
		try {
			stream = new FileOutputStream(FILE);
			prop.storeToXML(stream, "");
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Saved failed", "",
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Saved failed", "",
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		} finally {
			if (stream != null)
				try {
					stream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}

		if(b)
		JOptionPane.showMessageDialog(null, "Saved succesfully", "",
				JOptionPane.PLAIN_MESSAGE);
	}

	private void loadInfo() {
		Properties prop = new Properties();

		try {
			prop.loadFromXML(new FileInputStream(FILE));

			fullscreen = Boolean.parseBoolean(prop.getProperty("fullscreen",
					"false"));
			vsync = Boolean.parseBoolean(prop.getProperty("vsync", "true"));

			int width = Integer.parseInt(prop.getProperty("width", "0"));
			int height = Integer.parseInt(prop.getProperty("height", "0"));
			int depth = Integer.parseInt(prop.getProperty("depth", "0"));
			int freq = Integer.parseInt(prop.getProperty("freq", "0"));

			selectedDisplayMode = findDisplayMode(width, height, depth, freq);
			

		} catch (InvalidPropertiesFormatException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private int findDisplayMode(DisplayMode displayMode) {
		return findDisplayMode(displayMode.getWidth(), displayMode.getHeight(),
				displayMode.getBitsPerPixel(), displayMode.getFrequency());
	}

	private int findDisplayMode(int width, int height, int depth, int freq) {
		for (int i = 0; i < displayModes.length; i++) {
			if (displayModes[i].getWidth() == width
					&& displayModes[i].getHeight() == height
					&& displayModes[i].getBitsPerPixel() == depth
					&& displayModes[i].getFrequency() == freq)
				return i;
		}
		return -1;
	}
}

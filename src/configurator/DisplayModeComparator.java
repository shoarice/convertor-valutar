package configurator;

import java.util.Comparator;

import org.lwjgl.opengl.DisplayMode;

public class DisplayModeComparator implements Comparator<DisplayMode> {

	@Override
	public int compare(DisplayMode displayMode1, DisplayMode displayMode2) {
		if(displayMode1.getWidth() < displayMode2.getWidth())
			return -1;
		else if(displayMode1.getWidth() > displayMode2.getWidth())
			return 1;
		else if(displayMode1.getHeight() < displayMode2.getHeight())
			return -1;
		else if(displayMode1.getHeight() > displayMode2.getHeight())
			return 1;
		else if(displayMode1.getBitsPerPixel() < displayMode2.getBitsPerPixel())
			return -1;
		else if(displayMode1.getBitsPerPixel() > displayMode2.getBitsPerPixel())
			return 1;
		else if(displayMode1.getFrequency() < displayMode2.getFrequency())
			return -1;
		else if(displayMode1.getFrequency() > displayMode2.getFrequency())
			return 1;
		else
			return 0;
	}

}

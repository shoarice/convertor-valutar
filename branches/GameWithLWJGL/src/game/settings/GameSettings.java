package game.settings;

import org.lwjgl.opengl.DisplayMode;

import configurator.ConfigModel;

public class GameSettings {
	private ConfigModel savedConfigModel;
	
	public GameSettings(){
		savedConfigModel = new ConfigModel();
		savedConfigModel.getSelectedDisplayMode();
	}
	
	public DisplayMode getDisplayMode(){
		return savedConfigModel.getSelectedDisplayMode();
	}
	
	public boolean getVsync(){
		return savedConfigModel.isVsync();
	}
	
	public boolean getFullscreen(){
		return savedConfigModel.isFullscreen();
	}
}

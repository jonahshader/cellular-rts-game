package jonahshader.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import jonahshader.game.RTSGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.samples = 3;
		config.foregroundFPS = 144;
		config.width = 1280;
		config.height = 720;
		new LwjglApplication(new RTSGame(), config);
	}
}

package CampusTycoon.UI;

import com.badlogic.gdx.Screen;

public final class ScreenUtils {
	public static Screen currentScreen;
	
	public static Screen startScreen = new StartScreen();
	public static Screen gameplayScreen = new GameplayScreen();
	
	
	public static void openGameplayScreen() {
		currentScreen = gameplayScreen;
	}
}

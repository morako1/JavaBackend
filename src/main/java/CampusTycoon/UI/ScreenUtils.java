package CampusTycoon.UI;

import com.badlogic.gdx.Screen;

public final class ScreenUtils {
	public static Screen currentScreen;
	
	public static Screen startScreen = new StartScreen();
	public static Screen gameplayScreen = new GameplayScreen();
	public static Screen eventScreen = new EventScreen();
	public static Screen endScreen = new EndScreen();
	
	
	public static void openGameplayScreen() {
		currentScreen = gameplayScreen;
	}

	public static void OpenEventScreen() {
		currentScreen = eventScreen;
	}

	public static void CloseEventScreen() {
		currentScreen = gameplayScreen;
	}

	public static void OpenEndScreen() {
		currentScreen = endScreen;
	}
}

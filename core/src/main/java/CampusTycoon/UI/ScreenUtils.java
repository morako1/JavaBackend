package CampusTycoon.UI;

import com.badlogic.gdx.Screen;
import CampusTycoon.GameLogic.Map;

public final class ScreenUtils {
	public static Screen CurrentScreen;
	
	public static void openGameplayScreen() {
		CurrentScreen = new GameplayScreen(new Map());
	}
}

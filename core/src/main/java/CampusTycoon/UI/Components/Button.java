package CampusTycoon.UI.Components;

import java.util.List;
import java.util.function.Consumer;

import CampusTycoon.UI.Component;
import CampusTycoon.UI.ScreenUtils;
import CampusTycoon.InputHandler;
import CampusTycoon.UI.Drawer;

public class Button extends Component {

	public Button(float X, float Y, float Width, float Height) {
		super(X, Y, Width, Height);
	}
	public Button(String imagePath, float X, float Y, float Width, float Height) {
		super(imagePath, X, Y, Width, Height);
	}
	public Button(List<String> imagePaths, float X, float Y, float Width, float Height) {
		super(imagePaths, X, Y, Width, Height);
	}
	
	
	protected static void openStartScreen(Boolean isAction) {
		System.out.println("Screen changed to StartScreen");
	}
	
	protected static void openGameplayScreen(Boolean isAction) {
		ScreenUtils.openGameplayScreen();
		System.out.println("Screen changed to GameplayScreen");
	}

	protected static void openEventScreen(Boolean isAction) {
		ScreenUtils.OpenEventScreen();
		System.out.println("Screen changed to EventScreen");
	}
	
	protected static void closeEventScreen(Boolean isAction) {
		Drawer.clear();
		InputHandler.clear();
		ScreenUtils.CloseEventScreen();
		System.out.println("Closed EventScreen");
	}
	
	@Override
	public void setClickAction(String Action) {
		Consumer<Boolean> action = a -> none(a);
		switch (Action) {
			case Actions.OpenStartScreen:
				action = a -> openStartScreen(a);
				break;
			case Actions.OpenGameplayScreen:
				action = a -> openGameplayScreen(a);
				break;
			case Actions.OpenEventScreen:
				action = a -> openEventScreen(a);
				break;
			case Actions.CloseEventScreen:
				action = a -> closeEventScreen(a);
				break;
			default:
				System.out.println("Invalid action passed to button: " + this.toString());
				break;
		}
		
		clickAction = action;
	}
}
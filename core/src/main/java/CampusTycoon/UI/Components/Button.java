package CampusTycoon.UI.Components;

import java.util.List;
import java.util.function.Consumer;

import CampusTycoon.UI.Component;
import CampusTycoon.UI.ScreenUtils;
import CampusTycoon.GameUtils;
import CampusTycoon.GameLogic.Event;
import CampusTycoon.GameLogic.MapUtils;

public class Button extends Component {
	public int value; // Used to carry information about which button was pressed (i.e. in events)

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
		ScreenUtils.OpenStartScreen();
		System.out.println("Screen changed to StartScreen");
	}

	protected static void openGameplayScreen(Boolean isAction) {
		ScreenUtils.openGameplayScreen();
		System.out.println("Screen changed to GameplayScreen");
	}

    protected static void openLeaderboardScreen(Boolean isAction) {
        ScreenUtils.OpenLeaderboardScreen();
        System.out.println("Screen changed to LeaderboardScreen");
    }

	protected static void openEventPopup(Boolean isAction) {
		GameUtils.currentEvent = new Event();
		System.out.println("Event opened");
	}

	protected static void closeEventPopup(Boolean isAction) {
		GameUtils.currentEvent.eventUI.close();
		System.out.println("Event closed");
	}

	protected void chooseEventOption(Boolean isAction) {
		GameUtils.currentEvent.chooseOption(value);
	}

	protected static void toggleAccommodationBuilding(Boolean isAction) {
		GameUtils.map.toggleBuildingPlacement(MapUtils.Placement.AccommodationBuilding);
		printBuildingChange();
	}

	protected static void toggleStudyBuilding(Boolean isAction) {
		GameUtils.map.toggleBuildingPlacement(MapUtils.Placement.StudyBuilding);
		printBuildingChange();
	}

	protected static void toggleCafeteriaBuilding(Boolean isAction) {
		GameUtils.map.toggleBuildingPlacement(MapUtils.Placement.CafeteriaBuilding);
		printBuildingChange();
	}

	protected static void toggleRelaxationBuilding(Boolean isAction) {
		GameUtils.map.toggleBuildingPlacement(MapUtils.Placement.RelaxationBuilding);
		printBuildingChange();
	}

	protected static void ToggleRestaurantBuilding(Boolean isAction) {
		GameUtils.map.toggleBuildingPlacement(MapUtils.Placement.RestaurantBuilding);
		printBuildingChange();
	}

	private static void printBuildingChange() {
		System.out.println(
				"Toggled building placement mode to: " + GameUtils.map.placing +
						"\nToggled building placement type to: " + GameUtils.map.placementType);
	}

	@Override
	public void setClickAction(String Action) {
		Consumer<Boolean> action = a -> none(a);
		switch (Action) {
			// Screen changes
			case Actions.OpenStartScreen:
				action = a -> openStartScreen(a);
				break;
			case Actions.OpenGameplayScreen:
				action = a -> openGameplayScreen(a);
				break;
            case Actions.OpenLeaderboardScreen:
                action = a -> openLeaderboardScreen(a);
                break;

			// Events
			case Actions.OpenEventPopup:
				action = a -> openEventPopup(a);
				break;
			case Actions.CloseEventPopup:
				action = a -> closeEventPopup(a);
				break;

			case Actions.ChooseEventOption:
				action = a -> chooseEventOption(a);
				break;

			// Building toggles
			case Actions.ToggleAccommodationBuilding:
				action = a -> toggleAccommodationBuilding(a);
				break;
			case Actions.ToggleStudyBuilding:
				action = a -> toggleStudyBuilding(a);
				break;
			case Actions.ToggleCafeteriaBuilding:
				action = a -> toggleCafeteriaBuilding(a);
				break;
			case Actions.ToggleRelaxationBuilding:
				action = a -> toggleRelaxationBuilding(a);
				break;
			case Actions.ToggleRestaurantBuilding:
				action = a -> ToggleRestaurantBuilding(a);
			default:
				System.out.println("Invalid action passed to button: " + this.toString());
				break;
		}
		clickAction = action;
	}

}

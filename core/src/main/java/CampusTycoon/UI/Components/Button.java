package CampusTycoon.UI.Components;

import java.util.List;
import java.util.function.Consumer;

import CampusTycoon.UI.Component;
import CampusTycoon.UI.ScreenUtils;
import CampusTycoon.GameUtils;
import CampusTycoon.InputHandler;
import CampusTycoon.UI.Drawer;
import CampusTycoon.GameLogic.Event;
import CampusTycoon.GameLogic.MapUtils;
import CampusTycoon.GameLogic.SatisfactionMeter;

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
	
	protected static void openEventPopup(Boolean isAction) {
		GameUtils.currentEvent = new Event();
		System.out.println("Event opened");
	}
	protected static void closeEventPopup(Boolean isAction) {
		GameUtils.currentEvent.eventUI.close();
		System.out.println("Event closed");
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
				
			// Events
			case Actions.OpenEventPopup:
				action = a -> openEventPopup(a);
				break;
			case Actions.CloseEventPopup:
				action = a -> closeEventPopup(a);
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
			default:
				System.out.println("Invalid action passed to button: " + this.toString());
				break;
		}
		clickAction = action;
	}

	public void setClickAction(String Action, String buildingType) {	//Action for placing buildings on the map
		Consumer<Boolean> action = a -> none(a);
		switch (Action) {
			case Actions.ToggleRelaxationBuilding: // I don't really know what to use this entire function for
				switch(buildingType) {
					case Actions.ToggleRelaxationBuilding:
						action = a -> openEventPopup(a);
						break;
				}
			break;
			default:
				System.out.println("Invalid action passed to button: " + this.toString());
				break;
		}
		clickAction = action;
	}

		public void setClickAction(String Action, String effect, int value) {	//Action for affecting satisfaction score
		Consumer<Boolean> action = a -> none(a);
		switch (Action) {
			case Actions.CloseEventPopup:
				switch(effect) {
					case Actions.IncreaseSatisfactionScore:
						action = a -> {
							closeEventPopup(a);
							SatisfactionMeter.increaseSatisfactionScore(value);
					};
						break;
					case Actions.DecreaseSatisfactionSccore:
						action = a -> {
							closeEventPopup(a);
							SatisfactionMeter.decreaseSatisfactionScore(value);
					};
						break;
				}
				break;
			default:
				System.out.println("Invalid action passed to button: " + this.toString());
				break;
		}
		clickAction = action;
	}

}
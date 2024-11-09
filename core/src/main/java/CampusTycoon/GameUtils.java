package CampusTycoon;

import java.util.Arrays;
import java.util.List;

import CampusTycoon.GameLogic.Map;
import CampusTycoon.GameLogic.SatisfactionMeter;
import CampusTycoon.UI.Camera;
import CampusTycoon.UI.Component;
import CampusTycoon.UI.Component.Actions;
import CampusTycoon.UI.Component.Anchor;
import CampusTycoon.UI.Drawer;
import CampusTycoon.UI.Components.Button;
import CampusTycoon.UI.Components.MenuText;
import CampusTycoon.GameLogic.BuildingCounter;

public class GameUtils {
	public static Map map;
	
	public static void startGame() {
		map = new Map();
		Camera.map = map;
	}
	
	public static void createStartMenuUI() {
            Button buttonNewGame = new Button("New Game.png", 0, 90, 262, 66);
			buttonNewGame.setClickAction(Actions.OpenGameplayScreen);
            buttonNewGame.setAnchor(Anchor.Centre);

            Button buttonLeaderboard = new Button("Leaderboard.png", 0, 20, 262, 66);
            buttonLeaderboard.setAnchor(Anchor.Centre);

            Button buttonSettings = new Button("Settings.png", 0, -50, 262, 66);
            buttonSettings.setAnchor(Anchor.Centre);
    
    
            List<Component> startScreenButtonList = Arrays.asList(
				buttonNewGame, 
				buttonLeaderboard, 
				buttonSettings);
			
			// Add all buttons to the drawQueue
			for (Component button : startScreenButtonList) {
				// All added to layer '1' (generally on top of most other UI elements)
				Drawer.add(1, button);
			}
			
			// Add all buttons to the InputHandler to allow for interaction handling
			// (Allows buttons to be clicked and things to actually happen)
			InputHandler.add(startScreenButtonList);
	}
	
	public static void createGameplayUI() {
		Button buttonPH1 = new Button("Placeholder.png", -250, 10, 90, 66);
            buttonPH1.setAnchor(Anchor.BottomCentre);

            Button buttonPH2 = new Button("Placeholder.png", -150, 10, 90, 66);
            buttonPH2.setAnchor(Anchor.BottomCentre);

            Button buttonPH3 = new Button("Placeholder.png", -50, 10, 90, 66);
            buttonPH3.setAnchor(Anchor.BottomCentre);
    
            Button buttonRelax = new Button("MissingTexture.png", 50, 10, 90, 66);
			buttonRelax.setClickAction(Actions.PlaceBuilding, Actions.PlaceRelaxationBuilding);	//Temporarily only opens EventScreen
            buttonRelax.setAnchor(Anchor.BottomCentre);											//Just so I can verify the button is actually clicked
    
            Button buttonPH5 = new Button("Placeholder.png", 150, 10, 90, 66);
            buttonPH5.setAnchor(Anchor.BottomCentre);
    
            Button buttonPH6 = new Button("Placeholder.png",250, 10, 90, 66);
            buttonPH6.setAnchor(Anchor.BottomCentre);
    
            Button buttonDollar = new Button("Dollar.png", -300, 0, 70, 66);
            buttonDollar.setAnchor(Anchor.TopCentre);

            Button buttonHouses = new Button("House.png", 0, 0, 70, 66);
            buttonHouses.setAnchor(Anchor.TopCentre);

            Button buttonPeople = new Button("Person.png", 300, 0, 60, 66);
            buttonPeople.setAnchor(Anchor.TopCentre);

            Button notif1 = new Button("ExclamationMark.png", -12, 0, 100, 80);
            notif1.setClickAction(Actions.OpenEventScreen);
            notif1.setAnchor(Anchor.TopLeft);

            Button notif2 = new Button("QuestionMark.png", 0, 80, 80, 80);
            notif2.setClickAction(Actions.OpenEventScreen);
            notif2.setAnchor(Anchor.TopLeft);

            Button buttonSatisfaction = new Button("Satisfaction.png", 100, 10, 200, 66);
            buttonSatisfaction.setAnchor(Anchor.TopRight);
			
			
			List<Component> UIButtons = Arrays.asList(
				buttonPH1, buttonPH2, buttonPH3, buttonRelax, buttonPH5, buttonPH6, 
				notif1, notif2, buttonSatisfaction,
				buttonDollar, buttonHouses, buttonPeople);
			
			// Add all buttons to the drawQueue
			for (Component button : UIButtons) {
				// All added to layer '1' (generally on top of most other UI elements)
				Drawer.add(1, button);
			}
			
			// Add all buttons to the InputHandler to allow for interaction handling
			InputHandler.add(UIButtons);
			
			

            MenuText satisfactionText = new MenuText("" + SatisfactionMeter.getSatisfactionScore() +"", 50, 30, 2f, 2f);
            satisfactionText.setAnchor(Anchor.TopRight);

            MenuText notifText1 = new MenuText("Notification 1", 130, 23, 1.5f, 1.5f);
			notifText1.setAnchor(Anchor.TopLeft);

            MenuText notifText2 = new MenuText ("Notification 2", 135, 105, 1.5f, 1.5f);
            notifText2.setAnchor(Anchor.TopLeft);

			MenuText buildingCounterText = new MenuText("" +BuildingCounter.getBuildingCounter() + "", 70, 25, 2f, 2f);
			buildingCounterText.setAnchor(Anchor.TopCentre);
     
            List<Component> textElements = Arrays.asList(satisfactionText, notifText1, notifText2, buildingCounterText);
			
			// Add all text to the drawQueue
			for (Component text : textElements) {
				// All added to layer '2' (on top of almost all other UI elements)
				Drawer.add(2, text);
			}
			// No need to add text to the InputHandler (unless you really want to be able to click on it for some reason)
	}
}

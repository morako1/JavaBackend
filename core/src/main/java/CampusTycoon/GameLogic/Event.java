package CampusTycoon.GameLogic;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import CampusTycoon.GameLogic.SatisfactionMeter;
import CampusTycoon.GameUtils;
import CampusTycoon.UI.Systems.EventPopup;

public class Event {
	public EventPopup eventUI;
	public int choices; // Number of choices for the event
	public String eventText; // Description of the event
	public List<String> choiceText; // Text to be displayed in the choice buttons
	
	public Event() {
		eventText = "Test event";
		choices = 3;
		choiceText = new ArrayList<String>(Arrays.asList(
			"Accept", "Neutral", "Reject"));
		
		eventUI = new EventPopup(this);
		eventUI.initialise();
	}
	
	// Temporary choice implementations, will change to abstract functions later (as each individual event should decide what the outcome of choices are)
	public void Option1() {
		SatisfactionMeter.increaseSatisfactionScore(4);
		this.End();
	}
	public void Option2() {
		this.End();
	}
	public void Option3() {
		SatisfactionMeter.decreaseSatisfactionScore(4);
		this.End();
	}
	
	public void End() {
		eventUI.close();
		GameUtils.currentEvent = null;
	}
}

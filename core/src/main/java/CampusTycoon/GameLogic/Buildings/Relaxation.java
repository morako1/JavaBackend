package CampusTycoon.GameLogic.Buildings;

import CampusTycoon.GameLogic.BuildingCounter;
import CampusTycoon.GameLogic.Coordinate;

public class Relaxation extends Building {
	public static final String defaultImage = "Buildings\\Relaxation.png";
	public static final String buildingName = "Relaxation";
	
	public Relaxation(Coordinate Position) {
		super(Position, defaultImage, 3 , 3);
	}
	public Relaxation() {
		super(new Coordinate(0, 0), defaultImage, 3 , 3);
	}
	
	
	@Override
	public void incrementBuildingCounter() {
		BuildingCounter.increaseBuildingCounter(buildingName, 1);
	}
}

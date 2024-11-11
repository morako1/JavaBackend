package CampusTycoon.GameLogic.Buildings;

import CampusTycoon.GameLogic.BuildingCounter;
import CampusTycoon.GameLogic.Coordinate;

public class Study extends Building{
	public static final String defaultImage = "Buildings\\Study.png";
	public static final String buildingName = "Study";
	
	public Study(Coordinate Position) {
		super(Position, defaultImage, 3 , 3);
	}
	public Study() {
		super(new Coordinate(0, 0), defaultImage, 3 , 3);
	}
	
	
	@Override
	public void incrementBuildingCounter() {
		BuildingCounter.increaseBuildingCounter(buildingName, 1);
	}
}

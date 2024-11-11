package CampusTycoon.GameLogic.Buildings;

import CampusTycoon.GameLogic.BuildingCounter;
import CampusTycoon.GameLogic.Coordinate;

public class Cafeteria extends Building {
	public static final String defaultImage = "Buildings\\Cafeteria.png";
	public static final String buildingName = "Cafeteria";
	
	public Cafeteria(Coordinate Position) {
		super(Position, defaultImage, 3 , 3);
	}
	public Cafeteria() {
		super(new Coordinate(0, 0), defaultImage, 3 , 3);
	}
	
	
	@Override
	public void incrementBuildingCounter() {
		BuildingCounter.increaseBuildingCounter(buildingName, 1);
	}
}

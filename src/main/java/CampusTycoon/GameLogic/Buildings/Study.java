package CampusTycoon.GameLogic.Buildings;

import CampusTycoon.GameLogic.Coordinate;

public class Study extends Building{
	public static final String defaultImage = "Buildings\\Study.png";
	
	public Study(Coordinate Position) {
		super(Position, defaultImage, 3 , 3);
	}
	public Study() {
		super(new Coordinate(0, 0), defaultImage, 3 , 3);
	}
}

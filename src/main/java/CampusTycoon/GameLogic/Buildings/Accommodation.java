package CampusTycoon.GameLogic.Buildings;

import CampusTycoon.GameLogic.Coordinate;

public class Accommodation extends Building {
	public static final String defaultImage = "Buildings\\Accommodation.png";
	
	public Accommodation(Coordinate Position) {
		super(Position, defaultImage, 3 , 3);
	}
	public Accommodation() {
		super(new Coordinate(0, 0), defaultImage, 3 , 3);
	}
}

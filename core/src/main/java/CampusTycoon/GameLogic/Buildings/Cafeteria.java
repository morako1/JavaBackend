package CampusTycoon.GameLogic.Buildings;

import CampusTycoon.GameLogic.Coordinate;

public class Cafeteria extends Building {
	public static final String defaultImage = "Buildings\\Cafeteria.png";
	
	public Cafeteria(Coordinate Position) {
		super(Position, defaultImage, 3 , 3);
	}
	public Cafeteria() {
		super(new Coordinate(0, 0), defaultImage, 3 , 3);
	}
}

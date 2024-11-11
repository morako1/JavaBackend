package CampusTycoon.GameLogic.Buildings;

import CampusTycoon.GameLogic.Coordinate;

public class Relaxation extends Building {
	public static final String defaultImage = "Buildings\\Relaxation.png";
	
	public Relaxation(Coordinate Position) {
		super(Position, defaultImage, 3 , 3);
	}
	public Relaxation() {
		super(new Coordinate(0, 0), defaultImage, 3 , 3);
	}
}

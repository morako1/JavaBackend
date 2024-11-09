package CampusTycoon.GameLogic.Buildings;

import CampusTycoon.GameLogic.Coordinate;

public class Relaxation extends Building {
	public Relaxation(Coordinate Position) {
		super(Position, "Buildings\\Relaxation.png", 3 , 3);
	}
	public Relaxation() {
		super(new Coordinate(0, 0), "Buildings\\Relaxation.png", 3 , 3);
	}
}

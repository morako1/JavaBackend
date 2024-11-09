package CampusTycoon.GameLogic.Buildings;

import CampusTycoon.GameLogic.Coordinate;

public class Cafeteria extends Building {
	public Cafeteria(Coordinate Position) {
		super(Position, "Buildings\\Cafeteria.png", 3 , 3);
	}
	public Cafeteria() {
		super(new Coordinate(0, 0), "Buildings\\Cafeteria.png", 3 , 3);
	}
}

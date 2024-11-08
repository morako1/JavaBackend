package CampusTycoon.GameLogic.Buildings;

import CampusTycoon.GameLogic.Coordinate;
import CampusTycoon.UI.Component.Anchor;
import CampusTycoon.UI.Components.MapBuilding;

public abstract class Building {
	public MapBuilding drawInfo;
	public Coordinate position;
	public int width, height;
	
	public Building(Coordinate Position) {
		position = Position;
		drawInfo = new MapBuilding(
			"MissingTexture.png", 
			position.x, position.y);
		drawInfo.setAnchor(Anchor.Centre);
	}
	protected Building(Coordinate Position, String ImagePath, int Width, int Height) {
		position = Position;
		drawInfo = new MapBuilding(
			ImagePath, 
			position.x, position.y, 
			Width, Height);
		drawInfo.setAnchor(Anchor.Centre);
	}
}

package CampusTycoon.UI.Components;

import java.util.List;

import CampusTycoon.GameLogic.Tiles.Tile;
import CampusTycoon.UI.Component;

public class MapBuilding extends Component {
	public MapBuilding(String imagePath, float X, float Y, float Width, float Height) {
		super(imagePath, X, Y, Width * Tile.SpriteSize, Height * Tile.SpriteSize);
	}
	public MapBuilding(List<String> imagePaths, float X, float Y, float Width, float Height) {
		super(imagePaths, X, Y, Width * Tile.SpriteSize, Height * Tile.SpriteSize);
	}
	public MapBuilding(String imagePath, float X, float Y) {
		super(imagePath, X, Y, Tile.SpriteSize, Tile.SpriteSize);
	}
	
	
	@Override
	public void setClickAction(String action) {
		throw new UnsupportedOperationException("Unimplemented method 'setClickAction'");
	}
	
}

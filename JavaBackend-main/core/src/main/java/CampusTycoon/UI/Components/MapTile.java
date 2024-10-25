package CampusTycoon.UI.Components;

import CampusTycoon.GameLogic.Coordinate;
import CampusTycoon.GameLogic.Map;
import CampusTycoon.GameLogic.Tiles.Tile;
import CampusTycoon.UI.Component;

public class MapTile extends Component {

	public MapTile(String TilePath, float X, float Y, float Width, float Height) {
		super(TilePath, X, Y, Width, Height);
	}
	
	public abstract class Tiles {
		public static final String Grass = "aaaaa"; // TODO: Figure out what the hell I want to do here and how to implement spritemaps to the main Drawer class
	}
}

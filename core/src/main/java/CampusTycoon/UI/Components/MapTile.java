package CampusTycoon.UI.Components;

import CampusTycoon.UI.Component;
import CampusTycoon.UI.SpriteSheet;

public class MapTile extends Component {

	public MapTile(SpriteSheet SpriteSheet, int TileID, float X, float Y, float Width, float Height) {
		super(SpriteSheet, TileID, X, Y, Width, Height);
	}
	public MapTile(SpriteSheet SpriteSheet, int TileID, float X, float Y) {
		super(SpriteSheet, TileID, X, Y, SpriteSheet.spriteWidth, SpriteSheet.spriteHeight);
	}
	
	
	
	@Override
	public void setClickAction(String action) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'setClickAction'");
	}
	
}

package CampusTycoon.UI.Systems;

import CampusTycoon.GameLogic.Map;
import CampusTycoon.GameLogic.Tiles.Tile;
import CampusTycoon.UI.Drawer;
import CampusTycoon.UI.SpriteSheet;
import CampusTycoon.UI.Component.Anchor;
import CampusTycoon.UI.Components.MapTile;

import java.util.List;

public class MapDisplay {
	public static final int Layer = -2;
	private Map map;
	private SpriteSheet spriteSheet;
	
	public MapDisplay(Map Map) {
		map = Map;
		initialise();
	}
	
	public void drawMap() {
		for (int row = 0; row < map.height; row++) {
			List<Tile> mapRow = map.grid.get(row);
			for (int col = 0; col < map.width; col++) {
				Tile tile = mapRow.get(col);
				MapTile drawTile = new MapTile(
					spriteSheet, 
					tile.getTileID(), 
					getX(col), getY(row));
				drawTile.setAnchor(Anchor.Centre);
				Drawer.add(Layer, drawTile);
			}
		}
	}
	
	private int getX(int x) {
		return spriteSheet.spriteWidth * x;
	}
	
	private int getY(int y) {
		return spriteSheet.spriteHeight * (map.height - y);
	}
	
	private void initialise() {
		spriteSheet = new SpriteSheet("Tiles\\SpriteMap.png", 12, 12, 64, 64);
		// Implementing this is actually gonna be a bit more complicated than I thought because I need to keep performance in mind by limiting which tiles get rendered to be only those visible on camera, which means I need to implement the camera properly first
		// Therefore, this is a function stub (and really a class stub too)
	}
}

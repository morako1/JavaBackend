package CampusTycoon.UI;

import java.util.List;

import CampusTycoon.GameLogic.Coordinate;
import CampusTycoon.GameLogic.Map;
import CampusTycoon.GameLogic.Buildings.Cafeteria;
import CampusTycoon.GameLogic.Tiles.Tile;
import CampusTycoon.UI.Components.MapBuilding;
import CampusTycoon.UI.Components.MapTile;
import CampusTycoon.UI.Systems.BuildingDisplay;
import CampusTycoon.UI.Systems.MapDisplay;

public class Camera {
	public static Map map; // The game map
	public static int gridX, gridY; // Current grid coordinates of the mouse
	public static int x = 0, y = 0; // Current coordinates of the camera
	public static int width = Window.defaultWidth, height = Window.defaultHeight;
	public static float zoom = 1;
	private static final float MinZoom = 0.4f, MaxZoom = 2.5f;
	private static Coordinate lastMousePos = new Coordinate();
	private static Coordinate lastClickPos = null;
	
	public static void update() {
		printCameraInfo();
		updateDrawTiles();
		updateDrawBuildings();
	}
	
	// Calculates which Grid coordinate the mouse is over
	private static float getGridX(int X) {
		float GridX = zoom * (X - x) / (Tile.SpriteSize);
		return GridX;
	}
	private static float getGridY(int Y) {
		float GridY = zoom * (Window.height - Y - y) / (Tile.SpriteSize);
		return GridY;
	}
	
	public static void checkMouseOverTile(int X, int Y) {
		gridX = (int)Math.floor((double)getGridX(X));
		gridY = (int)Math.floor((double)getGridY(Y));
		System.out.println("X: " + X + ", Y: " + Y);
		System.out.println("Grid X: " + gridX + ", Grid Y: " + gridY);
	}

	public static void scroll(float scrollAmount) {
		float oldZoom = zoom;
		zoom += scrollAmount / 10;
		zoom = Math.min(MaxZoom, Math.max(MinZoom, zoom));
		x = Math.round(x * (oldZoom / zoom));
		y = Math.round(y * (oldZoom / zoom));
		update();
	}
	
	private static void placeBuilding() {
		if (ScreenUtils.currentScreen == ScreenUtils.gameplayScreen) {
			map.placeBuilding(new Cafeteria(new Coordinate(gridX, gridY)));
			update();
		}
	}
	
	public static void lift(int X, int Y, int button) {
		// TODO: Add a time based check to this too
		// Check that the mouse has barely moved since clicking
		if (lastClickPos != null && 
		lastClickPos.distance(new Coordinate(X, Y)) < 5) { // 5 is an extremely arbitrary number
			placeBuilding();
		}
	}
	
	public static void click(int X, int Y, int button) {
		lastMousePos = new Coordinate(X, Y);
		lastClickPos = lastMousePos;
	}
	
	public static void drag(int mouseX, int mouseY) {
		x += mouseX - lastMousePos.x;
		y -= mouseY - lastMousePos.y;
		lastMousePos = new Coordinate(mouseX, mouseY);
		update();
	}
	
	private static List<MapTile> getDrawTiles() {
		List<MapTile> components = Drawer.popLayer(MapDisplay.Layer, new MapTile());
		return components;
	}
	
	private static void updateDrawTiles() {
		List<MapTile> tiles = getDrawTiles();
		for (MapTile tile : tiles) { 
			tile.setOffset(x, y);
			tile.setScale(1f / zoom);
			tile.applyZoomOffset();
			Drawer.add(MapDisplay.Layer, tile);
		}
	}
	
	private static void updateDrawBuildings() {
		List<MapBuilding> buildings = Drawer.popLayer(BuildingDisplay.Layer, new MapBuilding());
		for (MapBuilding building : buildings) { 
			building.setOffset(x, y);
			building.setScale(1f / zoom);
			building.applyZoomOffset();
			Drawer.add(BuildingDisplay.Layer, building);
		}
	}
	
	// For debug purposes
	private static void printCameraInfo() {
		System.out.println("X: " + x + ", Y: " + y +
			"\nWidth: " + width + ", Height: " + height + 
			"\nZoom: " + zoom);
	}
}
package CampusTycoon.UI;

import java.util.List;

import CampusTycoon.GameLogic.Coordinate;
import CampusTycoon.GameLogic.Map;
import CampusTycoon.UI.Components.MapBuilding;
import CampusTycoon.UI.Components.MapTile;
import CampusTycoon.UI.Systems.BuildingDisplay;
import CampusTycoon.UI.Systems.MapDisplay;
import CampusTycoon.UI.GameplayScreen;

public class Camera {
	public static Map map;
	public static int gridX, gridY;
	public static int x = 0, y = 0;
	public static int width = Window.defaultWidth, height = Window.defaultHeight;
	public static float zoom = 1;
	private static final float MinZoom = 0.4f, MaxZoom = 2.5f;
	private static Coordinate lastMousePos = new Coordinate();
	
	public static void update() {
		printCameraInfo();
		updateDrawTiles();
		updateDrawBuildings();
	}
	
	public static void checkMouseOverTile(int X, int Y) {
		
	}

	public static void scroll(float scrollAmount) {
		float oldZoom = zoom;
		zoom += scrollAmount / 10;
		zoom = Math.min(MaxZoom, Math.max(MinZoom, zoom));
		x = Math.round(x * (oldZoom / zoom));
		y = Math.round(y * (oldZoom / zoom));
		update();
	}
	
	public static void click(int X, int Y, int button) {
		lastMousePos = new Coordinate(X, Y);
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
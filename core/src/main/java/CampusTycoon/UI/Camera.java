package CampusTycoon.UI;

import java.util.List;

import CampusTycoon.GameLogic.Coordinate;
import CampusTycoon.UI.Systems.BuildingDisplay;
import CampusTycoon.UI.Systems.MapDisplay;

public class Camera {
	public static int x = 0, y = 0;
	public static int width = Window.defaultWidth, height = Window.defaultHeight;
	private static float zoom = 1;
	private static final float MinZoom = 0.35f, MaxZoom = 2.5f;
	private static Coordinate lastMousePos = new Coordinate();

	public static void scroll(float scrollAmount) {
		float oldZoom = zoom;
		zoom += scrollAmount / 10;
		zoom = Math.min(MaxZoom, Math.max(MinZoom, zoom));
		x = Math.round(x * (oldZoom / zoom));
		y = Math.round(y * (oldZoom / zoom));
		printCameraInfo();
		updateDrawTiles();
		updateDrawBuildings();
	}
	
	public static void click(int X, int Y, int button) {
		lastMousePos = new Coordinate(X, Y);
	}
	
	public static void drag(int mouseX, int mouseY) {
		x += (mouseX - lastMousePos.x) / zoom;
		y -= (mouseY - lastMousePos.y) / zoom;
		lastMousePos = new Coordinate(mouseX, mouseY);
		printCameraInfo();
		updateDrawTiles();
		updateDrawBuildings();
	}
	
	private static void updateDrawTiles() {
		List<Component> components = Drawer.popLayer(MapDisplay.Layer);
		for (Component component : components) { 
			component.setOffset(x, y);
			component.setScale(1f / zoom);
			Drawer.add(MapDisplay.Layer, component);
		}
	}
	
	private static void updateDrawBuildings() {
		List<Component> components = Drawer.popLayer(BuildingDisplay.Layer);
		for (Component component : components) { 
			component.setOffset(x, y);
			component.setScale(1f / zoom);
			Drawer.add(BuildingDisplay.Layer, component);
		}
	}
	
	// For debug purposes
	private static void printCameraInfo() {
		System.out.println("X: " + x + ", Y: " + y +
			"\nWidth: " + width + ", Height: " + height + 
			"\nZoom: " + zoom);
	}
}
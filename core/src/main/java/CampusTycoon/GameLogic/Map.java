package CampusTycoon.GameLogic;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import CampusTycoon.GameLogic.Buildings.*;
import CampusTycoon.GameLogic.Tiles.*;
import CampusTycoon.UI.Drawer;
import CampusTycoon.UI.Systems.BuildingDisplay;
import CampusTycoon.UI.Systems.MapDisplay;
import CampusTycoon.GameLogic.BuildingCounter;

public class Map {
	public static String defaultMap = "York.txt";

	public ArrayList<ArrayList<Tile>> grid;
	public static int width, height;
	public Random rng = new Random();
	public List<Building> buildings = new ArrayList<Building>();
	private MapDisplay display;
	private BuildingDisplay buildingDisplay;
	private MapUtils mapUtils;
	
	public Map() {
		mapUtils = new MapUtils(this);
		mapUtils.initialiseGrid();
		mapUtils.initialiseBuildings();
		
		display = new MapDisplay(this);
		display.drawMap();
		buildingDisplay = new BuildingDisplay(buildings);
		buildingDisplay.drawBuildings();
	}

	public void placeBuilding(Building building) {
		if (mapUtils.buildingPlaceable(building)) {
			return;
		}
		
		// Else when tile is free:
		buildings.add(building);
		Drawer.add(-1, building.drawInfo);
	}
}
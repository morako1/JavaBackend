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
import CampusTycoon.GameLogic.MapUtils.Placement;

public class Map {
	public static String defaultMap = "York.txt";

	public ArrayList<ArrayList<Tile>> grid;
	public int width, height;
	public Random rng = new Random();
	public List<Building> buildings = new ArrayList<Building>();
	private MapDisplay display;
	private BuildingDisplay buildingDisplay;
	private MapUtils mapUtils;
	
	public boolean placing;
	public String placementType;
	
	public Map() {
		mapUtils = new MapUtils(this);
		mapUtils.initialiseGrid();
		mapUtils.initialiseBuildings();
		
		display = new MapDisplay(this);
		display.drawMap();
		buildingDisplay = new BuildingDisplay(buildings);
		buildingDisplay.drawBuildings();
	}
	
	public void toggleBuildingPlacement(String building) {
		if (placementType == building) {
			this.placing = !placing;
			return;
		}
		
		this.placementType = building;
		this.placing = true;
	}

	public void placeBuilding(Coordinate position) {
		if (!placing) {
			return; // Placement mode currently toggled off
		}
		
		Building building = mapUtils.getBuilding(placementType);
		building.setPosition(position);
		if (!mapUtils.buildingPlaceable(building)) {
			return; // Building location invalid
		}
		
		// Else if placing and building location valid:
		buildings.add(building);
		Drawer.add(-1, building.drawInfo);
	}
}
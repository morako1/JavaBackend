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

public class Map {
	public static String defaultMap = "York.txt";

	public ArrayList<ArrayList<Tile>> grid;
	public List<Building> buildings = new ArrayList<Building>();
	public int width, height;
	public Random rng = new Random();
	private MapDisplay display;
	private BuildingDisplay buildingDisplay;
	
	public Map() {
		initialiseGrid();
		initialiseBuildings();
		
		display = new MapDisplay(this);
		display.drawMap();
		buildingDisplay = new BuildingDisplay(buildings);
		buildingDisplay.drawBuildings();
	}
	
	private void initialiseBuildings() {
		buildings = new ArrayList<Building>();
		buildings.add(new Cafeteria(new Coordinate(5, 12)));
		buildings.add(new Cafeteria(new Coordinate(23, 9)));
		buildings.add(new Cafeteria(new Coordinate(7, 19)));
	}
	
	private void initialiseGrid() {
		// Read map file from somewhere
		// Format: 
		// 		width height
		//		mapTileID
		// e.g. 3 3
		//		0 0 1
		//		0 1 1
		// 		1 2 1

		String defaultDirectory = System.getProperty("user.dir");
		System.out.println(defaultDirectory);
		File file = new File(defaultDirectory + "\\assets\\Maps\\" + defaultMap);
		
		String content = "";
		try {
			if (file.exists() == false) {
				throw new Exception("Default map does not exist.");
			}

			FileReader fileReader = new FileReader(file);
			char[] chars = new char[(int) file.length()];
			fileReader.read(chars);
			content = new String(chars);
			fileReader.close();
		}
		catch (Exception e) { }

		String[] lines = content.split("\n");

		String[] size = lines[0].split(" ");
		width = Integer.parseInt(size[0].toString().strip());
		height = Integer.parseInt(size[1].toString().strip());

		grid = new ArrayList<ArrayList<Tile>>(height);

		for (int i = 0; i < height; i++) {
			ArrayList<Tile> row = new ArrayList<Tile>(width);
			String[] tiles = lines[1 + i].split(" ");
			for (int j = 0; j < width; j++) {
				Tile tile = getTile(Integer.parseInt(tiles[j].strip()));
				row.add(tile);
			}
			grid.add(row);
		}
	}

	private Tile getTile(int tileID) {
		Tile tile;
		switch (tileID) {
			case 0:
				tile = new Grass();
				break;
			case 1:
				tile = new Lake();
				break;
			case 2:
				tile = new Mountain();
				break;
			default:
				System.out.println("Unknown tile ID: \"" + tileID + "\"");
				tile = null;
		}
		return tile;
	}
}
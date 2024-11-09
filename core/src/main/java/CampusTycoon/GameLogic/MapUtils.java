package CampusTycoon.GameLogic;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import CampusTycoon.GameLogic.Buildings.Building;
import CampusTycoon.GameLogic.Buildings.Cafeteria;
import CampusTycoon.GameLogic.Tiles.Grass;
import CampusTycoon.GameLogic.Tiles.Lake;
import CampusTycoon.GameLogic.Tiles.Mountain;
import CampusTycoon.GameLogic.Tiles.Tile;

public class MapUtils {
	private Map map;
	
	public MapUtils(Map Map) {
		map = Map;
	}
	
	public boolean buildingPlaceable(Building newBuilding) {
		for (Building Building : map.buildings) {
			Coordinate b = Building.position;
			Coordinate newPos = newBuilding.position;
			
			// Checks if the tile is between the bottom/left and top/right sides of the building
			if (newPos.x + newBuilding.width - 1 >= b.x && newPos.x < b.x + Building.width &&
				newPos.y + newBuilding.height - 1 >= b.y && newPos.y < b.y + Building.height) {
					return true;
				}
		}
		return false;
	}
	
	
	public boolean tileHasBuilding(Coordinate tile) {
		for (Building building : map.buildings) {
			Coordinate pos = building.position;
			
			// Checks if the tile is between the bottom/left and top/right sides of the building
			if (tile.x >= pos.x && tile.x < pos.x + building.width &&
				tile.y >= pos.y && tile.y < pos.y + building.height) {
					return true;
				}
		}
		return false;
	}
	
	public void initialiseBuildings() {
		map.buildings = new ArrayList<Building>(); 
		map.placeBuilding(new Cafeteria(new Coordinate(5, 12)));
		map.placeBuilding(new Cafeteria(new Coordinate(23, 9)));
		map.placeBuilding(new Cafeteria(new Coordinate(7, 19)));
	}
	
	public void initialiseGrid() {
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
		File file = new File(defaultDirectory + "\\assets\\Maps\\" + map.defaultMap);
		
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
		map.width = Integer.parseInt(size[0].toString().strip());
		map.height = Integer.parseInt(size[1].toString().strip());

		map.grid = new ArrayList<ArrayList<Tile>>(map.height);

		for (int i = 0; i < map.height; i++) {
			ArrayList<Tile> row = new ArrayList<Tile>(map.width);
			String[] tiles = lines[1 + i].split(" ");
			for (int j = 0; j < map.width; j++) {
				Tile tile = getTile(Integer.parseInt(tiles[j].strip()));
				row.add(tile);
			}
		map.grid.add(row);
		}
	}
	
	public Tile getTile(int tileID) {
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

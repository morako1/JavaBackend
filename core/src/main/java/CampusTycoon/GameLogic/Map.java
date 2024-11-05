package CampusTycoon.GameLogic;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;

import CampusTycoon.GameLogic.Tiles.*;

public class Map {
	public static String defaultMap = "University of York";

	public ArrayList<ArrayList<Tile>> grid;
	public Random rng = new Random();
	
	public Map() throws Exception {
		grid = initialiseGrid();
	}
	
	private ArrayList<ArrayList<Tile>> initialiseGrid() throws Exception {
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
		File file = new File(defaultDirectory + "\\assets\\Maps\\York.txt");
		if (file.exists() == false) {
			throw new Exception("Default map does not exist.");
		}

		FileReader fileReader = new FileReader(file);
		char[] chars = new char[(int) file.length()];
		fileReader.read(chars);
		String content = new String(chars);

		String[] lines = content.split("\n");

		String[] size = lines[0].split(" ");
		int width = Integer.parseInt(size[0].toString().strip());
		int height = Integer.parseInt(size[1].toString().strip());

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
		return grid;
	}

	private Tile getTile(int tileID) throws Exception {
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
				throw new Exception("Unknown tile ID: \"" + tileID + "\"");
		}
		return tile;
	}

	// Depreciated (because we won't be using randomly generated maps)
	private ArrayList<ArrayList<Tile>> initialiseRandomGrid(int gridSize) {
		grid = new ArrayList<ArrayList<Tile>>(gridSize);
		for (int i = 0; i < gridSize; i++) {
			ArrayList<Tile> row = new ArrayList<Tile>(gridSize);
			
			for (int j = 0; j < gridSize; j++) {
				Tile tile;
				switch (rng.nextInt(3)) {
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
						tile = new Grass();
						break;
				}
				row.add(tile);
			}
			grid.add(row);
		}
		return grid;
	}
}

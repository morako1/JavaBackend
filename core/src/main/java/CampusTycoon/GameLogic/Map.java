package CampusTycoon.GameLogic;

import java.util.ArrayList;
import java.util.Random;

import CampusTycoon.GameLogic.Tiles.*;

public class Map {
	public ArrayList<ArrayList<Tile>> grid;
	public Random rng = new Random();
	
	public Map(int mapSize) {
		grid = initialiseGrid(mapSize);
	}
	
	private ArrayList<ArrayList<Tile>> initialiseGrid(int gridSize) {
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

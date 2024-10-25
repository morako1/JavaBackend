package CampusTycoon.UI.Systems;

import CampusTycoon.GameLogic.Map;
import CampusTycoon.UI.Components.MapTile;

import java.util.List;

public class MapDisplay {
	private Map map; // Important to keep private as anything regarding map that is non-rendering related should be done in GameLogic instead
	private List<MapTile> mapTiles;
	
	public MapDisplay(Map Map) {
		map = Map;
	}
	
	private void initialise() {
		// Implementing this is actually gonna be a bit more complicated than I thought because I need to keep performance in mind by limiting which tiles get rendered to be only those visible on camera, which means I need to implement the camera properly first
		// Therefore, this is a function stub (and really a class stub too)
	}
}

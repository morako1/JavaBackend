package CampusTycoon;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics.DisplayMode;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.ScreenUtils;

import CampusTycoon.GameLogic.Coordinate;
import CampusTycoon.GameLogic.Map;
import CampusTycoon.GameLogic.Tiles.*;

/** First screen of the application. Displayed after the application is created. */
public class GameScreen implements Screen {
	private SpriteBatch batch;
	private Texture texture; // For testing
	private TextureRegion tileTexture;
	private Map map;
	private int mapSize;
	
	public GameScreen(Map Map) {
		map = Map;
		mapSize = map.grid.size();
	}
	
    @Override
    public void show() {
        // Prepare your screen here.
		
		//Gdx.graphics.setForegroundFPS(60); // Useful function for settings menu later
		//Gdx.graphics.setContinuousRendering(false); // Interesting function to explore later 
			//(^if rendering performance becomes an issue)
		
		Gdx.graphics.setTitle("Campus Tycoon");
		Gdx.graphics.setResizable(false);
		
		DisplayMode dm = Gdx.graphics.getDisplayMode();
		System.out.println(dm.width + "x" + dm.height + ": " + dm.bitsPerPixel + "bpp");
		
		//Gdx.graphics.setWindowedMode(1080, 720);
		Gdx.graphics.setFullscreenMode(dm);
		dm = Gdx.graphics.getDisplayMode();
		System.out.println(dm.width + "x" + dm.height + ": " + dm.bitsPerPixel + "bpp");
		
		map = new Map(mapSize);
		batch = new SpriteBatch();
		texture = new Texture(Gdx.files.internal("Tiles\\SpriteMap.png"));
    }

	/**
	 * Renders the game screen.
	 *
	 * @param delta The time in seconds since the last render.
	 */
    @Override
    public void render(float delta) {
        // Draw your screen here. "delta" is the time since last render in seconds.
		ScreenUtils.clear(Color.BLACK);
		batch.begin();
		drawMap(map);
		batch.end();
    }
	
	public void drawMap(Map map) {
		for (int i = 0; i < mapSize; i++) {
			ArrayList<Tile> mapRow = map.grid.get(i);
			for (int j = 0; j < mapSize; j++) {
				Tile tile = mapRow.get(j);
				Coordinate start = tile.getSpriteCoords();
				tileTexture = new TextureRegion(texture, start.x, start.y, 
					Tile.SpriteSize, Tile.SpriteSize);
				batch.draw(tileTexture, 
					(i * 66 - InputHandler.camera.x) * InputHandler.zoom, 
					(j * 66 + InputHandler.camera.y) * InputHandler.zoom, 
					64 * InputHandler.zoom, 64 * InputHandler.zoom);
			}
		}
	}

    @Override
    public void resize(int width, int height) {
        // Resize your screen here. The parameters represent the new window size.
		DisplayMode dm = Gdx.graphics.getDisplayMode();
		System.out.println(dm.width + "x" + dm.height + ": " + dm.bitsPerPixel + "bpp");
    }

    @Override
    public void pause() {
        // Invoked when your application is paused.
    }

    @Override
    public void resume() {
        // Invoked when your application is resumed after pause.
    }

    @Override
    public void hide() {
        // This method is called when another screen replaces this one.
    }

    @Override
    public void dispose() {
        // Destroy screen's assets here.
    }
}
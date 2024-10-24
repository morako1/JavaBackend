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
import CampusTycoon.UI.Drawer;
import CampusTycoon.UI.Window;
import CampusTycoon.UI.Component.Anchor;
import CampusTycoon.UI.Components.Button;

/** First screen of the application. Displayed after the application is created. */
public class GameScreen implements Screen {
	private SpriteBatch batch;
	private Texture texture; // For testing
	private TextureRegion tileTexture;
	private Map map;
	private int mapSize;
	
	public GameScreen(Map Map) {
		map = Map;
	}
	
	@Override
	public void show() {
		//Gdx.graphics.setForegroundFPS(60); // Useful function for settings menu later
		//Gdx.graphics.setContinuousRendering(false); // Interesting function to explore later 
			//(^if rendering performance becomes an issue)
		
		Gdx.graphics.setTitle("Campus Tycoon");
		//Gdx.graphics.setResizable(false);
		//Gdx.graphics.setWindowedMode(1080, 720); // This breaks things
		
		//DisplayMode dm = Gdx.graphics.getDisplayMode();
		//Gdx.graphics.setFullscreenMode(dm); // I don't like how this seems to also break things
		
		Button button1 = new Button("TestButton.png", 0, 0, 378, 63);
		Drawer.add(1, button1);
		
		Button button2 = new Button("TestButton.png", 0, 0, 378, 63);
		button2.setAnchor(Anchor.Centre);
		Drawer.add(1, button2);
		
		map = new Map(mapSize);
		batch = new SpriteBatch();
		texture = new Texture(Gdx.files.internal("Tiles\\SpriteMap.png"));
    }

	@Override
	public void render(float delta) {
		ScreenUtils.clear(Color.BLACK);
		Drawer.drawAll();
	}
	
	@Override
	public void resize(int width, int height) {
		Window.updateResolution(width, height);
		Drawer.updateAll();
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
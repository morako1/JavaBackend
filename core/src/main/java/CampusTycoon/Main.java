package CampusTycoon;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;

import CampusTycoon.GameLogic.Map;
import CampusTycoon.UI.EventScreen;
import CampusTycoon.UI.GameplayScreen;
import CampusTycoon.UI.ScreenUtils;
import CampusTycoon.UI.StartScreen;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends Game {
	
    @Override
    public void create() {
		//Gdx.graphics.setForegroundFPS(60); // Useful function for settings menu later
        //Gdx.graphics.setContinuousRendering(false); // Interesting function to explore later 
        //(^if rendering performance becomes an issue)
            
        Gdx.graphics.setTitle("Campus Tycoon");
        Gdx.input.setInputProcessor(new InputHandler());
		
		Screen screen = new StartScreen(new Map());
		ScreenUtils.CurrentScreen = screen;
    	setScreen(screen);
    }
	
	@Override
	public void render () {
		if (screen != null) screen.render(Gdx.graphics.getDeltaTime());
		if (ScreenUtils.CurrentScreen != screen) { setScreen(ScreenUtils.CurrentScreen); }
	}
}
package CampusTycoon;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;

import CampusTycoon.GameLogic.Map;
import CampusTycoon.UI.EventScreen;
import CampusTycoon.UI.GameplayScreen;
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
		
		
        try {
            setScreen(new GameplayScreen(new Map()));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		// Research global variables and static types as a way to share Map between classes
				
    }
}
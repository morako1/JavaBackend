package CampusTycoon;

import com.badlogic.gdx.Game;

import CampusTycoon.GameLogic.Map;
import CampusTycoon.UI.StartScreen;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends Game {
    @Override
    public void create() {
        setScreen(new StartScreen(new Map(8)));
		// Research global variables and static types as a way to share Map between classes
				
        //CODE BELOW STOPPED COMPILING FOR SOME REASON, COMMENTED OUT FOR NOW
		//InputHandler ip = new InputHandler();
		//Gdx.input.setInputProcessor(ip);
    }
}
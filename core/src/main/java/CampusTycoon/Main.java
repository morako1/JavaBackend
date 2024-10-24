package CampusTycoon;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;

import CampusTycoon.GameLogic.Map;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends Game {
    @Override
    public void create() {
        setScreen(new GameScreen(new Map(8)));
		// Research global variables and static types as a way to share Map between classes
				
		InputHandler ip = new InputHandler();
		Gdx.input.setInputProcessor(ip);
    }
}
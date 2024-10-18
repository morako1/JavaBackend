package CampusTycoon;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;

import CampusTycoon.GameLogic.Map;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
/**
 * The Main class extends the Game class and serves as the entry point for the application.
 * It initializes the game screen and sets up the input processor.
 * 
 * <p>Responsibilities:</p>
 * <ul>
 *   <li>Creates and sets the initial game screen with a new Map instance.</li>
 *   <li>Initializes the input handler and sets it as the input processor.</li>
 * </ul>
 * 
 * <p>Note:</p>
 * <p>Consider researching global variables and static types as a way to share the Map instance between classes.</p>
 */
public class Main extends Game {
    @Override
    public void create() {
        setScreen(new GameScreen(new Map(12)));
		// Research global variables and static types as a way to share Map between classes
				
		InputHandler ip = new InputHandler();
		Gdx.input.setInputProcessor(ip);
    }
}
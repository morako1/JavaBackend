package CampusTycoon;

import com.badlogic.gdx.Game;

import CampusTycoon.GameLogic.Map;
import CampusTycoon.UI.EventScreen;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends Game {
    @Override
    public void create() {
        try {
            setScreen(new EventScreen(new Map()));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		// Research global variables and static types as a way to share Map between classes
				
    }
}
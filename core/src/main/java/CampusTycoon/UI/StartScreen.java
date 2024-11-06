package CampusTycoon.UI;

import java.util.Arrays;
import java.util.List;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.ScreenUtils;

import CampusTycoon.GameLogic.Map;
import CampusTycoon.InputHandler;
import CampusTycoon.UI.Component.Actions;
import CampusTycoon.UI.Component.Anchor;
import CampusTycoon.UI.Components.Button;


public class StartScreen implements Screen{

    /** First screen of the application. Displayed after the application is created. */
        public StartScreen() {
        }

        @Override
        public void show() {
			// This button has a weird rendeding problem due to the button being 261 wide. 
			// These buttons are only temporary, so this won't be an issue once we get actually good looking buttons
            Button buttonNewGame = new Button("New Game.png", 0, 90, 262, 66);
			buttonNewGame.setClickAction(Actions.OpenGameplayScreen);
            buttonNewGame.setAnchor(Anchor.Centre);
            Drawer.add(1, buttonNewGame); //IMPORTANT - UI elements should all be kept on the same layer (1 is just an arbitrary number for now)

            Button buttonLeaderboard = new Button("Leaderboard.png", 0, 20, 262, 66);
            buttonLeaderboard.setAnchor(Anchor.Centre);
            Drawer.add(1, buttonLeaderboard);

            Button buttonSettings = new Button("Settings.png", 0, -50, 262, 66);
            buttonSettings.setAnchor(Anchor.Centre);
            Drawer.add(1, buttonSettings);
    
    
            List<Component> buttonList = Arrays.asList(buttonNewGame, buttonLeaderboard, buttonSettings);
			InputHandler.add(buttonList);
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
            // Menu screen can't be paused, so nothing will be done
        }
    
        @Override
        public void resume() {
            // Menu screen can't be resumed, so nothing will be done
        }
    
        @Override
        public void hide() {
            // This method is called when another screen replaces this one.
			Drawer.clear();
        }
    
        @Override
        public void dispose() {
            // Destroy screen's assets here.
        }
    }

package CampusTycoon.UI;

import java.util.Arrays;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.ScreenUtils;

import CampusTycoon.GameLogic.Map;
import CampusTycoon.InputHandler;
import CampusTycoon.UI.Component.Anchor;
import CampusTycoon.UI.Components.Button;


public class StartScreen implements Screen{

    /** First screen of the application. Displayed after the application is created. */
        private Map map;
        private int mapSize;
        
        public StartScreen(Map Map) {
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
    
            Button buttonNewGame = new Button("New Game.png", 0, 90, 262, 66); //This button has a weird rendeding problem due to the button being 261 wide. 
            buttonNewGame.setAnchor(Anchor.Centre);                                                       //These buttons are only temporary, so this won't be an issue once we get actually good looking buttons
            Drawer.add(1, buttonNewGame);         //IMPORTANT - UI elements should all be kept on the same layer (1 is just an arbitrary number for now)
            //InputHandler ip1 = new InputHandler(button1);
            //Gdx.input.setInputProcessor(ip1);

            Button buttonLeaderboard = new Button("Leaderboard.png", 0, 20, 262, 66);
            buttonLeaderboard.setAnchor(Anchor.Centre);
            Drawer.add(1, buttonLeaderboard);
            //InputHandler ip2 = new InputHandler(button2);
            //Gdx.input.setInputProcessor(ip2);

            Button buttonSettings = new Button("Settings.png", 0, -50, 262, 66);
            buttonSettings.setAnchor(Anchor.Centre);
            Drawer.add(1, buttonSettings);
            //InputHandler ip3 = new InputHandler(button3);
            //Gdx.input.setInputProcessor(ip3);
    
    
            List<Button> buttonList = Arrays.asList(buttonNewGame, buttonLeaderboard, buttonSettings);
            InputHandler ip = new InputHandler(buttonList);
            Gdx.input.setInputProcessor(ip);

            try {
                map = new Map();
            } catch (Exception e) {
                // Dies
            }
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
            ;// Menu screen can't be paused, so nothing will be done
        }
    
        @Override
        public void resume() {
            ;// Menu screen can't be resumed, so nothing will be done
        }
    
        @Override
        public void hide() {
            ;// This method is called when another screen replaces this one.
        }
    
        @Override
        public void dispose() {
            ;// Destroy screen's assets here.
        }
    }

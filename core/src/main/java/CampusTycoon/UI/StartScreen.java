package CampusTycoon.UI;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.ScreenUtils;

import CampusTycoon.GameLogic.Map;
import CampusTycoon.UI.Drawer;
import CampusTycoon.UI.Window;
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
    
            Button button1 = new Button("New Game.png", 0, 90, 262, 66); //This button has a weird rendeding problem due to the button being 261 wide. 
            button1.setAnchor(Anchor.Centre);                                                       //These buttons are only temporary, so this won't be an issue once we get actually good looking buttons
            Drawer.add(1, button1);                                                           //IMPORTANT - UI elements should all be kept on the same layer (1 is just an arbitrary number for now)
    
            Button button2 = new Button("Load Game.png", 0, 20, 262, 66);
            button2.setAnchor(Anchor.Centre);
            Drawer.add(1, button2);
    
            Button button3 = new Button("Leaderboard.png", 0, -50, 262, 66);
            button3.setAnchor(Anchor.Centre);
            Drawer.add(1, button3);
    
            Button button4 = new Button("Settings.png", 0, -120, 262, 66);
            button4.setAnchor(Anchor.Centre);
            Drawer.add(1, button4);
    
            map = new Map(mapSize);
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

package CampusTycoon.UI;

import java.util.Arrays;
import java.util.List;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.ScreenUtils;

import CampusTycoon.GameUtils;
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
			GameUtils.createStartMenuUI();
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
			InputHandler.clear();
        }
    
        @Override
        public void dispose() {
            // Destroy screen's assets here.
        }
    }

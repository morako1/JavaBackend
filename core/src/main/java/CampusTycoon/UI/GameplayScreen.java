package CampusTycoon.UI;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.ScreenUtils;

import CampusTycoon.GameUtils;

public class GameplayScreen implements Screen{
        @Override
        public void show() {
            GameUtils.startGame();
			GameUtils.createGameplayUI();
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
        }
    
        @Override
        public void resume() {
        }
    
        @Override
        public void hide() {
        }
    
        @Override
        public void dispose() {
            // Destroy screen's assets here.
        }
    }

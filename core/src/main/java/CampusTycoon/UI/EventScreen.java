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
import CampusTycoon.UI.Components.Backdrop;
import CampusTycoon.UI.Components.Button;

public class EventScreen implements Screen{

        private Map map;
        private int mapSize;
        
        public EventScreen(Map Map) {
            map = Map;
        }

        @Override
        public void show() {

            Gdx.graphics.setTitle("Campus Tycoon");

            Backdrop eventScreenBackdrop = new Backdrop("Backdrop.png", 0, 30, 400, 350);
            eventScreenBackdrop.setAnchor((Anchor.Centre));
            Drawer.add(1, eventScreenBackdrop);
            
            Button buttonAccept = new Button("Accept.png", -130, -106, 126, 66); //This button has a weird rendeding problem due to the button being 261 wide. 
            buttonAccept.setAnchor(Anchor.Centre);                                                       //These buttons are only temporary, so this won't be an issue once we get actually good looking buttons
            Drawer.add(2, buttonAccept); //IMPORTANT - UI elements should all be kept on the same layer (1 is just an arbitrary number for now)

            Button buttonNeutral = new Button("Neutral.png", 0, -106, 126, 66);
            buttonNeutral.setAnchor(Anchor.Centre);
            Drawer.add(2, buttonNeutral);

            Button buttonReject = new Button("Reject.png", 130, -106, 126, 66);
            buttonReject.setAnchor(Anchor.Centre);
            Drawer.add(2, buttonReject);

            List<Component> buttonList = Arrays.asList(buttonAccept, buttonReject, buttonNeutral);
            InputHandler.add(buttonList);

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

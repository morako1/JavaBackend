package CampusTycoon.UI;

import java.util.Arrays;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.ScreenUtils;

import CampusTycoon.InputHandler;
import CampusTycoon.UI.Component.Actions;
import CampusTycoon.UI.Component.Anchor;
import CampusTycoon.UI.Components.Backdrop;
import CampusTycoon.UI.Components.Button;
import CampusTycoon.UI.Components.MenuText;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import CampusTycoon.GameLogic.SatisfactionMeter;

public class EventScreen implements Screen{

        private BitmapFont font;
        private SpriteBatch batch;

        public EventScreen() {
            this.font = new BitmapFont();
            this.batch = new SpriteBatch();
        }

        @Override
        public void show() {

            Gdx.graphics.setTitle("Campus Tycoon");

            Backdrop eventScreenBackdrop = new Backdrop("Backdrop.png", 0, 30, 400, 350);
            eventScreenBackdrop.setAnchor((Anchor.Centre));
            Drawer.add(1, eventScreenBackdrop);
            
            Button buttonAccept = new Button("Accept.png", -130, -106, 126, 66); //This button has a weird rendeding problem due to the button being 261 wide. 
            buttonAccept.setClickAction(Actions.CloseEventScreen, Actions.IncreaseSatisfactionScore, 4);
            buttonAccept.setAnchor(Anchor.Centre);                                                       //These buttons are only temporary, so this won't be an issue once we get actually good looking buttons
            Drawer.add(2, buttonAccept); //IMPORTANT - UI elements should all be kept on the same layer (1 is just an arbitrary number for now)

            Button buttonNeutral = new Button("Neutral.png", 0, -106, 126, 66);
            buttonNeutral.setClickAction(Actions.CloseEventScreen, Actions.DecreaseSatisfactionSccore, 1);
            buttonNeutral.setAnchor(Anchor.Centre);
            Drawer.add(2, buttonNeutral);

            Button buttonReject = new Button("Reject.png", 130, -106, 126, 66);
            buttonReject.setClickAction(Actions.CloseEventScreen, Actions.DecreaseSatisfactionSccore, 5);
            buttonReject.setAnchor(Anchor.Centre);
            Drawer.add(2, buttonReject);

            List<Component> buttonList = Arrays.asList(buttonAccept, buttonReject, buttonNeutral);
            InputHandler.add(buttonList);

            //MenuText eventTextTitle = new MenuText("Event 1", 0, 0, 0, 0);
            //eventTextTitle.setAnchor(Anchor.Centre);
			MenuText testText = new MenuText("Random Event 1", 0, 0, 1.5f, 1.5f);
			testText.setAnchor(Anchor.Centre);
            Drawer.add(2, testText);
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
            Drawer.clear();
            InputHandler.clear();
            //if (map != null) {
            //    map.dispose(); // Ensure any resources are cleaned up
            //    map = null;    // Nu;// This method is called when another screen replaces this one.
        }
    
        @Override
        public void dispose() {
            font.dispose();
            batch.dispose();
        }
    }

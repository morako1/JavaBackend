package CampusTycoon.UI;

import java.util.Arrays;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g3d.particles.influencers.DynamicsModifier.CentripetalAcceleration;
import com.badlogic.gdx.utils.ScreenUtils;

import CampusTycoon.GameLogic.Map;
import CampusTycoon.InputHandler;
import CampusTycoon.UI.Component.Anchor;
import CampusTycoon.UI.Components.Button;
import CampusTycoon.UI.Components.MenuText;


public class GameplayScreen implements Screen{

    /** First screen of the application. Displayed after the application is created. */
        private Map map;
        
        public GameplayScreen(Map Map) {
            map = Map;
        }

        @Override
        public void show() {
            Button buttonPH1 = new Button("Placeholder.png", -250, 10, 90, 66); //This button has a weird rendeding problem due to the button being 261 wide. 
            buttonPH1.setAnchor(Anchor.BottomCentre);                                                       //These buttons are only temporary, so this won't be an issue once we get actually good looking buttons
            Drawer.add(1, buttonPH1);         //IMPORTANT - UI elements should all be kept on the same layer (1 is just an arbitrary number for now)

            Button buttonPH2 = new Button("Placeholder.png", -150, 10, 90, 66);
            buttonPH2.setAnchor(Anchor.BottomCentre);
            Drawer.add(1, buttonPH2);

            Button buttonPH3 = new Button("Placeholder.png", -50, 10, 90, 66);
            buttonPH3.setAnchor(Anchor.BottomCentre);
            Drawer.add(1, buttonPH3);
    
            Button buttonPH4 = new Button("Placeholder.png", 50, 10, 90, 66);
            buttonPH4.setAnchor(Anchor.BottomCentre);
            Drawer.add(1, buttonPH4);
    
            Button buttonPH5 = new Button("Placeholder.png", 150, 10, 90, 66);
            buttonPH5.setAnchor(Anchor.BottomCentre);
            Drawer.add(1, buttonPH5);
    
            Button buttonPH6 = new Button("Placeholder.png",250, 10, 90, 66);
            buttonPH6.setAnchor(Anchor.BottomCentre);
            Drawer.add(1, buttonPH6);
    
            Button buttonDollar = new Button("Dollar.png", -150, 0, 70, 66);
            buttonDollar.setAnchor(Anchor.TopCentre);
            Drawer.add(1, buttonDollar);

            Button buttonHouses = new Button("House.png", 0, 0, 70, 66);
            buttonHouses.setAnchor(Anchor.TopCentre);
            Drawer.add(1, buttonHouses);

            Button buttonPeople = new Button("Person.png", 150, 0, 60, 66);
            buttonPeople.setAnchor(Anchor.TopCentre);
            Drawer.add(1, buttonPeople);

            Button notif1 = new Button("ExclamationMark.png", -12, 0, 100, 80);
            notif1.setAnchor(Anchor.TopLeft);
            Drawer.add(1, notif1);

            Button notif2 = new Button("QuestionMark.png", 0, 80, 80, 80);
            notif2.setAnchor(Anchor.TopLeft);
            Drawer.add(1, notif2);

            MenuText notifText1 = new MenuText("Notification 1", 130, 23, 1.5f, 1.5f);
			notifText1.setAnchor(Anchor.TopLeft);
            Drawer.add(2, notifText1);

            MenuText notifText2 = new MenuText ("Notification 2", 135, 105, 1.5f, 1.5f);
            notifText2.setAnchor(Anchor.TopLeft);
            Drawer.add(2, notifText2);
     
            List<Component> buttonList = Arrays.asList(buttonPH1, buttonPH2, buttonPH3, buttonPH4, buttonPH5, buttonPH6, notif1, notif2, buttonDollar, buttonHouses, buttonPeople);
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

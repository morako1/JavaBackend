package CampusTycoon;

import java.util.List;

import com.badlogic.gdx.InputProcessor;

import CampusTycoon.GameLogic.Coordinate;
import CampusTycoon.UI.Components.Button;
import CampusTycoon.UI.Component;

public class InputHandler implements InputProcessor {
	public static Coordinate camera = new Coordinate();
	public static float zoom = 1;
	private Coordinate mouseDragPos;
	private Button paramButton;
	private List<Button> buttonList;

	public InputHandler(Button paramButton) {
		this.paramButton = paramButton;
	}

	public InputHandler(List<Button> buttons){
		this.buttonList = buttons;
	}
	
	public boolean keyDown (int keycode) {
		return false;
	}

	public boolean keyUp (int keycode) {
		return false;
	}

	public boolean keyTyped (char character) {
		return false;
	}

	public boolean touchDown (int x, int y, int pointer, int button) {
		x = transformX(x);
		y = transformY(y);

		for (Button btn : buttonList){
			if (isTouchWithinButton(x, y, btn)) {
				System.out.println("Button Clicked");
				// Add functionality for button click here
				return true;
			}
        }
		return true;
	}

	private int transformX(int x) {
		return (int)(x * Component.widthRatio);
	}
	private int transformY(int y) {
		return (int)(y * Component.heightRatio);
	}

	private boolean isTouchWithinButton(int x, int y, Button button) {
		if (button == null) {
			return false; // Button is null, so return false to avoid a NullPointerException
		}
        // Assuming button's (x, y) represents the top-left corner and has width and height
        return x >= button.getX() && x <= button.getX() + button.getWidth()
                && y >= button.getY() && y <= button.getY() + button.getHeight();
    }

	public boolean touchUp (int x, int y, int pointer, int button) {
		return false;
	}

	public boolean touchDragged (int x, int y, int pointer) {
		//camera.x += (x - mouseDragPos.x) / zoom;
		//camera.y += (y - mouseDragPos.y) / zoom;
		//mouseDragPos = new Coordinate(x, y); // This crashes the program currently for some reason
		return false;
	}

	public boolean mouseMoved (int x, int y) {
		return false;
	}

	public boolean scrolled (float amountX, float amountY) {
		float oldZoom = zoom;
		zoom += amountY / 10;
		camera.x = Math.round(camera.x * (oldZoom / zoom));
		camera.y = Math.round(camera.y * (oldZoom / zoom));
		return true;
	}

	public boolean touchCancelled(int screenX, int screenY, int pointer, int button) {
		return false;
	}
}

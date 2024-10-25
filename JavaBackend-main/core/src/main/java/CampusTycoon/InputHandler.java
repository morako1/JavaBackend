package CampusTycoon;

import com.badlogic.gdx.InputProcessor;

import CampusTycoon.GameLogic.Coordinate;

public class InputHandler implements InputProcessor {
	public static Coordinate camera = new Coordinate();
	public static float zoom = 1;
	private Coordinate mouseDragPos;
	
	public InputHandler() {
		;
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
		mouseDragPos = new Coordinate(x, y);
		return true;
	}

	public boolean touchUp (int x, int y, int pointer, int button) {
		return false;
	}

	public boolean touchDragged (int x, int y, int pointer) {
		camera.x += (x - mouseDragPos.x) / zoom;
		camera.y += (y - mouseDragPos.y) / zoom;
		mouseDragPos = new Coordinate(x, y);
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

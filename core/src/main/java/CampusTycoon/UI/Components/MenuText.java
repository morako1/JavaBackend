package CampusTycoon.UI.Components;

import java.util.List;

import CampusTycoon.UI.Component;

public class MenuText extends Component {

	public MenuText(String text, float X, float Y, float Width, float Height) {
		super(X, Y, Width, Height);
	}

	public float getX() {
        return this.x;
    }

    public float getY() {
        return this.y;
    }

    public float getWidth() {
        return this.width;
    }

    public float getHeight() {
        return this.height;
    }

	public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public void setHeight(float height) {
        this.height = height;
    }
}


package CampusTycoon.UI.Components;

import java.util.List;

import CampusTycoon.UI.Component;

public class MenuText extends Component {

	public MenuText(String text, float X, float Y, float Width, float Height) {
		super(X, Y, Width, Height);
		
		this.text = text;
		this.isText = true;
	}
}


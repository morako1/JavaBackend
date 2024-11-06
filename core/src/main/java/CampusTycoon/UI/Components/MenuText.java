package CampusTycoon.UI.Components;

import java.util.List;

import CampusTycoon.UI.Component;

public class MenuText extends Component {

	public MenuText(String text, float X, float Y, float WidthScale, float HeightScale) {
		super(X, Y, WidthScale, HeightScale);
		
		this.text = text;
		this.isText = true;
	}
}


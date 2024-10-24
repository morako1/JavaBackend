package CampusTycoon.UI;

import java.util.List;

public abstract class Component {
	
	// Add to this class when implementing a new anchor point
	public abstract class Anchor {
		public static final String TopLeft = "TOPLEFT";
		public static final String Centre = "CENTRE";
	} 
	
	
	public static float widthRatio, heightRatio;
	
	public static void updateResolution() {
		widthRatio = (float)Window.defaultWidth / Window.width;
		heightRatio = (float)Window.defaultHeight / Window.height;
	}
	
	
	private float baseX, baseY, baseWidth, baseHeight; // add setter/getters (so that things can update properly when these values are changed)
	public float x, y, width, height;
	private String anchor = Anchor.TopLeft; // Default anchor position
	public Sprite sprite;
	
	public Component(float X, float Y, float Width, float Height) {
		sprite = new Sprite("MissingTexture.png"); // I love purple and black squares
		Initialise(X, Y, Width, Height);
	}
	public Component(String ImagePath, float X, float Y, float Width, float Height) {
		sprite = new Sprite(ImagePath);
		Initialise(X, Y, Width, Height);
	}
	public Component(List<String> ImagePaths, float X, float Y, float Width, float Height) {
		sprite = new Sprite(ImagePaths);
		Initialise(X, Y, Width, Height);
	}
	
	// Called after resolution changes
	public void update() {
		updateResolution();
		updateSize();
		applyAnchor();
	}
	
	private void Initialise(float X, float Y, float Width, float Height) {
		baseX = X;
		baseY = Y;
		baseWidth = Width;
		baseHeight = Height;
		
		updateResolution();
		updateSize();
		
		// Default anchor is TopLeft
		// (0, 0) is the top left of the screen for components bound to this anchor
		applyAnchor();
	}
	
	// Calculate the size of the image so that it scales correctly throughout resolution changes
	private void updateSize() {
		width = baseWidth * widthRatio;
		height = baseHeight * heightRatio;
	}
	
	
	public void setAnchor(String anchorPoint) {
		anchor = anchorPoint;
	}
	
	private void applyAnchor() {
		// I don't know how to do this without using a switch statement
		// If only I could store functions within a Map, then I could tie the Anchor constants to it and call the correct function simply by passing the Map the Anchor point 
		// (Note: I haven't actually looked into whether or not doing the above is possible)
		
		switch (anchor) {
			case Anchor.TopLeft:
				anchorTopLeft();
				break;
			case Anchor.Centre:
				anchorCentre();
				break;
			default:
				System.out.println("WARNING: Invalid anchor type, defaulting to TopLeft");
				anchorTopLeft();
				break;
		}
	}
	
	private void anchorTopLeft() {		
		// Calculate where to tell LibGDX to draw things in order for them to 
		// be drawn accurately throughout resolution changes
		float Y = Window.height - baseY - baseHeight;
		x = baseX * widthRatio;
		y = Y * heightRatio;
	}
	
	private void anchorCentre() {
		float X = baseX + (Window.width - baseWidth) / 2;
		float Y = baseY + (Window.height - baseHeight) / 2;
		x = X * widthRatio;
		y = Y * heightRatio;
	}
}
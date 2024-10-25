package CampusTycoon.UI;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Sprite {
	// Contains the locations of where all Component images are stored
	// Uses getters/setters to obsfuscate single images vs animations, and 
	
	private Map<String, AnimationInfo> animationType = new HashMap<String, AnimationInfo>();
	private String selected = "DEFAULT"; // Which method is currently active
	
	public Sprite(String imagePath) {
		Initialise();
		setDefaultImage(imagePath);
	}
	
	public Sprite(List<String> imagePaths) {
		Initialise();
		setDefaultAnimation(imagePaths);
	}
	
	private void Initialise() {
		animationType.put("DEFAULT", new AnimationInfo()); // Default image
		animationType.put("HOVER", new AnimationInfo()); // To be shown on mouse hover
		animationType.put("CLICK", new AnimationInfo()); // To be shown on click
		animationType.put("CALL", new AnimationInfo()); // To be shown when criteria defined in the Component is met
	}
	
	// I have 0 clue how to reasonably implement keyframe interpolation or any other fancy technique
	// So all an animation is here is just a list of images to cycle through (1 step per frame)
	private class AnimationInfo {
		private List<String> imagePaths;
		private int imageStep; // Counter for animation frame, will always be 0 for single images
		private boolean usesSpriteMap = false; // Spritemaps aren't implemented yet, probably would be best to do so in a different class tbh
		// Possibly add Time variable, in order to adjust how fast the animation plays
		
		public AnimationInfo() {
			imagePaths = new ArrayList<String>();
			imageStep = 0;
		}
		
		public AnimationInfo(String ImagePath) {
			imagePaths = new ArrayList<String>();
			imagePaths.add(ImagePath);
			imageStep = 0;
		}
		
		public AnimationInfo(List<String> ImagePaths) {
			imagePaths = ImagePaths;
			imageStep = 0;
		}
	}
	
	
	private boolean checkSelectionValid(String selection) {
		return animationType.keySet().contains(selection);
	}
	
	private String getInvalidSelectionMessage() {
		Iterator<String> keyIterator = animationType.keySet().iterator();
		String errorMessage = "Invalid Selection.\nSelection must be one of; ";
		for (int i = 0; i < animationType.keySet().size() - 1; i++) {
			errorMessage += "\"" + keyIterator.next() + "\", ";
		}
		errorMessage += "or \"" + keyIterator.next() + "\".";
		return errorMessage;
	}
	
	public void changeSelection(String selection) throws Exception {
		if (!checkSelectionValid(selection)) {
			throw new Exception(getInvalidSelectionMessage());
		}
		
		selected = selection;
	}
	
	public String getImagePath() {
		return selectImage();
	}
	
	private String selectImage() {
		AnimationInfo animInfo = animationType.get(selected);
		stepAnimation(animInfo);
		// Important to note that the animation is stepped and then immediately returned for drawing
		// This is to prevent the 1 frame delay that would be caused by stepping after returning the image
		
		return animInfo.imagePaths.get(animInfo.imageStep);
	}
	
	private void stepAnimation(AnimationInfo animInfo) {
		animInfo.imageStep = (animInfo.imageStep + 1) % animInfo.imagePaths.size();
	}
	
	
	public void setDefaultImage(String imagePath) {
		animationType.replace("DEFAULT", new AnimationInfo(imagePath));
	}
	public void setDefaultAnimation(List<String> imagePaths) {
		animationType.replace("DEFAULT", new AnimationInfo(imagePaths));
	}
	
	public void setHoverImage(String imagePath) {
		animationType.replace("HOVER", new AnimationInfo(imagePath));
	}
	public void setHoverAnimation(List<String> imagePaths) {
		animationType.replace("HOVER", new AnimationInfo(imagePaths));
	}
	
	public void setClickImage(String imagePath) {
		animationType.replace("CLICK", new AnimationInfo(imagePath));
	}
	public void setClickAnimation(List<String> imagePaths) {
		animationType.replace("CLICK", new AnimationInfo(imagePaths));
	}
	
	public void setCallImage(String imagePath) {
		animationType.replace("CALL", new AnimationInfo(imagePath));
	}
	public void setCallAnimation(List<String> imagePaths) {
		animationType.replace("CALL", new AnimationInfo(imagePaths));
	}
}
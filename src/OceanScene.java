import uwcse.graphics.*; // access the graphics utilities in the uw library
import java.awt.Color; // access the Color class   

/**
 * An OceanScene displays fish, sailboats, stars, and a fourth element of your
 * choice in a graphics window.
 * 
 * Add a line to declare an instance field of type the new type that you defined
 * in hw1, then complete the method addGraphicsElements. Leave all the rest of
 * the code unchanged.
 * 
 * Gilbert Febrianto
 */

public class OceanScene extends GWindowEventAdapter {

	/** The graphics window that displays the picture */
	private GWindow window;

	/** The elements in the picture */
	// 2 sailboats that sail back and forth
	private SailBoat sailboat1, sailboat2;
	// 4 stars that twinkle
	private Star star1, star2, star3, star4;
	// 6 fish that swim back and forth
	private Fish fish1, fish2, fish3, fish4, fish5, fish6;

	// Add here the declaration of an instance field of the type
	// that you created in hw1
	// YOU MUST NAME THIS VARIABLE: myElement.
	// Thus your statement should be (replacing
	// classname with the name of your class)
	// private classname myElement; (e.g. private Moon myElement if your fourth
	// element is a Moon).
	private Moon myElement1, myElement2;
	// To keep track of the duration of the animation
	private int animationCounter;

	/**
	 * Create a picture
	 */
	
	public OceanScene() {
		// The graphics window
		this.window = new GWindow("Mountain scene");
		this.window.setExitOnClose();

		// The ocean and the sky
		Rectangle ocean = new Rectangle(0, 0, window.getWindowWidth(), window
				.getWindowHeight(), Color.blue, true);
		window.add(ocean);

		// the sky covers the upper quarter of the window
		Rectangle sky = new Rectangle(0, 0, window.getWindowWidth(), window
				.getWindowHeight() / 4, Color.black, true);
		window.add(sky);

		// Add the graphics elements
		this.addGraphicsElements();

		// Code to do the animation
		this.window.addEventHandler(this);
		this.window.startTimerEvents(150);
	}

	// To do the animation
	public void timerExpired(GWindowEvent we) {
		this.window.suspendRepaints();

		this.star1.twinkle();
		this.star2.twinkle();
		this.star3.twinkle();
		this.star4.twinkle();

		this.fish1.swim();
		this.fish2.swim();
		this.fish3.swim();
		this.fish4.swim();
		this.fish5.swim();
		this.fish6.swim();

		this.sailboat1.moveUpOrDown();
		this.sailboat2.moveUpOrDown();

		this.myElement1.doAction();
		this.myElement2.doAction();

		this.window.resumeRepaints();

		// Run the animation 100 times (about 15 s)
		this.animationCounter++;
		if (this.animationCounter >= 200)
			this.window.stopTimerEvents();
	}

	/**
	 * Instantiate in this method the elements of the scene. This is the only
	 * method that you need to modify in this class
	 */
	
	private void addGraphicsElements() {
		// You can change the coordinates and scales that appear
		// in the constructors (but don't change the names of the variables)
		this.star1 = new Star(50, 20, 0.8, this.window);
		this.star2 = new Star(100, 30, 1.2, this.window);
		this.star3 = new Star(150, 10, 0.6, this.window);
		this.star4 = new Star(300, 40, 1.5, this.window);

		this.fish1 = new Fish(50, 250, 1, Fish.LEFT_MOVING, this.window);
		this.fish2 = new Fish(200, 280, 1.2, Fish.RIGHT_MOVING, this.window);
		this.fish3 = new Fish(300, 320, 1.1, Fish.LEFT_MOVING, this.window);
		this.fish4 = new Fish(100, 120, 0.8, Fish.RIGHT_MOVING, this.window);
		this.fish5 = new Fish(200, 150, 0.6, Fish.LEFT_MOVING, this.window);
		this.fish6 = new Fish(350, 360, 1.3, Fish.RIGHT_MOVING, this.window);

		this.sailboat1 = new SailBoat(70, 170, 1.9, SailBoat.MOVING, this.window);
		this.sailboat2 = new SailBoat(350, 40, 2, SailBoat.MOVING, this.window);
		
		this.myElement1 = new Moon(410, 30, 1, window);
		this.myElement2 = new Moon(170, 30, 1.1, window);
		// Complete the line of code below to instantiate an object of the type
		// that you created in homework #1
		// this.myElement = new ???;
	}

	/**
	 * Starts the application
	 */
	public static void main(String[] args) {
		new OceanScene();
	}
}
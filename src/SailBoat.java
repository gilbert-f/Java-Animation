import java.awt.Color; // graphics library
import uwcse.graphics.*; // uw graphics library

/**
 * A sailboat in a graphics window
 */

// Create a SailBoat class
public class SailBoat {

	// The graphics window the boat belongs to
	private GWindow window;
	// The location of the boat
	private int x, y;
	// Scale of the drawing of the boat
	private double scale;
	// parts of the boat
	private Rectangle boat1, boat2, pole;
	private Triangle flag, sail1, sail2, boat4, boat3;
	// color of boat
	private Color boatColor;
	// position of boat
	private boolean upOrDown;
	// initialize the magnitude of moving
	public static final int MOVING = 2;
	
	/**
	 * Draws a sailboat in a graphics window
	 * 
	 * @param x
	 *            the x coordinate of the location of the boat
	 * @param y
	 *            the y coordinate of the location of the boat
	 * @param window
	 *            the graphics window where the boat is displayed
	 * @param window
	 *            the graphics window the boat belongs to
	 */
	
	// SailBoat constructor
	public SailBoat(int x, int y, double scale, int direction, GWindow window) {
		// Initialize the instance fields
		// x-coordinate
		this.x = x;
		this.y = y;
		// scale
		this.scale = scale;
		// window
		this.window = window;
		// y coordinate of the wave
		
		// generate random colors for fish
		// the red integer
		int r = (int) (Math.random() * 256);
		// the green integer
		int g = (int) (Math.random() * 256);
		// the blue integer
		int b = (int) (Math.random() * 256);
		// defines the boat color
		boatColor = new Color(r, g, b);
		// initialize the upOrDown
		upOrDown = true;
		
		// Draw the boat
		this.draw();
	}

	/**
	 * Draws this sailboat
	 */
	
	// private draw method
	private void draw() {
		
		// initialize the value of pxscale
		int pxscale = 25;
		// the size of the sail
		int sailSize = (int) (this.scale * pxscale);
		// the pole width
		int poleWidth = sailSize / 12;
		// the pole height
		int poleHeight = sailSize * 12 / 10;
		// the length of the boat
		int boatLength = sailSize * 22 / 10;
		// the height of the boat
		int boatHeight = sailSize / 3;

		// initialize the coordinates for every points on the objects
		int x1 = this.x;
		int y1 = this.y;
		int x2 = x1 - sailSize;
		int y2 = y1 + sailSize;
		int x3 = x1;
		int y3 = y2;
		int x4 = x1;
		int y4 = y1;
		int x5 = x1 + poleWidth;
		int y5 = y1;
		int x6 = x5 + sailSize / 3;
		int y6 = y5 + sailSize / 5;
		int x7 = x5;
		int y7 = y6;
		int x8 = x7;
		int y8 = y7;
		int x9 = x7;
		int y9 = y3;
		int x10 = x9 + sailSize * 3 / 4;
		int y10 = y9;
		int x11 = x2 - sailSize / 5;
		int y11 = y1 + poleHeight;
		int x12 = x9 + boatLength / 14;
		int y12 = y11 - boatHeight * 2 / 3;
		int x13 = x11;
		int y13 = y12 + boatHeight / 3 * 2;
		int x14 = x11 - boatLength / 9;
		int y14 = y11;
		int x15 = x11;
		int y15 = y11 + boatHeight;
		int x16 = x11 + boatLength;
		int y16 = y11;
		int x17 = x11 + boatLength * 10 / 9;
		int y17 = y16;
		int x18 = x11 + boatLength;
		int y18 = y15;

		// define the first sail
		sail1 = new Triangle(x1, y1, x2, y2, x3, y3, Color.WHITE, true);
		// define the pole
		pole = new Rectangle(x4, y4, poleWidth, poleHeight, Color.BLACK, true);
		// define the second sail
		sail2 = new Triangle(x5, y5, x6, y6, x7, y7, Color.RED, true);
		// define the flag
		flag = new Triangle(x8, y8, x9, y9, x10, y10, Color.YELLOW, true);
		// define the boat
		boat2 = new Rectangle(x12, y12, boatLength / 4, boatHeight / 2 * 3,
				boatColor, true);
		// if the hull is in the bottom, make the hull shorter
		if(upOrDown == true){
		boat1 = new Rectangle(x11, y11, boatLength, boatHeight - MOVING, 
				boatColor, true);
		boat3 = new Triangle(x13, y13, x14, y14, x15, y15 - MOVING, boatColor, true);
		boat4 = new Triangle(x16, y16, x17, y17, x18, y18 - MOVING, boatColor, true);
		}
		// if the boat is in the top, make the hull normal
		else{
			boat1 = new Rectangle(x11, y11, boatLength, boatHeight, boatColor, true);
			boat3 = new Triangle(x13, y13, x14, y14, x15, y15, boatColor, true);
			boat4 = new Triangle(x16, y16, x17, y17, x18, y18, boatColor, true);
		}

		// adds the first sail to window
		this.window.add(sail1);
		// adds the pole to window
		this.window.add(pole);
		// adds the second sail to window
		this.window.add(sail2);
		// adds the flag to window
		this.window.add(flag);
		// adds the boat to window
		this.window.add(boat1);
		this.window.add(boat2);
		this.window.add(boat3);
		this.window.add(boat4);
	}
	// moveUpOrDown method
	public void moveUpOrDown() {
		// if the boat is on the bottom
		if (upOrDown == true) {
			// set upOrDown to up
			upOrDown = false;
			// the y coordinates of the
			// boat is subtracted by 2
			this.y -= MOVING;
		} else {
			// set upOrDown to down
			upOrDown = true;
			// else, added by 2
			this.y += MOVING;
		}
		// calls the removeBoat method
		removeBoat();
		// calls the draw method
		draw();
	}
	// removeBoat method
	public void removeBoat() {
		// removes parts of the boat
		this.window.remove(sail1);
		this.window.remove(pole);
		this.window.remove(sail2);
		this.window.remove(flag);
		this.window.remove(boat1);
		this.window.remove(boat2);
		this.window.remove(boat3);
		this.window.remove(boat4);
	}
}
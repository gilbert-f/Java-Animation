import java.awt.Color; // graphics library
import uwcse.graphics.*; // uw graphics library

/**
 * A star in a graphics window
 */

// creates the class named Star
public class Star {

	// The graphics window the star belongs to
	private GWindow window;
	// The location of the center of the star
	private int x, y;
	// Scale of the drawing of the star
	private double scale;
	// initialize the starColor
	private Color starColor;

	/**
	 * Draws a star in a graphics window
	 * 
	 * @param x
	 *            the x coordinate of the center of the star
	 * @param y
	 *            the y coordinate of the center of the star
	 * @param scale
	 *            the scale of the drawing of the star
	 * @param window
	 *            the graphics window the star belongs to
	 */
	
	// public Star constructor
	public Star(int x, int y, double scale, GWindow window) {
		// Initialize the instance fields
		this.x = x;
		this.y = y;
		this.window = window;
		this.scale = scale;

		// Draw the star
		this.draw();
	}

	/**
	 * Draws this star (complete this method to make a better star)
	 */
	
	// private draw method
	private void draw() {
		// Size of the star
		int starSize = (int) (this.scale * 10);
		// Draw the lines making up the star
		Line line1 = new Line(this.x, this.y - starSize / 2, this.x, this.y
				+ starSize / 2, starColor);
		Line line2 = new Line(this.x - starSize / 2, this.y, this.x + starSize
				/ 2, this.y, starColor);
		Line line3 = new Line(x - starSize / 4, y - starSize / 4, x + starSize
				/ 4, y + starSize / 4, starColor);
		Line line4 = new Line(x - starSize / 4, y + starSize / 4, x + starSize
				/ 4, y - starSize / 4, starColor);
		Line line5 = new Line(x - starSize / 8, y + starSize / 3, x + starSize
				/ 8, y - starSize / 3, starColor);
		Line line6 = new Line(x + starSize / 8, y + starSize / 3, x - starSize
				/ 8, y - starSize / 3, starColor);
		Line line7 = new Line(x - starSize * 3 / 8, y + starSize / 6, x + starSize
				* 3 / 8, y - starSize / 6, starColor);
		Line line8 = new Line(x + starSize * 3 / 8, y + starSize / 6, x - starSize
				* 3 / 8, y - starSize / 6, starColor);
		
		// adds the lines to window
		this.window.add(line1);
		this.window.add(line2);
		this.window.add(line3);
		this.window.add(line4);
		this.window.add(line5);
		this.window.add(line6);
		this.window.add(line7);
		this.window.add(line8);
	}
	// twinkle method
	public void twinkle(){
		// generate random colors for star
		// the red integer
		int r = (int)(Math.random() * 256);
		// the green integer
		int g = (int)(Math.random() * 256);
		// the blue integer
		int b = (int)(Math.random() * 256);
		// defines the star color
		starColor = new Color(r, g, b);
		
		// draws the star
		draw();
	}
}
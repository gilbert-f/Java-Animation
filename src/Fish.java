import java.awt.Color; // graphics library
import uwcse.graphics.*; // uw graphics library

/**
 * A fish in a graphics window
 */

// creates public class named Fish
public class Fish {

	// The graphics window the fish belongs to
	private GWindow window;
	// The location, dimensions and direction of the fish
	private int x, y, length, height, direction;
	// Scale of the drawing of the fish
	private double scale;
	// Color of the fish
	private Color fishColor;
	// Parts of the fish
	private Triangle tail, mouth, fin1, fin2,
	fin3;
	private Oval eye, body;
	// Magnitude of the moving of the fish;
	public static final int LEFT_MOVING = -3;
	public static final int RIGHT_MOVING = 3;

	/**
	 * Draws a Fish in a graphics window
	 * 
	 * @param x
	 *            the x coordinate of the location of the fish
	 * @param y
	 *            the y coordinate of the location of the fish
	 * @param scale
	 *            the scale of the drawing of the fish
	 * @param window
	 *            the graphics window the fish belongs to
	 */
	
	// public Fish constructor
	public Fish(int x, int y, double scale, int direction,
			GWindow window) {
		
		// Initialize the instance fields
		this.x = x;
		this.y = y;
		this.scale = scale;
		this.window = window;
		this.direction = direction;
		
		// generate random colors for fish
		// the red integer
		int r = (int)(Math.random() * 256);
		// the green integer
		int g = (int)(Math.random() * 256);
		// the blue integer
		int b = (int)(Math.random() * 256);
		// defines the boat color
		fishColor = new Color(r, g, b);

		// Draws the fish
		this.draw();
	}

	/**
	 * Draws this fish
	 */
	
	// private draw method
	public void draw() {
		
		// defines the pxscale
		int pxscale = 20;
		// defines the height of the fish
		height = (int)(this.scale * pxscale);
		// defines the length of the fish
		length = (int)(2.5 * height);
		// defines the radius of the eye of the fish
		int eyeRadius = length / 10;
		
		// defines the body of the fish
		body = new Oval(this.x, this.y, length,
				height, fishColor, true);
		
		// adds the body to window
		this.window.add(body);
		
		// makes the fish facing right
		if (direction == RIGHT_MOVING) {
		// initialize the coordinate for every point of the object
		int x1 = this.x - length / 4;
		int y1 = this.y;
		int x2 = x1;
		int y2 = this.y + height;
		int x3 = this.x + length / 5;
		int y3 = this.y + height / 2;
		int x4 = this.x + length * 3 / 4;
		int y4 = this.y + height * 3 / 16;
		int x5 = this.x + length * 3 / 4;
		int y5 = this.y + height * 5 / 8;
		int x6 = this.x + length;
		int y6 = y3;
		int x7 = x6;
		int y7 = y2;
		int x8 = this.x + length * 2 / 3;
		int y8 = this.y + height / 2;
		int x9 = this.x + length * 4 / 9;
		int y9 = this.y + height / 4;
		int x10 = x9;
		int y10 = this.y + height * 3 / 4;
		int x11 = x9 - length / 8;
		int y11 = this.y - height / 3 ;
		int x12 = x9;
		int y12 = this.y + height / 6;
		int x13 = x9 + length / 4;
		int y13 = y12;
		int x14 = x11;
		int y14 = this.y + height * 4 / 3;
		int x15 = x12;
		int y15 = this.y + height * 5 / 6;
		int x16 = x13;
		int y16 = y15;
		
		// defines the tail
		tail = new Triangle(x1, y1, x2, y2, 
				x3,y3, fishColor, true);
		// defines the eye
		eye = new Oval(x4, y4, eyeRadius, eyeRadius, 
				Color.BLACK, true);
		// defines the mouth
		mouth = new Triangle(x5, y5, x6, 
				y6, x7, y7, Color.BLUE, true);
		// defines the fin on the top of the fish
		fin1 = new Triangle(x8, y8, x9, y9, x10, y10,
				Color.BLACK,false);
		// defines the fin on the bottom of the fish
		fin2 = new Triangle(x11, y11, x12, y12, x13, y13,
				fishColor,true);
		// defines the fin on the side of the fish
		fin3 = new Triangle(x14, y14, x15, y15, x16, y16,
				fishColor,true);
		
		// adds the tail to window
		this.window.add(tail);
		// adds the eye to window
		this.window.add(eye);
		// adds the mouth to window
		this.window.add(mouth);
		//adds the fin on the top of the fish to window
		this.window.add(fin1);
		//adds the fin on the fin on the bottom of the fish
		this.window.add(fin2);
		//adds the fin on the fin on the side of the fish
		this.window.add(fin3);
		}
		// makes the fish facing left 
		else{
			// initialize the coordinates for every point of the object
			int x1 = this.x + length * 5 / 4;
			int y1 = this.y;
			int x2 = x1;
			int y2 = this.y + height;
			int x3 = this.x + length * 4 / 5;
			int y3 = this.y + height / 2;
			int x4 = this.x + length / 5;
			int y4 = this.y + height * 3 / 16;
			int x5 = this.x + length / 4;
			int y5 = this.y + height * 5 / 8;
			int x6 = this.x;
			int y6 = y3;
			int x7 = x6;
			int y7 = y2;
			int x8 = this.x + length / 3;
			int y8 = this.y + height / 2;
			int x9 = this.x + length * 5 / 9;
			int y9 = this.y + height / 4;
			int x10 = x9;
			int y10 = this.y + height * 3 / 4;
			int x11 = x9 + length / 8;
			int y11 = this.y - height / 3 ;
			int x12 = x9;
			int y12 = this.y + height / 6;
			int x13 = x9 - length / 4;
			int y13 = y12;
			int x14 = x11;
			int y14 = this.y + height * 4 / 3;
			int x15 = x12;
			int y15 = this.y + height * 5 / 6;
			int x16 = x13;
			int y16 = y15;
			
			// defines the tail
			tail = new Triangle(x1, y1, x2, y2, 
					x3,y3, fishColor, true);
			// defines the eye
			eye = new Oval(x4, y4, eyeRadius, eyeRadius, 
					Color.BLACK, true);
			// defines the mouth
			mouth = new Triangle(x5, y5, x6, 
					y6, x7, y7, Color.BLUE, true);
			// defines the fin on the top
			fin1 = new Triangle(x8, y8, x9, y9, x10, y10,
					Color.BLACK,false);
			// defines the fin on the bottom
			fin2 = new Triangle(x11, y11, x12, y12, x13, y13,
					fishColor,true);
			// defines the fin on the side
			fin3 = new Triangle(x14, y14, x15, y15, x16, y16,
					fishColor,true);
			
			// adds the tail to window
			this.window.add(tail);
			// adds the eye to window
			this.window.add(eye);
			// adds the mouth to window
			this.window.add(mouth);
			//adds the fin on the top of the fish to window
			this.window.add(fin1);
			//adds the fin on the fin on the bottom of the fish
			this.window.add(fin2);
			//adds the fin on the fin on the side of the fish
			this.window.add(fin3);
		}
	}
	// swim method
	public void swim(){
		// moves the fish to the right if the fish is facing right
		if(direction == RIGHT_MOVING){
			// moves the fish by 3 pixels to the right 
			this.x += RIGHT_MOVING;
		}
		// moves the fish to the left if the fish is facing left
		else{
			// moves the fish to the left by 3 pixels
			this.x += LEFT_MOVING;
		}
		// if the body of the fish touches the right side of the window, move the fish back to the left
		if (this.x + length/2 > window.getWindowWidth()){
			direction = LEFT_MOVING;
		}
		// if the body of the fish touches the left side of the window, move the fish back to the right
		if (this.x + length/2 < 0){
			direction = RIGHT_MOVING;
		}
		// remove the fish
		removeFish();
		// draws the fish
		draw();
	}
	// removeFish() method defined
	public void removeFish() {
		// removes the tail to window
		this.window.remove(tail);
		// removes the eye to window
		this.window.remove(eye);
		// removes the mouth to window
		this.window.remove(mouth);
		// removes the fin on the top of the fish to window
		this.window.remove(fin1);
		// removes the fin on the fin on the bottom of the fish
		this.window.remove(fin2);
		// removes the fin on the fin on the side of the fish
		this.window.remove(fin3);
		// removes the fin on the fin on the side of the fish
		this.window.remove(body);
	}
}
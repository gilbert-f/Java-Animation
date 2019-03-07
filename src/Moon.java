import java.awt.Color; // graphics library
import uwcse.graphics.*; // uw graphics library

// creates the class Moon
public class Moon{
	
	// instance field
	// initialize the window
	private GWindow window;
	// initialize the position of the moon
	private int x, y;
	// scale of the moon
	private double scale;
	// cover of the moon
	public Oval moonCover;
	
	// moon constructor
	public Moon(int x, int y, double scale, GWindow window){
		
		// initialize the instance fields
		this.x = x;
		this.y = y;
		this.scale = scale;
		this.window = window;
		
		// draws the moon
		this.draw();
	}
	// defines the draw method
	private void draw(){
		// defines the pxScale
		int pxScale = 25;
		// defines the radius of circle
		int radiusCircle = (int)(this.scale * pxScale);
		// defines the radius of circle
		int diameterCircle = 2 * radiusCircle;
		// defines the x coordinates of the moonCover
		int x2 = (int) (this.x + (radiusCircle / 2));
		
		// makes the moon
		Oval moon = new Oval(this.x, this.y, diameterCircle,
				diameterCircle, Color.yellow, true);
		// makes the moon cover
		moonCover = new Oval(x2, this.y, diameterCircle,
				diameterCircle, Color.BLACK, true); 
		
		// adds the moon to the window
		this.window.add(moon);
		// adds the moonCover to the window
		this.window.add(moonCover);
	}
	// doAction method
	public void doAction(){
		// rotates the moonCover by 5 degrees clockwise
		moonCover.rotateAround(this.x, this.y, -5);
	}
}

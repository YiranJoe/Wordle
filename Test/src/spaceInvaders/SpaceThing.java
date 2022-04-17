package spaceInvaders;

// SpaceThing class for SpaceInvaders by Mr. David
// no need to edit this class

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpaceThing extends Rectangle {
	
	private Image img;
	
	// constructor takes a location and the name of the image file as parameters
	public SpaceThing(int x, int y, int w, int h, String imgName) {
		super(x, y, w, h);//inherit from the rectangle class
		
		try {
			img = ImageIO.read(new File(imgName)).getScaledInstance(w, h, Image.SCALE_SMOOTH);
		} catch (IOException e) {
			System.out.println("Image file not found");
		}
	}
	
	
	public void returnY() {
		y=0;
	}
	
	// moves x by the inputted amount
	public void moveX(int dX) {
		x += dX;
	}
	
	// moves y by the inputted amount
	public void moveY(int dY) {
		y += dY;
	}
	
	// draws the image corresponding with this alien/player
	public void draw(Graphics g) {
		g.drawImage(img, x, y, null);
		//draw the image
	}
	
}

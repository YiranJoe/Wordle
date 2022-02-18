package Class;

import java.awt.Color;
import java.awt.Graphics;

public class Oval extends Shape{

	private int diameter;
	public Oval(int startx,int starty,int diameter) {
		super(startx, starty);
		this.diameter=diameter;
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawOval(super.getX(), super.getY(),diameter,diameter);	
	}
}

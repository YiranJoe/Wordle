package Class;

import java.awt.Color;
import java.awt.Graphics;

public class Square extends Shape{

	private int side;
	public Square(int startx,int starty,int side) {
		super(startx, starty);
		this.side=side;
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawRect(super.getX(), super.getY(),side,side);	
	}
}

import java.awt.Color;
import java.awt.Graphics;

public class SineBall extends Bouncing{

	private int xLimit;
	private int yLimit;
	
	
	public SineBall(int startx, int starty, int startrad, int startxspeed, int startyspeed, Color startcolor) {
		super(startx,starty,startrad,startxspeed,startyspeed,startcolor);
		xLimit=startx;
		yLimit=starty;
	}
	
	
	public void draw(Graphics g) {
		super.draw(g);
		setY((int) (Math.sin(getX())));
	}
	
	public void move() {
		super.move();
		setY((int)(Math.sin(getX()/20.0)*70+HEIGHT/2));
	}
}

import java.awt.Color;
import java.awt.Graphics;

public class CircleBall extends Ball{

	private int Index=0;
	public CircleBall(int startx, int starty, int startrad, int startxspeed, int startyspeed, Color startcolor) {
		super(startx, starty, startrad, startxspeed, startyspeed, startcolor);
	}
	
	public void move() {
		Index++;
		setX((int) (WIDTH/2+Math.cos(Index/20.0)*200));
		setY((int) (HEIGHT/2+Math.sin(Index/20.0)*200));
		super.move();
	}
}

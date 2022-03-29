package Class;
import java.awt.*;
import java.awt.Color;

public class Block {

	int x;
	int y;
	Color color;
	int speed;
	
	public Block(int x,int y) {
		this.x=x;
		this.y=y;
		this.speed=(int)(Math.random()*10+1);
		this.color=new Color((int)(Math.random()*254+1),(int)(Math.random()*254+1),(int)(Math.random()*254+1));
	}
	
	public void draw(Graphics g) {
		g.setColor(color);
		g.fillRect(x,y,20,20);
	}
	
	public void move() {
		y+=speed;
	}
	
	public Color getCOlor() {
		return color;
	}
	
	public int getY() {
		return y;
	}
	public int getX() {
		return x;
	}

}

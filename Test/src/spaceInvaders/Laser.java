package spaceInvaders;
import java.awt.*;
import java.io.*;
import javax.print.attribute.standard.Media;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Laser extends Rectangle{
	
	Color color;
	public Laser(int x, int y, int w, int h) {
		super(x, y, w, h);//inherit from the rectangle class
		this.color=new Color((int)(Math.random()*100+155),(int)(Math.random()*100+155),(int)(Math.random()*100+155));
		//the color needs to be bright every time so that we can see the lasers in the infinite space
	}
	
	public void moveY(int speed) {
		y+=speed;
		//move the lasers!
	}
	
	public void draw(Graphics g){
		g.setColor(color);//set the laser to its color
		g.fillRect(x,y,width,height);//draw the lasers as rectangles
	}
	
	public void makeSound(){
	    File lol = new File("shoot.wav");
	    

	    try{
	        Clip clip = AudioSystem.getClip();
	        clip.open(AudioSystem.getAudioInputStream(lol));
	        clip.start();
	    } catch (Exception e){
	        e.printStackTrace();
	    }
	}
	
}

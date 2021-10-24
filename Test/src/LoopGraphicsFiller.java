// filler code for pong provided by Mr. David

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class LoopGraphicsFiller extends JPanel {
	
	// constants that are predefined and won't change as the program runs
	private final int WIDTH = 1000, HEIGHT = 590;

	// defines what we want to happen anytime we draw the graphics
	public void paint(Graphics g) {
		
		// background color is gray
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		// call your methods here
		for(int i=1;i<=10;i++)//3# 10*10 circles
		{
			for(int j=1;j<=10;j++)
			{	
				g.setColor(Color.red);
				g.fillOval(i*10,j*10,10,10);
			}
			System.out.println();
		}
		
		/*Scanner num=new Scanner(System.in);//1# Across the Screen NOTE Have to Scanner a NUMBER
		int n=num.nextInt();
		for(int i=1;i<=n;i++)
		{
			g.setColor(Color.green);
			g.fillOval(i*10,i*10,10,10);
		}*/
		
		for(int i=1;i<=20;i++)//2# Changing sizes of the balls
		{
			g.setColor(Color.red);
			g.fillOval(i*50,(500-i)/2,100-10*Math.abs(10-i),100-10*Math.abs(10-i));
		}
		
		for(int i=1;i<=15;i+=2)//4# checkboard
		{
			for(int j=1;j<=16;j+=2)
			{
				g.setColor(Color.black);
				g.fillRect(100+i*10, 30+j*10, 10, 10);
				g.setColor(Color.black);
				g.fillRect(100+(i+1)*10, 30+(j+1)*10, 10, 10);
			}
		}
		
		for(int i=1;i<=15;i++)//5# draw rectangles in various colors
		{
			
			if(i%2!=0&&i%3!=0)
			{
				g.setColor(Color.red);
				g.fillRect(300+i*30,50,10,20);
			}
			else if(i%2==0&&i%3!=0)
			{
				g.setColor(Color.green);
				g.fillRect(300+i*30,50,10,20);
			}
			else if(i%3==0&&i%2!=0)
			{
				g.setColor(Color.yellow);
				g.fillRect(300+i*30,50,10,20);
			}else
			{
				g.setColor(Color.yellow);
				g.fillRect(300+i*30,50,10,20);
			}
		}
		}
		



	//////////////////////////////////////
	//////////////////////////////////////
	
	// DON'T TOUCH THE BELOW CODE
	
	
	// this method runs the actual program.
	public void run() {

		// while(true) should rarely be used to avoid infinite loops, but here it is ok because
		// closing the graphics window will end the program
		while (true) {
	
			// draws
			//repaint();
			
			//rests for a hundredth of a second
			try {
				Thread.sleep(10);
			} catch (Exception ex) {}
		}
	}
	
	// very simple main method to get the game going
	public static void main(String[] args) {
		new LoopGraphicsFiller();
	}
 
	// does complicated stuff to initialize the graphics and key listeners
	// DO NOT CHANGE THIS CODE UNLESS YOU ARE EXPERIENCED WITH JAVA
	// GRAPHICS!
	public LoopGraphicsFiller() {
		JFrame frame = new JFrame();
		frame.setSize(WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(this);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
		this.setFocusable(true);
		
		run();
	}
}
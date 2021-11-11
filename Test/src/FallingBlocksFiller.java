
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FallingBlocksFiller extends JPanel {
	
	private int WIDTH = 800, HEIGHT = 600, NUMBLOCKS = 50;
	
	private int RecWidth=20;

	// instance variables (what kind of data structure should we use?)
	int[] blockX=new int[NUMBLOCKS];
	
	int[] blockY=new int[NUMBLOCKS];
	
	Color[] color= new Color[NUMBLOCKS];
	
	int y=0;
	
	int[] blockSpeed=new int[NUMBLOCKS];
	// your code here
	
	// fills in your arrays with random x and y values
	public void initializeArrays() {
		for(int i=0;i<NUMBLOCKS;i++)
		{
			blockY[i]=0;
		}
		for(int i=0;i<NUMBLOCKS;i++)
		{
			blockX[i]=(int)(Math.random()*(WIDTH-RecWidth)+0);
		}
		for(int i=0;i<NUMBLOCKS;i++)
		{
			blockSpeed[i]=(int)(Math.random()*5+2);
			color[i] = new Color((int)(Math.random()*254+1),(int)(Math.random()*254+1),(int)(Math.random()*254+1));
			
		}
		
		// your code here
	}
	
	// change your arrays here to make the blocks move
	public void moveblocks() {
		// your code here
		for(int i=0;i<NUMBLOCKS;i++) {
			blockY[i]+=blockSpeed[i];
			if(blockY[i]==HEIGHT)
			{
				blockX[i]=(int)(Math.random()*(WIDTH-RecWidth)+0);
				blockY[i]=0;
				blockSpeed[i]=(int)(Math.random()*5+2);
				color[i] = new Color((int)(Math.random()*254+1),(int)(Math.random()*254+1),(int)(Math.random()*254+1));
			}
		}
	}
	
	// change the last part of this method!
	public void paint(Graphics g) {
		// give a white background
		g.setColor(Color.white);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		// color the rectangles blue - you can change this
		for(int i=0;i<NUMBLOCKS;i++) {
			g.setColor(color[i]);
			g.fillOval(blockX[i],blockY[i],RecWidth,RecWidth);
		}
		// draw your rectangles here! 
		
	}
	
	// ******** DON'T TOUCH BELOW CODE ***************
	
	// don't touch this method!
	public FallingBlocksFiller() {
		initializeArrays();
		JFrame frame = new JFrame();
		frame.setSize(WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(this);
		frame.setVisible(true);

		while (true) {
			moveblocks();
			repaint();
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			WIDTH = frame.getSize().width;
			HEIGHT = frame.getSize().height;
		}
	}

	// don't touch this method!
	public static void main(String[] args) {
		new FallingBlocksFiller();
	}

}
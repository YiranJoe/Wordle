// filler code for pong provided by Mr. David
//Gregory helps me with my restarting and teaches me how to do switching solo and double players

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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Pong extends JPanel implements KeyListener {//Basic Set Up variables
	
	// constants that are predefined and won't change as the program runs
	private final int WIDTH = 600, HEIGHT = 600, WINDOW_HEIGHT = 650;
	private final int PADDLE_WIDTH = 20, DIAM = 8, PADDLE_HEIGHT = 100;
	private final int PADDLE_SPEED = 4;

	private int xBall=30,yBall=30,xBallSpeed=2,yBallSpeed=3;
	
	private int xPaddle1=0,yPaddle1=0;
	
	private int xPaddle2=600-PADDLE_WIDTH,yPaddle2=0;
	
	private int point1=0,point2=0;
	
	// your instance variables here, I've given you a few 
	private boolean up1, down1, up2, down2; 		// booleans to keep track of paddle movement
	private boolean solo = false;
	
	public void getPoint() {//Test if it touches the wall
		if((yBall>yPaddle1&&yBall<yPaddle1+100)&&(xBall==xPaddle1+PADDLE_WIDTH)) {
			point1+=1;
		}
		else if((yBall>yPaddle2&&yBall<yPaddle2+100)&&(xBall==xPaddle2)){
			point2+=1;
		}
	}
	

	
	
	
	
	// this method moves the ball at each timestep
	public void move_ball() {//Keep it moving
		xBall+=xBallSpeed;
		yBall+=yBallSpeed;
		// your code here //
	}
	
	// this method moves the paddles at each timestep
	public void move_paddles() {//Solo, double, and basic moving
		if(down2==true)
		{
			yPaddle1+=PADDLE_SPEED;
		}
		if(up2==true)
		{
			yPaddle1-=PADDLE_SPEED;
		}
		
		if(solo==false) {
		if(down1==true)
		{
			yPaddle2+=PADDLE_SPEED;
		}
		if(up1==true)
		{
			yPaddle2-=PADDLE_SPEED;
		}
		}
		if(solo==true)
		{
			yPaddle2=yBall-PADDLE_HEIGHT/2;
		}
		// your code here // 
	}
	
	// this method checks if there are any bounces to take care of,
	// and if the ball has reached a left/right wall it adds to 
	// the corresponding player's score
	public void check_collisions() {//check if touches the walls
		if(yBall<0||yBall+DIAM>600)
		{
			yBallSpeed*=-1;
		}
		if((yBall>yPaddle1&&yBall<yPaddle1+100)&&(xBall<=xPaddle1+PADDLE_WIDTH))
		{
			xBallSpeed*=-1;
		}
		if((yBall>yPaddle2&&yBall<yPaddle2+100)&&(xBall>=xPaddle2))
		{
			xBallSpeed*=-1;
		}
		
		// your code here
	}
	

	// defines what we want to happen anytime we draw the game
	// you simply need to fill in a few parameters here
	public void paint(Graphics g) {//Draw everything
		
		// background color is gray
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		// draw your rectangles and circles here
		// .......
		g.setColor(Color.green);
		g.fillRect(xPaddle1,yPaddle1,PADDLE_WIDTH,PADDLE_HEIGHT);
		
		g.setColor(Color.red);
		g.fillRect(xPaddle2,yPaddle2,PADDLE_WIDTH,PADDLE_HEIGHT);
		g.fillOval(xPaddle1,yPaddle1,PADDLE_WIDTH,PADDLE_HEIGHT);
		// writes the score of the game - you just need to fill the scores in
		Font f = new Font("Arial", Font.BOLD, 14);
		g.setFont(f);
		g.setColor(Color.red);
		
		g.drawString("P1 Score: "+point1, WIDTH/5, 20);
		g.drawString("P2 Score: "+point2, WIDTH*3/5, 20);
		
		g.fillOval(xBall,yBall,DIAM,DIAM);
	}

	// defines what we want to happen if a keyboard button has 
	// been pressed - you need to complete this
	public void keyPressed(KeyEvent e) {//press keyboard to contrl
		
		int keyCode = e.getKeyCode();
		
		// changes paddle direction based on what button is pressed
		if (keyCode == KeyEvent.VK_DOWN)
		{
			// fill this in
		down1=true;
		}
		if (keyCode == KeyEvent.VK_UP) 
		{
			// fill this in
		up1=true;
		}
		if (e.getKeyChar() == 'w')
		{
			// move paddle down
		up2=true;
		}
		if (e.getKeyChar() =='s')
		{
			// fill this in
		down2=true;
		}
		// turn 1-player mode on
		if (e.getKeyChar() == '1')
			solo = true;
		// turn 2-player mode on
		if (e.getKeyChar() == '2')
			// fill this in*/
			solo=false;
			
	}

	// defines what we want to happen if a keyboard button
	// has been released - you need to complete this
	public void keyReleased(KeyEvent e) {//release keyboard when something is achieved
		
		int keyCode = e.getKeyCode();
		
		// stops paddle motion based on which button is released
		if (keyCode == KeyEvent.VK_UP) 
			// fill this in
			up1=false;
		if (keyCode == KeyEvent.VK_DOWN) 
			// fill this in
			down1=false;
		if(e.getKeyChar() == 'w')
			// fill this in
			up2=false;
		if (e.getKeyChar() == 's')
			// fill this in
			down2=false;

	}
	
	// restarts the game, including scores
	public void restart() {//when pressing restart, put everything into basic setting
		solo=false;
		xBall=30;
		yBall=30;
		xBallSpeed=2;
		yBallSpeed=3;
		xPaddle1=0;
		yPaddle1=0;
		xPaddle2=600-PADDLE_WIDTH;
		yPaddle2=0;	
		point1=0;
		point2=0;
		
		// your code here
	}

	//////////////////////////////////////
	//////////////////////////////////////
	
	// DON'T TOUCH THE BELOW CODE
	
	
	// this method runs the actual game.
	public void run() {

		// while(true) should rarely be used to avoid infinite loops, but here it is ok because
		// closing the graphics window will end the program
		while (true) {
	
			// draws the game
			repaint();
			
			// we move the ball, paddle, and check for collisions
			// every hundredth of a second
			move_ball();
			move_paddles();
			check_collisions();
			getPoint();
			
			
			//rests for a hundredth of a second
			try {
				Thread.sleep(10);
			} catch (Exception ex) {}
		}
	}
	
	// very simple main method to get the game going
	public static void main(String[] args) {
		new Pong();
	}
 
	// does complicated stuff to initialize the graphics and key listeners
	// DO NOT CHANGE THIS CODE UNLESS YOU ARE EXPERIENCED WITH JAVA
	// GRAPHICS!
	public Pong() {
		JFrame frame = new JFrame();
		JButton button = new JButton("restart");
		frame.setSize(WIDTH, WINDOW_HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(this);
		frame.add(button, BorderLayout.SOUTH);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				restart();
				Pong.this.requestFocus();
			}
		});
		this.addKeyListener(this);
		this.setFocusable(true);
		
		run();
	}
	
	// method does nothing
	public void keyTyped(KeyEvent e) {}
}


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class JeopardyBoardFiller {
	
	private int gridWidth = 800, gridHeight = 600, textHeight = 50, sectionScore = 100;//setting up the background and the points plus on each question
	
	private final int NUMQUESTIONS = 5, NUMCATEGORIES = 6;//Setting up how many rows and Columns in the Jeopardy
	
	private int score = 0;//Setting up the original score
	
	int totalPoint=0;//this is the point shown on each board
	
	int ColorX, ColorY;//instant variables for recording the location of mouse
	
	
	boolean click=false;//boolean if the mouse is clicked
	
	public void click(int mouseX, int mouseY) {//we want to record the location of mouse, adding points and letting the board know we click a bottom
		score+=(mouseY/(gridHeight/NUMQUESTIONS)+1)*sectionScore;//Adding to the total point
		click=true;
		ColorX=mouseX;
		ColorY=mouseY;
	}
	
	public void draw(Graphics g) {//drawing everything including the frame and the numbers on the board
		for(int i=0;i<NUMQUESTIONS;i++)
		{
			for(int j=0;j<NUMCATEGORIES;j++)
			{
				totalPoint=sectionScore*(i+1);//numbers on each board
				g.setColor(Color.green);//color of the frame
				g.drawRect(j*gridWidth/NUMCATEGORIES,i*gridHeight/NUMQUESTIONS,gridWidth/NUMCATEGORIES,gridHeight/NUMQUESTIONS);//drawing the frame
				
				if (click==true&&j*gridWidth/NUMCATEGORIES>ColorX-gridWidth/NUMCATEGORIES&&j*gridWidth/NUMCATEGORIES<=ColorX&&i*gridHeight/NUMQUESTIONS<ColorY&&i*gridHeight/NUMQUESTIONS>=ColorY-gridHeight/NUMQUESTIONS) { 
					g.setColor(Color.red); //change color to red if a bottom is clicked
				}else {
					g.setColor(Color.blue);//if the block is not clicked remain blue
				}
				g.drawString(totalPoint+" ",(j)*gridWidth/NUMCATEGORIES+gridWidth/NUMCATEGORIES/2,(i)*gridHeight/NUMQUESTIONS+gridHeight/NUMCATEGORIES/2);//write the numbers on the board!
				
			}
		}
		// how to draw your jeopardy board (categories going across, questions going down)
		
	}
	

	
	
	
	// DO NOT TOUCH BELOW CODE //
	
	public JeopardyBoardFiller() {
		
		JFrame window = new JFrame();
		window.setTitle("Jeopardy!");
		window.setSize(gridWidth, gridHeight + textHeight);
		window.setLocationRelativeTo(null);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel container = new JPanel();
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
		
		JTextArea scoreDisplay = new JTextArea();
		scoreDisplay.setEditable(false);
		scoreDisplay.setText("\t\tScore: 0");
		
		JPanel canvas = new JPanel() {
			public void paint(Graphics g) {
				gridWidth = window.getWidth();
				gridHeight = window.getHeight() - textHeight;
				draw(g);
			}
		};
		canvas.setPreferredSize(new Dimension(gridWidth, gridHeight));
		
		canvas.addMouseListener(new MouseListener() {
			
			@Override
			public void mousePressed(MouseEvent e) {
				click(e.getX(), e.getY());
				scoreDisplay.setText("\t\tScore: " + score);
				window.getContentPane().repaint();
			}

			@Override
			public void mouseClicked(MouseEvent e) {}

			@Override
			public void mouseReleased(MouseEvent e) {}

			@Override
			public void mouseEntered(MouseEvent e) {}

			@Override
			public void mouseExited(MouseEvent e) {}
		});
		
		container.add(canvas);
		container.add(scoreDisplay);
		window.add(container);
		window.setVisible(true);
	}
	
	public static void main(String[] args) {
		new JeopardyBoardFiller();
	}

}

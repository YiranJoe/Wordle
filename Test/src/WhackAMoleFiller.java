// Filler code for Whack a Mole by Mr. Friedman: THANK YOU Mr.Friedman
//ATTENTION:
/*
 if the user clicks shark, the points will minus 2; if the user clicks dolphin, the points will add 1; 
 if the user clicks the eagle, there will be 5 points added: however, each eagle only appear once!
 the goal of the game is to reach 30 points! however you can keep playing if it exceeds 30 points
 NOTE: if the user clicks too many sharks, there will be consequences!
 */
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;

public class WhackAMoleFiller {

	// size of the display area
    private int windowWidth = 800, windowHeight = 600, textHeight = 35; //the sides of the background showing in the background
    
    private int dirtHeight = 100, dirtWidth = 100, TIMESTEP = 3000;//the width and the height of the dirt	
    
    private int TIMEBIRD = 50;//set the timer for my eagles
    
    private int EagleWidth=100, EagleHeight=60;//set the height and width of my eagle
    
    private Image moleImg, bgImg, dirtImg, birdImg, extraImg, blankImg, vicImg;//insert images from the internet and rename them so that everything is clear

    // constants for the number of moles, number of moles appearing at a time, and the 
    // time gap between new moles popping up (in milliseconds)
    private final int NUMMOLES = 6, NUMEAGLE=2;
    
    private int  NUMEXTRA=2, NUMAPPEARING = 2;//number of sharks the user wants
    
    private int punishmentSharks=3, punishmentDolphin=1;
    
    private int[] x, y; // locations of the moles
    
    private boolean[] showing;	// keeps track of which moles are popped up
    
    private boolean[] showingExtra;	// keeps track of which extra features are popped up
    
    private boolean[] showingEagle;	// keeps track of Eagles situations
    
    private Timer timer, timer2;
    
    private int [] speedEagle;//set different speed of eagles
    
    private int [] xEagle,yEagle;//record the locations of eagle
    
    private int score;//score the user get
    
    private int sharkNum=0;//record the number of clicking shark
    
    private boolean win=false;//the win boolean determines whether the user wins the game
    
    public void setup() {
    	//click=false;
    	// loads your 3 images - all you need to do is match file names.
		moleImg = Toolkit.getDefaultToolkit().getImage("dolphin2.png");
		bgImg = Toolkit.getDefaultToolkit().getImage("background.jpg");
		dirtImg = Toolkit.getDefaultToolkit().getImage("pond3.png");
		birdImg = Toolkit.getDefaultToolkit().getImage("eagle.png");
		extraImg = Toolkit.getDefaultToolkit().getImage("Shark2.png");
		vicImg = Toolkit.getDefaultToolkit().getImage("victory.png");
		blankImg = Toolkit.getDefaultToolkit().getImage("blank.png");
		
		//setting up the locations and the speeds of the eagles in the window
		xEagle=new int[NUMEAGLE];
		yEagle=new int[NUMEAGLE];
		speedEagle=new int[NUMEAGLE];
		showingEagle=new boolean[NUMEAGLE];
		//setting up the number of showing sharks
		showingExtra=new boolean[NUMMOLES];
		//setting up the appearing moles in the window
		showing=new boolean[NUMMOLES];
		//xAppear=new int[NUMAPPEARING];
		//yAppear=new int[NUMAPPEARING];
		//setting up the other moles in the window
		x=new int[NUMMOLES];
		y=new int[NUMMOLES];
		//set the locations of the moles
		for(int i=0;i<NUMMOLES;i++)
		{
			x[i]=(int)(Math.random()*(windowWidth-dirtWidth)+0);
			y[i]=(int)(Math.random()*(windowHeight/3-dirtHeight)+(windowHeight/2));
		}
		//set the locations and speeds of eagles
		for(int i=0;i<NUMEAGLE;i++)
		{
			xEagle[i]=windowWidth-EagleWidth;
			yEagle[i]=(int)(Math.random()*(windowHeight/4)+EagleHeight);
			speedEagle[i]=(int)(Math.random()*20+10);
			
		}
		//initiate the mole appears as dolphins
	    for(int i=0;i<NUMAPPEARING;i++)
	    {
	       	int index=(int)(Math.random()*(NUMMOLES-1)+0);
	        if(showingExtra[index]==false&&showing[index]==false)
	       	{
	       		showing[index]=true;
	      	}
	       	else
	       	{
	       		i--;
	       		continue;
	       	}
	    }
	    //initiate the mole appears as sharks
	    for(int i=0;i<NUMEXTRA;i++)
	    {
	        int index=(int)(Math.random()*(NUMMOLES-1)+0);
	        if(showingExtra[index]==false&&showing[index]==false)
	       	{
	       		showingExtra[index]=true;
	       	}
	       	else
	       	{
	       		i--;
	       		continue;
	       	}
	    }
	    //initiate the showing of eagles
	    for(int i=0;i<NUMEAGLE;i++)
	    {
	    	showingEagle[i]=true;
	    }
    }

    public void draw(Graphics g) {
    	// draws the background image at 0,0 with a size that will cover 
    	// the entire display window
    	//draw the moles
    	if(win==true)
    	{
    		g.drawImage(bgImg, 0, 0, windowWidth, windowHeight, null);
    		g.drawImage(vicImg, 0, 0, windowWidth, windowHeight, null);
    	}
    	else
    	{
    		g.drawImage(bgImg, 0, 0, windowWidth, windowHeight, null);
    	}
    	
        for(int i=0;i<NUMMOLES;i++)
        {
        	if(showing[i]==true)//draw the Appearing Moles or sharks
        	{
        		g.drawImage(moleImg,x[i],y[i],dirtWidth,dirtHeight,null);
        	}
        	else if(showingExtra[i]==true)
        	{
        		g.drawImage(extraImg,x[i],y[i],dirtWidth,dirtHeight,null);
        	}
        	else
        	{
        		g.drawImage(dirtImg,x[i],y[i],dirtWidth,dirtHeight,null);
        	}
        }
        //draw the eagles
        for(int i=0;i<NUMEAGLE;i++)
        {
        	if(showingEagle[i]==true) {
        		g.drawImage(birdImg,xEagle[i],yEagle[i],EagleWidth,EagleHeight,null);
        	}
        	else
        	{
        		g.drawImage(blankImg,xEagle[i],yEagle[i],EagleWidth,EagleHeight,null);
        	}
        }
        // your code here
    }


    // what you want to happen when the mouse is clicked
    public void click(int mouseX, int mouseY) {
    	//the appearing moles or sharks turn to moles after being clicked by locating the x and y values of mouse
    	for(int i=0;i<NUMMOLES;i++)
    	{
    		if((mouseX>x[i]&&mouseX<x[i]+dirtWidth)&&(mouseY>y[i]&&mouseY<y[i]+dirtHeight)&&(showing[i]==true))
    		{
    			showing[i]=false;
    			score++;
    		}
    		else if((mouseX>x[i]&&mouseX<x[i]+dirtWidth)&&(mouseY>y[i]&&mouseY<y[i]+dirtHeight)&&(showingExtra[i]==true))
    		{
    			showingExtra[i]=false;
    			score-=2;//MINUS SCORES
    			sharkNum++;//record number of clicking sharks
    		}
    	}
    	//if an eagle is being clicked add 5 points and the eagle will disappear
    	for(int i=0;i<NUMEAGLE;i++)
    	{
    		if((mouseX>xEagle[i]&&mouseX<xEagle[i]+EagleWidth)&&(mouseY>yEagle[i]&&mouseY<yEagle[i]+EagleHeight)&&(showingEagle[i]==true)) 
    		{
    			showingEagle[i]=false;
    			score+=5;
    		}
    	}
    	//if the user has clicked shark for 5 times, the punishment would be more sharks and less time!
        if(sharkNum==5)
        {
        	NUMEXTRA=punishmentSharks;
        	NUMAPPEARING=punishmentDolphin;
        	TIMESTEP=1000;
        	timer.setDelay(TIMESTEP);
        }
    	//the extra features(SHARKS) turn to moles after being clicked by locating the x and y values of the mouse
        
        if(score>=30)
        {
        	win=true;
        }
    }
    
    // what you want to happen when the time for the current round ends
    public void timeAdvance() {
    	//every time reset the locations of the appearing moles and sharks
    	for(int i=0;i<NUMMOLES;i++)
    	{
    		showing[i]=false;
    		showingExtra[i]=false;
    	}
    	
        for(int i=0;i<NUMAPPEARING;i++)
        {
        	int index=(int)(Math.random()*(NUMMOLES-1)+0);
        	if(showingExtra[index]==false&&showing[index]==false)
       		{
       			showing[index]=true;
       		}
       		else
       		{
       			i--;
       			continue;
       		}
        }
        
        for(int i=0;i<NUMEXTRA;i++)
        {
        	int index=(int)(Math.random()*(NUMMOLES-1)+0);
        	if(showingExtra[index]==false&&showing[index]==false)
       		{
       			showingExtra[index]=true;
       		}
       		else
       		{
       			i--;
       			continue;
       		}
        }
        
    }
    
    public void timeEagle()
    {
    	//time step eagle to take so that they can move constantly
        for(int i=0;i<NUMEAGLE;i++)
        {
        	xEagle[i]-=speedEagle[i];
        	timer.setDelay(TIMESTEP);
        	if(xEagle[i]<=0)
        	{
        		xEagle[i]=windowWidth;
        	}
        }
    }
    
    // reset the game
    public void reset() {
    	//reset the game by setting everything back to original values
    	win=false;
    	TIMESTEP=3000;
    	NUMEXTRA=2;
    	NUMAPPEARING=2;
    	score=0;//reset the score
    	//reset the locations of moles
		for(int i=0;i<NUMMOLES;i++)
		{
			x[i]=(int)(Math.random()*(windowWidth-dirtWidth)+0);
			y[i]=(int)(Math.random()*windowHeight/3+(windowHeight/2));
		}
		//reset the locations and speeds of eagles
		for(int i=0;i<NUMEAGLE;i++)
		{
			xEagle[i]=windowWidth-EagleWidth;
			yEagle[i]=(int)(Math.random()*(windowHeight/4)+EagleHeight);
			speedEagle[i]=(int)(Math.random()*20+10);
			showingEagle[i]=true;
		}
    }


    // DO NOT TOUCH BELOW CODE //

    public WhackAMoleFiller() {
    	setup();

        JFrame window = new JFrame();
        window.setTitle("Whack A Mole");
        window.setSize(windowWidth, windowHeight + textHeight);
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

        JTextArea scoreDisplay = new JTextArea();
        scoreDisplay.setEditable(false);
        scoreDisplay.setText("\t\tScore: 0");
        
        JButton resetButton = new JButton("Reset");
        resetButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				reset();
			    window.getContentPane().repaint();
			}
        });
        
        JPanel topPanel = new JPanel();
        topPanel.setPreferredSize(new Dimension(windowWidth, textHeight));
        topPanel.add(resetButton);
        scoreDisplay.setBackground(topPanel.getBackground());
        
        topPanel.add(scoreDisplay);

        

        JPanel canvas = new JPanel() {
            public void paint(Graphics g) {
                draw(g);
                scoreDisplay.setText("\t\tScore: " + score);
            }
        };
        canvas.setPreferredSize(new Dimension(windowWidth, windowHeight));

        canvas.addMouseListener(new MouseListener() {

            @Override
            public void mousePressed(MouseEvent e) {
                click(e.getX(), e.getY());
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
        
        window.addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent componentEvent) {
                windowWidth = window.getWidth();
                windowHeight = window.getHeight() - textHeight;
                topPanel.setPreferredSize(new Dimension(windowWidth, textHeight));
                canvas.setPreferredSize(new Dimension(windowWidth, windowHeight));
            }
        });

        container.add(topPanel);
        container.add(canvas);
        window.add(container);
        window.setVisible(true);
        canvas.revalidate();
        window.getContentPane().repaint();
        
        timer = new Timer(TIMESTEP, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
            	timeAdvance();
            	window.getContentPane().repaint();
            }
        });
        timer.start();
        
        timer2 = new Timer(TIMEBIRD, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
            	timeEagle();
            	//timeAdvance();
            	window.getContentPane().repaint();
            }
        });
        timer2.start();
        		
        		
    }
    

    public static void main(String[] args) {
        new WhackAMoleFiller();
    }

}
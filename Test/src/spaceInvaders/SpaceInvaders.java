package spaceInvaders;
import java.io.*;
// Space Invaders Filler Code by Mr. David
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
//HELLO

//RULES of the game
/*
 1. The up,down,left,right keys control the player-spaceship: avoid being shot by the lasers!
 2. The player can shoot a laser when SPACE is pressed.
 3. The first task of the game is to eliminate the first round of small space invaders
 4. After killing the first round of the small space invaders, a BOSS will appear and the final goal is to kill it!
 5. Each player gets 3 lives--every time the player is hit by one laser, the player loss one live
 6. If the player has any direct physical contacts with the boss, the player will be killed because the boss is too powerful
 */

//the extra features of the game:
/*
 1. The little spaceship changes to Millennium Falcon!!
 2. Some images displayed when the player won or lost(I manually drew the WIN won so please win)
 3. COOL sound when player shoots a laser(BIUBIU)
 4. Background Music
 5. A ultimate boss at the end when the player killed all the small spaceships
 6. The exploding effects of the boss and the player(if one dies)
 7. The color-changing lasers!
 8. The background turns into the infinite universe--a better environment for impeding space invaders!
 9. More free game mode--the player can move any directions!
 */
public class SpaceInvaders {

	// constants for various aspects of the game
	private final int WIDTH = 1000, HEIGHT = 700, NUMALIENS = 20, ALIENSPEED = 4, LASERSPEED = 7, PLAYERSPEED = 6,
			LASERWIDTH = 8, LASERHEIGHT = 25, PLAYERENEMYWIDTH = 50, PLAYERENEMYHEIGHT = 60, BOSSWIDTH = 140, BOSSHEIGHT = 85, BOSSSPEED = 6, BOSSLIVE = 10, ROWS = 3,
			WINLOSSWIDTH=500, WINLOSSHEIGHT=350;

	// determines the difficulty. The closer to 1.0, the easier the game
	private final double BOSSDIFFICULTY=0.95,DIFFICULTY = 0.99;
	
	
	// our list of aliens
	private ArrayList<SpaceThing> aliens = new ArrayList<SpaceThing>();

	// our list of lasers for both the player and the aliens
	private ArrayList<Laser> alienLasers = new ArrayList<Laser>();
	private ArrayList<Laser> playerLasers = new ArrayList<Laser>();

	// the player
	private SpaceThing player;
	//the FINAL BOSS
	private SpaceThing Boss;
	//the image we used for the background
	private Image img, loss, win;

	// the current speeds of the player as well as their remaining lives
	private int lives = 3, playerSpeed = 0, 
			playerSpeedU = 0;//this is the speed I write for the player to move vertically
	//the current speed of the boss
	private int bossspeed = BOSSSPEED;
	// booleans to keep track of the game's progress
	private boolean lost = false, paused = true;
	private boolean won = false;
	//boolean to keep tract of if the boss is activated
	private boolean boss=false;
	//the count variable counting how many times does the boss got hit
	private int timesHit=0;

	// move the aliens, the lasers, and the player.
	public void move() {
		for (int i = 0; i < aliens.size(); i++) {// goes through the aliens list and move them
			aliens.get(i).moveX(ALIENSPEED);
			if (aliens.get(i).x >= WIDTH) {// if the index i alien reaches the WIDTH, set its x value back to 0
				aliens.get(i).moveX(-1 * WIDTH);
				aliens.get(i).moveY(PLAYERENEMYHEIGHT);// and then change the y value a PLAYERENEMYHEIGHT afoot
			}
			//use Math.random() to compare with DIFFICULTY to shoot the lasers
			if (Math.random() > DIFFICULTY) {
				Laser a = new Laser(aliens.get(i).x+PLAYERENEMYWIDTH/2, aliens.get(i).y, LASERWIDTH, LASERHEIGHT);//generate the lasers at the spot of the current alien
				alienLasers.add(a);
			}
			//if the aliens reach the end line OR the player has 0 lives, then we lost
			if(aliens.get(i).y>=HEIGHT-PLAYERENEMYHEIGHT||lives<=0) {
				lost=true;
				break;
			}
		}
		//go through the alien lasers and move them
		for (int i = 0; i < alienLasers.size(); i++) {
			alienLasers.get(i).moveY(LASERSPEED);
			if(alienLasers.get(i).y>HEIGHT) {//if the laser's y value is larger than the screen, remove the laser
				alienLasers.remove(i);
				i--;
			}
		}
		//go through the player lasers and move them
		for (int i = 0; i < playerLasers.size(); i++) {
			playerLasers.get(i).moveY(-LASERSPEED);
			if (playerLasers.get(i).y <= 0) {//if the laser's y value is bigger than the screen height, remove it
				playerLasers.remove(i);
				i--;
			}
		}
		
		//move the player at their current speeds when the player is in the screen
		if(player.x>=0&&player.x<=WIDTH&&player.y<=HEIGHT&&player.y>=0) {
			player.moveX(playerSpeed);
			player.moveY(playerSpeedU);
			//if the player is trying to go out of the screen, bounce them back--cannot take the shortcut to win the game!
			if(player.x<=0) {
				player.x=1;
			}
			if(player.x>=WIDTH-PLAYERENEMYWIDTH) {
				player.x=WIDTH-PLAYERENEMYWIDTH-1;
			}
			if(player.y>=HEIGHT-PLAYERENEMYHEIGHT) {
				player.y=HEIGHT-PLAYERENEMYHEIGHT-1;
			}
			if(player.y<=0) {
				player.y=1;
			}
		}
		//this starts when the boss is activated
		if(boss==true) {
			//here I want the boss to appear from random sides if it reaches the end
			if(Boss.x>=WIDTH||Boss.x<=0) {
				//if the boss go out of the screen
				if(0.5>Math.random()) {//start left if 0.5 is less than Math.random()
					Boss.x=0;
					Boss.moveY(BOSSWIDTH);//goes to the next row
					bossspeed=BOSSSPEED;//move right
					Boss.moveX(bossspeed);
				}else {
					//start right if 0.5 is NOT less than Math.random()
					Boss.x=WIDTH;
					Boss.moveY(BOSSWIDTH);//goes to the next row
					bossspeed=BOSSSPEED*-1;//set the speed to opposite--move left
					Boss.moveX(bossspeed);
				}
			}
			Boss.moveX(bossspeed);//move the boss
			if (Math.random() > BOSSDIFFICULTY) {//if Math.random() is larger than Boss Difficulty, the boss shoots lasers
				//shoot 2 lasers--one from the left the other from the right
				Laser a = new Laser(Boss.x, Boss.y, LASERWIDTH, LASERHEIGHT);
				alienLasers.add(a);
				Laser b = new Laser(Boss.x+BOSSWIDTH, Boss.y, LASERWIDTH, LASERHEIGHT);
				alienLasers.add(b);
			}
		}
		if(lives<=0) {
			lost=true;
		}
		

	}

	// check for collisions between alien lasers and the player
	// and between player lasers and the aliens
	public void checkCollisions() {
		//go through the alien lasers, see if they have intersection with the player
		for(int i=0;i<alienLasers.size();i++) {
			if(alienLasers.get(i).intersects(player)) {
				lives--;//live minus 1 if the it has intersection
				alienLasers.remove(i);//remove the laser that hit the player
				i--;
			}
			
		}
		//using a nested for-loop to check if the player lasers have intersections with all the aliens
		for(int i=0;i<playerLasers.size();i++) {//goes through the player lasers
			for(int j=0;j<aliens.size();j++) {//go through the aliens
//				System.out.println(i+" "+j); 
				if(playerLasers.get(i).intersects(aliens.get(j))) {//if they have intersection
					aliens.remove(j);//remove the alien--it is dead!
					j--;
					playerLasers.remove(i);//remove the lasers--it has been used and it's not powerful enough to kill more than one aliens
					i--;
					break;
				}
			}
		}
		//this happens when the boss is activated
		if(boss==true) {
			if(Boss.intersects(player)||Boss.y>=HEIGHT) {
				//when the boss hit the player OR the boss's y value has gone through the Height of the screen
				lost=true;//we LOST(sadly)
			}
			//go through the player lasers
			for(int i=0;i<playerLasers.size();i++) {
				//if the player's lasers have intersections with the boss
				if(playerLasers.get(i).intersects(Boss)) {
					timesHit++;//the times that the boss got hit plus plus
					playerLasers.remove(i);//remove the player lasers
					i--;
				}
				if(timesHit==BOSSLIVE) {// if the times that boss has been hit equals to the lives of the boss
					Boss=new SpaceThing(Boss.x,Boss.y,BOSSWIDTH,BOSSHEIGHT,"explosion.png");//draw the boss to be DESTROYED
					won=true;//WE FINALLY WON
				}
			}
		}
		//activate the boss when there are not aliens left in the screen, that is, the size of the aliens is 0
		if(aliens.size()==0) {
			boss=true;
		}
	}

	// set up all the elements of the game here
	public void setup() {
		img = Toolkit.getDefaultToolkit().getImage("sky.jpg");//set up the background image to the variable "img"
		loss = Toolkit.getDefaultToolkit().getImage("lost.png");//set up the background image to the variable "img"
		win = Toolkit.getDefaultToolkit().getImage("win1.png");//set up the background image to the variable "img"

		//this is my way to line up the aliens 
		int count = 0;//the count variable to keep tract of the current aliens number
		int cal = NUMALIENS / ROWS;//cal is a variable for "calculation", that is, counting how many aliens should be in a row
		for (int i = 0; i < NUMALIENS; i++) {//create NUMALIENS aliens using a for-loop
			int x = (count % cal) * PLAYERENEMYWIDTH;//set up the x value of aliens
			int y = PLAYERENEMYHEIGHT * (count / cal);//set up the y value of the aliens
			SpaceThing a = new SpaceThing(x, y, PLAYERENEMYWIDTH, PLAYERENEMYHEIGHT, "alien.png");//create the alien in the current spot
			aliens.add(a);
			count++;//the current number of aliens plus one so that we can keep tract of their locations
		}
		backgroundSound();
		//set the player to the middle of the screen, bottom with its corresponding width and height
		player = new SpaceThing(WIDTH / 2, HEIGHT - PLAYERENEMYHEIGHT*2, PLAYERENEMYWIDTH, PLAYERENEMYHEIGHT, "me.png");
		//set the boss to the middle top of the screen, with its corresponding width and height
		Boss = new SpaceThing(WIDTH / 2, 0, BOSSWIDTH, BOSSHEIGHT,"boss.png");
		paused=false;//START the game when everything is set up
	}

	// fires a player laser. if there are currently less than 4 lasers on the screen
	public void fireLaser() {
		//if the player laser size is less than 4
		if (playerLasers.size() < 4) {
			//add a new laser for the player
			Laser a = new Laser(player.x + (PLAYERENEMYWIDTH / 2), player.y, LASERWIDTH, LASERHEIGHT);
			shootSound();
			playerLasers.add(a);
		}
	}

	// draw a background with its image along with my lasers, aliens, and player here
	public void draw(Graphics g) {
		g.drawImage(img,0,0,WIDTH,HEIGHT,null);//draw the background as a big image
		//draw the list of aliens
		for (int i = 0; i < aliens.size(); i++) {
			aliens.get(i).draw(g);
		}
		player.draw(g);//draw the player
		//draw the alien lasers
		for (int i = 0; i < alienLasers.size(); i++) {
			alienLasers.get(i).draw(g);
		}
		//draw the player lasers
		for (int i = 0; i < playerLasers.size(); i++) {
			playerLasers.get(i).draw(g);
		}
		//draw the number of lives in color red
		g.setColor(Color.red);
		g.drawString("Lives: " + lives, 15, 15);
		//if the boss is activated, draw it
		if(boss==true) {
			Boss.draw(g);
		}
		//determine the output when we lost or won
		if (lost){//if lost, explode the player
			player=new SpaceThing(player.x,player.y,PLAYERENEMYWIDTH,PLAYERENEMYHEIGHT,"explosion.png");
			player.draw(g);//draw the player
			g.drawImage(loss,WIDTH/2-WINLOSSWIDTH/2,HEIGHT/2-WINLOSSHEIGHT/2,WINLOSSWIDTH,WINLOSSHEIGHT,null);//draw the GAME OVER
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			paused=true;//we pause the game
		}
		if (won) {
			g.drawImage(win,WIDTH/2-WINLOSSWIDTH/2,HEIGHT/2-WINLOSSHEIGHT/2,WINLOSSWIDTH,WINLOSSHEIGHT,null);//draw YOU WIN
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			paused=true;//we pause the game
		}
	}
	
	public void shootSound(){//this class is intended to make sounds when the player fires
	    File shootSound = new File("shoot.wav");
	    try{
	        Clip clip = AudioSystem.getClip();
	        clip.open(AudioSystem.getAudioInputStream(shootSound));
	        clip.start();
	    } catch (Exception e){
	    	System.out.println("can‘t find the shootSound source");
	    }
	}
	
	public void backgroundSound(){//this is the code for background music
	    	File backgroundSound = new File("bg4.wav");
    	try {
	        Clip clip = AudioSystem.getClip();
	        clip.open(AudioSystem.getAudioInputStream(backgroundSound));
	        clip.start();
	    } catch (Exception e){
	    	System.out.println("can't find the background music source");
	    }
	}

	
 

	// ******* DON'T TOUCH BELOW CODE ************//

	public SpaceInvaders() {
		setup();
		JFrame frame = new JFrame();
		frame.setSize(WIDTH, HEIGHT);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel canvas = new JPanel() {
			public void paint(Graphics g) {
				draw(g);
			}
		};
		canvas.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0, false), "Left");
		canvas.getActionMap().put("Left", new LeftAction());
		canvas.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0, true), "LeftRelease");
		canvas.getActionMap().put("LeftRelease", new LeftReleaseAction());
		canvas.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0, false), "Right");
		canvas.getActionMap().put("Right", new RightAction());
		canvas.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0, true), "RightRelease");
		canvas.getActionMap().put("RightRelease", new RightReleaseAction());
		canvas.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0, false), " ");
		canvas.getActionMap().put(" ", new SpaceAction());
		canvas.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_P, 0, false), "Pause");
		canvas.getActionMap().put("Pause", new PauseAction());
		frame.add(canvas);
		frame.setVisible(true);
//this is to move vertically
		canvas.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0, false), "Up");
		canvas.getActionMap().put("Up", new UpAction());
		canvas.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0, true), "UpRelease");
		canvas.getActionMap().put("UpRelease", new UpReleaseAction());
		canvas.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0, false), "Down");
		canvas.getActionMap().put("Down", new DownAction());
		canvas.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0, true), "DownRelease");
		canvas.getActionMap().put("DownRelease", new DownReleaseAction());
		
		while (true) {
			if (!paused) {
				move();
				checkCollisions();
				frame.getContentPane().repaint();
			}
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
			}
		}
	}

	private class RightAction extends AbstractAction {
		public void actionPerformed(ActionEvent e) {
			playerSpeed = PLAYERSPEED;
		}
	}

	private class LeftAction extends AbstractAction {
		public void actionPerformed(ActionEvent e) {
			playerSpeed = -PLAYERSPEED;
		}
	}

	private class LeftReleaseAction extends AbstractAction {
		public void actionPerformed(ActionEvent e) {
			playerSpeed = 0;
		}
	}

	private class RightReleaseAction extends AbstractAction {
		public void actionPerformed(ActionEvent e) {
			playerSpeed = 0;
		}
	}

	private class SpaceAction extends AbstractAction {
		public void actionPerformed(ActionEvent e) {
			fireLaser();
		}
	}

	private class PauseAction extends AbstractAction {
		public void actionPerformed(ActionEvent e) {
			paused = !paused;
		}
	}

	
	//this moves my player vertically
	private class DownAction extends AbstractAction {
		public void actionPerformed(ActionEvent e) {
			playerSpeedU = PLAYERSPEED;
		}
	}

	private class UpAction extends AbstractAction {
		public void actionPerformed(ActionEvent e) {
			playerSpeedU = -PLAYERSPEED;
		}
	}

	private class DownReleaseAction extends AbstractAction {
		public void actionPerformed(ActionEvent e) {
			playerSpeedU = 0;
		}
	}

	private class UpReleaseAction extends AbstractAction {
		public void actionPerformed(ActionEvent e) {
			playerSpeedU = 0;
		}
	}
	
	public static void main(String[] args) {
		new SpaceInvaders();
	}
}

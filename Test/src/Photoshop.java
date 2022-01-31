// Photoshop program that can run several manipulations on 
// an image
// filler code by Mr. David

import java.awt.Color;
import java.awt.Component;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;

public class Photoshop extends Component {

	// the name of the output file. will be determined by which methods are called
    private String outputName;
    
    // the 2d array of colors representing the image
    private Color[][] pixels;
    
    // the width and height of the image 
    private int w,h;
    


    public void brighten(int amount) {
        outputName = "brightened_" + outputName;
        for(int i=0;i<pixels.length;i++) {//use a nested for loop to go through every pixels of the image
        	for(int j=0;j<pixels[i].length;j++) {
        		int r=pixels[i][j].getRed()+amount;
        		int g=pixels[i][j].getGreen()+amount;
        		int b=pixels[i][j].getBlue()+amount;
        		//each pixel pluses the corresponding amount of value that the user want to to gain/loss
        		if(r>255) r=255;
        		else if(r<0) r=0;
        		
        		if(g>255) g=255;
        		else if(g<0) g=0;
        		
        		if(b>255) b=255;
        		else if(b<0) b=0;
        		//if the range of the color exceeds 255 or less than 0, set the value to 255 or 0
        		pixels[i][j]=new Color(r,g,b);
        	}
        }
    }
    
    public void flip(boolean horizontally) {
        outputName = (horizontally?"h":"v") + "_flipped_" + outputName;
        Color a=new Color(0,0,0);
        if(!horizontally) {//if the boolean is false, switch the top pixels and bottom pixels
        	for(int i=0;i<pixels.length/2;i++) {
        		for(int j=0;j<pixels[i].length;j++) {
        			a=pixels[i][j];
        			pixels[i][j]=pixels[pixels.length-1-i][j];
        			pixels[pixels.length-1-i][j]=a;
        		}
        	}
        	//if the boolean is true, switch the left pixels and right pixels
        }else {
        	for(int i=0;i<pixels.length;i++) {
        		for(int j=0;j<pixels[i].length/2;j++) {
           			a=pixels[i][j];
        			pixels[i][j]=pixels[i][pixels[i].length-1-j];
        			pixels[i][pixels[i].length-1-j]=a;
        		}
        	}
        }
    }
    
    public void negate() {
        outputName = "negated_" + outputName;
      //go through every pixels, and make make 255 minus the pixels to "inverse" the color
        for(int i=0;i<pixels.length;i++) {
        	for(int j=0;j<pixels[i].length;j++) {
        		int r=255-pixels[i][j].getRed();
        		int g=255-pixels[i][j].getGreen();
        		int b=255-pixels[i][j].getBlue();
        		
        		pixels[i][j]=new Color(r,g,b);
        	}
        }
    }
    
    public void kmeans(int num) {//
    	//steps of Kmeans:
    	//1. have a list of colors(in my code, the number of colors decide by the user,these colors would be randomly picked from the image)
    	//2. goes through every pixels in the image
    	//3. make each pixels to the closest color cluster
    	//4. average the colors in each cluster,then make the cluster to the averaged color
    	//5. repeat the 3 and 4 steps for __ times(more times repeated, more accurate)
    	int repetitionTimes=50;//NOTE: the more repetition times, the closer to the original picture but the slower program goes
    	outputName = "KMEANS_" + outputName;
    	Color[] colorList=new Color[num];
    	//randomly pick colors from the image for user-decide times
    	for(int i=0;i<colorList.length;i++) {
    		int x=(int)(Math.random()*pixels.length+0);
    		int y=(int)(Math.random()*pixels[i].length+0);
    		colorList[i]=new Color(pixels[x][y].getRed(),pixels[x][y].getGreen(),pixels[x][y].getBlue());
    	}
    	for(int c=0;c<repetitionTimes;c++) {//repeat 500 times
    	//below is a tracking line that if the repetition times are higher than 100, I suggest to uncomment it so that we can keep tract if the computer is still working
    	//	System.out.println("RunTime:"+c+" ");//keep tract that if the computer is still working, because sometimes it takes time to finish this process:(
    		int[] r=new int[colorList.length];
        	int[] g=new int[colorList.length];
        	int[] b=new int[colorList.length];//creating these 3 arrays to add up the sum of the pixels each cluster has
        	int[] Count=new int[colorList.length];//create the number of pixels each cluster collects, and eventually we need to divide this
			for(int i=0;i<pixels.length;i++) {

				for(int j=0;j<pixels[i].length;j++) {
					int indexK=0;	 
					double min=255*255;
					for(int d=0;d<colorList.length;d++) {
						if(distance(colorList[d],pixels[i][j])<min) {//find the closest number cluster
							min=distance(colorList[d],pixels[i][j]);
							indexK=d;
						}
					}
					//for every pixels' closest color, add the count array and sum corresponding r,g,b values
					Count[indexK]++;
					r[indexK]+=pixels[i][j].getRed();
					g[indexK]+=pixels[i][j].getGreen();
					b[indexK]+=pixels[i][j].getBlue();
				}
			}
			for(int e=0;e<colorList.length;e++) {
				int red=0,green=0,blue=0;
				if(Count[e]!=0) {//find the average of each number cluster
					red=(r[e])/(Count[e]);
					green=(g[e])/(Count[e]);
					blue=(b[e])/(Count[e]);
				}
				colorList[e]=new Color(red,green,blue);//set the cluster to the average
			}
		}
    		
    	
    	//after doing all of these, simplify the new set of colors
		int index=0;
	    for(int i=0;i<pixels.length;i++) {
	        for(int j=0;j<pixels[i].length;j++) {
	        	double min=255*255;
	        	for(int k=0;k<colorList.length;k++) {
	        		if(distance(colorList[k],pixels[i][j])<min) {
	        			min=distance(colorList[k],pixels[i][j]);
	        			index=k;
	        		}
	        	}
	        	pixels[i][j]=colorList[index];
	       	}
	    }
    }
    
    
    public void simplify() {
    		//set the list of colors that you want your image to have
    		Color[] colorList = {Color.BLUE, Color.RED,Color.ORANGE, Color.MAGENTA,
                Color.BLACK, Color.WHITE, Color.GREEN, Color.YELLOW, Color.CYAN};
        outputName = "simplified_" + outputName;
        //int a index to represent the closest color in the colorlist to every pixels
        int index=0;
        //go through every pixels
        for(int i=0;i<pixels.length;i++) {
        	for(int j=0;j<pixels[i].length;j++) {
        		//set a minimum value to compare and record distance
        		double min=255*255;
        		for(int k=0;k<colorList.length;k++) {
        			//use distance formula to find the closest distance between every pixels and colors in the list
        			if(distance(colorList[k],pixels[i][j])<min) {
        				min=distance(colorList[k],pixels[i][j]);
        				index=k;
        			}
        		}
        		//set the pixel to the nearest color in the colorlist
        		pixels[i][j]=colorList[index];
        	}
        }
        // your code here
         
    }
    
    public void blackorwhite() {
		Color[] colorList = {Color.black,Color.white};
		//basically it is a simplify function but set the original color to white and black, so that color blocks goes to either black or white
    outputName = "BlackOrWhite_" + outputName;
    int index=0;
    for(int i=0;i<pixels.length;i++) {
    	for(int j=0;j<pixels[i].length;j++) {
    		double min=255;
    		for(int k=0;k<colorList.length;k++) {
    			if(distance(colorList[k],pixels[i][j])<min) {
    				min=distance(colorList[k],pixels[i][j]);
    				index=k;
    			}
    		}
    		pixels[i][j]=colorList[index];
    	}
    }
     
}
    //method contributes to kmeans, simplify and black or white
    public double distance(Color c1, Color c2) {
    		return Math.sqrt(Math.pow((c1.getRed()-c2.getRed()),2)+Math.pow((c1.getGreen()-c2.getGreen()),2)+Math.pow((c1.getBlue()-c2.getBlue()),2));	// fix this
    }
    
    public void minecraft() {
    	//this method makes every 49 blocks into the same color, and therefore it looks like a image of minecraft
		outputName = "Minecraft_" + outputName;
		//go to every 7 blocks from left to right, from up to bottom
		for(int i=3;i<pixels.length-3;i+=7) {
			for(int j=3;j<pixels[i].length-3;j+=7) {
				int r=0,g=0,b=0;
				//plus the square of pixels to a sum
				for(int k=i-3;k<i+4;k++) {
					for(int l=j-3;l<j+4;l++) {
						r+=pixels[k][l].getRed();
						g+=pixels[k][l].getGreen();
						b+=pixels[k][l].getBlue();
					}
				}
				//set these pixels to the same color--their average
				for(int k=i-3;k<i+4;k++) {
					for(int l=j-3;l<j+4;l++) {
						pixels[k][l]=new Color(r/49,g/49,b/49);
					}
				}
			}
		}
	}
    
    public void blur() {
    	//unlike Minecraft, this method makes every nine blocks into the same color and make it blur
    	outputName = "blurred_" + outputName;
    	//because we don't want to mess up(modify) the original pixels, we make a new array to represent pixels of the image
    	Color[][] pixelSample=new Color[pixels.length][];
    	//goes through every 2 pixels from left to right and from top to bottom to find the "middle pixel"
    	for(int i=1;i<pixelSample.length-1;i++) {
    		pixelSample[i]=new Color[pixels[i].length];
    		for(int j=1;j<pixelSample[i].length-1;j++) {
    			//every time set r,g,b to 0 and sum the nine pixels
    			int r=0,g=0,b=0;
				for(int k=i-1;k<i+2;k++) {
					for(int l=j-1;l<j+2;l++) {
						r+=pixels[k][l].getRed();
						g+=pixels[k][l].getGreen();
						b+=pixels[k][l].getBlue();
					}
				}
				//make the new array of colors to the average of these nine pixels
				pixelSample[i][j]=new Color(r/9,g/9,b/9);
    		}
    	}
    	//insert colors from the new array to the original array
    	for(int i=1;i<pixels.length-1;i++) {
    		for(int j=1;j<pixels[i].length-1;j++) {
    			pixels[i][j]=pixelSample[i][j];
    		}
    	}
    }
    
    public void edge() {
        outputName = "edged_" + outputName;
        Color[][] pixelSample=new Color[pixels.length][];
        //go through every pixels
    	for(int i=1;i<pixelSample.length-1;i++) {
    		pixelSample[i]=new Color[pixels[i].length];
    		for(int j=1;j<pixelSample[i].length-1;j++) {
    			int r=0,g=0,b=0;
    			//still, we do not want to modify the original pixels, so we create a new array
    			//sum the r,g,b for every 9 colors in a square
				for(int k=i-1;k<i+2;k++) {
					for(int l=j-1;l<j+2;l++) {
						r+=pixels[k][l].getRed();
						g+=pixels[k][l].getGreen();
						b+=pixels[k][l].getBlue();
					}
				}
				//follow the calculation process--sum the surrounding pixels and subtract current pixel times 8
				r=(r-pixels[i][j].getRed())*-1+8*pixels[i][j].getRed();
				g=(g-pixels[i][j].getGreen())*-1+8*pixels[i][j].getGreen();
				b=(b-pixels[i][j].getBlue())*-1+8*pixels[i][j].getBlue();
				//IF it exceeds 255 or goes below 0, set it to 255 or 0
				if(r>255) r=255;
        		else if(r<0) r=0;
        		
        		if(g>255) g=255;
        		else if(g<0) g=0;
        		
        		if(b>255) b=255;
        		else if(b<0) b=0;
        		//set the block to its final color
				pixelSample[i][j]=new Color(r,g,b);
    		}
    	}
    	//insert the colors to the original array
    	for(int i=1;i<pixels.length-1;i++) {
    		for(int j=1;j<pixels[i].length-1;j++) {
    			pixels[i][j]=pixelSample[i][j];
    		}
    	}
    }
    
    
    // *************** DON'T MESS WITH THE BELOW CODE **************** //
    
    // feel free to check it out, but don't change it unless you've consulted 
    // with Mr. David and understand what the code's doing
    
    

    public void run() {
    	JFileChooser fc = new JFileChooser();
		File workingDirectory = new File(System.getProperty("user.dir")+System.getProperty("file.separator")+ "Images");
		fc.setCurrentDirectory(workingDirectory);
		fc.showOpenDialog(null);
		File my_file = fc.getSelectedFile();
		if (my_file == null)
			System.exit(-1);
		
		// reads the image file and creates our 2d array
        BufferedImage image;
		try {
			image = ImageIO.read(my_file);
		
	        BufferedImage new_image = new BufferedImage(image.getWidth(),
	                        image.getHeight(), BufferedImage.TYPE_INT_ARGB);
	        create_pixel_array(image);
			outputName = my_file.getName();
			
			// runs the manipulations determined by the user
			System.out.println("Enter the manipulations you would like to run on the image.\nYour "
					+ "choices are: brighten, flip, negate, blur, edge, minecraft, blackorwhite, simplify or kmeans.\nEnter each "
					+ "manipulation you'd like to run, then type in 'done'.");
			Scanner in = new Scanner(System.in);
			String action = in.next().toLowerCase();
			while (!action.equals("done")) {
	    			try {
		    			if (action.equals("brighten")) {
		    				System.out.println("enter an amount to increase the brightness by");
		    				int brightness = in.nextInt();
		        			Method m = getClass().getDeclaredMethod(action, int.class);
		        			m.invoke(this, brightness);
		    			}
		    			else if (action.equals("flip")) {
		    				System.out.println("enter \"h\" to flip horizontally, anything else to flip vertically.");
		        			Method m = getClass().getDeclaredMethod(action, boolean.class);
		        			m.invoke(this, in.next().equals("h"));
		    			}
		    			else if(action.equals("kmeans")) {
		    				System.out.println("enter the number of color you want to use");
		    				int numColors = in.nextInt();
		    				Method m = getClass().getDeclaredMethod(action, int.class);
		        			m.invoke(this, numColors);
		    			}else {
		        			Method m = getClass().getDeclaredMethod(action);
		        			m.invoke(this, new Object[0]);
		    			}
		    			System.out.println("done. enter another action, or type 'done'");
	    			}
	    			catch (NoSuchMethodException e) {
	    				System.out.println("not a valid action, try again");
	    			} catch (IllegalAccessException e) {e.printStackTrace();System.exit(1);} 
	    			catch (IllegalArgumentException e) {e.printStackTrace();System.exit(1);}
	    			catch (InvocationTargetException e) {e.printStackTrace();System.exit(1);}
	    			
	    			action = in.next().toLowerCase();
	    		} 
	        in.close();
	        
	        // turns our 2d array of colors into a new png file
	        create_new_image(new_image);
	        File output_file = new File("Images/" + outputName);
	        ImageIO.write(new_image, "png", output_file);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    }
		
    
    public void create_pixel_array(BufferedImage image) {
        w = image.getWidth();
        h = image.getHeight();
        pixels = new Color[h][];
        for (int i = 0; i < h; i++) {
            pixels[i] = new Color[w];
            for (int j = 0; j < w; j++) {
                pixels[i][j] = new Color(image.getRGB(j,i));
            }
        }
    }

    public void create_new_image(BufferedImage new_image) {
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
            		new_image.setRGB(j, i, pixels[i][j].getRGB());
            }
        }
    }

    public static void main(String[] args) {
		new Photoshop();
	}

    public Photoshop() {
		run();
    }
}
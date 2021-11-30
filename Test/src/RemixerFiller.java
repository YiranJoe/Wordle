import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class RemixerFiller {

	private String[] lyrics;
	private String fileName = "Perfect";	// this should match your txt file
	
	private String[] wordsToReplace;	// for part 2, if you finish the main project
	private String[] newWords;
	
	private int changingWords=3;
	
	public void remix() {
		wordsToReplace=new String[changingWords];
		newWords=new String[changingWords];
		for(int i=0;i<lyrics.length;i++)
		{
			if(lyrics[i].equalsIgnoreCase("I"))
			{
				lyrics[i]="You";
			}
		}
		
		wordsToReplace=new String[3];
		newWords=new String[3];
		
		wordsToReplace[0]="give";
		
		wordsToReplace[1]="dreams";
		
		wordsToReplace[2]="love";
		
		newWords[0]="obtain";
		
		newWords[1]="nightmares";
		
		newWords[2]="hatred";
		
		for(int i=0;i<lyrics.length;i++)
		{
			for(int j=0;j<changingWords;j++)
			{
				if(lyrics[i].equalsIgnoreCase(wordsToReplace[j]))
				{
					lyrics[i]=newWords[j];
				}
			}
		}
		
		
	}
	
	// DON'T TOUCH THE BELOW CODE //
	
	public RemixerFiller() {
		try {
			BufferedReader in = new BufferedReader(new FileReader(fileName));
			ArrayList<String> tempLyrics = new ArrayList<String>();
			for (String line = in.readLine(); line != null; line = in.readLine()) {
				
				String[] words = line.split(" ");
				for (String w : words) {
					tempLyrics.add(w.toLowerCase().replaceAll("^[^a-zA-Z0-9\\s]+|[^a-zA-Z0-9\\s]+$", ""));
				}
				tempLyrics.add("\n");
			}
			in.close();
			lyrics = new String[tempLyrics.size()];
			for (int i = 0; i < tempLyrics.size(); i++) {
				lyrics[i] = tempLyrics.get(i);
			}
			

			remix();
			
			if (fileName.substring(fileName.length()-4).equals(".txt")) {
				fileName = fileName.substring(0, fileName.length()-4);
			}
			
			BufferedWriter out = new BufferedWriter(new FileWriter(fileName + "_remixed"));
			
			for (String s : lyrics) {
				out.write(s + (s.equals("\n") ? "" : " "));
			}
			out.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
			System.exit(1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new RemixerFiller();
	}
}

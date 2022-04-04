package List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DictionarySorterFiller {
	
	public String mode = "merge";	
	public String fileName = "wordsShuffled.txt";
	
	public void swap(List<String> words,int i,int j) {
		String tempt=words.get(i);
		words.set(i, words.get(j));
		words.set(j, tempt);
	}
	
	public void selectionSort(List<String> words) {
		for(int i=0;i<words.size();i++) {
			int min=i;
			for(int j=i+1;j<words.size();j++) {
				if(words.get(min).compareTo(words.get(j))>0) {
					min=j;
				}
				swap(words,min,i);
			}
		}
	}
	
	public void insertionSort(List<String> words) {
		int j=0;
		for(int i=1;i<words.size();i++) {
			j=i;
			while (j>0&&words.get(j).compareTo(words.get(j-1))<0) {
				swap(words,j,j-1);
				j--;
			}
		}
		// your code here

	}

	public void mergeSort(List<String> words) {	// starter for your recursion
		mergeSort(words, 0, words.size()-1);
	}
	
	public void mergeSort(List<String> words, int start, int end) {
		if(start<end) {
			int mid=(start+end)/2;
			mergeSort(words,start,mid);
			mergeSort(words,mid+1,end);
			merge(words,start,mid,end);
		}
		
		// your code here

	}
	
	public void merge(List<String> words, int start, int mid, int end) {
		List<String> sort=new ArrayList<String>();
		int i=start;
		int j=mid+1;
		while (i<=mid&&j<=end) {
			if(words.get(i).compareTo(words.get(j))<0) {
				sort.add(words.get(i));
				i++;
			}else{
				sort.add(words.get(j));
				j++;
			}
		}
		for(int n=i;n<=mid;n++) {
			sort.add(words.get(n));
		}
		for(int n=j;n<=end;n++) {
			sort.add(words.get(n));
		}
		int k=start;
		for(int n=0;n<sort.size();n++) {
			words.set(k, sort.get(n));
			k++;
		}
		// your code here

	}
	
	public static void main(String[] args) throws IOException {
		new DictionarySorterFiller();
	}
	public DictionarySorterFiller() throws IOException{
		// generates the word list from the dictionary file
		BufferedReader in = new BufferedReader(new FileReader(fileName));
		List<String> words = new ArrayList<String>();
		for (String line = in.readLine(); line != null; line = in.readLine()) {
			words.add(line.trim());
		}
		in.close();
		long startTime = System.currentTimeMillis();
		if (mode.equals("selection"))
			selectionSort(words);
		else if (mode.equals("insertion"))
			insertionSort(words);
		else
			mergeSort(words);
		System.out.println("runtime: " + (System.currentTimeMillis() - startTime));
		
		BufferedWriter out = new BufferedWriter(new FileWriter("wordsSorted.txt"));
		for (String s : words)
			out.write(s + "\n");
		out.close();
	}
}

package wordle;
import java.io.*;
import java.util.*;
public class solver {

	//the hint can be separated into 3 different symbol
	//- means it is grey
	//x means it is yellow
	//any other letter means green
	/*
	 * for example: when enter "hello", 
	 * it is grey, green, grey, grey, yellow
	 * input the hint "- a - - x"(you have to include the space!)
	 * it gives you the remaining options for the words
	 * repeat 1-4
	 * GOOD LUCK WITH WORDLE!
	 */
	public static int len=5;
	public static ArrayList<Character> ban=new ArrayList<>();
	public static ArrayList<Character> contain=new ArrayList<>();
	public static Scanner io=new Scanner(System.in);
	public static ArrayList<String> words=new ArrayList<>();
	public static ArrayList<String> vocab=new ArrayList<>();
	public static HashMap<Integer,Character> sure=new HashMap<>();
//	public static HashMap<Integer,Character> unsure=new HashMap<>();
	public static ArrayList<Character>[] unsure=new ArrayList[len];
	public static boolean delima=false;
	
	
	public static void analysis(String word,ArrayList<String> list) {
		int length=len;
		System.out.println("input the hint:");
		for(int i=0;i<length;i++) {
			char a=io.next().charAt(0);
			if(a=='-') {
				ban.add(word.charAt(i));
				unsure[i].add(word.charAt(i));
			}else if(a=='x') {
				contain.add(word.charAt(i));
				unsure[i].add(word.charAt(i));
			}else {
				sure.put(i, word.charAt(i));
			}
		}
		for(int index:sure.keySet()) {
			if(contain.indexOf(sure.get(index))==-1) {
				contain.add(sure.get(index));
			}
			for(int i=0;i<list.size();i++) {
				if(list.get(i).charAt(index)!=sure.get(index)) {
					list.remove(i);
					i--;
				}
			}
		}
		for(int i=0;i<contain.size();i++) {
			for(int j=0;j<ban.size();j++) {
				if(ban.get(j)==contain.get(i)) {
					ban.remove(j);
					j--;
				}
			}
			for(int j=0;j<list.size();j++) {
				if(list.get(j).indexOf(contain.get(i))==-1) {
					list.remove(j);
					j--;
				}
			}
			for(int j=0;j<list.size();j++) {
				if(list.get(j).indexOf(contain.get(i))==word.indexOf(contain.get(i))&&!sure.containsValue(contain.get(i))) {
					list.remove(j);
					j--;
				}
			}
		}
//		System.out.println(ban);
//		System.out.println(contain);
//		System.out.println(sure);
		for(int i=0;i<ban.size();i++) {
			for(int j=0;j<list.size();j++) {
				if(list.get(j).indexOf(ban.get(i))!=-1) {
					list.remove(list.get(j));
					j--;
				}
			}
		}
		
//		for(int index:unsure) {
//			for(int i=0;i<list.size();i++) {
//				if(list.get(i).charAt(index)==unsure.get(index)) {
//					list.remove(i);
//					i--;
//				}
//			}
//		}
		for(int i=0;i<unsure.length;i++) {
			for(int k=0;k<unsure[i].size();k++) {
				for(int j=0;j<list.size();j++) {
					if(list.get(j).charAt(i)==unsure[i].get(k)) {
						list.remove(j);
						j--;
					}
				}
			}
		}
//		System.out.println(Arrays.toString(unsure));
		if(sure.size()>=2) {
			delima=true;
		}

		System.out.println("Choices:");
		System.out.println(list);
	}
	
	public static boolean single(String word) {
		for(int i=0;i<word.length()-1;i++) {
			for(int j=i+1;j<word.length();j++) {
				if(word.charAt(i)==word.charAt(j)) {
					return false;
				}
			}
		}
		return true;
	}
	
	public static ArrayList<Character> mostCommonLetters(ArrayList<String> remainingWords) {
//		ArrayList<Character> list=new ArrayList<>();
		ArrayList<Integer> unsureDigit=new ArrayList<>();
		ArrayList<Character> returnList=new ArrayList<>();
		PriorityQueue<Integer> numlist=new PriorityQueue<>();
		HashMap<Character,Integer> list=new HashMap<>();
		for(int i=0;i<len;i++) {
			if(!sure.containsKey(i)) {
				unsureDigit.add(i);
			}
		}
		for(int i=0;i<remainingWords.size();i++) {
			for(int j=0;j<unsureDigit.size();j++) {
				if(list.containsKey(remainingWords.get(i).charAt(unsureDigit.get(j)))) {
					list.put(remainingWords.get(i).charAt(unsureDigit.get(j)),1+list.get(remainingWords.get(i).charAt(unsureDigit.get(j))));
				}else {
					list.put(remainingWords.get(i).charAt(unsureDigit.get(j)), 0);
				}
			}
		}
//		System.out.println(list);
		for(char Character:list.keySet()) {
				numlist.add(list.get(Character));
		}
		while(numlist.size()>3) {
			numlist.poll();
		}
		for(int n:numlist) {
			for(char c:list.keySet()) {
				if(list.get(c)==n&&!returnList.contains(c)) {
					returnList.add(c);
					break;
				}
			}
		}
//		System.out.println(numlist);
		return returnList;
	}
	
	public static boolean isBest(String word) {
		for(int i=0;i<unsure.length;i++) {
			if(unsure[i].contains(word.charAt(i))) {
				return false;
			}
		}
		return true;
	}
	
	public static ArrayList<String> best(ArrayList<String> listOfWords,ArrayList<String> remainingWords){
		ArrayList<String> returnList=new ArrayList<>();
		for(int i=0;i<listOfWords.size();i++) {
			if(containLetter(listOfWords.get(i),mostCommonLetters(remainingWords))&&isBest(listOfWords.get(i))) {
				returnList.add(listOfWords.get(i));
			}
		}
		System.out.println("Common letters:");
		System.out.println(mostCommonLetters(remainingWords));
		System.out.println("Suggest you to choose:");
		return returnList;
	}
	
	public static boolean containLetter(String words, ArrayList<Character> list) {
		int count=0;
		if(!single(words)) {
			return false;
		}
		for(int i=0;i<words.length();i++) {
				for(int j=0;j<list.size();j++) {
					if(words.charAt(i)==list.get(j)) {
						count++;
						break;
					}
				}
		}
		if(count>=list.size()) {
			return true;
		}else {
			return false;
		}
	}
	
	public static void main(String[] args) throws Exception{
		for(int i=0;i<len;i++) {
			unsure[i]=new ArrayList<Character>();
		}
		BufferedReader in=new BufferedReader(new FileReader("answer"));
		String a=in.readLine();
		while(a!=null) {
			words.add(a);
			vocab.add(a);
			a=in.readLine();
		}
		while(true) {
			System.out.println("input your try:");
			String w=io.next();
			analysis(w,words);
			if(delima==true&&words.size()>=3) {
				System.out.println(best(vocab,words));
			}
		}
	}
}

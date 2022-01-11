
public class MoreStringP {

	public static void pigLatin(String n) {
		String m=n.substring(1)+n.substring(0,1)+"ay";
		System.out.print(m);
	}
	
	public static void replace(String word,char letter) {
		for(int i=0;i<word.length();i++) {
			if(word.charAt(i)!=letter) {
				System.out.print(word.charAt(i)+" ");
			}else {
				System.out.print("$"+" ");
			}
		}
	}
	
	public static void longest(String[] words) {
		int max=0;
		for(int i=0;i<words.length;i++) {
			if(words[i].length()>words[max].length()) {
				max=i;
			}
		}
		System.out.print(words[max]);
	}
	
	public static void main(String[] args) {
		//pigLatin("pig");
		//replace("hello",'l');
		longest(new String[]{"hi","hello","by"});
	}
}

package Map;
import java.io.*;
import java.util.*;
public class moreWithMaps {

	static Scanner io=new Scanner(System.in);
	public static void companies(HashMap<String, Integer> list) {
		while(true) {
			String companyName=io.next();
			if(list.containsKey(companyName)) {
				System.out.println(list.get(companyName));
			}else if(companyName.equals("average")) {
				double sum=0;
				int count=0;
				for(String name:list.keySet()) {
					sum+=list.get(name);
					count++;
				}
				System.out.println(sum/count);
			}else {
				int max=Integer.MIN_VALUE;
				for(String name:list.keySet()) {
					max=Math.max(max,list.get(name));
				}
				System.out.println(max);
			}
		}
	}
	public static String MorseCode(String sentence) {
		String ans="";
		HashMap<Character, String> morse = new HashMap<>();
        morse.put('a', ".-");
        morse.put('b', "-...");
        morse.put('c',  "-.-");
        morse.put('d',  "-..");
        morse.put('e',    ".");
        morse.put('f', "..-.");
        morse.put('g',  "--.");
        morse.put('h', "....");
        morse.put('i',   "..");
        morse.put('j', ".---");
        morse.put('k',   "-.");
        morse.put('l', ".-..");
        morse.put('m',   "--");
        morse.put('n',   "-.");
        morse.put('o',  "---");
        morse.put('p', ".--.");
        morse.put('q', "--.-");
        morse.put('r', ".-.");
        morse.put('s',  "...");
        morse.put('t',   "-");
        morse.put('u',  "..-");
        morse.put('v', "...-");
        morse.put('w',  ".--");
        morse.put('x', "-..-");
        morse.put('y', "-.--");
        morse.put('z', "--..");
        morse.put('1', ".----");
        morse.put('2',"..---");
        morse.put('3', "...--");
        morse.put('4', "....-");
        morse.put('5', ".....");
        morse.put('6', "-....");
        morse.put('7', "--...");
        morse.put('8', "---..");
        morse.put('9', "----.");
        morse.put('0', "-----");
        morse.put(' ', " ");
        for(int i=0;i<sentence.length();i++) {
        	char curr=sentence.charAt(i);
        	ans+=morse.get(curr)+" ";
        }
        return ans;
	}
	
	public static void MostCommonWord(String FileName) throws Exception{
		HashMap<String,Integer> map=new HashMap<>();
		BufferedReader in=new BufferedReader(new FileReader(FileName));
		String sentence=in.readLine();
		while(sentence!=null) {
			String[] list=sentence.split(" ");
			for(int i=0;i<list.length;i++) {
				if(!map.containsKey(list[i])) {
					map.put(list[i], 0);
				}else {
					map.put(list[i], map.get(list[i])+1);
				}
			}
			sentence=in.readLine();
		}
		PriorityQueue<Integer> big=new PriorityQueue<Integer>();
		for(String words:map.keySet()) {
			big.add(map.get(words));
		}
		while(big.size()>5) {
			big.poll();
		}
		ArrayList<String> appear=new ArrayList<>();
		for(int a:big) {
			for(String words:map.keySet()) {
				if(map.get(words)==a) {
					if(!appear.contains(words)) {
						System.out.print(words+" ");
						appear.add(words);
						break;
					}
				}
			}
		}
	}
	public static void main(String[] args) throws Exception {
		HashMap<String, Integer> companies=new HashMap<>();
		companies.put("ASA", 6666);
		companies.put("GregoryChocolateShop", 1);
		companies.put("CondyPhoneShop", 5000);
//		companies(companies);
//		System.out.println(MorseCode("Gregory is my friend".toLowerCase()));
		MostCommonWord("perfect");
	}
	
}

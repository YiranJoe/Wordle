package Map;
import java.io.*;
import java.util.*;
public class translator {

	public static void main(String[] args) throws Exception{
		Scanner in=new Scanner(System.in);
		BufferedReader io=new BufferedReader(new FileReader("EnglishToArabicDictionary.txt"));		
		HashMap<String,String> script=new HashMap<>();
		script.put("hello", "Ahllan");
		String a=io.readLine();
		while(a!=null) {
			String b=io.readLine();
			script.put(a, b);
			a=io.readLine();
//			System.out.println(script.get(a));
		}
		while(true) {
			System.out.println("input your word:");
			System.out.println(script.get(in.nextLine()));
		}
	}
}

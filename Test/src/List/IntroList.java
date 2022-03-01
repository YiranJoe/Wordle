package List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class IntroList {

	public static ArrayList<Character> remove2s(ArrayList<Character> a) {
		for(int i=0;i<a.size();i++) {
			a.remove(i);
		}
		return a;
	}
	
	public static ArrayList<String> reverse(String[] a){
		ArrayList<String> myString=new ArrayList<String>();
		for(int i=0;i<a.length;i++) {
			myString.add(0,a[i]);
		}
		return myString;
	}
	
	public static ArrayList<Double> doubleValue(ArrayList<Double> a){
		for(int i=0;i<a.size();i++) {
			a.set(i, 2*a.get(i));
		}
		return a;
	}
	
	public static ArrayList<Character> order(int n){
		ArrayList<Character> myList=new ArrayList<Character>();
		myList.add('a');
		for(int i=1;i<n;i++) {
			if((i+97)%2==0) {
				myList.add(myList.size(),(char)(i+97));
			}else {
				myList.add(0,(char)(i+97));
			}
		}
		return myList;
	}
	
	public static void main(String[] args) {
		Character[] s={'d', 'k', 'e', 'p', 'w', 's', 'f'};
		ArrayList<Character> myList=new ArrayList<Character>();
		Double[] b={3.0,4.0,5.0,6.0,7.0};
		ArrayList<Double> myList1=new ArrayList<Double>();
		Collections.addAll(myList1, b);
		Collections.addAll(myList, s);
//		System.out.println(remove2s(myList));
//		System.out.println(reverse(new String[]{"lists", "are", "great"}));
//		System.out.println(doubleValue(myList1));
		System.out.println(order(5));
	}
}

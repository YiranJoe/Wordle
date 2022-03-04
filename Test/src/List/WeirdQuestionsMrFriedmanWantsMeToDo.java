package List;

import java.util.ArrayList;

public class WeirdQuestionsMrFriedmanWantsMeToDo {

	public static ArrayList<Integer> random(int x,int n){
		ArrayList<Integer> a=new ArrayList<Integer>();
		for(int i=0;i<n;i++) {
			a.add((int)(Math.random()*2*x+-1*x));
		}
		return a;
	}
	
	public static void classfy(ArrayList<Integer> a) {
		ArrayList<Integer> positive=new ArrayList<Integer>();
		ArrayList<Integer> negative=new ArrayList<Integer>();
		for(int i=0;i<a.size();i++) {
			if(a.get(i)>=0) {
				positive.add(a.get(i));
			}else {
				negative.add(a.get(i));
			}
		}
		System.out.println(positive);
		System.out.println(negative);
	}
	
	public static void reverse(ArrayList<Double> a) {
		for(int i=0;i<a.size()/2;i++) {
			double tempt=a.get(i);
			a.add(i,a.get(a.size()-1-i));
			a.remove(a.size()-i-1);
			a.add(a.size()-i,tempt);
			a.remove(i+1);
		}
		System.out.println(a);
	}
	
	public static void main(String[] args) {
//		System.out.println(random(10,4));
//		classfy(random(10,4));
		ArrayList<Double> arr=new ArrayList<Double>();
		arr.add(5.0);
        arr.add(10.0);
        arr.add(15.0);
        arr.add(20.0);
        arr.add(25.0);
        arr.add(30.0);
        arr.add(35.0);
		reverse(arr);
	}
}

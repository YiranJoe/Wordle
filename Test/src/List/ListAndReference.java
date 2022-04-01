package List;

import java.util.ArrayList;

public class ListAndReference {

	public static String method1(ArrayList<Character> a) {
		String str="";
		for(int i=0;i<a.size();i++) {
			str+=a.get(i);
		}
		return str;
	}
	
	public static ArrayList<Double> method2(ArrayList<Double> a) {
		for(int i=0;i<a.size();i++) {
			double average=0;
			double sum=0;
			for(int j=0;j<a.size();j++) {
				sum+=a.get(j);
			}
			average=sum/a.size();
			a.set(i, average);
		}
		return a;
	}
	
	public static ArrayList<Integer> method3(int[] a){
		ArrayList<Integer> list=new ArrayList<Integer>();
		for(int i=0;i<a.length;i++) {
			for(int j=0;j<i+1;j++) {
				list.add(a[j]);
			}
		}
		return list;
		
	}
	
	
	public static void main(String[] args) {
		ArrayList<Double> list=new ArrayList<>();
		list.add(3.0);
		list.add(6.0);
		list.add(1.0);
		list.add(8.0);
		list.add(19.0);
		
//		System.out.println(method1(new char[]{'h','e','l','l','o'}));
//		System.out.println(method2(list));
		System.out.println(method3(new int[]{3,1,4,2}));
	}
}

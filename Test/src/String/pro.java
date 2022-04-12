package String;
import java.io.*;
import java.util.*;
public class pro {
	
	public static ArrayList<Integer> relativeMax(ArrayList<Double> a){
		ArrayList<Integer> list=new ArrayList<Integer>();
		for(int i=1;i<a.size()-1;i++) {
			if(a.get(i-1)<a.get(i)&&a.get(i+1)<a.get(i)) {
				list.add(i);
			}
		}
		return list;
	}
	
	public static void main(String[] args) {
		ArrayList<Double> list=new ArrayList<>();
		list.add(1.0);
		list.add(3.0);//index 1
		list.add(2.0);
		list.add(4.0);//index 3
		list.add(3.5);
		System.out.println(relativeMax(list));//print 1,3
		
		//Editor class
		Editor message=new Editor("I love CS");
		System.out.println(message);
		message.change("I actually hate it.(Which is not true)");
		System.out.println(message);
		message.delete();
		System.out.println(message);
		message.undo();
		System.out.println(message);
		message.redo();
		System.out.println(message);
	}
	
}

class Editor{
	//for the class I created a list for it to store the memories
	String s;
	ArrayList<String> list=new ArrayList<String>();
	boolean undoo=false;
	public Editor(String s) {
		this.s=s;
		list.add(s);
	}
	public void change(String newStr) {
		s=newStr;
		list.add(s);
	}
	public void delete() {
		s=s.substring(0,s.length()-1);
		list.add(s);
	}
	public void undo() {
		try {
			s=list.get(list.size()-2);
			undoo=true;
		}catch(Exception e){
			System.out.println("not enough editing yet my friend");
		}
	}
	public void redo() {
		try {
			if(undoo==true) {
				s=list.get(list.indexOf(s)+1);
				undoo=false;
			}
		}catch(Exception e) {
			System.out.println("u did not undo my friend");
		}
	}
	public String toString() {
		return s;
	}
	
}

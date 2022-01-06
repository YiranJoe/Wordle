import java.lang.reflect.Array;
import java.util.Arrays;

public class StringReview {

	public static boolean Alphabet(String n) {
		for(int i=1;i<n.length();i++) {
			if((int)n.charAt(i-1)>(int)n.charAt(i)) {
				System.out.println("false");
				return false;
			}
		}
		return true;
	}
	
	public static void gradeOfStudents(String[] name, int[] grade) {
		int max=0;
		int index=0;
		for(int i=0;i<grade.length;i++) {
			if(grade[i]>max) {
				max=grade[i];
				index=i;
			}
		}
		System.out.println(name[index]);
	}
	
	public static void square(int n) {
		int[] oddSquared=new int[n];
		int j=1;
		for(int i=0;i<oddSquared.length;i++) {
				oddSquared[i]=j*j;
				j+=2;
		}
		System.out.print(Arrays.toString(oddSquared));
	}
	
	public static void list(String n) {
		String output="";
		for(int i=0;i<n.length();i+=3) {
			if(i+3<n.length()) {
				output+=n.substring(i,i+3);
			}else{
				while(i<n.length()) {
					output+=n.substring(i,i+1);
				}
			}
		}
		System.out.println(output);
	}
	
	public static void main(String[] args) {
		//Alphabet("ngeo");
		gradeOfStudents(new String[]{"Yiran","Condy","Cooper"},new int[] {50,60,70});
		//square(9);
		//list("abcdefghijklm");
	}
}

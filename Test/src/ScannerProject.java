import java.util.Scanner;
public class ScannerProject {
	
	public static void num() 
	{

	}
	
	public static void main(String[] ars)
	{
		Scanner num=new Scanner(System.in);
		System.out.print("enter your numbers");
		int num1=num.nextInt();
		int num2=num.nextInt();
		int num3=num.nextInt();
		int num4=num.nextInt();
		System.out.println(num1+num2*10+num3*100+num4*1000);
	}
}

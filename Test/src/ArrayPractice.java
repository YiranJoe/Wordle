import java.util.Scanner;

public class ArrayPractice {

	public static void display(int[] displayArray)
	{
		
		for(int i=0;i<=displayArray.length-1;i++)
		{
			System.out.print(displayArray[i] + ", ");
		}
		System.out.println();
	}
	
	public static int[] oneToN(int n)
	{
		int[] arr1=new int[n];
		for(int i=0;i<=arr1.length-1;i++)
		{
			arr1[i]=i+1;
		}
		return(arr1);
	}
	
	public static void sway(int[] swayArray)
	{
		System.out.print(swayArray[0] + ", ");
		System.out.print(swayArray[swayArray.length-1]);
	}
	
	public static int[] userArray(int n)
	{
		int[] user1=new int[n];
		Scanner num=new Scanner(System.in);
		for(int i=0;i<=user1.length-1;i++)
		{
			user1[i]=num.nextInt();
		}
		return(user1);
	}
	
	public static void reverse(int[] reverseArray)
	{
		int casa=0;
		for(int i=0;i<reverseArray.length/2;i++)
		{
			casa=reverseArray[i];
			reverseArray[i]=reverseArray[reverseArray.length-i-1];
			reverseArray[reverseArray.length-i-1]=casa;
		}
		display(reverseArray);
	}
	
	public static void main(String[] args)
	{
	//	display(oneToN(6));
	//	sway(oneToN(6));
	//	display(userArray(8));
		reverse(oneToN(7));
	}
}

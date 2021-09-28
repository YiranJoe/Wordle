import java.util.Scanner;

public class HumanClassScanner {
	public static int age;
	
	public static char gender;
	public static void setAge(int x) {
		age=x;
	}
	
	public static void setGender(char g)
	{
		gender=g;
	}
	
	public static void voting()
	{
		if(age>=18) {
			System.out.println("Can vote");
		}
		else 
		{
			System.out.println("Cannot vote");
		}
	}
	
	public static void Tetanus()
	{
		if(age%4==0)
		{
			System.out.println("Yes,this person need a shot");
		}
	}
	
	public static void toddler()
	{
		if(age<4 && gender=='b')
		{
			System.out.println("toddler boy");
		}
		else if(age<4 && gender=='g')
		{
			System.out.println("toddler girl");
		}
		else
		{
			System.out.println("not a toddler");
		}
	}
	
	public static void Movie()
	{
		if(age<12||age>65)
		{
			System.out.println("Movie discount");
		}
	}
	
	public static void Teen()
	{
		if(age>=12&&age<=18)
		{
			System.out.println("teenager");
		}
	}
	
	
	public static void main(String[] ars)
	{
		Scanner input=new Scanner(System.in);
		System.out.println("enter a number: ");
		int myNum=input.nextInt();
		
		runner.setAge(18);
		runner.setGender('b');
		runner.voting();
		runner.Tetanus();
		runner.toddler();
		runner.Movie();
		runner.Teen();
		
		
	}
}

import java.util.Scanner;

public class ForLoop {
	
	private Scanner in = new Scanner(System.in);
	
public static void OVER() {//definite finite other
	Scanner num=new Scanner(System.in);
	double num2=num.nextDouble();
	double n=35;
	boolean m=false;
	while(num2!=n)
	{
		System.out.println("no");
		num2=num.nextDouble();
		
	}
	System.out.println("YES");
	
	
}

public static void NEGATIVE()//definite finite constant
{
	Scanner num=new Scanner(System.in);
	int n=num.nextInt();
	for(int i=-n;i<=n;i++)
	{
		System.out.println(i);
	}
}

public static void Fact()//definite finite constant
{
	Scanner num=new Scanner(System.in);
	int n=num.nextInt();
	int sum=1;
	for(int i=1;i<=n;i++)
	{
		sum*=i;
	}
	System.out.println(sum);
}

public static void game()//definite finite other
{
	System.out.println("Do you want to keep playing?");
	Scanner num=new Scanner(System.in);
	String n=num.next();
	while(!n.equals("no")) {
		
		System.out.println("Do you want to keep playing?");
		if(n.equals("no"))
		{
			break;
		}
		n=num.next();
	}
	System.out.println("game over");
}

public static void least()//definite finite linear
{
	Scanner num=new Scanner(System.in);
	double num1=num.nextDouble();
	double num2=num.nextDouble();
	for (double i=Math.max(num1, num2);i<=num1*num2;i+=Math.max(num1, num2))
	{
		if(i%Math.min(num2, num1)==0) 
		{
			System.out.println(i);
			break;
		}
	}
	
}

public static void greatest()
{
	Scanner num=new Scanner(System.in);
	double num1=num.nextDouble();
	double num2=num.nextDouble();
	for(double i=Math.max(num1, num2);i>=1;i--)
	{
		if(num1%i==0&&num2%i==0)
		{
			System.out.println(i);
			break;
		}
	}
}

public static void main(String[] args)
{
	ForLoop runner =new ForLoop();
	//runner.OVER();
	//runner.NEGATIVE();
	//runner.Fact();
	//runner.game();
	//runner.least();
	//runner.greatest();
}
}

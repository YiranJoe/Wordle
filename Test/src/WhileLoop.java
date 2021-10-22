import java.util.Scanner;

public class WhileLoop {

	public static void number1()//definite finite
	{
		Scanner num=new Scanner(System.in);
		int num1=num.nextInt();
		int num2=num.nextInt();
		int x=0;
		int y;
		if(num1>=num2) 
		{
			y=num2;
			num2=num1;
			num1=y;
		}
		
		while(x<=num2-num1)
		{
			System.out.println(num1+x);
			x++;
		}
	}
	
	public static void Log()//definite finite
	{
		Scanner num=new Scanner(System.in);
		double num1=num.nextDouble();
		double num2=num.nextDouble();
		int x=0;
		while(x<6)
		{
			System.out.println(num2*(Math.pow(num1, x)));
			x++;
		}
	}
	
	public static void powe()//definite finite
	{
		Scanner num=new Scanner(System.in);
		int num1=num.nextInt();
		int x=0;
		while(x*x<=num1) 
		{
			x++;
			if(x*x==num1)
			{
				System.out.println(x);
				break;
			}
			else if(x*x>num1)
			{
				System.out.println("does not have a root");
			}
		}
	}
	
	public static void bigges()// definite finite
	{
		Scanner num=new Scanner(System.in);
		int n=num.nextInt();
		int max=0;
		for(int x=0;x<n;x++)
		{
			int num1=num.nextInt();
			if(num1>max)
			{
				max=num1;
			}
		}
		System.out.println(max);
	}
	
	public static void Ty()
	{
		Scanner num=new Scanner(System.in);
		double x=num.nextDouble();

		double sin=0;
		double n = 6;
		
		for(double y=3;y<=203;y+=4) {
			sin=sin-(Math.pow(x, y)/n)+(Math.pow(x, y+2)/((n*(y+1)*(y+2))));
			n=n*(y+1)*(y+2)*(y+3)*(y+4);
		}
		System.out.println(x-sin);
	}
	
	
	
	public static void main(String[] args)
	{
		WhileLoop runner=new WhileLoop();
		//runner.number1();
		//runner.Log();
		//runner.powe();
		//runner.bigges();
		runner.Ty();
	}
}

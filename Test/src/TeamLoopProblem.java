import java.util.Scanner;

public class TeamLoopProblem {

	public void fact(double x,int n)
	{
		for(int i=1;i<=n;i++)
		{
			System.out.println(Math.pow(x,i));
		}
	}
	
	public void sum(int n)
	{
		int SUM=1;
		for(int i=2;i<=n;i++)
		{
			SUM+=i;
		}
		System.out.println(SUM);
	}
	
	public void aver()
	{
		Scanner num=new Scanner(System.in);
		int a=num.nextInt();
		int average=0;
		int i=1;
		while(a!=-1)
		{
			average+=a;
			a=num.nextInt();
			i++;
		}
		System.out.println((double)(average)/(i-1));
	}
	
	public void reverse(int n)
	{
		int m=n;
		int digit=0;
		int num=0;
		while(m/10>0)
		{
			digit++;
			m/=10;
		}
		while (digit>=0)
		{
			num+=n%10*Math.pow(10, digit);
			n/=10;
			digit--;
		}
		System.out.println(num);
	}
	
	public void decode(int n)
	{
		int digit=0;
		int m=n;
		while(m/100>=0)
		{
			digit ++;
			m/=100;
		}
		while(digit>=0)
		{
			System.out.print((char)(n/Math.pow(10, digit)));
			n%=Math.pow(10, digit);
			digit--;
		}
		
		
	}
	
	public static void main(String[] args)
	{
		TeamLoopProblem runner=new TeamLoopProblem();
		//runner.fact(3, 3);
		//runner.sum(2);
		//runner.aver();
		//runner.reverse(12345);
		//runner.decode(656770);
	}
}

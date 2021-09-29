
public class ifMethod {
	public static void PN(int a)
	{
		if(a>0)
		{
			System.out.println("Positive");
		}
		else if(a<0)
		{
			System.out.println("Negative");
		}
	}
	
	public static void para(int a)
	{
		if(a%2==0)
		{
			System.out.println("even");
		}
		else
		{
			System.out.println("odd");
		}
	}
	
	public static void chara(char a)
	{
		if((int)a>=65&&(int)a<=92)
		{
			System.out.println("UPPERCASE");
		}
		else if((int)a>=97&&(int)a<=123)
		{
			System.out.println("LOWERCASE");
		}
		else
		{
			System.out.println("Neither");
		}
	}
	
	public static void Pmul10(int a)
	{
		if(a%10==0)
		{
			System.out.println("YES");
		}
		else
		{
			System.out.println("NO");
		}
	}
	
	public static double max=0;
	
	public static void bigg(double a, double b, double c)
	{
			if(a>max) 
			{
				max=a;
			}
			if(b>max)
			{
				max=b;
			}
			if(c>max)
			{
				max=c;
			}
			System.out.println(max);
	}
	
	public static void main(String[] args)
	{
		ifMethod runner=new ifMethod();
		runner.PN(3);
		runner.para(4);
		runner.chara('N');
		runner.Pmul10(50);
		runner.bigg(3, 5, 7);
	}
	
}

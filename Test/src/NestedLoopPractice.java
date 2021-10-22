
public class NestedLoopPractice {

	public void Alphabet()
	{
		for(int i=65;i<91;i++)
		{
			System.out.print((char)i);
		}
	}
	
	public void table()
	{
		for(int i=1;i<=12;i++)
		{
			for(int j=1;j<=12;j++)
			{
				System.out.print(i*j + "   ");
			}
			System.out.println();
		}
	}
	
	public void prime(int n)
	{
		System.out.println(2);
		int prim;
		for(int i=3;i<=n;i+=2)
		{
			prim=0;
			for(int j=1;j<=Math.sqrt(i);j++)
			{
				if(i%j==0)
				{
					prim++;
				}
			}
			if(prim==1)
			{
				System.out.println(i);
			}
		}
	}
	
	public void star(int n)
	{
		for(int i=1;i<=n;i++)
		{
			for(int j=1;j<=n;j++)
			{
				if(i==j) {
					System.out.print("*");
				}
				else if(i+j==n+1) {
					System.out.print("*");
				}
				else
				{
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
	
	public void Pascal(int n)
	{
		for(int i=1;i<=n;i++)
		{
			for(int j=1;j<=n;j++)
			{
				if(i==1) {
					System.out.print(1);
				}
			}
		}
	}
	
	public static void main(String[] args)
	{
		NestedLoopPractice runner=new NestedLoopPractice();
		//runner.Alphabet();
		//runner.table();
		//runner.prime(55);
		runner.star(6);
	}
}

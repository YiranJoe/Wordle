
public class NestedLoopsMorePractice {

	public void square(int x) {
        for (int i=0;i<x;i++) 
        {
            for (int j=1;j<=x;j++) 
            {
                System.out.print((i+j)-x*((i+j)/(x+1)));
            }
            System.out.println();
        }
    }
	
	public void triangle(int n)
	{
		for(int i=1;i<=n;i++)
		{
			for(int j=1;j<=n;j++)
			{
				if(j<=i)
				{
					System.out.print("X");
				}
				else
				{
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
	
	public void what_power(int x, int y)
	{
		for(int i=1;i<=Math.sqrt(y);i++)
		{
			if(Math.pow(x, i)==y)
			{
				System.out.print(i);
				break;
			}
		}
	}
	
	
	public void diamond(int x)
	{
	int m=x-1;
	for (int i=0; i<x;i++) 
	{
		 for (int j=0; j<m; j++) 
		 {
			 System.out.print(" ");
		 }
		 for (int k=0; k<=i;k++) 
		 {
			 System.out.print("* ");
		 }
		 System.out.println();
		 m--;
	}
	int n=0;
	for(int i=x-1;i>0;i--) 
	{
		System.out.print(" ");
		for(int j=0;j<n;j++) 
		{
			System.out.print(" ");
		}
		for(int k=0;k<i;k++) {
			System.out.print("* ");
		}
		System.out.println();
		n++;
	}
	}
	public static void main(String[] args)
	{
		NestedLoopsMorePractice Runner=new NestedLoopsMorePractice();
		Runner.square(5);
	}
}

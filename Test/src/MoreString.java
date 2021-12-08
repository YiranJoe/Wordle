
public class MoreString {

	public static void same(String n)
	{
		if(n.endsWith(n.substring(0,2)))
		{
			System.out.println("yes");
		}
		else
		{
			System.out.println("no");
		}
	}
	
	public static void contain(String x,String y)
	{
		for(int i=0;i<=y.length()-1;i++)
		{
			if(x.contains(y.substring(i,i+1)))
			{
				System.out.println("yes");
			}
			else
			{
				System.out.println("no");
			}
		}
	}
	
	public static void wordsNum(String n)
	{
		int num=0;
		for(int i=0;i<=n.length()-1;i++)
		{
			if(n.substring(i,i+1).equals(" "))
			{
				num++;
			}
		}
		System.out.println(num+1);
	}
	
	public static void withoutE(String n)
	{
		for(int i=0;i<n.length();i++)
		{
			if(n.charAt(i)!='e')
			{
				System.out.print(n.charAt(i));
			}
		}
	}
	
	public static void palindrome(String n)
	{
		for(int i=0;i<n.length()/2;i++)
		{
			if(n.charAt(i)!=n.charAt(n.length()-i-1))
			{
				System.out.println("no");
				return;
			}
		}
		System.out.println("yes");
	}
	
	public static void blocks(String n)
	{
		int max=0;
		int con=1;
		for(int i=1;i<n.length();i++)
		{
			if(n.charAt(i)==n.charAt(i-1))
			{
				con++;
				if(con>max)
				{
					max=con;
				}
			}
			else
			{
				con=1;
			}
		}
		System.out.println(max);
	}
	
	public static void main(String[] args)
	{
		//same("edited");
		//contain("Hello world","leg");
		//wordsNum("I love you");
		//withoutE("lets eat there");
		//palindrome("grvrg");
		blocks("aabbbbc");
	}
}

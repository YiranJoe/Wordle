
public class StringPractice {

	public static void half(String n)
	{
		System.out.println(n.substring(n.length()/2));
	}
	
	public static void concatenate(String m, String n)
	{
		m=m.substring(1)+n.substring(1);
		System.out.println(m);
	}
	
	public static void adverb(String n)
	{
		if(n.substring(n.length()-2).equals("ly"))
		{
			System.out.println("yes");
		}
		else
		{
			System.out.println("no");
		}
	}
	
	public static void contain(String m, String n)
	{
		for(int i=0;i<m.length()-n.length();i++)
		{
			if(m.substring(i,i+n.length()).equals(n))
			{
				System.out.println("yes");
				return;
			}
		}
		System.out.println("no");
	}
	
	public static void backwards(String n)
	{
		String m = "";
		for(int i=n.length()-1;i>=0;i--)
		{
			m+=n.charAt(i);
		}
		System.out.println(m);
	}
	
	public static void box(String n)
	{
		String arr="";
		for(int i=0;i<n.length();i++)
		{
			arr=n;
			n=n.substring(1)+n.charAt(0);
			System.out.println(arr);
		}
	}
	
	public static void main(String[] args)
	{
		//half("hi there");
		//concatenate("hello","there");
		//adverb("tenatiously");
		//contain("hippo","hi");
		//backwards("hello");
		box("hello");
	}
}

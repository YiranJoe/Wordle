import java.util.Arrays;

public class FinalArrayProblems {

	public static void index(double[] n) 
	{
		int sum=0;
		for(int i=0;i<n.length;i++)
		{
			sum+=n[i]*i;
		}
		System.out.println((double)sum);
	}
	
	public static void sumint(int[] arr,int n)
	{
		for(int i=1;i<arr.length;i++){
			if(arr[i]+arr[i-1]==n)
			{
				System.out.println("yes");
				break;
			}
		}
	}
	
	public static void repeat(char[] n)
	{
		int max=0;
		int record=0;
		for(int i=0;i<n.length;i++)
		{
			int sum=0;
			for(int j=i;j<n.length;j++)
			{
				if(n[i]==n[j]) 
				{
					sum++;
				}
			}
			if(sum>max)
			{
				max=sum;
				record=i;
			}
		}
		System.out.println(n[record]);
	}
	
	public static void lowercase(char[] n)
	{
		String m=" ";
		for(int i=0;i<n.length;i++)
		{
			if((int)n[i]>=97&&(int)n[i]<=124)
			{
				m+=(char)n[i];
			}
		}
		System.out.println(m);
	}
	
	public static void main(String[] args)
	{
		//index(new double[] {5.8,3.1,2.5});
		//sumint(new int[]{1,5,2,7,3},9);
		//repeat(new char[] {'h','k','h','u','b','e','k','u','u'});
		lowercase(new char[] {'h', 'i', '!', 'H', 'e', 'l', 'L', 'o', '?'});
	}
}

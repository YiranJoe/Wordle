
public class arrayAlgorithms {
	
	public static char[] arr={'w','e','r'};
	public static char[] arr2={'s','t','l'};

	public static double aver(int[] n)
	{
		double averagenum=0;
		for(int i=0;i<n.length;i++)
		{
			averagenum+=n[i];
		}
		averagenum=averagenum/n.length;
		return averagenum;
	}
	
	public static char[] Sum(char[] m,char[] n)
	{
		char[] sum=new char[m.length+n.length];
		for(int i=0;i<m.length;i++)
		{
			sum[i]=m[i];
		}
		for(int i=m.length;i<(m.length+n.length);i++)
		{
			sum[i]=n[i-m.length];
		}
		return sum;
	}
	//public static int 
	public static void main(String[] args)
	{
		System.out.println(Sum(arr,arr2));
	}
}

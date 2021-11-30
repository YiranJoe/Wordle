import java.util.Arrays;

public class ArrayProblemWarmUp {

	public static void fibo(int n)
	{
		int[] m=new int[n];
		m[0]=1;
		m[1]=1;
		for(int i=2;i<n;i++)
		{
			m[i]=m[i-1]+m[i-2];
		}
		System.out.println(Arrays.toString(m));
	}
	
	public static void avera(int[] n)
	{
		double[] m=new double[n.length];
		for(int i=0;i<n.length;i++)
		{
			double sum=0;
			for(int j=0;j<i;j++)
			{
				sum+=n[j];
			}
			sum/=i;
			m[i]=sum;
		}
		System.out.println(Arrays.toString(m));
	}
	
	public static void list(int n)
	{
		int[] aList=new int[n];
		for(int i=0;i<n;i++)
		{
			aList[i]=i+1;
		}
		System.out.println(Arrays.toString(aList));
	}
	
	public static void aver(int[] n)
	{
		double sum=0;
		for(int i=0;i<n.length;i++)
		{
			sum+=n[i];
		}
		sum/=n.length;
		System.out.println(sum);
	}
	
	public static void doubleValues(int[] n)
	{
		for(int i=0;i<n.length;i++)
		{
			n[i]*=2;
		}
		System.out.println(Arrays.toString(n));
	}
	
	public static void divisible(int[] n)
	{
		for(int i=1;i<n.length;i++)
		{
			if(n[i]%n[i-1]==0)
			{
				System.out.print("yes" + " ");
			}
			else
			{
				System.out.print("no" + " ");
			}
		}
	}
	
	public static void trim(int[] n)
	{
		int[] arr=new int[n.length-2];
		int max=n[0],min=n[0];
		for(int i=0;i<n.length;i++)
		{
			if(n[i]>max)
			{
				max=i;
			}
			else if(n[i]<min)
			{
				min=i;
			}
		}
		int j=0;
		for(int i=0;i<n.length;i++)
		{
			if(i==max||i==min)
			{
				continue;
			}
			arr[j]=n[i];
			j++;
		}
		System.out.println(Arrays.toString(arr));
	}
	
	public static void main(String[] args)
	{
		//fibo(10);
		//list(10);
		//avera(new int[]{4,6,2,12});
		//aver(new int[]{3,4,5,6});
		//doubleValues(new int[]{3,4,5,6});
		//divisible(new int[]{8, 3, 12, 5, 15, 45});
		trim(new int[]{8, 3, 12, 5, 15, 45});
	}
	
}

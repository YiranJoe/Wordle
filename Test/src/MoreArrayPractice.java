
public class MoreArrayPractice {

	public static int samenum(int[] a,int[] b)
	{
		for(int i=0;i<a.length;i++)
		{
			for(int j=0;j<b.length;j++)
			{
				if(a[i]==b[j])
				{
					System.out.println(a[i]);
				}
			}
		}
		return 0;
	}
	
	public static int uniqueInt(int[] n)
	{
		for(int i=0;i<n.length;i++)
		{
			boolean duplicatenum=false;
			for(int j=i+1;j<n.length;j++)
			{
				if(n[i]==n[j])
				{
					duplicatenum=true;
				}
			}
			if(duplicatenum==false)
			{
				System.out.println(n[i]);
			}
		}
		return 0;
	}
	
	public static int digits(int n)
	{
		int[] arr=new int[String.valueOf(n).length()];
		/*int digit=1;
		while(n/10!=0)
		{
			digit++;
			n/=10;
		}
		int[] m=new int[digit];
		/*for(int i=0;i<digit;i++)
		{
			m[i]=(n/(int)Math.pow((double)(n), (double)(digit-i))%10);
		}*/
		for(int i=arr.length-1;i>=0;i--)
		{
			arr[i]=n%10;
			n/=10;
		}
		for(int i=0;i<arr.length;i++)
		{
			System.out.print(arr[i] + ", ");
		}
		return 0;
	}
	
	public static int uniqueArray(int []n)
	{
		int digit=0;
		boolean[] repeat=new boolean[n.length];
		for(int i=0;i<repeat.length;i++)
		{
			repeat[i]=false;
		}
		for(int i=0;i<n.length;i++)
		{
			for(int j=i+1;j<n.length;j++)
			{
				if(n[i]==n[j])
				{
					repeat[i]=true;
				}
			}
			if(repeat[i]==false) 
			{
				digit++;
			}
		}
		int[] arr=new int[digit];
		int newDigit=0;
		for(int i=0;i<repeat.length;i++)
		{
			if(repeat[i]==false)
			{
				arr[newDigit]=n[i];
				newDigit++;
			}
		}
		for(int i=0;i<arr.length;i++)
		{
			System.out.print(arr[i] + ", ");
		}
		return 0;
	}
	
	
	public static void main(String[] args)
	{
		//samenum(new int[]{3,4,5,6},new int[]{4,2,3,7});
		//uniqueInt(new int[] {6, 6, 3, 9, 4, 3, 2});
		//digits(456754);
		uniqueArray(new int[]{5,3,5,7,2,3});
	}
}

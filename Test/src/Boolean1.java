
public class Boolean1 {
	
	public static String x; 
	
	public static void Swit(String str1, String str2)
	{
		x=str1;
		str1=str2;
		str2=x;
		System.out.print(str1 + " ");
		System.out.println(str2);
	}


	public static int y;
	
	public static void remaid(int a) {
		y=a/1000;
		System.out.print(y%(a%10)+" ");
		System.out.print(y%((a/10)%10)+" ");
		System.out.println(y%((a/100)%10));
	}
	
	public static void inte(int a,int b,int c,int d,int e)
	{
		if(a==1)
		{
			a=16;
		}else{
			a=0;
		}
		if(b==1)
		{
			b=8;
		}else{
			b=0;
		}
		if(c==1)
		{
			c=4;
		}else{
			c=0;
		}
		if(d==1)
		{
			d=2;
		}else{
			d=0;
		}
		System.out.println(a+b+c+d+e);
	}
	
	public static void main(String[] args)
	{
		Boolean1 runner=new Boolean1();
		runner.inte(1,0,1,1,1);
		runner.Swit("Good","Bad");
		runner.remaid(34924);
		
	}
}

import java.util.Arrays;

public class evenMoreWith2D {
	
	public static void display(int[][] n) {
		for(int[] row:n) {
			System.out.println(Arrays.toString(row));
		}
	}
	public static void display(double[][] n) {
		for(double[] row:n) {
			System.out.println(Arrays.toString(row));
		}
	}

	public static void charString(char[][] arr) {
		String n="";
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				n+=arr[i][j];
			}
		}
		System.out.print(n);
	}
	
	public static void triangle(int n) {
		int[][] tri=new int[n][];
		for(int i=0;i<tri.length;i++) {
			tri[i]=new int[i+1];
		}
		int a=1;
		for(int i=0;i<tri.length;i++) {
			for(int j=0;j<tri[i].length;j++) {
				tri[i][j]=a;
				a++;
			}
		}
		display(tri);
	}
	
	public static void duplicate(int[][] arr) {
		int[][] arr1=new int[arr.length][arr[0].length*2];
		for(int i=0;i<arr1.length;i++) {
			int k=0;
			for(int j=0;j<arr1[i].length;j++) {
				if(j%2==0) {
					arr1[i][j]=arr[i][k];
				}else{
					arr1[i][j]=0;
					k++;
				}
			}
		}
		display(arr1);
	}
	
	public static void reverse(double[][] arr) {
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length/2;j++) {
				double temp=arr[i][arr[i].length-1-j];
				arr[i][arr[i].length-1-j]=arr[i][j];
				arr[i][j]=temp;
			}
		}
		display(arr);
	}
	public static void Sum(int[][] arr) {
		int[] n=new int[arr[0].length];
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				n[j]+=arr[i][j];
			}
		}
		System.out.println(Arrays.toString(n));
	}
	
	public static void main(String[] args) {
		//charString(new char[][]{{'h', 'e', 'l'}, {'l', 'o'}});
		//triangle(4);
		//duplicate(new int[][]{{1, 2, 3}, {4, 5, 6}});
		//reverse(new double[][]{{1, 2, 3}, {4, 5, 6}});
		Sum(new int[][]{{1, 2, 3}, {4, 5, 6}});
	}
}

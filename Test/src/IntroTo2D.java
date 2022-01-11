import java.util.Arrays;

public class IntroTo2D {

	//A. 6		B.1		C.OutOfBounce	D. 3
	//E. k		F.OutOfBounce	G. 105	H.k
	//I.{7,6}
	
	
	public static void nxn(int n) {
		int[][] matrix=new int[n][n];
		for(int i=0;i<matrix.length;i++) {
			for(int j=0;j<matrix[i].length;j++) {
				matrix[i][j]=j+i*n;
			}
		}
		for(int[] row:matrix) {
			System.out.println(Arrays.toString(row));
		}
	}
	
	public static void base(String[][] n) {
		System.out.print(n.length+" "+n[0].length);
	}
	
	public static void triangle(int a,int b,int c,int d,int e,int f) {
		int[][] arr=new int[3][];
		for(int i=0;i<arr.length;i++) {
			arr=new int[3][i+1];
		}
		arr[0][0]=a;
		arr[1][0]=b;
		arr[1][1]=c;
		arr[2][0]=d;
		arr[2][1]=e;
		arr[2][2]=f;
	}
	
	public static void main(String[] args) {
		nxn(3);
		
	}
}

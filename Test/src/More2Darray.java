import java.util.Arrays;

public class More2Darray {

	public static void display(int[][] n) {
		for(int[] row:n) {
			System.out.println(Arrays.toString(row));
		}
	}
	
	
	public static void nxm(int n,int m) {
		int[][] matrix=new int[n][m];
		for(int i=0;i<matrix.length;i++) {
			for(int j=0;j<matrix[i].length;j++) {
				matrix[i][j]=j+(i*matrix[i].length+1);
			}
		}
		display(matrix);
	}
	
	public static void maximum(double[][] arr) {
		int indexI=0,indexJ=0;
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				if(arr[i][j]>arr[indexI][indexJ]) {
					indexI=i;
					indexJ=j;
				}
			}
		}
		System.out.print(arr[indexI][indexJ]);
	}
	
	public static void average(double[][] arr) {
		double sum=0;
		int count=0;
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				sum+=arr[i][j];
				count++;
			}
		}
		System.out.print(sum/count);
	}
	
	public static void shorten(int[][] arr) {
		int[] newArr=new int[arr.length];
		for(int i=0;i<arr.length;i++) {
			int sum=0;
			for(int j=0;j<arr[i].length;j++) {
				sum+=arr[i][j];
			}
			newArr[i]=sum;
		}
		System.out.print(Arrays.toString(newArr));
	}
	
	public static void magicMatrix(int[][] arr) {
		int[] sumC=new int[arr.length];
		int[] sumR=new int[arr.length];
		int[] sumD=new int[2];
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				sumC[i]+=arr[i][j];
			}
		}
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				sumR[j]+=arr[i][j];
			}
		}
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				if(i==j) {
					sumD[0]++;
				}
			}
		}
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				if(i+j==arr.length-1) {
					sumD[1]++;
				}
			}
		}
		
		for(int i=1;i<arr.length;i++) {
			if(sumC[i]!=sumC[i-1]||sumR[i]!=sumR[i-1]||sumD[0]!=sumD[1]) {
				System.out.print("not"+" ");
				break;
			}
		}
		
		System.out.print("magic");
	}
	

	
	public static void challenge(int[][] arr) {
		int max=0;
		int indexI=0,indexJ=0;;
		for(int i=2;i<arr.length;i++) {
			for(int j=2;j<arr[i].length;j++) {
				if(arr[i-2][j-2]+arr[i-2][j-1]+arr[i-2][j]+arr[i-1][j-2]+arr[i-1][j-1]+arr[i-1][j]+arr[i][j-2]+arr[i][j-1]+arr[i][j]>max) {
					max=arr[i-2][j-2]+arr[i-2][j-1]+arr[i-2][j]+arr[i-1][j-2]+arr[i-1][j-1]+arr[i-1][j]+arr[i][j-2]+arr[i][j-1]+arr[i][j];
					indexI=i-2;
					indexJ=j-2;
				}
			}
		}
		System.out.print("{"+indexI+","+indexJ+"}");
		
	}
	
	public static void main(String[] args) {
		//maximum(new double[][]{{1000,666},{4444,100000,55555,2222,11},{9999,555,44,777,22222},{88888}});
		//nxm(3,4);
		//average(new double[][] {{3,4},{5,6,7},{8,9,10,1,2}});
		//shorten(new int[][] {{3, 5, 2}, {8, 3}, {9, 0, 1, 4}});
		//magicMatrix(new int[][] {{3,3,3},{3,3,3},{3,3,3}});
		challenge(new int[][] {{3,3,3},{3,3,3},{3,3,3},{4,4,4},{5,5,5}});
	}
}

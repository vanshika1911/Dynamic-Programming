package dynamicProgramming;

import java.util.Arrays;
import java.util.Comparator;

public class RussianDollEnvelopes {
	
	private static void solve(int[][] A) {
		
		int m = A.length;
		int n = A[0].length;
		int[][] new_arr = new int[m+m][n];
		
		for(int i=0 ;i <A.length; i++) {
			for(int j=0; j<A[0].length; j++) {
				new_arr[i][j] = A[i][j]; 
			}	
		}

		int k=m;
		for(int i=m-1 ;i >=0; i--) {
			int l=0;
			for(int j=n-1; j >=0; j--) {
				
				new_arr[k][l] = A[i][j];  // A[4][]
				l++;
			}
			k++;
		}
		
		Arrays.sort(new_arr, (int[] a, int[] b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
		
	
//		Arrays.sort(new_arr, new Comparator<int[]>() {
//
//			@Override
//			public int compare(int[] arr1, int[] arr2) {
//				
//				if(arr1[0] > arr2[0])
//				return 0;
//				else
//				return -1;
//			}
//			
//		});
		
		int[] arr = new int[new_arr.length];
		
		for(int i=0;i<new_arr.length;i++) 
			arr[i] = new_arr[i][1];
		
		
		longestIncreasingSubsequence(arr);
		
		System.out.println(Arrays.toString(arr));
		
		for(int i=0; i<new_arr.length; i++) {
			for(int j=0;j<new_arr[0].length;j++) {
				System.out.print(new_arr[i][j]+" ");
			}
			System.out.println();
		}
		
	}

	private static void longestIncreasingSubsequence(int[] A) {
	
		int[] dp = new int[A.length];
		int res =1;
		
		// Fill 1 in  the dp array
		for(int i=0;i<dp.length;i++)
			dp[i] =1;
		
		for(int i=1;i<A.length;i++) {
			for(int j=0;j<i;j++) {
				
				if(A[j] < A[i]) {
					dp[i] = Math.max(dp[i], dp[j]+1);
				}
				
				res = Math.max(dp[i], res);
			}	
		}
	
		System.out.println(res);
	}

	public static void main(String[] args) {
		int[][] A =  {  {5, 4},
				        {6, 4},
				        {6, 7},
				        {2, 3} };   
		                 
//		int[][] A = { {1,3},
//				      {9,4},
//				      {5,10}
//		              };
//		int[][] A = { {8,9},
//				      {8,18}
//		};
		solve(A);
	}
}

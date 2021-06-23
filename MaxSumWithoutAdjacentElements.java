package dynamicProgramming;

import java.util.Arrays;

public class MaxSumWithoutAdjacentElements {
	
	private static void solve(int[][] A) {
		
		int m = A.length;
		int n = A[0].length;
		int[] arr = new int[n];
		int max = Integer.MIN_VALUE;
		int k=0;

		int i=0;
		for(int j =0; j<n;j++) {

			arr[i] = Integer.max(A[0][j], A[1][j]);
            i++;
		}
		
		System.out.println(Arrays.toString(arr));
		int[] dp = new int[arr.length+1];
		int n1 =findMax(arr, arr.length-1, dp);
		
	}

	// 74 38 84 1
	private static int findMax(int[] A, int len, int[] dp) {
		
		if(len < 0)
			return 0;
			
		if(len == 0)
			return A[0];
		
		if(len == 1)
			return Math.max(A[0], A[1]);
		
		if(dp[len] != 0)
			return dp[len];
		
		dp[len] = Math.max((A[len] + findMax(A, len-2, dp)), findMax(A, len-1, dp));
		return dp[len];
		
	}

	public static void main(String[] args) {
		int[][] A = {
				{1, 2, 3, 4},
				{2, 3, 4, 5} 
		};

		solve(A);

	}
}

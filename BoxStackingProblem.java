package dynamicProgramming;

import java.util.Arrays;

public class BoxStackingProblem {
	
	private static void solve(int[][] A) {
	 
		int m = A.length;
		int n = A[0].length;
		Arrays.sort(A, (int[] a, int[] b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
		
		longestIncreasingSubsequence(A);
	}
	
	private static void longestIncreasingSubsequence(int[][] A) {
		
		int[] dp = new int[A.length];
		int res =1;
		
		// Fill 1 in  the dp array
		for(int i=0;i<dp.length;i++)
			dp[i] =1;
		
		for(int i=1;i<A.length;i++) {
			for(int j=0;j<i;j++) {
				
				if(A[j][1] < A[i][1] && A[j][0] < A[i][0] && A[j][2] < A[i][2]) {
					dp[i] = Math.max(dp[i], dp[j]+1);
				}
				
				res = Math.max(dp[i], res);
			}	
		}
	
		System.out.println(res);
	}
	public static void main(String[] args) {
		int[][] A =   { {4, 6, 7},
	                    {1, 2, 3},
	                    {4, 5, 6},
	                    {1, 2, 3} };
		
		solve(A);
 }
}
	

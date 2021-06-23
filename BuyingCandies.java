package dynamicProgramming;

public class BuyingCandies {
	
	private static void solve(int[] A, int[] B, int[] C, int D) {
	      
		int[][] dp = new int[1001][1001];
		int n = knapsack(A, C, B, D, dp, B.length);
		System.out.println(n);
		
	}

	private static int knapsack(int[] A, int[] wt, int[] val, int W, int[][] dp, int n) {
		
		if(n <= 0 || W <= 0)
			return 0;
		
		if(dp[n][W] != 0)
			return dp[n][W];
		
		if(wt[n-1] > W) {
			dp[n][W] = knapsack(A, wt, val, W, dp, n-1);
			return dp[n][W];
		}
		
		dp[n][W] = Math.max(val[n-1]*A[n-1] + knapsack(A, wt, val, W-wt[n-1], dp, n), knapsack(A, wt, val, W, dp, n-1));
		
		return dp[n][W];
	}

	public static void main(String[] args) {
		
		 int[] A = {1, 2, 3};
		 int[] B = {2, 2, 10};
		 int[] C = {2, 3, 9};
		 int D = 8;
		 
		 solve(A, B, C, D);
	}
}

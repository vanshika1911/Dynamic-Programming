package dynamicProgramming;

public class UnboundedKnapsack {
	
	private static void solve(int A, int[] B, int[] C) {
	
		int[][] dp = new int[B.length+1][A+1];
		int n = knapsack(B, C, A, dp, B.length);
		System.out.println(n);
	}

	private static int knapsack(int[] val, int[] wt, int W, int[][] dp, int n) {
		
		if( n == 0 || W == 0 )
			return 0;
			
		if(dp[n][W] != 0)
			return dp[n][W];
		
		if(wt[n-1] > W) {
			dp[n][W] = knapsack(val, wt, W, dp, n-1);
			return dp[n][W];
		}
		dp[n][W] =  Math.max((val[n-1] + knapsack(val, wt, W-wt[n-1], dp, n)), knapsack(val, wt, W, dp, n-1));
		
		return dp[n][W];
	}
	
	public static void main(String[] args) {
		
		int A = 10;
		int[] B = {5};
		int[] C = {10};
		solve(A, B, C);
	}
}

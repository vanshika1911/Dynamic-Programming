package dynamicProgramming;

public class Knapsack01 {
	
	private static void solve(int[] A, int[] B, int C) {
		
		int[][] dp = new int[A.length+1][C+1];
		int n = knapsack(A, B, C, dp, A.length);
		System.out.println(n);
	}

	private static int knapsack(int[] val, int[] wt, int W, int[][] dp, int n) {
		
		if(n == 0 || W == 0)
			return 0;
			
		if(dp[n][W] != 0)
			return dp[n][W];
		
		if(wt[n-1] > W) {
			dp[n][W] = knapsack(val, wt, W, dp, n-1);
			return dp[n][W];
		}
		dp[n][W] =  Math.max((val[n-1] + knapsack(val, wt, W-wt[n-1], dp, n-1)), knapsack(val, wt, W, dp, n-1));
		
		return dp[n][W];
	}

	public static void main(String[] args) {
	
		 int[] A = {60, 100, 120};
		 int[] B = {10, 20, 30};
		 int C = 50;
		 
		 solve(A, B, C);
	}
}

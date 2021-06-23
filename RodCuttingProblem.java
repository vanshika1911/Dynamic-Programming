package dynamicProgramming;

public class RodCuttingProblem {
	
	private static void solve(int A, int[] B) {
		
		int[] C = new int[B.length];
		for(int i=0;i<B.length;i++)
			C[i] = B[i];
		
		int[][] dp = new int[B.length+1][A+1];
		int result = knapsack(A, B, C, dp, B.length);
		System.out.println(result);
	}

	private static int knapsack(int W, int[] val, int[] wt, int[][] dp, int n) {
		
		if( n == 0 || W == 0 )
			return 0;
			
		if(dp[n][W] != 0)
			return dp[n][W];
		
		if(wt[n-1] > W) {
			dp[n][W] = knapsack(W, val, wt, dp, n-1);//(val, wt, W, dp, n-1);
			return dp[n][W];
		}
		dp[n][W] =  Math.min((val[n-1] + knapsack(W-wt[n-1],val, wt, dp, n)), knapsack(W, val, wt, dp, n-1));
		
		return dp[n][W];
	}

	public static void main(String[] args) {
		int A = 6; 
		int[] B = {1, 2, 5};
		solve(A, B);
	}
}

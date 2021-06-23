package dynamicProgramming;

public class TusharBirthday {
	
	private static int solve(int[] A, int[] B, int[] C) {
		
		int[][] dp = new int[1001][1001];
		
		for(int i=0;i<dp.length;i++) {
			for(int j=0;j<dp[0].length;j++) {
				dp[i][j] = -1;
			}
		}
		
		int minCost =0;
		
		for(int i=0;i<A.length;i++)
			minCost += Knapsack(A[i], B, C, dp, C.length-1);
		
		return minCost;
	}

	private static int Knapsack(int W, int[] wt, int[] val, int[][] dp, int n) {
		
		if( W == 0)
		   return 0;
		
		if(W < 0 || n < 0 )
			return 999999;
		
		if(dp[n][W] != -1)
			return dp[n][W];
		
		//System.out.println(wt[n-1]+ "  "+W);
		if(wt[n] > W) {
			dp[n][W] = Knapsack(W, wt, val, dp, n-1);
			return dp[n][W];
		}
		
		dp[n][W] = Math.min(val[n] + Knapsack(W - wt[n], wt, val, dp, n), Knapsack(W, wt, val, dp, n-1) );
		
		return dp[n][W];
	}

	public static void main(String[] args) {
		
		int[] A = {2, 4, 6};
		int[] B = {2, 1, 3};
		int[] C = {2, 5, 3};
		
		System.out.println(solve(A, B, C));
	}
}

package dynamicProgramming;

public class CoinSumInfinite {
	
	private static void solve(int[] A, int B) {
		
		long[][] dp = new long[A.length+1][B+1];
	
		long n = knapsack(A, B, dp, A.length);
		System.out.println(n);
		
	}

	private static long knapsack(int[] wt, int W, long[][] dp, int n) {
		
		if( W == 0 )
			return 1;
		
		if(n <= 0)
			return 0;
		
		if(n == 0 && W >= 1)
			return 0;
			
		if(dp[n][W] != 0)
			return dp[n][W];
		
		if(wt[n-1] > W) {
			dp[n][W] = knapsack( wt, W, dp, n-1);
			return dp[n][W];
		}
		
		dp[n][W] =   knapsack( wt, W-wt[n-1], dp, n) + knapsack( wt, W, dp, n-1);
		
		return dp[n][W];
	}

	public static void main(String[] args) {
		
		int[] A = {1, 2, 3};
		int	B = 4;
		solve(A, B);

	}

	

}

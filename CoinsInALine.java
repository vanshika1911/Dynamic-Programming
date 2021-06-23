package dynamicProgramming;

public class CoinsInALine {
	
	private static void solve(int[] A) {
		
		int[][] dp = new int[A.length+1][A.length+1];
		int max =maxCoins(A, dp, 0, A.length-1);
		
		System.out.println(max);
	}

	private static int maxCoins(int[] A, int[][] dp, int i, int j) {

		if(i >= A.length || j < 0)
			return 0;

//		if(i == j)
//			return A[i];
		
		if(i > j)
			return 0;

		if(dp[i][j] != 0)
			return dp[i][j];
		
		dp[i][j] = Math.max(A[i]+ Math.min(maxCoins(A, dp, i+2, j), maxCoins(A, dp, i+1, j-1)), 
				                A[j] + Math.min(maxCoins(A, dp, i+1, j-1), maxCoins(A, dp, i, j-2)));
		
		return dp[i][j];
	}

	public static void main(String[] args) {
	     int[]  A = {1, 2, 3, 4};
	     solve(A);
	}
}

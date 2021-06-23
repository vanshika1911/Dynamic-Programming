package dynamicProgramming;

public class BlockThePath {
	
	private static void solve(String[][] A) {
	
		int m = A.length;
		int n = A[0].length;
		int[][] dp = new int[m+1][n+1];
		
		blockThePath(A, 0, 0, dp);
	}

	private static void blockThePath(String[][] A, int i, int j, int[][] dp) {
	
		dp[m][n] = uniquePaths(A, m-1, n, dp) + uniquePaths(A, m, n-1, dp);
		
	}

	public static void main(String[] args) {
		String[][] A = { { "0","0"},
				         { "0","0" } };
		solve(A);
	}
}

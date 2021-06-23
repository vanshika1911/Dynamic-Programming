package dynamicProgramming;

public class UniquePaths {
	
	private static int solve(int[][] A) {
		
		int m = A.length;
		int n = A[0].length;
		int[][] dp = new int[n+1][m+1];
		
		return uniquePaths(A, m, n, dp);	
	}

	private static int uniquePaths(int[][] A, int m, int n, int[][] dp) {
         
		if(m == 0 || n == 0)
			return 1;
		
		else
			
			dp[m][n] = uniquePaths(A, m-1, n, dp) + uniquePaths(A, m, n-1, dp);
		
		return dp[m][n];
	}

	public static void main(String[] args) {
		int[][] A = {{0, 0, 0},
		             {0, 1, 0},
		             {0, 0, 0} };
		
		System.out.println(solve(A));
	}
}

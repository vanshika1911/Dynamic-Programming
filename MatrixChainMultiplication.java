package dynamicProgramming;

public class MatrixChainMultiplication {
	
	private static void solve(int[] A) {
		
		int[][]dp = new int[A.length+1][A.length+1];
		int ans =mcm(A, 1, A.length-1, dp);
		
		System.out.println(ans);
		
	}

	private static int mcm(int[] A, int i, int j, int[][] dp) {
		
		if(i >= j)
			return 0;
		
		if(dp[i][j] != 0)
			return dp[i][j];
		
		int min = Integer.MAX_VALUE;
		for(int k=i; k <=j-1; k++) {
			
			int temp = mcm(A, i, k, dp) + mcm(A, k+1, j, dp) + (A[i-1]*A[k]*A[j]);
			
			if(temp < min)
				min = temp;
		}
		dp[i][j] = min;
			
		return dp[i][j];
		
	}

	public static void main(String[] args) {
		int[] A = {40, 20, 30, 10, 30};
		solve(A);
	}
}

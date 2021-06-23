package dynamicProgramming;

import java.util.Arrays;

public class MinSumPathInMatrix {

	private static void solve(int[][] A) {


		int[][] dp = new int[A.length+1][A[0].length+1];

		int sum = minSumPathInMatrix(A, 0, 0, dp);

		System.out.println(sum);
	}

	private static  int minSumPathInMatrix(int[][] A, int i, int j ,int[][] dp) {

		if(i < 0 || j < 0 || i >= A.length || j >= A[0].length) return Integer.MAX_VALUE;

		if(i == A.length-1 && j == A[0].length-1)
			return A[i][j];

		if(dp[i][j] != 0)
			return dp[i][j];

		dp[i][j] = A[i][j] + Math.min(minSumPathInMatrix(A, i+1, j, dp), minSumPathInMatrix(A, i, j+1, dp));

		return dp[i][j];
	}

	public static void main(String[] args) {
		int[][] A = {
				{1, 3, 2},
				{4, 3, 1},
				{5, 6, 1} };

		solve(A);
	}
}

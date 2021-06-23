package dynamicProgramming;

public class LengthOfLongestFibonacciSubsequence {

	private static int solve(int[] A) {

		int n = A.length;
		int[][] dp = new int[n][n];
		int result =0;

		for(int k=2; k<n;k++) {
			int i=0; 
			int j=k-1;

			while(i < j) {

				int sum = A[i]+A[j]-A[k];

				if(sum < 0)
					i++;
				else if(sum > 0)
					j++;
				else {

					dp[j][k] = dp[i][j]+1;
					result = Math.max(result, dp[j][k]);
					i++;
					j--;
				}

			}
		}
		return result+2 >= 3? result+2 : 0;

	}

	public static void main(String[] args) {
		int[]  A = {1, 2, 3, 4, 5, 6, 7, 8};
		System.out.println(solve(A));
	}
}

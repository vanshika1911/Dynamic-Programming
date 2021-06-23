package dynamicProgramming;

public class RepeatingSubsequence {

	private static void solve(String A) {

		int m = A.length();
		int[][] dp = new int[101][101];

		for(int i=0;i<101;i++){
			for(int j=0;j<101;j++){
				dp[i][j] = -1;
			}
		}

		int lcs =lcs(A, m, A, m, dp);
		System.out.println(lcs);	
	}

	private static int lcs(String A, int l1, String B, int l2, int[][] dp) {

		if(l1 == 0 || l2 == 0)
			return 0;

		if(dp[l1][l2] != -1)
			return dp[l1][l2];

		if(A.charAt(l1-1) == B.charAt(l2-1) && (l1 != l2))
			dp[l1][l2] = 1 + lcs(A, l1-1, B, l2-1, dp);

		else
			dp[l1][l2] = Math.max(lcs(A, l1, B, l2-1, dp), lcs(A, l1-1, B, l2, dp));

		return dp[l1][l2];
	}

	public static void main(String[] args) {
		String A = "abba";//"aabb";//"abab";
		solve(A);
	}
}

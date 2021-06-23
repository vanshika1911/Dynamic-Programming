package dynamicProgramming;

import java.util.Arrays;

public class LCS {
	
	private static void solve(String A, String B) {

		int l1 = A.length();
		int l2 = B.length();
		int[][] dp = new int[l1+1][l2+1];
		//int n = LCS(A, l1, B, l2, dp);
		int n1 = LCSIterative(A, l1, B, l2, dp); // Iterative way
		System.out.println(n1);
	}

	private static int LCSIterative(String A, int l1, String B, int l2, int[][] dp) {
		
		// already have default value as 0
//			for(int i=0;i<l1+1;i++)
//				dp[i][0] =0;
//			
//			for(int i=0;i<l2+1;i++)
//				dp[0][i] =0;
		

		for(int i=1; i<=l1; i++) {
			for(int j=1;j<=l2;j++) {
				
				if(A.charAt(i-1) == B.charAt(j-1))
					dp[i][j] = 1 + dp[i-1][j-1];
				
				else
				dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
			}
		}
		
		for(int i=0; i<=l1; i++) {
			for(int j=0;j<=l2;j++) {
				System.out.print(dp[i][j]);
			}
			System.out.println();
		}
		return dp[l1][l2];	
	}

	private static int LCS(String A, int l1, String B, int l2, int[][] dp) {
	
		if(l1 == 0 || l2 == 0)
			return 0;
		
		if(dp[l1][l2] != 0)
			return dp[l1][l2];
			

		if(A.charAt(l1-1) == B.charAt(l2-1))
			dp[l1][l2] = 1 + LCS(A, l1-1, B, l2-1, dp);

		else
			dp[l1][l2] = Math.max(LCS(A, l1-1, B, l2, dp), LCS(A, l1, B, l2-1, dp));
		
		  return dp[l1][l2];
	}

	public static void main(String[] args) {
		
		String A = "abbcdgf";// "aaaaaa"; //
		String B =  "bbadcgf";//"ababab"; //
		solve(A,B);
	}
}

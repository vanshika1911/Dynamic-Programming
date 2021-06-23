package dynamicProgramming;

public class ThreeStrings {
	
	private static void solve(String A, String B, String C) {
		
		int[][][] dp = new int[100][100][100];
		
		int lcs =LCS(A, A.length(), B, B.length(), C, C.length(), dp);
	
		System.out.println(lcs);
	}

	private static int LCS(String A, int l1, String B, int l2, String C, int l3, int[][][] dp) {
		
		if(l1 <= 0 || l2 <= 0 || l3<=0)
			return 0;
		
		if(dp[l1][l2][l3] != 0)
			return dp[l1][l2][l3];
		
		if(A.charAt(l1-1) == B.charAt(l2-1) && (B.charAt(l2-1) == C.charAt(l3-1))) {
			dp[l1][l2][l3] = 1 + LCS(A, l1-1, B, l2-1, C, l3-1, dp);
		}
		
		else
			dp[l1][l2][l3] = Math.max(LCS(A, l1-1, B, l2, C, l3, dp), Math.max(LCS(A, l1, B, l2-1, C, l3, dp), LCS(A, l1, B, l2, C, l3-1, dp))); 
		
		return dp[l1][l2][l3];
	}

	public static void main(String[] args) {
//		String  A = "abab";
//		String	B = "aaab";
//		String	C = "aazb";
		
		String A = "eaae";
		String B = "bdecddcadb";
		String C = "cac";
		
		solve(A, B, C);
	}
}

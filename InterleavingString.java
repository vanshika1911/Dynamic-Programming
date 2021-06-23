package dynamicProgramming;

public class InterleavingString {
	
	private static int solve(String A, String B, String C) {
		
		int m = A.length();
		int n = B.length();
		boolean[][] dp = new boolean[m+1][n+1];
		
		if(interleavingString(A, m, B, n, C, dp))
			return 1;
		else
			return 0;
	}

	private static boolean interleavingString(String A, int m, String B, int n, String C, boolean[][] dp) {

		if((m+n) != C.length())
			return false;
		
		for(int i=0;i<=m;i++) {
			for(int j=0;j<=n;j++) {

				if(i == 0 && j == 0)
					dp[i][j] =true;

				else if(i==0) {
					if(B.charAt(j-1) == C.charAt(j-1))
						dp[i][j] = dp[i][j-1];
				}

					else if(j == 0) {
						if(A.charAt(i-1) == C.charAt(i-1))
							dp[i][j] = dp[i-1][j];
					}

					else if(C.charAt(i+j-1) == A.charAt(i-1) && C.charAt(i+j-1) != B.charAt(j-1)) {
						dp[i][j] = dp[i-1][j];
					}

					else if(C.charAt(i+j-1) == B.charAt(j-1) && C.charAt(i+j-1) != A.charAt(i-1)) {
						dp[i][j] = dp[i][j-1];
					}

					else if(C.charAt(i+j-1) == B.charAt(j-1) && C.charAt(i+j-1) == A.charAt(i-1)){

						dp[i][j] =  dp[i-1][j] || dp[i][j-1];
					}
				}
			}
		

		return dp[m][n];
//		dp[0][0] = true;
//		
//		// Filling Zeroth row
//		for(int i=1;i<=n;i++) {
//			if(A.charAt(i-1) == C.charAt(i-1))
//				dp[0][i] = dp[0][i-1];
//		}
//
//		// Filling Zeroth col
//		for(int j=1;j<=m;j++) {
//			if(B.charAt(j-1) == C.charAt(j-1))
//				dp[j][0] = dp[j-1][0];
//		}
//		
//		// Filling remaining rows ans cols
//		for(int i=1;i<m;i++) {
//			for(int j=1;j<n;j++) {
//				
//				if(C.charAt(i+j-1) == A.charAt(i-1))
//					dp[i][j] = dp[i-1][j];
//				
//				if(C.charAt(i+j-1) == B.charAt(j-1))
//					dp[i][j] = dp[i][j] || dp[i][j-1];
//			}
//		}
//		
//		for(int i=0;i<m;i++) {
//			for(int j=0;j<n;j++) {
//				
//				System.out.print(dp[i][j]+"  ");
//			}
//			System.out.println();
//		}
//		
//		return dp[m-1][n-1];
//		
	}

	public static void main(String[] args) {
		String A = "aabcc";
		String B = "dbbca";
        String 	C = "aadbbcbcac";
        
        System.out.println(solve(A, B, C));
	}
}

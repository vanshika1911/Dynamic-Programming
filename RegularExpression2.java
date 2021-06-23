package dynamicProgramming;

public class RegularExpression2 {

	private static int solve(String A, String B) {

		boolean[][] dp = new boolean[A.length()+1][B.length()+1];
		if(wildcardMatch(A, A.length(), B, B.length(), dp))
			return 1;
		else
			return 0;

	}

	private static boolean wildcardMatch(String inputStr, int li, String wildcard, int lw, boolean[][] dp) {

		int writeIndex =0;
		boolean isFirst= true;;
		char[] pattern = wildcard.toCharArray();
		char[] input = inputStr.toCharArray();

		// remove extra * from wildcard string
		for(int i=0;i<li;i++) {

			if(pattern[i] == '*') {

				if(isFirst) {
					pattern[writeIndex++] = pattern[i];
					isFirst = false;
				}
			}
			else {
				pattern[writeIndex++] = pattern[i];	
				isFirst = true;
			}
		}

		dp[0][0] = true;

		for(int i=1;i<dp.length;i++) {
			for(int j=1;j<dp[0].length;j++) {

				if(pattern[j-1] =='.' || pattern[j-1] == input[i-1]) {
					dp[i][j] = dp[i-1][j-1];
				}
				else if(pattern[j-1] =='*') {

					//dp[i][j] = dp[i-1][j] || dp[i][j-1];
					dp[i][j] = dp[i][j-2] || dp[i-1][j];
				}

			}
		}

		boolean ans = dp[input.length][writeIndex];

		return ans;
	}

	public static void main(String[] args) {
		String A = "aab";
		String B = "c*a*b";

		System.out.println(solve(A, B));
	}

}

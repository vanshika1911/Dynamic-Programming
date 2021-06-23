package dynamicProgramming;

public class LongestPalindromicSubstring {

	private static void solve(String A) {

		int n = A.length();
		boolean[][] dp = new boolean[n+1][n+1];
		int x=0;
		int y=0;
		int max = Integer.MIN_VALUE;

		for(int i=n-1;i>=0;i--) {
			for(int j=i;j<=n-1; j++) {

				if(i == j)
					dp[i][j] = true;

				else if(A.charAt(i) == A.charAt(j)) {

					if(j-i == 1)
						dp[i][j] = true;
					else
						dp[i][j] = dp[i+1][j-1];
				}

				if(dp[i][j] && j-i>= max) {
					max = j-i;
					x =i;
					y=j;
				}
			}
		}	

		String s = A.substring(x, y-x+1);
		System.out.println(s);
	}

	public static void main(String[] args) {
		String A = "babad";
		solve(A);
	}
}

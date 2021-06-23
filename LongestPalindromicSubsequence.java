package dynamicProgramming;

public class LongestPalindromicSubsequence {

	private static void solve(String s) {
		
		int[][] dp = new int[s.length()][s.length()];
		int max =0;
		
		for(int i=0;i<s.length();i++) {
			for(int j=0;j<s.length();j++) {


				if(i == j) {
					dp[i][j] = 1;

				}
			}
		}

			for(int j=1;j<s.length();j++) {
				
				for(int p=0, q =j; q<s.length();p++, q++) {
				
				if(s.charAt(p) == s.charAt(q)) {
					
					dp[p][q] = 2+dp[p+1][q-1];
				}
				else {
					dp[p][q] = Math.max(dp[p+1][q], dp[p][q-1]);
				}
			}
		}
		
		 for (int k = 0; k < dp.length; k++) {
		        for (int m = 0; m < dp[0].length; m++) {
		            System.out.print(dp[k][m]);
		        }
		        System.out.println();
		    }
		
	}
	
	public static void main(String[] args) {
	   String s = "bebdeeedaddecebbbbbabebedc";//"aedsead";
	   solve(s);
	}
}

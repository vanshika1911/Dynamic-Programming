package dynamicProgramming;

public class LCSIterative {
	
	
	private static void solve(String A, String B) {
		
		int l1 = A.length();
		int l2 = B.length();
		int[][] dp = new int[l1+1][l2+1];
		findLcsIterative(A, l1, B, l2, dp);	
	}
	
	private static int findLcsIterative(String A, int l1, String B, int l2, int[][] dp) {

	    for (int i=0;i<l1+1;i++)
	        dp[i][0]=0;

	    for (int i=0;i<l2+1;i++)
	        dp[0][i]=0;

	    for (int i = 1; i <=l1; i++) {
	        for (int j = 1; j <=l2; j++) {

	             if (A.charAt(i-1) == B.charAt(j-1))
	                dp[i][j] = 1 + dp[i - 1][j - 1];
	            else
	                dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
	        }
	    }
	    
	    for (int k = 0; k <=l1; k++) {
	        for (int m = 0; m <=l2; m++) {
	            System.out.print(dp[k][m]);
	        }
	        System.out.println();
	    }

	    return dp[l1][l2];
	}

	public static void main(String[] args) {
		
		String A = "abbcdgf";// "aaaaaa"; //
		String B =  "bbadcgf";//"ababab"; //
		solve(A, B);

	}

	

}

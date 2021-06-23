package dynamicProgramming;

public class EditDistance {
	
	private static void solve(String s1, String s2) {
		
		int l1 = s1.length();
		int l2 = s2.length();
		int[][] dp = new int[l1+1][l2+1];
		//int n = editDistance(s1, l1 , s2, l2, dp);
		int n = editDistanceIterative(s1, l1 , s2, l2, dp);
		System.out.println(n);
	}

	private static int editDistanceIterative(String s1, int l1, String s2, int l2, int[][] dp) {
	
		for(int i=0;i<=l1;i++) 
			dp[i][0] = i;
		
		for(int i=0;i<=l2;i++) 
			dp[0][i] = i;
		

		for(int i=1;i<=l1;i++) {
			for(int j=1;j<=l2;j++) {
				
				if(s1.charAt(i-1) == s2.charAt(j-1))
					dp[i][j] =  dp[i-1][j-1];
				
				else
					dp[i][j] = 1 + Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1])); //A= p q  B = p    q
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

	private static int editDistance(String s1, int l1, String s2, int l2, int[][] dp) {
		
		if(l1 == 0)
			return l2;
		
		if(l2 == 0)
			return l1;
		
		if(dp[l1][l2] != 0)
			return dp[l1][l2];
		
		if(s1.charAt(l1-1) == s2.charAt(l2-1))
			dp[l1][l2] =  editDistance(s1, l1-1, s2, l2-1, dp);
		
		else
			dp[l1][l2] = 1 + Math.min( editDistance(s1, l1-1, s2, l2, dp) , Math.min(  editDistance(s1, l1, s2, l2-1, dp) ,  editDistance(s1, l1-1, s2, l2-1, dp)));
		
		    return dp[l1][l2];
	}

	public static void main(String[] args) {
		String s1 ="aaa";//"Anshuman";
		String s2 = "aa";//"Antihuman";
		
		solve(s1, s2);
	}
}

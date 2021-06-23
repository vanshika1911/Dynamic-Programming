package dynamicProgramming;

public class RegularExpressionIterative {
	
	private static void solve(String A, String B) {
		
		
		char[] str = A.toCharArray();
		char[] pattern = B.toCharArray();
		int writeIndex = 0;
		
		//replace extra * from the pattern string
		boolean isFirst = true;

		for(int i=0;i<pattern.length;i++) {

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
	
        boolean[][] dp = new boolean[str.length+1][writeIndex+1];
        
        if(writeIndex > 0 && pattern[0] == '*') 
        	dp[1][0] = true;
        
        dp[0][0] = true;
		
			for(int i=1;i<B.length();i++) {
				for(int j=1;j<A.length();j++) {
					
					if(A.charAt(i-1) == B.charAt(j-1) || B.charAt(j-1) == '?')
						dp[i][j] = dp[i-1][j-1];
					
					else if(pattern[j-1] == '*'){
							dp[i][j] = dp[i-1][j] || dp[i][j-1];
					}
					
				}
			}
			
			for(int i=0; i<dp.length; i++) {
				for(int j=0;j<dp[0].length;j++) {
					System.out.print(dp[i][j]+" ");
				}
				System.out.println();
			}
			
			boolean ans = dp[str.length][writeIndex];
			
		}

	public static void main(String[] args) {
		String  A = "xaylmz"; 
		String	B = "x?y*z";
		
		solve(A,B);
	}
}

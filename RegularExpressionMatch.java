package dynamicProgramming;

public class RegularExpressionMatch {

	private static int solve(String A, String B) {
	
		    int l1 = A.length();
	        int l2 = B.length();
	        
	        int[][] dp = new int[l1+1][l2+1];
	        
	        
	         for(int i=0;i<=l1;i++){
	             for(int j=0;j<=l2;j++)
	                 dp[i][j] = -1;
	         }
	        
	         return wildCardMatch(A, l1, B, B.length(),dp);
	}
	
	private static int wildCardMatch(String inputString, int li, String wildcardString, int lw, int[][] dp) {

	        if(li == 0 && lw ==0)
	            return 1; //dp[li][lw]=1;
	           
	        if (lw==0)
	            return 0; // dp[li][lw]=0;

	        if(li == 0) {
	            if (wildcardString.charAt(lw - 1) == '*')
	                dp[li][lw] = wildCardMatch(inputString, li, wildcardString, lw - 1, dp);
	            else
	                return 0; //dp[li][lw]= 0;
	        }

	        if(dp[li][lw] != -1)
	            return dp[li][lw];

	        // case 1
	        if(inputString.charAt(li-1) == wildcardString.charAt(lw-1))
	            dp[li][lw] = wildCardMatch(inputString,li-1,wildcardString,lw-1,dp);

	        // case 2
	        else if (wildcardString.charAt(lw-1) == '?')
	            dp[li][lw] = wildCardMatch(inputString,li-1,wildcardString,lw-1,dp);
	       
	        // case 3
	        else if (wildcardString.charAt(lw-1) == '*'){
	            // case 1   -> * can be current character
	           
	                int n1=  wildCardMatch(inputString,li-1,wildcardString,lw,dp);
	                int n2 = wildCardMatch(inputString, li,wildcardString,lw-1,dp);
	               
	                if(n1==0 && n2==0)
	                    dp[li][lw] =0;
	                else
	                    dp[li][lw] =1;
	        }
	        else
	            dp[li][lw] = 0;

	        return dp[li][lw];
	    }
	   
	
	public static void main(String[] args) {
		String  A = "xaylmz"; // aa // a   //""    // ""
		String	B = "x?y*z";  //a*  //a*  //a*  // a
		
		System.out.println(solve(A,B));
	}
}

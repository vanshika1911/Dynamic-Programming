package dynamicProgramming;

public class DistinctSubsequence {
	
	    public static int numDistinct(String A, String B) {
	      
	    	int dp [][] = new int[B.length()+1][A.length()+1];

	    	int ans = findDistinctNumIterative(A , A.length() , B , B.length() , dp);
	    	
	    	//int ans =  findDistinctNum(A,A.length(),B,B.length(),dp);
	    	System.out.println("Ans: " + ans);

	    	return ans;
	    }

	    private static int findDistinctNumIterative(String A, int la, String B, int lb, int dp[][]) {
	    	
	    	System.out.println(dp.length+"  "+dp[0].length);
	    	System.out.println(la+"  "+lb);
	        for (int i=0;i<=la;i++)
	            dp[0][i] = 1;

	        
	        for (int i=1 ;i<=lb; i++){
	            for (int j=1 ;j<=la; j++){

	            	//System.out.println(i+"   "+j);
	                if (A.charAt(j-1) == B.charAt(i-1)){
	                    dp[i][j] = dp[i][j-1] + dp[i-1][j-1] ;
	                }else
	                    dp[i][j] = dp[i][j-1];
	            }
	        }

	        System.out.println("After");
	        for (int k = 0; k <dp.length; k++) {
	            for (int m = 0; m <dp[0].length; m++) { 
	                System.out.print(dp[k][m]);
	            }
	            System.out.println();
	        }
	        return dp[lb][la];
	    }

	    private int findDistinctNum(String superStr, int la, String subStr, int lb,int dp[][]) {

	        if (lb ==0)
	            return 1;
	        if (la == 0)
	            return 0;

	        if (dp[la][lb] != 0)
	            return dp[la][lb];

	        if (superStr.charAt(la-1) != subStr.charAt(lb-1))
	            dp[la][lb] = findDistinctNum(superStr,la-1,subStr,lb,dp);
	        else
	            dp[la][lb] = (findDistinctNum(superStr,la-1,subStr,lb,dp) + findDistinctNum(superStr,la-1,subStr,lb-1,dp));

	        return dp[la][lb]/2;
	    }


	public static void main(String[] args) {
		 
		  String  A = "rabbbit"; //"abc"; //
		  String B ="rabbit"; // "abc"; // 
		numDistinct(A, B);

	}

}

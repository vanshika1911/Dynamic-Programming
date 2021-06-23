package dynamicProgramming;

public class MaximumPathInTriangle {
	
	private static int solve(int[][] A) {
		
		 int[][] dp = new int[A.length+1][A[0].length+1];  

	     return  maxPathInTriangle(A, 0, 0, dp);
	    }
	    
	    public static int maxPathInTriangle(int[][] A, int i, int j, int[][] dp) {
	        
	        if(i == A.length || j == A[0].length)
	            return 0;
	            
	        if(dp[i][j] != 0)
	          return dp[i][j];
	          
	         dp[i][j] = A[i][j] + Math.max(maxPathInTriangle(A, i+1, j, dp),  maxPathInTriangle(A, i+1, j+1, dp));
	        
	        return dp[i][j];
	    }

	public static void main(String[] args) {
//	      int[][] A = {{3, 0, 0, 0},
//	    	           {7, 4, 0, 0},
//	    	           {2, 4, 6, 0},
//	    	           {8, 5, 9, 3} };    
		 int[][] A = {
		               {8, 0, 0, 0},
		               {4, 4, 0, 0},
		               {2, 2, 6, 0},
		               {1, 1, 1, 1}
		             };
	      System.out.println(solve(A));
	}
}

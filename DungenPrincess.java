package dynamicProgramming;

import java.util.Arrays;

public class DungenPrincess {
	
	private static void solve(int[][] A) {
		
		int m = A.length;
		int n = A[0].length;
		int[][] dp = new int[m][n];
		
		if(A[m-1][n-1] < 0)
			dp[m-1][n-1] = 1 - A[m-1][n-1];
		else
			dp[m-1][n-1] = 1;

		//Last row
		for(int j=dp[0].length-2;j >=0;j--) {

			if(dp[m-1][j+1] - A[m-1][j] <= 0)
				dp[m-1][j] = 1;
			else
				dp[m-1][j] = dp[m-1][j+1] - A[m-1][j];	
		}

		// Last col
		for(int i=dp.length-2;i >=0;i--) {
			
		if(dp[i+1][n-1] - A[i][n-1]  <= 0)
			dp[i][n-1] = 1;
		else
		  dp[i][n-1] =  dp[i+1][n-1] - A[i][n-1] ;	
		}
		
        // rem cell
		for(int i=m-2;i>=0;i--) {
			for(int j=n-2;j>=0;j--) {
				
				int min = Math.min(dp[i+1][j], dp[i][j+1]);
				
				if(A[i][j] <= 0 || A[i][j] < min)
				dp[i][j] = min - A[i][j];
				else
					dp[i][j] = 1;
			}
		}
		
		  for (int k = 0; k <m; k++) {
	            for (int m1 = 0; m1 <n; m1++) { 
	                System.out.print(dp[k][m1]+" ");
	            }
	            System.out.println();
	        }
		
	}
	public static void main(String[] args) {
//	int[][] A =   { 
//	               {-2, -3,   3},
//	               {-5, -10,  1},
//	               {10,  30, -5}
//	               };
		
	int[][] A = {
			     {1, -1, -1},   //         3
		         {-1, -1, -1},  //         3
		         {-1, -1, -1}    //    1 1  2
	            };
	              
	solve(A);
 }	
}

	

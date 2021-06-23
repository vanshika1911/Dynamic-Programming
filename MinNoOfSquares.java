package dynamicProgramming;

import java.util.Arrays;

public class MinNoOfSquares {
	
	static int count=0;
	private static void solve(int A) {
	     
		int[] dp = new int[A+1];
	
		if(A >= 3) {
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 3;
		}
		else
			System.out.println(A);
		
		int n =countMin(A, dp);
		System.out.println(n);	
	}
 
	private static int countMin(int A, int[] dp) { // 6
		

		if(A < 4) {
			return A;
		}
		if(dp[A] != 0)
			return dp[A];
		
		  countMin(A-1, dp);
		
		int ans =0;
		int min = Integer.MAX_VALUE;
		for(int i =1; i<=Math.sqrt(A) ;i++) { 
		  ans = A - (i*i); 
		  min = Math.min(dp[ans], min);  
		}
		dp[A] = min+1;
     
		
		return dp[A];
	}

	public static void main(String[] args) {
		int A =1;
		solve(A);
	}
}

package dynamicProgramming;

import java.util.Arrays;

public class ArithmeticSlices {
	
	//static int sum =0;
	private static void solve(int[] A) {
		
		//int[] dp = new int[A.length];
		int dp =0;
		int res =0;
		
		for(int i=2;i<A.length;i++) {
			
			if(A[i] - A[i-1] == A[i-1] - A[i-2]) {
				
				//dp[i] = 1 + dp[i-1];
				//res += dp[i];
				dp++;
				res += dp;
			}
			else
				dp =0;
		}
		
		//int n = arithmeticSubSequence(A, A.length-1, dp);
		System.out.println(res);
	}

	private static int arithmeticSubSequence(int[] A, int index, int[] dp) {
		
		if(index <2)
			return 0;
		
		if(dp[index] != 0)
			return dp[index];
		
		//int res =0;
		
		System.out.println(Arrays.toString(dp));
		System.out.println(index);
		
		if(A[index] - A[index-1] == A[index-1] - A[index-2]) {
			
			dp[index] += 1 + arithmeticSubSequence(A, index-1, dp);		
		}
		else {
			 arithmeticSubSequence(A, index-1, dp);
		}
		
		return dp[index];
	
	}

	public static void main(String[] args) {
		int[] A =  {2, 4, 6, 8, 10};
		
		solve(A);
	}
}

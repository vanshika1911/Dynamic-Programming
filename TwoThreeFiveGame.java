package dynamicProgramming;

import java.util.Arrays;

public class TwoThreeFiveGame {
	
	private static void solve(int[] A) {
		
		int[] dp = new int[100001];
		
		dp[0] = 0;
		dp[1] = 0;
		dp[2] = 1;
		dp[3] = 1;
		dp[4] = 1;
		dp[5] = 1;
		dp[6] = 1;
		
		for(int i =7; i< 100001;i++) {
			
			if(dp[i-2] == 0 || dp[i-3] == 0 || dp[i-5] == 0) {
				dp[i] = 1;
			}
			else
				dp[i] = 0;
		}
		
		String[] ans  = new String[A.length];
		
		for(int i=0;i<A.length;i++) {
			
			if(dp[i] == 1)
				ans[i] ="Alice";
			else
				ans[i] = "bob";
		}
		
		System.out.println(Arrays.toString(ans));
	}

	public static void main(String[] args) {
		int[] A = {1, 6, 4};
		
		solve(A);
	}
}

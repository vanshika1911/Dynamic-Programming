package dynamicProgramming;

public class Stairs {
	
	private static int solve(int A) {
		
		int[] dp = new int[A+1];
		return waysToFindPath(A, dp);	
	}

	private static int waysToFindPath(int A, int[] dp) {
		
		if(A <= 1)
			return 1;
		
		if(A == 2)
			return 2;
		
		if(dp[A] != 0) {
			return dp[A];
		}
		else {
			dp[A] = waysToFindPath(A-1,dp) + waysToFindPath(A-2,dp);
		}
		return dp[A];
	}

	public static void main(String[] args) {
		int A =17;//4;
		System.out.println(solve(A));
	}
}

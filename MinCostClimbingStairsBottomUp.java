package dynamicProgramming;

public class MinCostClimbingStairsBottomUp {
	
	private static int solve(int[] cost) {

		//return bottomUpApproach(cost);
		
		return bottomUpApproachOptimize(cost);
		
	}

	private static int bottomUpApproachOptimize(int[] cost) {
		
		int n = cost.length;
		
		int dp1 = 0;
		int dp2 = 0;
		
		for(int i=n-1;i>=0;i--) {
			
			int dpi = cost[i] + Math.min(dp1, dp2);
			dp2 = dp1;
			dp1 = dpi;
		}
		
		return Math.min(dp1, dp2);
		
	}

	private static int bottomUpApproach(int[] cost) {

		int n = cost.length;
		
		int[] dp = new int[n+2];
		
		dp[n] = 0; // recursion condition if(i>= c.length) return 0;
		dp[n+1] = 0; // recursion condition if(i>= c.length) return 0;
		
		for(int i=n-1;i>=0;i--) {
			dp[i] = cost[i] + Math.min(dp[i+1], dp[i+2]);
		}
		
		return Math.min(dp[0], dp[1]);
	}

	public static void main(String[] args) {
		int[] cost = {10,15,20};
		System.out.println(solve(cost));

	}

}

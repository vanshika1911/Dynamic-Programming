package dynamicProgramming;

public class MinCostClimbingStairs {

	 static int[] dp = new int[1001];
	private static int solve(int[] cost) {
		
		//using recursion
		//return Math.min(minCostUsingRecursion(1, cost),minCostUsingRecursion(0, cost));
		
		//Using dp
		for(int i=0;i<dp.length;i++)
			dp[i] = -1;
		
		return Math.min(minCostUsingDp(1, cost, dp),minCostUsingDp(0, cost, dp));
	
	}

	private static int minCostUsingDp(int i, int[] cost, int[] dp) {
		
		if(i >= cost.length)
			return 0;
		
		if(dp[i] != -1)
			return dp[i];
		
		int op1 = minCostUsingDp(i+1, cost, dp);
		int op2 = minCostUsingDp(i+2, cost, dp);
		
		dp[i] = Math.min(op1, op2) + cost[i];
		
		return dp[i];
	}

	private static int minCostUsingRecursion(int i, int[] cost) {
	
		if(i >= cost.length)
			return 0;
		
		int op1 = minCostUsingRecursion(i+1, cost);
		int op2 = minCostUsingRecursion(i+2, cost);
		
		return Math.min(op1, op2)+cost[i];
	}

	public static void main(String[] args) {
		int[] cost = {10,15,20};
		System.out.println(solve(cost));
	}
}

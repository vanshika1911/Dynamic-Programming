package dynamicProgramming;

public class LongestIncreasingSubsequence {
	
	private static void solve(int[] A) {
	
		int[] dp = new int[A.length+1];
		int res =1;
		
		// Fill 1 in  the dp array
		for(int i=0;i<dp.length;i++)
			dp[i] =1;
		
		for(int i=1;i<A.length;i++) {//9
			for(int j=0;j<i;j++) { //10
				
				if(A[j] < A[i]) {
					dp[i] = Math.max(dp[i], dp[j]+1);
				}
				
				res = Math.max(dp[i], res);
			}	
		}
		System.out.println(res);
		
	}

	public static void main(String[] args) {
		int[] A = {10, 9, 2, 5, 3, 7, 101, 18}; 
		solve(A);	
	}
}

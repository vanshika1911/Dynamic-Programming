package dynamicProgramming;

public class WineProblem {
	
	private static void solve(int[] A) {
		
		int[][] dp = new int[A.length][A.length];
		//int n =wineProblem(A, 0, A.length-1, 1, dp);
		int n =wineProblemIterative(A, 0, A.length-1, dp);
		System.out.println(n);
	}

	private static int wineProblemIterative(int[] A, int start, int end , int[][] dp) {
		
		int  year = A.length;
		
		for(int i=0;i<dp.length;i++) {
			for(int j=0;j<dp[0].length;j++) {
				
				if( i == j) {
					dp[i][j] = A[i]*year;
				}
			}
		}
		year--;
		for(int j=1;j<A.length;j++) {
			
			for(int p=0, q =j; q<A.length;p++, q++) {
				
				 if(q > p){
					//dp[i][j] = Math.max(A[i]*(year-1) +  dp[i+1][j], A[j]*(year-1) + dp[i][j-1]);
					dp[p][q] = Math.max(A[q]*year +  dp[p][q-1], A[p]*year + dp[p+1][q]);
				}
			}
			year--;
		}
		
		for(int i=0; i<dp.length; i++) {
			for(int j=0;j<dp[0].length;j++) {
				System.out.print(dp[i][j]+" ");
			}
			System.out.println();
		}
		
		return dp[0][dp[0].length-1];
	}

	private static int wineProblem(int[] A, int start, int end, int year, int[][] dp) {
	
		if(A.length == 0)
			return 0;
		
		if(start == end) {
			dp[start][end] = A[start]*year;
		  return dp[start][end];
	}
		
		if(start > end)
			return 0;
		
		if(dp[start][end] != 0)
			return dp[start][end];
		
		
		dp[start][end] =  Math.max(A[start]*year +  wineProblem(A, start+1, end, year+1, dp), A[end]*year + wineProblem(A, start, end-1, year+1, dp));
		
		return dp[start][end];
	
	}

	public static void main(String[] args) {
		int[]  A = {1, 2, 4, 3, 1};
		
		solve(A);
	}
}

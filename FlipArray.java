package dynamicProgramming;

class node{
	
	int weight;
	int items;
	
	public node(int weight, int items) {
		
		this.weight = weight;
		this.items = items;
	}
}

public class FlipArray {
	
	private static int solve(int[] A) {
		
		node[][] dp = new node[105][10005];
		int n = A.length;
		int sum = 0;
		
		for(int i=0;i<n;i++)
			sum += A[i];
		
		for(int i=0;i<105;i++) {
			for(int j=0;j<10005;j++) {
				
				dp[i][j] = new node(0,0);
			}
		}
		
		int temp = sum/2;

		for(int i=0;i<=n;i++) {
			for(int j=0;j<=temp;j++) {

				if(i == 0 || j == 0)
					dp[i][j] = new node(0,0);

				else {

					int prevWeight = dp[i-1][j].weight;
					int prevItems = dp[i-1][j].items;

					if(j - A[i-1] >= 0) {

						int currWeight = dp[i-1][j - A[i-1]].weight + A[i-1];
						int currItems = dp[i-1][j - A[i-1]].items +1;

						if(currWeight > prevWeight || (currWeight == prevWeight 
								&& currItems < prevItems)) {
							
							dp[i][j] = new node(currItems, currWeight);
						}
						else {
							dp[i][j] = dp[i-1][j];
						}

					}
					else {
						dp[i][j] = dp[i-1][j];
					}
				}
			}
		}
		
		return dp[n][temp].items;
	}

	public static void main(String[] args) {
		int[] A = {15, 10, 6};
		
		System.out.println(solve(A));
	}
}

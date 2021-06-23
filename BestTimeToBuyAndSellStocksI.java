package dynamicProgramming;

public class BestTimeToBuyAndSellStocksI {
	
	private static void solve(int[] A) {
	
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		int cost =0;
		
		int index =0;
		for(int i=0;i<A.length;i++) {
			
			if(min > A[i]) {
				min = A[i];
				index = i;
			}
		}
		
		for(int i=index;i<A.length;i++) {
			
			cost = A[i] - min;
			max = Math.max(cost, max);
		}
		
		System.out.println(max);
		
	}

	public static void main(String[] args) {
		int[] A = {2, 1};//{1, 4, 5, 2, 4};
		solve(A);
	}
}

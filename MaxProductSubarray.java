package dynamicProgramming;

public class MaxProductSubarray {
	
	private static int solve(int[] A) {
		
		int choice1 = 0;
		int choice2 =0;
		int max_prod =A[0];
		int min_prod =A[0];
		int ans = A[0];

		//4,2,-5,1, -3, -6, 0, 3 ,5
		for(int i=1;i<A.length;i++) {
			
			if(A[i] ==  0) {
				choice1=0;
				choice2=0;
				max_prod =0;
				min_prod =0;
			}
			else {
				
				choice1 = max_prod * A[i]; //8 //-40
				choice2 = min_prod * A[i]; //8 //-10
				max_prod = Math.max(A[i], Math.max(choice2, choice1)); //8 //-5
				min_prod = Math.min(A[i], Math.min(choice2, choice1)); // 2  //-40
				
			}
			ans = Math.max(ans ,Math.max(max_prod, min_prod)); //8 //-5
		}
		return ans;
		
	}

	public static void main(String[] args) {
		int[] arr = {-1, -3, 10, 0 ,60};//{-3,-5};//{-3, 0, -5, 0};//{4,2,-5,1, -3, -6, 0, 3 ,5};// //
		System.out.println(solve(arr));
	}
}

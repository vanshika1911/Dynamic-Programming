package dynamicProgramming;

public class MaximumSum {
	
	private static void solve(int[] A, int B, int C, int D) {
		
        int n = A.length;
        
        int[] left = new int[n];
        
        // fill left max value
        left[0] = B*A[0];
        for(int i=1;i<n;i++){
            left[i] = Math.max(left[i-1], B*A[i]);
        }
        
        int[] right = new int[n];
        
        //fill right max value
        right[n-1] = D*A[n-1];
        for(int i=n-2;i>=0;i--){
            right[i] = Math.max(right[i+1], D*A[i]);
        }
        
        int ans = Integer.MIN_VALUE;
        //traverse through the entire array
        for(int i=0;i<A.length;i++){
            
            ans = Math.max(ans, left[i] + C*A[i] + right[i]);
        }
        
        System.out.println(ans);
		
	}

	public static void main(String[] args) {
		
		 int[] A = {1, 5, -3, 4, -2};
		 int B = 2;
		 int C = 1;
		 int D = -1;
		 
		 solve(A, B, C, D);
	}
}

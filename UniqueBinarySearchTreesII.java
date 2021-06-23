package dynamicProgramming;

public class UniqueBinarySearchTreesII {
	
	private static int solve(int A) {
		
		return catalanNo(A);
		
	}

	private static int catalanNo(int A) {
	
		int[] catalan = new int[A+1];
		catalan[0] = 1;
		catalan[1]= 1;
		
		for(int i=2;i<=A;i++) {
			
			catalan[i] =0;
			
			for(int j=0;j<i;j++) {
				catalan[i] += catalan[j]*catalan[i-j-1];
			}
		}
		
		return catalan[A];
	}

	public static void main(String[] args) {
		
		int A = 2;
		System.out.println(solve(A));
	}
}

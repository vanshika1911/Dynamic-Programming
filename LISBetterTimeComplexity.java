package dynamicProgramming;

public class LISBetterTimeComplexity {

	private static int solve(int[] A) {

		int[] parent = new int[A.length];
		int[] increasingSub = new int[A.length+1];
		int length = 0;

		for(int i=0;i<A.length;i++) {

			int low =1;
			int high = length;

			while(low <= high) {

				int mid = low+(high-low)/2;

				if(A[increasingSub[mid]] < A[i])
					low = mid+1;

				else
					high = mid-1;
			}
			int pos = low;
			//update parent element for LIS
			parent[i] = increasingSub[pos-1];
			//replace
			increasingSub[pos] = i;

			if(pos > length)
				length=pos;
		}

		return length;
	}

	public static void main(String[] args) {
		int[] A = {10, 9, 2, 5, 3, 7, 101, 18};
		System.out.println(solve(A));
	}
}

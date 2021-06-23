package dynamicProgramming;

import java.util.Arrays;
import java.util.Stack;

public class MaxRectangleInBinaryMatrix {
	
	private static int solve(int[][] A) {

		int[] arr = new int[A[0].length];
		int maxArea = Integer.MIN_VALUE;

		for(int i=0;i<A.length;i++) {
			int index =0;
			for(int j=0;j<A[0].length;j++) {

				if(A[i][j] == 1)
					arr[index++] += A[i][j];
				else
					arr[index++] =0;
			}
			int area = largestAreaInHistogram(arr);
			maxArea = Math.max(maxArea, area);
			//System.out.println(Arrays.toString(arr));
		}
		
		return maxArea;

	}

	private static int largestAreaInHistogram(int[] A) {
		
		// find just smaller element in right and just smaller in left
		   //find just smaller to left

		int ans=0;
		Stack<Integer> stack = new Stack<>();
		int[] smallerToLeft = new int[A.length];

		stack.push(0);
		smallerToLeft[0] =-1;

		for(int i=1;i<A.length;i++) {

			if(A[i] > A[stack.peek()]) {

				smallerToLeft[i] = stack.peek();
				stack.push(i);
			}
			else {

				while(!stack.isEmpty() && A[i] <= A[stack.peek()])
					stack.pop();

				if(stack.isEmpty())
					smallerToLeft[i] = -1;

				else
					smallerToLeft[i] = stack.peek();
				
				stack.push(i);
			}
		}
		
		 //find just smaller to left
		stack = new Stack<>();
		int[] smallerToRight = new int[A.length];
		
		stack.push(A.length-1);
		smallerToRight[A.length-1] = A.length;
		
		for(int i=A.length-2;i>=0;i--) {
			
			if(A[i] > A[stack.peek()]) {
				smallerToRight[i] = stack.peek();
				stack.push(i);
			}
			else {
				while(!stack.isEmpty() && A[i] <= A[stack.peek()])
					stack.pop();
				
				if(stack.isEmpty())
					smallerToRight[i] = -1;
				else
					smallerToRight[i] = stack.peek();
				
				stack.push(i);
			}
			
		}
		
		//System.out.println(Arrays.toString(smallerToLeft));
		//System.out.println(Arrays.toString(smallerToRight));
		for(int i=0;i<smallerToRight.length;i++) {
			int area = (smallerToRight[i] - smallerToLeft[i] -1)*A[i];
			ans =Integer.max(ans, area);
		}
		
		return ans;
	}

	public static void main(String[] args) {
		int[][] A = {  {1, 1, 1},
			           {0, 1, 1},
			    	   {1, 0, 0} };
		
		System.out.println(solve(A));
	}
}

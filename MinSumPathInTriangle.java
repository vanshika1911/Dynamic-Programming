package dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;

public class MinSumPathInTriangle {
	
	private static void solve(ArrayList<ArrayList<Integer>> A) {
		
		int m=A.size();
		int n = A.get(A.size()-1).size();

		int Arr[][] = new int[m][n];

		int j=0;
		for (int i=0;i<A.size();i++){
			ArrayList<Integer> list = A.get(i);
			for (Integer k:list){
				Arr[i][j++] = k;
			}
			j=0;
		}

		int[][] dp = new int[Arr.length][Arr[0].length];
		
		for(int i=0;i<dp.length;i++)
			Arrays.fill(dp[i] , Integer.MAX_VALUE);
		
		for(int i=0;i<dp.length;i++) {
			for(int k=0;k<dp[0].length;k++) {
				System.out.print(dp[i][k]+"  ");
			}
			System.out.println();
		}
		
		int sum = minSumPathInTriangle(Arr, 0, 0, dp);
		System.out.println(sum);
		
	}

	private static int minSumPathInTriangle(int[][] A, int i, int j, int[][] dp) {
	
		if(i >= A.length || j >= A[0].length)
			return 0;
			
		if(i == A.length-1 && j == A[0].length-1)
			return A[i][j];
					
		if(dp[i][j] != Integer.MAX_VALUE)
			return dp[i][j];
		
		dp[i][j] = A[i][j] + Math.min(minSumPathInTriangle(A, i+1, j, dp), minSumPathInTriangle(A, i+1, j+1, dp));

		return dp[i][j];
	}

	public static void main(String[] args) {
		
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();

        ArrayList<Integer> r1 = new ArrayList<>();
        r1.add(2);
        A.add(r1);

        ArrayList<Integer> r2 = new ArrayList<>();
        r2.add(6);
        r2.add(6);
        A.add(r2);
        ArrayList<Integer> r3 = new ArrayList<>();
        r3.add(7);
        r3.add(8);
        r3.add(4);
        A.add(r3);

        solve(A);
        /*int [][] A = {
        {2,0,0,0},
        {3, 4,0,0},
        {6, 5, 7,0},
        {4, 1, 8, 3} };*/
	}
}

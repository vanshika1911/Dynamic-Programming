package dynamicProgramming;

import java.util.Arrays;

public class CoinSumIterative {
	
	private static int solve(int[] A, int B) {
	   
		int mod = (int) Math.pow(10, 6)+7;
		
		long[] table = new long[B+1];
		Arrays.fill(table, -1);
		int n = A.length;
		
		table[0] =1;
		
		for(int i=0;i<n;i++) {
			for(int j=A[i];j<=B;j++) {
				
				table[j] = table[j-A[i]]%mod;
			}
		}
		
		return (int) (table[B]%mod);
		
	}	

	public static void main(String[] args) {
		
		int[] A = {1, 2, 3};
		int	B = 4;
		System.out.println(solve(A, B));
	}
}

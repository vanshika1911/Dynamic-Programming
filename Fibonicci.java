package dynamicProgramming;

import java.util.Scanner;

public class Fibonicci {

	private static int fib(int A, int[] dp) {
		
		if(A <= 1)
			return A;
		
		if(dp[A] != 0)
			return dp[A];
		else
			dp[A] = fib(A-1,dp) + fib(A-2, dp);
		
		return dp[A];
	}
	
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int[] dp = new int[A+1];
		
		System.out.println(fib(A,dp));
	}
}

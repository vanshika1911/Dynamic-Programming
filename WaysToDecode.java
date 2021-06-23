package dynamicProgramming;

public class WaysToDecode {
	
	private static int solve(String s) {
	
		int mod = (int) (Math.pow(10, 9)+7);
	   	Integer[] dp = new Integer[s.length() + 1];
		int num = numDecodings(s, 0, dp);
		return  (num%mod);
	}

	private static int numDecodings(String s, int index, Integer[] dp) {
	    
	    int mod = (int) (Math.pow(10, 9)+7);
		if (index == s.length()) {
			return 1;
		}
		if (s.charAt(index) == '0') {
			return 0;
		}
		if (dp[index] != null) {
			return dp[index];
		}
		int way1 = (numDecodings(s, index + 1, dp)%mod);
		int way2 = 0;
		if (index < s.length() - 1 && Integer.parseInt(s.substring(index, index + 2)) <= 26) {
			way2 = (numDecodings(s, index + 2, dp)%mod);
		}
		dp[index] = way1 + way2;
		return dp[index];
	}

	public static void main(String[] args) {
		String A = "1218956498";
		System.out.println(solve(A));
	}
}

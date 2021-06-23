package dynamicProgramming;

public class PalindormicPartitioning2 {
	

	private static void solve(String s) {
		
		//int min =palidromePartitioning(s, 0);
		int[] arr = new int[s.length()+1];
		int min =palidromePartitioning2(s, 0, s.length(), arr);
		System.out.println(min);
	}

	private static int palidromePartitioning2(String s, int left, int right, int[] arr) {
		
		if(isPalindrome(s, left, right)) 
			return 0;
		
		
		if(arr[left] != 0)
			return arr[left];
		
		int minCut = Integer.MAX_VALUE;
		for(int i =left;i<s.length();i++) {
			
			if(!isPalindrome(s, left, i+1))
				continue;
			
			int cut = 1 + palidromePartitioning2(s, i+1, right, arr);
			
			if(cut < minCut)
				minCut = cut;

		}
		arr[left] = minCut;
		
		return arr[left];
		
	}
	private static boolean isPalindrome(String s, int left, int right) { // a | b | c
		
		int j=right-1;
		int i=left;
		while(i < j) { // a b a b a
			
			if(s.charAt(i) != s.charAt(j)) {
			return false;
			}
			i++;
			j--;
		}
		return true;
	}

	public static void main(String[] args) {
		String s= "abc";
		solve(s);

	}

	

}

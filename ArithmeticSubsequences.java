package dynamicProgramming;

import java.util.HashMap;

public class ArithmeticSubsequences {
	
	private static int solve(int[] A) {
		
		//create hash map of size A length
		HashMap<Integer, Integer>[] map = new HashMap[A.length];
		int ans =0;
		
		for(int i=0;i<A.length;i++)
			map[i] = new HashMap<>();
		
		for(int i=1;i<map.length;i++) {
			for(int j=0;j<i;j++) {
				
				long diff = (long)A[i] - (long)A[j];
				
				if(diff >= Integer.MAX_VALUE || diff <= Integer.MIN_VALUE)
					continue;
				
				int apiStartingFromJ = map[j].getOrDefault((int) diff, 0);
				int apiStartingFromI = map[i].getOrDefault((int) diff, 0);
				
				ans += apiStartingFromJ;
				map[i].put((int) diff, apiStartingFromJ + apiStartingFromI + 1);
			}
		}
		return ans;
	}

	public static void main(String[] args) {
        int[] A =  {2, 4, 6, 8, 10};
		
		System.out.println(solve(A));
	}
}

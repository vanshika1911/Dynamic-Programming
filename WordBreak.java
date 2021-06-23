package dynamicProgramming;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class WordBreak {
	
	private static void solve(String A, String[] B) {
	         
		Set<String> set = new HashSet<>();
		HashMap<String, Boolean> map = new HashMap<>();
		
		for(String s : B) {
			set.add(s);
		}
		
		if(wordBreak(A,set, map))
			System.out.println("word break");
		else
			System.out.println("no word break");
	}
	
	private static boolean wordBreak(String A, Set<String> set, HashMap<String, Boolean> map) {
		
		if(A.isEmpty())
			return true;
		
		if(map.containsKey(A))
			return map.get(A);
		
		for(int i=1;i<=A.length();i++) {
			
			if(set.contains(A.substring(0, i)) && wordBreak(A.substring(i, A.length()), set, map)){
				map.put(A.substring(i, A.length()), true);
				return true;
			}
			map.put(A, false);
		}
		return false;
	}

	public static void main(String[] args) {
		String A = "trainer";//nterviewtrainer";
		String[] B = {"trainer", "my", "interview"};
		solve(A, B);
	}
}

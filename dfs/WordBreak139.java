package qiang.dfs;

import java.util.HashSet;
import java.util.Set;

public class WordBreak139 {

 
	 
	public boolean wordBreak(String s, Set<String> wordDict) {
		
		if(s == null) return false;
		boolean []dp = new boolean[s.length()+1];
		dp[0] = true;
		
		for(int i = 0 ; i < s.length(); i++){
			
			if(dp[i] == false){
				continue;
			}
			
			for(String word: wordDict){
				int end = i+word.length();
				
				if(end > s.length()) continue;
				if(dp[end])continue;
				
				if(s.substring(i, end).equals(word)){
					dp[end] = true;
				}
				
			}
		}
		return dp[s.length()];
	}
	
	public static void main(String[] args) {

		String s = "lee2tcode";
		Set<String> wordDict = new HashSet<String>();
		wordDict.add("leet");
		wordDict.add("code");
		System.out.println(new WordBreak139().wordBreak(s, wordDict));
	}

}

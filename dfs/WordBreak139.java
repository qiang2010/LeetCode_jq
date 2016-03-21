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
	
	 
	 
		public boolean wordBreak2(String s, Set<String> wordDict) {
			
			if(s == null) return false;
			boolean []dp = new boolean[s.length()+1];
			dp[0] = true;
			int max  = -1;
			int min = Integer.MAX_VALUE;
			for(String temp:wordDict){
				max = max > temp.length() ? max: temp.length();
				min = min < temp.length() ? min: temp.length();
			}
			for(int i = 0 ; i < s.length(); i++){
				
				if(dp[i] == false){
					continue;
				}
				
				for(int j = min;j<max+1 && i+j<s.length()+1;j++){
					int end = i+j;
					if(dp[end])continue;
					if(wordDict.contains(s.substring(i,end))){
						dp[end] =true;
					}
				}
//				for(String word: wordDict){
//					int end = i+word.length();
//					
//					if(end > s.length()) continue;
//					if(dp[end])continue;
//					
//					if(s.substring(i, end).equals(word)){
//						dp[end] = true;
//					}
//				}
			}
			return dp[s.length()];
		}
		
	
	public static void main(String[] args) {

		String s = "leetcode";
		Set<String> wordDict = new HashSet<String>();
		wordDict.add("leet");
		wordDict.add("code");
		System.out.println(new WordBreak139().wordBreak2(s, wordDict));
	}

}

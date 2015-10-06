package qiang.dfs;

import java.util.HashSet;
import java.util.Set;

public class WordBreak139_2 {

 
	 
//	boolean flag= false;
	int max = -1;
	int min = Integer.MAX_VALUE;
	public boolean wordBreak(String s, Set<String> wordDict) {
	        
		if(s == null || "".equals(s)) return false;
		for(String temp:wordDict){
			max = max > temp.length() ? max: temp.length();
			min = min < temp.length() ? min: temp.length();
		}
		boolean res =  wordDfs(s, 0, wordDict);
	//	System.out.println(flag);
		return res;
		
	}
	
	public boolean wordDfs(String s,int k,Set<String> wordDict){
		
		if(k > s.length()-1 ){
	//	 	flag = true;
			return true;
		}
		String temp;
		boolean tempBoolean = false;
		for(int m = min; m< max+1 && m+k < s.length()+1 ; m++){
			temp = s.substring(k,k+m);
			tempBoolean = wordDict.contains(temp);
			if(tempBoolean){
				tempBoolean = wordDfs(s, m+k, wordDict);
				if(tempBoolean) return true;
			}
		}
		return false;
		
	}
	public static void main(String[] args) {

		String s = "leetcode";
		Set<String> wordDict = new HashSet<String>();
		wordDict.add("leet");
		wordDict.add("code");
		System.out.println(new WordBreak139_2().wordBreak(s, wordDict));
	}

}

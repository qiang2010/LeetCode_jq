package qiang.dfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import qiang.leetcode.util.PrintUtil;

public class WordBreakII140 {

	
	
	public static void main(String[] args) {
		
		Set<String> wordDict= new HashSet<String>();
		wordDict.add("cats");
		wordDict.add("cat");
		wordDict.add("and");
		wordDict.add("sand");
		wordDict.add("dog");
		List<String> ans = new WordBreakII140().wordBreak("", wordDict);
		System.out.println(ans);
	}
	
	public List<String> wordBreak(String s, Set<String> wordDict) {
	        
		List<String> ans = new LinkedList<String>();
		if(s == null ||s.length()==0) return ans;
		dfs(ans, new LinkedList<String>(), s, 0, wordDict);
		return ans;
	}
	private void dfs(List<String> ans,LinkedList<String> tempAns,String s,int index,Set<String> wordDict){
		
		if(index == s.length()){
			StringBuilder sb = new StringBuilder();
			sb.append("\""+tempAns.get(0));
			for(int i =1;i< tempAns.size();i++){
				sb.append(" "+tempAns.get(i));
			}
			sb.append("\"");
			ans.add(sb.toString());
			return;
		}
		String tempS;
		for(String w:wordDict){
			int size = w.length();
			if(index+size > s.length() )continue;
			tempS =  s.substring(index, index+w.length());
			if(!tempS.equals(w))continue;
			tempAns.addLast(tempS);
			dfs(ans, tempAns, s, index+size, wordDict);
			tempAns.removeLast();
		}
		
	}
	
	
}

package qiang.dfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import qiang.leetcode.util.PrintUtil;

public class WordLadderII126 {

	List<List<String>> ans = new LinkedList<List<String>>();
	LinkedList<String> oneAns = new LinkedList<>();
	public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordDict) {

		
		//wordDict.add(endWord);
		String [] words = new String[wordDict.size()];
		boolean []visited = new boolean[wordDict.size()];
		int i=0;
		for(String w:wordDict){
			visited[i] = false;
			words[i++] = w;
		}
		oneAns.add(beginWord);
		dfsLadder(beginWord, endWord, beginWord, words, visited,0);
		return ans;
	}
 
 
	/**
	 * 
	 * @param beginWord
	 * @param endWord
	 * @param lastword	上一个判断的单词
	 * @param wordDict
	 * @param visited
	 * @param deep
	 * @return
	 */
	public void dfsLadder(String beginWord,String endWord,String lastword,String [] wordDict,boolean []visited,int deep){
		
		if(isDistanceIsOne(endWord, lastword) || lastword.equals(endWord)) {
			LinkedList<String> tempAn = new LinkedList<>();
			tempAn.addAll(oneAns);
			tempAn.add(endWord);
			ans.add(tempAn);
		}
		if(deep > wordDict.length)return;
		for(int i =0; i < wordDict.length;i++){
			if(visited[i])continue;
			if(isDistanceIsOne(wordDict[i], lastword)){
				visited[i]=true;
				oneAns.addLast(wordDict[i]);
				dfsLadder(beginWord, endWord, wordDict[i], wordDict, visited, deep+1);
				// 回溯的时候需要复原
				visited[i]=false;
				oneAns.removeLast();
			}
		}
	}
	
	
	boolean isDistanceIsOne(String a,String b){
		
		if(a==null || b == null) return false;
		int aSize = a.length();
		int bSize = b.length();
		if(aSize != bSize) return false;

		int j =0;
		for(int i = 0 ; i < aSize; i++){
			if(a.charAt(i)!= b.charAt(i)){
				j++;
				if(j==2)return false;
			}
		}
		return true;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<String> wordDict = new HashSet<>();
		wordDict.add("hot");
		wordDict.add("dot");
		wordDict.add("dog");
		wordDict.add("lot");
		wordDict.add("log");
		List<List<String>> ans = 	new WordLadderII126().findLadders("hit", "cog", wordDict);
		PrintUtil.print2DList(ans);
	}

}

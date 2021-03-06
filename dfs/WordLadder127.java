package qiang.dfs;

import java.util.HashSet;
import java.util.Set;

public class WordLadder127 {


	int min = Integer.MAX_VALUE;
//	LinkedList<String> oneAns = new LinkedList<String>();
	public int ladderLength(String beginWord, String endWord, Set<String> wordDict) {
		
		String [] words = new String[wordDict.size()];
		boolean []visited = new boolean[wordDict.size()];
		int i=0;
		for(String w:wordDict){
			visited[i] = false;
			words[i++] = w;
		}
		
		dfsLadder(beginWord, endWord, beginWord, words, visited,0);
		return min+2;
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
	public boolean dfsLadder(String beginWord,String endWord,String lastword,String [] wordDict,boolean []visited,int deep){
		
		if(isDistanceIsOne(endWord, lastword) || lastword.equals(endWord)) {
			min = min < deep? min:deep;
//			for(String a:oneAns){
//				System.out.print(a+" ");
//			}
//			System.out.println();
			return true;
		}
		if(deep > wordDict.length)return false;
		for(int i =0; i < wordDict.length;i++){
			if(visited[i])continue;
			if(isDistanceIsOne(wordDict[i], lastword)){
				visited[i]=true;
				//oneAns.addLast(wordDict[i]);
				if(dfsLadder(beginWord, endWord, wordDict[i], wordDict, visited, deep+1))
					return true;
				else{
					// 回溯的时候需要复原
					visited[i]=false;
			//		oneAns.removeLast();
				}
			}
		}
		return false;
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
		System.out.println(new WordLadder127().ladderLength("hit", "cog", wordDict));
	}

}

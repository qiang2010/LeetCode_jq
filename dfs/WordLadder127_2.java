package qiang.dfs;

import java.util.HashSet;
import java.util.Set;

public class WordLadder127_2 {


	int min = Integer.MAX_VALUE;
//	LinkedList<String> oneAns = new LinkedList<String>();
	public int ladderLength(String beginWord, String endWord, Set<String> wordDict) {
		
		if(wordDict == null) return 0;
		int dictSize = wordDict.size();
		String [] words = new String[dictSize+2];
		words[dictSize] = beginWord;
		words[dictSize+1] = endWord;
		boolean []visited = new boolean[dictSize];
		int i=0;
		boolean [][]disFlag = new boolean[dictSize+2][dictSize+2];
		for(String w:wordDict){
			visited[i] = false;
			disFlag[i][dictSize] = isDistanceIsOne(beginWord, w);
			words[i++] = w;
		}
		
		for( i = 0 ; i <dictSize+2; i++ ){
			for( int j  = i+1 ; j <dictSize+2; j++ ){
				disFlag[i][j] = disFlag[j][i] = isDistanceIsOne(words[i], words[j]);  
			}
		}
		
		//dictSize 位置和dictSize+1 位置上分别是begin 和end
		dfsLadder(disFlag, dictSize,words,dictSize, visited,0);
		if(min == Integer.MAX_VALUE){
			return 0;
		}
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
	public boolean dfsLadder(boolean disFlag[][],int lastWord,String [] wordDict,int dictSize,boolean []visited,int deep){
		
		if(disFlag[dictSize+1][lastWord]) {
			min = min < deep? min:deep;
//			for(String a:oneAns){
//				System.out.print(a+" ");
//			}
//			System.out.println();
			return true;
		}
		if(deep > min) return false;
		if(deep > dictSize)return false;
		for(int i =0; i < dictSize;i++){
			if(visited[i])continue;
			if(disFlag[i][lastWord]){
				visited[i]=true;
				//oneAns.addLast(wordDict[i]);
				if(dfsLadder(disFlag, i, wordDict, dictSize, visited, deep+1))
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
		//wordDict.add("dot");
		wordDict.add("dog");
	//	wordDict.add("lot");
		//wordDict.add("log");
		System.out.println(new WordLadder127_2().ladderLength("hot", "dog", wordDict));
	}

}

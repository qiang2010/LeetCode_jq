package qiang.dfs;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import qiang.leetcode.util.PrintUtil;

public class WordLadderII126_2 {
	
	class WordNode{
		String word;
		WordNode fater;
		int level;
		WordNode(String word, WordNode father,int level){
			this.word = word;
			this.fater = father;
			this.level= level;
		}
	}
	LinkedList<String> oneAns = new LinkedList<>();
	public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
		List<List<String>> ans = new LinkedList<List<String>>();
		if(wordList == null) return ans;
		LinkedList<WordNode> queue = new LinkedList<WordNode>();
		Set<String> visited = new HashSet<>();
		Set<String> levelVisited = new HashSet<>();
		WordNode root = new WordNode(beginWord,null,0);
		queue.addFirst(root);
		visited.add(beginWord);
		WordNode top;
		char []wordCharArray;
		char c;
		String newWord;
		int ansLevel = -1;
		int lastLevel = 0;
		while(!queue.isEmpty()){
			top = queue.getFirst();
			queue.removeFirst();
			if(isDistanceIsOne(top.word,endWord)) {
				ansLevel = top.level;
				queue.addFirst(top);
				break;
			}
			if(top.level != lastLevel){
				visited.addAll(levelVisited);
				levelVisited.clear();
				lastLevel = top.level;
			}
			wordCharArray = top.word.toCharArray();
			for(int j =0 ; j < wordCharArray.length;j++){
				c = wordCharArray[j];
				for(char a = 'a'; a <= 'z'; a++){
					wordCharArray[j] = a;
					newWord = new String(wordCharArray);
					if(!wordList.contains(newWord))continue;
					if(visited.contains(newWord))continue;
					WordNode newNode = new WordNode(newWord, top, top.level+1);
					queue.addLast(newNode);
					levelVisited.add(newWord);
				}
				wordCharArray[j] = c;
			}
 
		}
		if(ansLevel == -1)
			return ans;
		LinkedList<String> oneAns ;
		WordNode wn;
		while(!queue.isEmpty()){
			wn = queue.getFirst();
			queue.removeFirst();
			if(!isDistanceIsOne(wn.word, endWord))continue;
			if(wn.level!=ansLevel) break;
			oneAns = new LinkedList<>();
			while(wn != null){
				oneAns.add(wn.word);
				wn = wn.fater;
			}
			Collections.reverse(oneAns);
			oneAns.add(endWord);
			ans.add(oneAns);
		}
		//System.out.println(ans.size());
//		for(List<String> tem:ans){
//			Collections.reverse(tem);
//		}
		return ans;
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
		List<List<String>> ans = 	new WordLadderII126_2().findLadders("hit", "cog", wordDict);
		PrintUtil.print2DList(ans);
	}

}

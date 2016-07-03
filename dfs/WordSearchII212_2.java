package qiang.dfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import qiang.trie.Trie;

public class WordSearchII212_2 {
 

	public static void main(String[] args) {
		
		char [][] board = {{'o','a','a','n'},
				  {'e','t','a','e'},
				  {'i','h','k','r'},
				  {'i','f','l','v'}};
		String [] words = {"oath","pea","eat","rain"};
		List<String> ans = new WordSearchII212_2().findWords(board, words);
		for(String s:ans){
			System.out.println(s);
		}
	}
	/**
	 * 这里使用Trie数来解决。
	 * @param board
	 * @param words
	 * @return
	 */
	public List<String> findWords(char[][] board, String[] words) {
		
		List<String> ans = new LinkedList<>();
		if(words == null || words.length ==0) return ans;
		int row = board.length;
		int col = board[0].length;
		TrieNode root = buildTrie(words);
		for(int i =0;i< row ;i++){
			for(int j = 0 ; j < col;j++){
				dfs(root, i, j, board, ans);
			}
		}
		return ans;		
	}
	void dfs(TrieNode root,int i ,int j , char [][]board, List<String> ans){
		char c = board[i][j];
		if(c == '#' || root.sons[c-'a']==null) return;
		root = root.sons[c-'a'];
		if(root.word !=null){
			ans.add(root.word);
			root.word = null;
		}
		board[i][j] = '#';
		// dfs
		if(i > 0)dfs(root, i-1, j, board, ans);
		if(j > 0)dfs(root, i, j-1, board, ans);
		if(i < board.length-1)dfs(root, i+1, j, board, ans);
		if(j < board[0].length-1)dfs(root, i, j+1, board, ans);
		board[i][j] = c;
	}
	TrieNode buildTrie(String []words){
		
		TrieNode root = new TrieNode();
		char []ws;
		int i;
		for(String w:words){
			ws = w.toCharArray();
			TrieNode temp = root;
			for(char c:ws){
				i = c -'a';
				if(temp.sons[i] ==null)temp.sons[i] = new TrieNode();
				temp = temp.sons[i];
			}
			temp.word = w;
		}
		return root;
	}
	
    class TrieNode{
    	TrieNode[] sons = new TrieNode[26];
    	String word;
    }
    	
	 
}

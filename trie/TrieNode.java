package qiang.trie;

public class TrieNode {

	TrieNode []sons ;
	char c;
	int count=0; 
	TrieNode(){
		sons = new TrieNode[26];
	}
	public TrieNode []getSons(){
		return sons;
	}
}

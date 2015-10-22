package qiang.trie;

public class Trie {

	
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    
    public TrieNode getRoot() {
		return root;
	}


	public void setRoot(TrieNode root) {
		this.root = root;
	}


	// Inserts a word into the trie.
    public void insert(String word) {
    	TrieNode cur=root,son;
    	for(int i=0;i<word.length();i++){
    		int index = word.charAt(i)-'a';
    		son = cur.sons[index];
    		if(son == null){
    			son = new TrieNode();
    			son.c = word.charAt(i);
    			cur.sons[index] = son;
    			cur = son;
    		}else{
    			cur = son;
    		}
    	}
    	cur.count++;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        
    	if(root == null) return false;
    	TrieNode cur = root,son;
    	int i;
    	for( i =0;i< word.length();i++){
    		int index = word.charAt(i)-'a';
    		son = cur.sons[index];
    		if(son == null)return false;
    		else{
    			cur = son;
    		}
    	}
    	if(i == word.length() && cur.count > 0)return true;
    	return false;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
    	if(root == null) return false;
    	TrieNode cur = root,son;
    	int i;
    	for( i =0;i< prefix.length();i++){
    		int index = prefix.charAt(i)-'a';
    		son = cur.sons[index];
    		if(son == null)return false;
    		else{
    			cur = son;
    		}
    	}
    	if(i == prefix.length())return true;
    	return false;
    }


    public static void main(String[] args) {
		
    	Trie trie = new Trie();
    	trie.insert("abc");
    	System.out.println(trie.search("abc"));
    	System.out.println(trie.startsWith("ab"));
    	
	}
}

package qiang.trie;

public class AddAndSearchWordDataStructureDesign211 {

	
    public static void main(String[] args) {
		
    	AddAndSearchWordDataStructureDesign211 trie = new AddAndSearchWordDataStructureDesign211();
    	trie.addWord("abc");
    	System.out.println(trie.search_rex("..."));
    	System.out.println(trie.startsWith("ab"));
    	
	}

	
    private TrieNode root;

    public AddAndSearchWordDataStructureDesign211() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void addWord(String word) {
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
    public boolean search_rex(String word) {
        
    	if(root == null) return false;
    	if(search_cur(root, word, 0)) return true;
    	return false;
    }
    private boolean search_cur(TrieNode root, String word,int i){
    	
    	if(root == null) return false;
    	if(i == word.length()) {
    		if(root.count>0)
    			return true;
    		else return false;
    	}else{
    		if(i > word.length()) return false;
    	}
    	if(word.charAt(i)=='.'){
    		TrieNode []sons = root.sons;
    		for(int j =0;j<26;j++){
    			if(sons[j] != null){
    				if(search_cur(sons[j], word, i+1))
    					return true;
    			}
    		}
    		
    	}else{
    		if(search_cur(root.sons[word.charAt(i)-'a'], word, i+1))return true;
    	}
    	return false;
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




	
	
	
}

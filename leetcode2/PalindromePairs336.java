package qiang.leetcode2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import qiang.leetcode.util.PrintUtil;

public class PalindromePairs336 {

	public static void main(String[] args) {
		PalindromePairs336 pp = new PalindromePairs336();
		String []words = {"abcd","dcba","lls","s","sssll"};
		PrintUtil.print2DList(pp.palindromePairs(words));
		
	}
    public List<List<Integer>> palindromePairs(String[] words) {
    	List<List<Integer>> ans = new ArrayList<>();
    	if(words == null || words.length < 2) return ans; 
    	Map<String,List<Integer>> premap = buildPrefilxMap(words);
    	Map<String,List<Integer>> postmap = buildPostMap(words);
    	List<Integer> li;
    	for(int i = 0 ; i < words.length;i++){
    		if(postmap.containsKey(words[i])){
    			li = postmap.get(words[i]);
    			for(int k:li){
    				if(k!=i){
    					List<Integer> tt = new ArrayList<>();
    					// 这里需要注意添加的顺序
    					tt.add(i);tt.add(k);
    					ans.add(tt);
    				}
    			}
    		}
    		if(premap.containsKey(words[i])){
    			li = premap.get(words[i]);
    			for(int k:li){
    				if(k!=i){
    					List<Integer> tt = new ArrayList<>();
    				
    					tt.add(k);	tt.add(i);
    					ans.add(tt);
    				}
    			}
    		}
    		
    	}
    	return ans;
    }
    /**
     * 构建前缀map
     * @param words
     * @return
     */
    Map<String,List<Integer>> buildPrefilxMap(String []words){
    	 Map<String,List<Integer>> prefmap = new HashMap<>();
    	 String tempW,rev;
    	 List<Integer> li;
    	 for(int i = 0 ; i < words.length;i++){
    		 tempW = words[i];
    		 for(int j = tempW.length()-1; j > -1;j--){
    			 if(isPal(tempW.substring(j))){
    				 rev = reverse(tempW, 0, j-1); 
    				 if(prefmap.containsKey(rev)){
    					 li = prefmap.get(rev);
    				 }else{
    					 li = new ArrayList<>();
    					 prefmap.put(rev, li);
    				 }
    				 li.add(i);
    			 }
    		 }
    	 }
    	 return prefmap;
    }
  
    public Map<String,List<Integer> > buildPostMap(String []words){
    	
    	Map<String,List<Integer> > ans = new HashMap<>();
    	String tempW;
    	String rev;
    	List<Integer> li;
    	for(int i = 0 ; i < words.length;i++){
    		tempW = words[i];
    		for (int j = 0; j <= tempW.length() ; j++){
    			
    			if(isPal(tempW.substring(0,j))){
    				rev = reverse(tempW, j,tempW.length()-1);
    				if(ans.containsKey(rev)){
    					li = ans.get(rev);
    				}else{
    					li = new ArrayList<>();
    					ans.put(rev, li);
    				}
    				li.add(i);
    			}
    			
    		}
    	}
    	return ans;
    }
    
    
    boolean isPal(String s){
    	if("".equals(s))return true;
    	int left = 0,right = s.length()-1;
    	while(left < right && s.charAt(left)==s.charAt(right)){
    		left++;right--;
    	}
    	if(left <right) return false;
    	return true;
    }
    String reverse(String s,int i,int j){
    	StringBuilder sb = new StringBuilder();
    	for(int k = j; k > i-1;k--){
    		sb.append(s.charAt(k));
    	}
    	return sb.toString();
    }
    
    
}

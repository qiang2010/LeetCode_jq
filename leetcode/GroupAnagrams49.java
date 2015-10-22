package qiang.leetcode;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import qiang.leetcode.util.PrintUtil;

public class GroupAnagrams49 {
	  
	public static void main(String[] args) {
		
		String []strs ={"eat", "tea", "tan", "ate", "nat", "bat"};
		List<List<String>> ans = new GroupAnagrams49().groupAnagrams(strs);
		PrintUtil.print2DList(ans);
	}
	
	public List<List<String>> groupAnagrams(String[] strs) {
	        
		List<List<String>> ans = new LinkedList<List<String>>();
		if(strs == null || strs.length==0)return ans;
		int size = strs.length;
		int [][]count = new int[size][26];
		int i=0;
		for(String w:strs){
			int wS = w.length();
			for(int j =0;j < wS;j++){
				count[i][w.charAt(j)-'a']++;
			}
			i++;
		}
		StringBuilder key;
		Map<String,List<String>> tempAns = new HashMap<>();
		List<String> one ;
		for(i=0;i<size;i++){
			key = new StringBuilder();
			for(int j=0;j<26;j++){
				if(count[i][j] >0){
					key.append((j+'a')+""+count[i][j]);
				}
			}
			if(tempAns.containsKey(key.toString())){
				one = tempAns.get(key.toString());
			}else{
				one = new LinkedList<String>();
			}
			one.add(strs[i]);
			tempAns.put(key.toString(), one);
		}
		for(List<String> l: tempAns.values()){
			Collections.sort(l);
			ans.add(l);
		}
		return ans;
	}
}

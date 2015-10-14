package qiang.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class RepeatedDNASequences187 {

	
	public List<String> findRepeatedDnaSequences2(String s) {
		
		
		List<String> ans = new LinkedList<>();
		if(s == null || s.length() <10){
			return ans;
		}
		
		HashMap<Integer,Integer> map = new HashMap<>();
		int key =0;
		for(int i = 0 ; i < 10; i ++){
			key<<=3;
			key = (key | (s.charAt(i)&0x7));
			
		}
		map.put(key, 1);
		int size = s.length();
		for(int j = 10; j < size; j++){
			key <<=5;
			key >>>=2;
			key = key | (s.charAt(j)&0x7);
			if(map.containsKey(key)){
				if(map.get(key)==1){
					ans.add(s.substring(j-9,j+1));
					map.put(key, 2);
				}
			}else{
				map.put(key, 1);
			}
		}
		return ans;
		
	}
	   
	public List<String> findRepeatedDnaSequences(String s) {
	       
		HashSet<String> ans = new  HashSet<String>();
		List<String> ansList = new LinkedList<>();
		if(s == null || s.length() <10){
			ansList.addAll(ans);
			return ansList;
		}
		
		int size = s.length();
		String tempSub;
		for(int i = 0 ;i < size-11; i++){
			tempSub  = s.substring(i,i+10);
			if(ans.contains(tempSub))continue;
			if(s.lastIndexOf(tempSub)>i){
				ans.add(tempSub);
			}
		}
		ansList.addAll(ans);
		return ansList;
	}
	public static void main(String[] args) {
		
		String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
		//System.out.println(s.indexOf("AAAAACCCCC"));
		List<String> ans = new RepeatedDNASequences187().findRepeatedDnaSequences2(s);
		System.out.println(ans);
	}
}

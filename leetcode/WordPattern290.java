package qiang.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordPattern290 {
	   
	public static void main(String[] args) {
		System.out.println(new WordPattern290().wordPattern("abba", "dog cat cat dodg"));
		
	}
	public boolean wordPattern(String pattern, String str) {
	        
		Map<String,Character> map = new HashMap<>();
		String []splits = str.split("\\s+");

		int size = splits.length;
		int sizeP = pattern.length();
		if(size != sizeP) return false;
		char v;
		Set<Character> chars = new HashSet<Character>();
		for(int i=0;i< size;i++){
			if(map.containsKey(splits[i])){
				v = map.get(splits[i]);
				if(v != pattern.charAt(i))return false;
			}else{
				if(chars.contains(pattern.charAt(i)))return false;
				map.put(splits[i], pattern.charAt(i));
				chars.add(pattern.charAt(i));
			}
			
		}
		return true;
	}
}

package qiang.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class IsomorphicStrings205 {
	  
	
	public boolean isIsomorphic(String s, String t) {
	     
		if(s == null || t == null) return false;
		int sSize = s.length();
		int tSize = t.length();
		if(sSize != tSize) return false;
		
		Map<Character,Character> map = new HashMap<>();
		Set<Character> mappedChar = new HashSet<Character>();
				
		char a,b;
		for(int i =0;i<tSize; i++){
			a = s.charAt(i);
			b = t.charAt(i);
			if(map.containsKey(a)){
				b = map.get(a);
				if(t.charAt(i) != b)return false;
			}else{
				if(mappedChar.contains(b))return false;
				map.put(a, b);
				mappedChar.add(b);
			}
		}
		return true;
	}
	 public static void main(String[] args) {
		
		 System.out.println(new IsomorphicStrings205().isIsomorphic("ab", "aa"));
	} 
}

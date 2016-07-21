package qiang.dfs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordPatternII291 {

	public static void main(String[] args) {
		
		WordPatternII291 ss = new WordPatternII291();
		System.out.println(ss.wordPatternMatch("abab", "redbl0ueredblue"));
		System.out.println(ss.wordPatternMatch("aabb", "xyzabcxzyabc"));
	}
	
	public boolean wordPatternMatch(String pattern, String str) {
		
		if(pattern == null || str == null)return true;
		Map<Character,String> map = new HashMap<>();
		Set<String> mapped = new HashSet<>();
		return isMatch(pattern, 0, str, 0, map, mapped);
	}
	boolean isMatch(String pattern,int patternIndex,String str,int strIndex,Map<Character,String> map, Set<String> mapped){
		
		if(patternIndex == pattern.length() && strIndex == str.length())return true;
		
		char cur = pattern.charAt(patternIndex);
		if(map.containsKey(cur)){
			String s = map.get(cur);
			// 这里忘了一个判断了。
			if(s.length()+ strIndex > str.length()) return false;
			
			if(s.equals(str.substring(strIndex,strIndex+s.length()))){
				return isMatch(pattern, patternIndex+1, str, strIndex+s.length(), map, mapped);
			}
			return false;
		}
		for(int i = strIndex+1;i< str.length()+1;i++){
			String s = str.substring(strIndex,i);
			// 这里要保证s不能在set中,之前忘记这个地方了。
			if(mapped.contains(s)) continue;
			
			map.put(cur, s);
			mapped.add(s);
			boolean f = isMatch(pattern, patternIndex+1, str, i, map, mapped);
			if(f) return true;
			mapped.remove(s);
			map.remove(cur);
		}
		return false;
	}
	
}

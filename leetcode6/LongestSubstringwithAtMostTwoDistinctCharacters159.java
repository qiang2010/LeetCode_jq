package qiang.leetcode6;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringwithAtMostTwoDistinctCharacters159 {

	public static void main(String[] args) {

		LongestSubstringwithAtMostTwoDistinctCharacters159 ss = new LongestSubstringwithAtMostTwoDistinctCharacters159();
		System.out.println(ss.lengthOfLongestSubstringTwoDistinct("eceba"));
	}
	public int lengthOfLongestSubstringTwoDistinct(String s) {  
		if(s == null || s.length()==0) return 0;
		int ans = 0;
		int begin = 0;
		int end = 0;
		int len = s.length();
		char [] cs = s.toCharArray();
		Map<Character, Integer> map = new HashMap<>();
		while(end < len){
			// 扩张
			while(map.size()<3 && end< len){
				char c = cs[end];
				if(map.containsKey(c)){
					map.put(c, map.get(c)+1);
				}else{
					map.put(c, 1);
				}
				end++;
			}
			
			if(end-begin-1 > ans) ans = end-begin-1;
			// 搜索
			while(map.size()> 2){
				char c = cs[begin];
				int cou = map.get(c);
				if(cou == 1) map.remove(c);
				else map.put(c, cou-1);
				begin++;
			}
			if(end-begin+1 > ans) ans = end-begin+1;
		}
		return ans;
	}

}

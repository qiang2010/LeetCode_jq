package qiang.leetcode2;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram242 {
	 
	public static void main(String[] args) {
		System.out.println(new ValidAnagram242().isAnagram("b", "a"));
	}
	public boolean isAnagram(String s, String t) {
		
		if(s == null && t == null) return true;
		if(s == null || t==null) return false;
		int sSize = s.length();
		int tSize = t.length();
		if(tSize != sSize) return false;
		int charCount [] = new int[26];
		for(int i =0;i<tSize;i++){
			charCount[t.charAt(i)-'a']++;
		}
		int c;
	    for(int j=0;j<sSize;j++){
	    	c = s.charAt(j)-'a';
	    	if(charCount[c]<1)return false;
	    	charCount[c]--;
	    }
		return true;
	}
}

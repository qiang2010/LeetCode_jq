package qiang.leetcode.util;


/**
 * 
 * 给一个字符串，返回该字符串的最长回文子串
 * 或者返回根据字符串构建的p数组，p数组是p[i]是以i为中心的回文串的长度。
 * 
 * @author jq
 *
 */
public class LongestPalindromeSubString {

	
	public static void main(String[] args) {
		
		int [] p = LongestPalindromeSubString.manacherAlg("abba");
		for(int a:p)
			System.out.println(a);
	}
	
	
	
	public static int[] manacherAlg(String s){
		if(s == null )return null;
		int size = s.length();
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < size ; i++){
			sb.append("#");
			sb.append(s.charAt(i));
		}
		sb.append("#");
		int curSize = sb.length();
		int [] p = new int[curSize];
		p[0] = 1;
		int mx=0,id=0;
		for(int i = 1;i < curSize; i++){
			
			if( i >= mx) p[i] = 1;
			else{
				p[i] = Math.min(mx-i, p[2*id-i]);
			}
			while(i-p[i] >-1 && i+p[i] < curSize && sb.charAt(i-p[i])==sb.charAt(i+p[i]))p[i]++;
			if(i+p[i] > mx){
				mx = i+p[i];
				id = i;
			}
		}
		return p;
	}
	
}

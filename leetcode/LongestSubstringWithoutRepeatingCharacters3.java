package qiang.leetcode;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters3 {

	
	
	
	/**
	 * 
	 * Given a string, find the length of the longest substring 
	 * without repeating characters. 
	 * For example, the longest substring without repeating letters for "abcabcbb" is "abc",
	 *  which the length is 3. For "bbbbb" the longest substring is "b", 
	 *  with the length of 1.
	 * 
	 * @param s
	 * @return
	 */
	
    public static int lengthOfLongestSubstring(String s) {
    	int size = s.length();
        boolean dp[][] = new boolean[size][size];
        int max = 0;
//        int begin = 0,end = 0;
        for(int i = 0; i<size ; i ++){
        	dp[i][i] = true;
        }
        int j = 0;
        int tempPos;
    	for(int len = 1; len < size; len++ ){
    		j = size - len -1  ;
    		for(int k = 0 ; k<= j ; k++){
    			tempPos = s.substring(k,k+len).indexOf(s.charAt(k+len));
    			if(dp[k][k+len-1]  && tempPos < 0){
    				dp[k][k+len] = true;
    				if(len > max ) max = len;
    				//System.out.println( max);
    			}
    		}
    	}
        
    	return max+1;
    }
	/**
	 * 改进： 用一个hashmap记录 当前处理过的字母最后一次出现的位置，
	 * 如果没有出现过就将当前字母和位置让入map，如果出现过，
	 * 那么子串的长度最大为 当前位置和上一次出现的位之间的长度，
	 * 和max对比，更新max。这样遍历一遍，就可以计算出max。
	 * @param s
	 * @return
	 */
	
    public static int lengthOfLongestSubstring2(String s) {
    	
    	if("".equals(s.trim())) return 0; //忘了考虑了
    	
    	HashMap<Character, Integer>  posFlagHashMap  = new HashMap<Character, Integer>();
    	
    	int tempPos;
    	int size = s.length();
    	int max = 1;
    	int last=0 ;
    	int i;
    	for( i = 0 ; i < size ; i++){
    		if(posFlagHashMap.containsKey(s.charAt(i))){
    			tempPos = posFlagHashMap.get(s.charAt(i));
    			
    			last =last > tempPos? last : tempPos +1;
    			if(i - last +1 > max ) max = i - last +1;
    			//System.out.println(last +"qq");
    			posFlagHashMap.put(s.charAt(i), i);
    		}else{
    			posFlagHashMap.put(s.charAt(i), i);
    			if(i - last +1   > max ) max = i - last +1;
    			//max = i - last;  
    		}
    	}
    	//System.out.println( i+ " " + last);
    	return max;
    }
    
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abcbeafg";
//		s = "a";
		System.out.println(lengthOfLongestSubstring(s));
		System.out.println(lengthOfLongestSubstring2(s));
	}

}

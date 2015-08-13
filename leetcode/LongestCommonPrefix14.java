package qiang.leetcode;

public class LongestCommonPrefix14 {

	
	
	
    public static  String longestCommonPrefix(String[] strs) {
    
    	if(strs == null) return "";
    	if(strs.length == 0 ) return ""; // 不要忘记数组为空的情况
    	int size = strs[0].length();
    	for(int j= 0 ; j < size; j++){
    		char cur = strs[0].charAt(j);
    		for(int i =1 ;i < strs.length;i++){
    			if(strs[i].length()-1 < j || strs[i].charAt(j) != cur){
    				return strs[0].substring(0,j);
    			}
    		}
    	}
    	return strs[0];
    }
	
    public static  String longestCommonPrefix2(String[] strs) {
        
    	if(strs == null) return "";
    	if(strs.length == 0 ) return ""; // 不要忘记数组为空的情况
    	// 首先循环找到最短的字符串
    	int min = Integer.MAX_VALUE;
    	String ans="";
    	for(int i = 0 ; i < strs.length ; i++)
    		if( strs[i].length() < min) {
    			min = strs[i].length() ;
    			ans = strs[i];
    		}
    	
    	for(int j= 0 ; j < min; j++){
    		char cur = strs[0].charAt(j);
    		for(int i =1 ;i < strs.length;i++){
    			if(strs[i].charAt(j) != cur){
    				return strs[0].substring(0,j);
    			}
    		}
    	}
    	return ans;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[]strs = {""};
		System.out.println(longestCommonPrefix2(strs));
	}

}

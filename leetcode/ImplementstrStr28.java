package qiang.leetcode;

public class ImplementstrStr28 {

	
    public static int strStr(String haystack, String needle) {
        
    	
    	if(haystack == null || needle == null  )return -1;
    	if(haystack.equals(needle))return 0;
    	if("".equals(haystack))return -1;
    	if("".equals(needle))return 0;
    	int s1 = haystack.length();
    	int s2 = needle.length();
    	if(s2>s1)return -1;
    	int j = 0,tempI=0;
    	for(int i=0; i < s1-s2+1; i++){
    		j=0;tempI = i;
    		while(j< s2 && tempI<s1){
    			if(haystack.charAt(tempI)==needle.charAt(j) ){
    				j++;tempI++;
    			}else{
    				break;
    			}
    		} 
    		if(j == s2) return tempI-s2;
    		//if(s1-i < s2) return -1;
    	}
    	if(j==s2)return tempI-s2;
    	return -1;
    
    }	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(strStr("mississippi", "issip"));
	}

}

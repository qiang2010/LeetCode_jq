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
	
    
    /**
     * KMP 算法，实现判断一个串是否是另一个的子串
     * @param haystack
     * @param needle
     * @return
     */
    public static int strStrKMP(String haystack, String needle) {
    	
    	if(needle == null || haystack == null){
    		return -1;
    	}
    	int ns = needle.length();
    	int hs = haystack.length();
    	if(ns > hs){
    		return -1;
    	}
    	if(ns ==0){
    		return 0;
    	}
    	if(hs == 0){
    		return -1;
    	}
    	// 构建next数组
    	// next[i] 记录的是以needle[i] 字符结尾的最长前缀
    	int next[] = new int[ns];
    	next[0] = 0;
    	
    	for(int i = 1;i<ns;i++){
    		next[i] = 0;
    		char c = needle.charAt(i);
    		int k;
    		for(k = next[i-1];k > 0 && needle.charAt(k)!=c;k = next[k-1]);
    		if(needle.charAt(k) == c){
    			next[i] = k+1;
    		}
    	}
//    	for(int a:next){
//    		System.out.println(a);
//    	}
    	int i =0,j=0;
    	while(i<hs && j<ns){
    		if(needle.charAt(j)==haystack.charAt(i)){
    			i++;j++;
    		}else if(j ==0){// 第一个就不相等
    			i++;
    		}else{
    			j = next[j-1];
    		}
    	}
    	if(j == ns){
    		return i-j;
    	}
    	return -1;
    }
    
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(strStrKMP("a", "a"));
	}

}

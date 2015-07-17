package qiang.leetcode;

public class RegularExpressionMatching10 {

	
	/**
	 *   下面的代码还未完成
	 * @param s
	 * @param p
	 * @return
	 */
    public static boolean isMatch0(String s, String p) {
    	if(p==null || s == null ) return false;
    	if(p.indexOf('.') < 0  && p.indexOf('*') < 0){
    		return s.equals(p);
    	}
    	int pSize = p.length();
    	int sSize = s.length();
    	
    	int [] pFlag = new int[pSize];
    	for(int i = 0; i< pSize ; i++){
    		pFlag[i] = regCharToNum(p.charAt(i));
    	}
    	
    	// 遍历一遍待匹配待串，看看是否可以匹配
    	for( int j = 0 ,i =0; j < pSize && i< sSize ;){
    		if(pFlag[j] > 0  ) {
    			if( pFlag[j] == s.charAt(i)  && j<pSize-1 && pFlag[j+1] != -2 ){
    				i++;
        			j++;
        			continue;	
    			}else return false;
    			
    		}
    		// 到正则的符号 －1 匹配一个字符 －2 匹配 0 个或者多个
    		if(pFlag[j] == -1){
    			i++;j++;
    			continue;
    		}
    		// -2 
    		if( j+1 == pSize) return true; // * 可以将所有信息匹配
    		// 否则 枚举＊匹配0到 sSize -1个字符到情况
    		int leftSSize = sSize - i-1;
    		boolean temp = true;
    		int le ;
    		for(  le = 0; le < leftSSize ; le++){
//    			System.out.println(i);
    			 temp = isMatch0(s.substring(i+le),p.substring(j));
    			if(temp) return true;
    		}
    		if(le == leftSSize )
    		  return false;
    	}
    	return true;
    }
    /**
     *  这里把 Exg中的字符都按照类型转换一下
     * @param a
     * @return
     */
    public static int regCharToNum(char a){
    	if(a == '.' ) return  -1;
    	if(a ==  '*' ) return -2;
    	return a; 
    }
	
    /**
     *  
     * @param s
     * @param p
     * @return
     */
    public static boolean isMatch1(String s, String p) {
    	if(p == null || s == null ) return false; 
    	if("".equals(p)|| "".equals(s))return false;
    	if(p.indexOf('.') < 0 && p.indexOf('*') < 0){
    		return p.equals(s);
    	}
    	int sSize = s.length();
    	int pSize = p.length();
    	
    	int i =0,j=0;
    	StringBuilder regPre ;
    	for(   i = 0 ; i < sSize; ){
//    		System.out.println(0);
    		// 1. 情况1 ，需要匹配的字符的下一个是 ＊
    		if( j < pSize-1 ){
    			if(p.charAt(j+1)=='*'){
        			
//    				// j＋2 已经是超界了的情况
//    				if( j+2 >= pSize){
//    					return true;
//    				}
    				
    				// 这里为 ＊ ，复制前面一个字符，从0 到 sSize－i个，然后递归调用剩下到字符串

    				String las;
    				int k;
    				
    				for(  k = 0;k <= sSize - i ; k++){
//    					System.out.println(sSize - i);
        				regPre = new StringBuilder();    					
    					for( int build = 0; build < k; build++) regPre.append(p.charAt(j));
    					if(j +2 > pSize) las = "";
    					else las = p.substring(j+2);
//    					System.out.println(regPre.toString()+las);
    					boolean temp = isMatch1(s.substring(i),regPre.toString()+las);
    					if(temp ) return temp;
//    					System.out.println(k);
    				}
    				if(k > sSize -i) return false;
    				
    				
        		}else{
        			if(p.charAt(j) == '.' || p.charAt(j)==s.charAt(i)){
        				j++;i++;continue;
        			}else {
        				return false;
        			}
        			
        			
        		}
    		}else{ // 此时 j已经到p到最后一个字符了，如果是 ＊ 那么就return true
    			
    			if((p.charAt(j)== s.charAt(i) && i == sSize -1) || (p.charAt(j)=='.' && i == sSize -1)) return true;
    			return false;
//    			if(p.charAt(j)=='*' ) return true;
//    			else {
//    				
//    				return false;
//    			}
    			
    		}
    	}
    	return false;
    	
    }
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "aaaabc";
		String p = "a*abc";
		s = "abcd";
		p = "d*";
		s = "aaaaaaaaaaaaab";
		p = "a*a*a*a*a*a*a*a*a*a*c";
		System.out.println(isMatch1(s,p));
	}

}

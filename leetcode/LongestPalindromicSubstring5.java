package qiang.leetcode;

public class LongestPalindromicSubstring5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "ASDFFDSA";
//		String s1 = "AAAAA";
//		s=s1;
//		s="abca"; 
//		s = "bc";
//		s = "a";
//		s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabcaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		
		System.out.println(longestPalindrome1(s));
		System.out.println(longestPalindrome2(s));
		System.out.println(longestPalindrome3(s));
		System.out.println(longestPalindrome4(s));
	}

	
	

	
    
    //动态规划，使用全局的临时变量存储
    public static String longestPalindrome1(String s){
    	if("".equals(s)) return "";
    	int size = s.length();
    	int b=0,e=0;
    	boolean [][] tempResult = new boolean[size][size];

    	int in;
    	int max = 0;
    	int begin = 0,end = 0;
    	
    	// 首先初始化 长度为 1 和 2的情况 
    	for( int i=0;i< size -1; i++){
    		tempResult[i][i] = true;
    		if( s.charAt(i) == s.charAt(i+1)) {
    			tempResult[i][i+1] = true;
    			begin = i;
    			end = i+1;
    		}
    	}
    	tempResult[size-1][size-1] = true;
    	
    	// 然后判断 len 大于 2 的情况

    	for(int len=3; len <= size ; len++){
    		in = size - len + 1 ;
    		for(int j = 0; j <  in ; j++){
    			if(tempResult[j+1][j+len-2]  && s.charAt(j) == s.charAt(j+len-1) ){
    				tempResult[j][j+len-1] = true;
    				if(max < len){
    					max = len;
    					begin = j;
    					end = j+len-1;
    				}
    			}
//    			else {
//    				tempResult[j][j+len-1] = false;
//    			}
    		}
    	}
    	
    	return s.substring(begin,end+1); // 注意substring截取的范围
    }
    
	/**
	 *  中心扩展方法
	 *  这个算法思想其实很简单啊，时间复杂度为O（N2），空间复杂度仅为O（1）。
	 *  就是对给定的字符串S，分别以该字符串S中的每一个字符C为中心，向两边扩展，
	 *  记录下以字符C为中心的回文子串的长度。但是有一点需要注意的是，
	 *  回文的情况可能是 a b a，也可能是 a b b a。
	 * @param s
	 * @return
	 */
	public static String longestPalindrome2(String s){
		if(s==null || "".equals(s)) return "";
		String longest = s.substring(0,1);
		int max = 1;
		int size = s.length();
		String temp1;
		// c 仍然从 0 开始，因为要 0 1 这样扩展，否则aa会出错
		for( int c=0; c < size ; c++){
			temp1 = expendFromCenter(s, c, c);
			if(temp1.length() > max ){
				longest = temp1;
				max = temp1.length();
			}
			
			if( c+1 < size && s.charAt(c) == s.charAt(c+1)){
				temp1 = expendFromCenter(s,c,c+1);
				if(temp1.length() > max ){
					longest = temp1;
					max = temp1.length();
				}
			}
			
		}
		return longest;
	}
	/**
	 *   这里需要考虑 a b a，也可能是 a b b a 这两种情况，
	 *   所以需要 抽象出下面的从 c1 和c2 扩展，这样对于 abba这个就可以，调用 1 1， 1 2
	 * @param s
	 * @param i
	 * @return
	 */
	public static String expendFromCenter(String s,int c1,int c2){
		
		int left  = c1;
		int  right = c2;
		int size = s.length();
		while(left > -1 && right < size && s.charAt(left) == s.charAt(right)){
			left --;
			right ++;
		}
		// 这里 注意left 和 right的值
		//if(right == size) return s.substring(left);
		return s.substring(left+1,right);
	}

	
	
	/**
	 *   这里使用著名的 Manacher算法，时间复杂度竟然低至 O(N)
	 *   
	 * @param s
	 * @return
	 */
	public static String longestPalindrome3(String s){
		
		// 首先将s转换，插入＃
		StringBuilder newS = new StringBuilder();
//		newS.append('&');
		newS.append('#');
		int size = s.length();
		for(int i =0; i < size ; i++){
			newS.append(s.charAt(i));
			newS.append('#');
		}
//		newS.append('&');
		
		String newStr = newS.toString();
		int id = 0;
		int j;
		int ans = 1;
		int ansPos = 2;
		int newSize = newStr.length();   // 新的字符串长度
		int []p = new int[newSize];  //  p 都为 0 
		int mx = p[id] + id;
		int diff =-1;
		for( int i = 0;  i < newSize ; i++){   // 这里从 1 开始是因为在新的串的起始位置添加了额外的字符
			j = 2*id - i; // i 关于id 的对称点
			diff = mx - i;
			if( diff >= 0 ){  
				//System.out.println(i+" "+p[i] + " " +(mx- i) + " " + p[j]);
				if(diff >  p[j]){
					p[i] = p[j];
				}else{
					// mx 和 i 之间的距离小于 p［j］，需要进一步扩展
					p[i] = diff; // i-p[i] >0 && p[i]+i < newSize && 
					while(p[i]+i+1 < newSize && i-p[i]-1 >=0 && newStr.charAt(p[i]+i+1) == newStr.charAt(i-p[i]-1)){
						p[i]++;
					}
					
					
				}
				//p[i] = (mx - i) > p[j] ? p[j]:(mx-i);
				
			}else{
				p[i] = 0;
				while(p[i]+i+1 < newSize && i-p[i]-1 >=0 &&  newStr.charAt(p[i]+i+1) == newStr.charAt(i-p[i]-1)){
					p[i]++;
				}
			}
			
//			while(i-p[i] >0 && p[i]+i < newSize && newStr.charAt(p[i]+i) == newStr.charAt(i-p[i])){
//				p[i]++;
//			}
			
			// 这里更新 mx 和id ，注意 mx 和id 的含义，当前正在考虑的 id
			if(p[i] +i > mx ){  
				mx = p[i] + i;
				id = i;
			}
			if(ans < p[i]){
				ans = p[i];
				ansPos = i;
			}
		}
//		for( int k : p){
//			System.out.print(k +" ");	
//		}
		
        ans -=1; // 实际在原来的字符串中的 回文字符串长度
        int begin = (ansPos - ans-1)/2;
//        System.out.println( "  "+ans + " " +begin);
        return s.substring(begin,begin+ans+1);
		
	}
	
	
	/**
	 *   这里使用著名的 Manacher算法，时间复杂度竟然低至 O(N)
	 *   longestPalindrome4 是对 longestPalindrome3的简单代码改进和整理
	 * @param s
	 * @return
	 */
	public static String longestPalindrome4(String s){
		
		// 首先将s转换，插入＃
		StringBuilder newS = new StringBuilder();
//		newS.append('&');
		newS.append('#');
		int size = s.length();
		for(int i =0; i < size ; i++){
			newS.append(s.charAt(i));
			newS.append('#');
		}
//		newS.append('&');
		
		String newStr = newS.toString();
		int id = 0;
		int j;
		int ans = 1;
		int ansPos = 2;
		int newSize = newStr.length();   // 新的字符串长度
		int []p = new int[newSize];  //  p 都为 0 
		int mx = p[id] + id;
		int diff =-1;
		for( int i = 0;  i < newSize ; i++){   // 这里从 1 开始是因为在新的串的起始位置添加了额外的字符
			j = 2*id - i; // i 关于id 的对称点
			diff = mx - i;
			if( diff >= 0 ){  
				//System.out.println(i+" "+p[i] + " " +(mx- i) + " " + p[j]);
				if(diff >  p[j]){
					p[i] = p[j];
				}else{
					// mx 和 i 之间的距离小于 p［j］，需要进一步扩展
					p[i] = diff; // i-p[i] >0 && p[i]+i < newSize && 
//					while(p[i]+i+1 < newSize && i-p[i]-1 >=0 && newStr.charAt(p[i]+i+1) == newStr.charAt(i-p[i]-1)){
//						p[i]++;
//					}
					
					
				}
				//p[i] = (mx - i) > p[j] ? p[j]:(mx-i);
				
			}else{
				p[i] = 0;
//				while(p[i]+i+1 < newSize && i-p[i]-1 >=0 &&  newStr.charAt(p[i]+i+1) == newStr.charAt(i-p[i]-1)){
//					p[i]++;
//				}
			}
			
			while(p[i]+i+1 < newSize && i-p[i]-1 >=0 &&  newStr.charAt(p[i]+i+1) == newStr.charAt(i-p[i]-1)){
				p[i]++;
			}

			
			// 这里更新 mx 和id ，注意 mx 和id 的含义，当前正在考虑的 id
			if(p[i] +i > mx ){  
				mx = p[i] + i;
				id = i;
			}
			if(ans < p[i]){
				ans = p[i];
				ansPos = i;
			}
		}
//		for( int k : p){
//			System.out.print(k +" ");	
//		}
		
        ans -=1; // 实际在原来的字符串中的 回文字符串长度
        int begin = (ansPos - ans-1)/2;
        //System.out.println( "  "+ans + " " +begin);
        return s.substring(begin,begin+ans+1);
		
	}
	
	
}


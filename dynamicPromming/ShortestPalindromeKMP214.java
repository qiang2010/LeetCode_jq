package qiang.dynamicPromming;

public class ShortestPalindromeKMP214 {

	public static void main(String[] args) {
		
		System.out.println(new ShortestPalindromeKMP214().shortestPalindrome("abc"));
		System.out.println(new ShortestPalindromeKMP214().shortestPalindrome2("abc"));
	}
	
	
	/**
	 * 使用KMP算法
	 * 将s +"&" + s.reverse 组合在一起，然后求得next数组
	 * 那么就可以获得以左边界为边界的最长回文长度了。
	 * @param s
	 * @return
	 */
 	public String shortestPalindrome2(String s) {
 	
 		if(s == null || s.length()< 2)return s;
 		StringBuilder sb = new StringBuilder(s);
 		StringBuilder sbR = sb.reverse();
 		String newS = s +"%"+ sbR;
 		int []next = new int[newS.length()];
 		
 		next[0] = 0;
 		for(int i =1;i<next.length;i++){
 			
 			next[i] = 0;
 			char c = newS.charAt(i);
 			int k;
 			for(k = next[i-1];k>0 && newS.charAt(k)!=c;k=next[k-1]);
 			if(c == newS.charAt(k)){
 				next[i] = k+1;
 			}
 			
 		}
 		return sbR.substring(0,sbR.length()-next[next.length-1])+s;
 	}
 	
	/**
	 * 这里使用最传统的方法，找到以左边界结尾的回文，回文串的长度从size依次减少。
	 * @param s
	 * @return
	 */
	public String shortestPalindrome(String s) {
		
		if(s==null || s.length()==0)return "";
		int size = s.length()-1;
		
		while(!isPal(s,size)){
			size--;
		}
		//String a = s.substring(size+1);
		StringBuilder sb = new StringBuilder();
		for(int j = s.length()-1;j >size;j--){
			sb.append(s.charAt(j));
		}
		sb.append(s);
		return sb.toString();
	
	}
	boolean isPal(String s,int end){
		int size = s.length();
		if(end > size-1)return false;
		int i= 0;
		while(i < end ){
			if(s.charAt(i) != s.charAt(end))return false;
			i++;
			end--;
		}
		return true;
	}
}

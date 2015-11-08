package qiang.leetcode;

public class ShortestPalindrome214 {

	public static void main(String[] args) {
		
		System.out.println(new ShortestPalindrome214().shortestPalindrome("aba"));
		System.out.println(new ShortestPalindrome214().shortestPalindrome2("aba"));
	}
	
	
 	public String shortestPalindrome2(String s) {
 		

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
		int i = curSize-1;
		while(i > -1 && i+1 != p[i])i--;
		StringBuilder tempS = new StringBuilder();
		int e =0;
		if(i == -1){
			e = 0;
		}else{
			e = p[i]-1-1;
		}
 		for(i = size-1;i>e;i--){
 			tempS.append(s.charAt(i));
 		}
 		tempS.append(s);
 		return tempS.toString();
 	}
	
 
	
	
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

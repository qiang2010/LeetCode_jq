package qiang.leetcode3;


public class MinimunWindowSubstring76_2{
	
	/**
	 * 找到t中所有字符出现在s中的最小窗口。
	 * @param s
	 * @param t
	 * @return
	 */
	 public static String minWindow(String s, String t) { 
		 
		 if(t == null || s == null) return "";
		 if(t.equals(""))return "";
		 int begin=0,end =0;
		 
		 int []needFound = new int[256];
		 int []hasFound = new int[256];
		 for(int i =0;i< t.length();i++){
			 needFound[t.charAt(i)]++;
		 }
		 int count = 0;
		 int needCount = t.length();
		 int minWind = s.length()+1;
		 int minBegin=0,minend=0;
		 while(end < s.length()){
			 int cur = s.charAt(end);
			 if(needFound[cur]>0){
				 hasFound[cur]++;
				 if(needFound[cur]>= hasFound[cur]){
					 count++;
				 }
				 if(count == needCount){ // 找到一个窗口
					 // begin 向后收缩。
					 while(begin < s.length()){
						 int bb = s.charAt(begin);
						 if(needFound[bb]>0){
							 if(needFound[bb]< hasFound[bb]){
								 hasFound[bb]--;
							 }else{
								 break;
							 }
						 }
						 begin++;
					 }
					 if(end-begin+1<minWind){
						 minWind = end - begin +1;
						 minBegin = begin;
						 minend = end;
					 }
				 }	
			 }
		     end++;
		 }
		 if(count != t.length())return "";
		 return s.substring(minBegin,minend+1);
	 }
	
	
	
 
	public static  void main(String[]args) {
		// TODO Auto-generated method stub
		
		System.out.println(minWindow("ADOBECODEBANC", "ABC"));
	}
}
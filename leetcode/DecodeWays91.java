package qiang.leetcode;

public class DecodeWays91 {
    
	
	
	public static  int numDecodings(String s) {
		
		if(s == null || s.trim().length() ==0) return 0;
		int size = s.length();
		if(s.charAt(0)=='0')return 0;
		int last=1;
		int lastTow =1,cur=1;
		char lastChar,curChar;
		for(int i=1; i<size; i++){
			lastChar = s.charAt(i-1);
			curChar = s.charAt(i);
			if(curChar == '0'){
				if(lastChar>'0' && lastChar<'3')
					cur = lastTow;
				else return 0;
			}else{
				if(lastChar =='0'){
					cur = lastTow;
				}else{
					cur = (lastChar-'0')*10 + curChar-'0';
					if(cur < 27 && cur >0){
						cur = last + lastTow;
					}else{
						cur = last;
					}
				}
		
			}
			lastTow = last;
			last = cur;
		}
		return cur;
		
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(numDecodings("110"));
	}

}

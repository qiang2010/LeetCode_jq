package qiang.leetcode;

public class LengthOfLastWordEasy58 {
    
	
	
	public int lengthOfLastWord(String s) {
     
		if(s == null || "".equals(s.trim())) return 0;
		s = s.trim();
		int size = s.length();
		int i = size-1 ;
		while(i >-1 && s.charAt(i)!=' '){
			i--;
		}
		return size-i-1;	
    	
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LengthOfLastWordEasy58 ll = new LengthOfLastWordEasy58();
		System.out.println(ll.lengthOfLastWord("a"));
	}

}

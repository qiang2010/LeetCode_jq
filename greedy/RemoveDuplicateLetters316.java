package qiang.greedy;

public class RemoveDuplicateLetters316 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(removeDuplicateLetters("bbcaac"));
	}
    
	
	public static  String removeDuplicateLetters(String s) {
    
		if(s == null || s.length()==0)return "";
		if(s.length()<2)return s;
		int [] count = new int[26]; 
		
		int pos = 0;
		int size = s.length();
		for(int i =0;i<size;i++){
			count[s.charAt(i)-'a']++;
		}
		
		char c = s.charAt(pos);
		char b;
		for(int i =0;i<size;i++){
			b = s.charAt(i);
			if(b<c){
				c =b;
				pos = i;
			} 
			count[b-'a']--;
			if(count[b-'a']==0)break; // 找到了 count为1的之前的最小的字符。
		}
		
		return c + removeDuplicateLetters(s.substring(pos+1).replaceAll(c+"", ""));
    }
}

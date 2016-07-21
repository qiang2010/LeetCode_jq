package qiang.leetcode5;

public class ReverseWordsInString151 {
	   
	
	public String reverseWords(String s) {
	        
		StringBuilder  sb = new StringBuilder();
		
		String[]split = s.trim().split("\\s+");
		System.out.println(split.length);
		if(split.length == 0) return "";
		sb.append(split[split.length-1]);
		for(int i = split.length-2; i > -1; i--){
			sb.append(" "+split[i]);
		}
		return sb.toString();
	}
	public static void printSplit(String s[]){
		for(String ss:s){
			System.out.print("B");
			System.err.print(ss);
			System.out.print("B");
		}
		System.out.println();
	}
	
	
	public static void main(String[] args) {
		
		String s = "    2  blue";
		System.out.println(s.split("\\s").length);
		printSplit(s.split("\\s"));
		System.out.println(s.split("\\s+").length);
		printSplit(s.split("\\s+"));
		System.out.println(s.split("{1,}\\s").length);
		printSplit(s.split("{1,}\\s"));
		
		System.out.println(new ReverseWordsInString151().reverseWords(s));
		
	}
}

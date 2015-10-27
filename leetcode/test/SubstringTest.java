package qiang.leetcode.test;

public class SubstringTest {

	
	
	public static void main(String[] args) {
		
		System.out.println((5&6&7));
		
		String a = "1";
		System.out.println(a.substring(0, 1));
		
		// 将多个空格替换成1个。
		String s = "1    2";
		System.out.println(s.replaceAll("\\s{1,}", " "));
	}
}

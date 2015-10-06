package qiang.leetcode.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class REXTest {

	
	public static void main(String[] args) {
		
		String s = "leetcodecodecodecodecodeleeta";
		
		String pattern = "(leet|code)*";
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(s);
		
		if(m.matches()){
			System.out.println("match");
		}
	}
}

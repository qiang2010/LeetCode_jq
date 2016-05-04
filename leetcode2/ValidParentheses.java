package qiang.leetcode2;

import java.util.LinkedList;
import java.util.List;

public class ValidParentheses {
    
	/**
	 * 遇到左括号就进栈，右括号就出栈，出栈判断是否匹配，是就继续，否则false
	 * @param s
	 * @return
	 */
	public static boolean isValid(String s) {
		
		if(s == null || "".equals(s)) return true;
		int size = s.length();
		if(size % 2 == 1) return false;
		LinkedList<Character> stack = new LinkedList<Character>();
		for(int i = 0 ; i<size; i++ ){
			char curChar = s.charAt(i);
			if(curChar == '(' ||curChar == '{' ||curChar == '[' ){
				stack.addLast(curChar);
			}else{
				if(stack.isEmpty()) return false;  // }}}} 全是右括号
				char topChar = stack.getLast();
				stack.removeLast();
				if(topChar == '[' && curChar == ']' ||
						topChar == '{' && curChar == '}' ||
						topChar == '(' && curChar == ')' )
					continue;
				else return false;
			}
			
	    }
		if(stack.isEmpty()) // 如果最后栈中仍然有数据，fasle
			return true;
		else return false;
    }
    public static void main(String[]args){
    	System.out.println(isValid("({})()()"));
    	
    }
    
}

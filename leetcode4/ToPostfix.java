package qiang.leetcode4;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
/**
 * 
 * 
 * 将中序表达式转换成后缀表达式。
 * 
 * @author jq
 *
 */
public class ToPostfix {

	
	public static void main(String[] args) {
		
		ToPostfix ss = new ToPostfix();
		ss.toPost("1+56*8-(2-9)*63");
	}
	
	/**
	 * 将输入的中序表达式转成后续表达式。
	 * @param inorder
	 */
	void toPost(String inorder){
		System.out.println(inorder);
		LinkedList<Character> stack = new LinkedList<>();
		proi = new HashMap<>();
		proi.put('(', 3);
		proi.put(')', 3);
		proi.put('*', 2);
		proi.put('/', 2);
		proi.put('+', 1);
		proi.put('-', 1);
		
		int s = inorder.trim().length();
		for(int i = 0 ; i < s;){
			char c = inorder.charAt(i);
			switch(c){
			case '+':
			case '-':
			case '*':
			case '/':
				if(stack.isEmpty()){
					stack.addLast(c);
				}else{
					char top = stack.getLast();
					if(this.priorityCompareIsGreat(c,top)){
						stack.addLast(c);
					}else{
						while(stack.isEmpty()==false && this.priorityCompareIsGreat(c,top)==false)
						System.out.println(top);
						stack.removeLast();
						top = stack.getLast();
					}
				}
				i++;
				break;
			case ' ':i++;break;
			case '(':
				stack.addLast(c);
				i++;
				break;
			case ')':
				i++;
				while(stack.isEmpty() == false && stack.getLast() !='('){
					System.out.println(stack.getLast());
					stack.removeLast();
				}
				if(stack.isEmpty()==false) stack.removeLast();
				break;
			default: // 数字
				int nu = 0;
				while(i < s && Character.isDigit(inorder.charAt(i))){
					nu *=10;
					nu += inorder.charAt(i)-'0';
					i++;
				}
				System.out.println(nu);
			}
		}
		while(stack.isEmpty()==false){
			System.out.println(stack.getLast());
			stack.removeLast();
		}
	}
	Map<Character,Integer> proi;
	/**
	 * 优先级判断，返回a的优先级是否大于b
	 * @param a
	 * @param b
	 * @return
	 */
	boolean priorityCompareIsGreat(char a ,char b){
		if( a == '(') return true;
		int al = proi.get(a);
		int bl = proi.get(b);
		return al > bl;
	}
	
}

package qiang.leetcode;

import java.util.LinkedList;

public class EvaluateReversePolishNotation150 {

	
	
	  
	
	
	public int evalRPN(String[] tokens) {
	        
		if(tokens == null || tokens.length == 0) return 0;
		LinkedList<Integer> ans = new LinkedList<Integer>(); 
		int a=0,b=0;
		for(String temp: tokens){
			
			switch(temp){
			case "/":
					if(ans.isEmpty()==false){
						a = ans.getLast();ans.removeLast();
					}else return 0;
					if(ans.isEmpty()==false){
						b = ans.getLast();ans.removeLast();
					}else return 0;
					ans.addLast(b/a);
				break;
			case "*":
				if(ans.isEmpty()==false){
					a = ans.getLast();ans.removeLast();
				}else return 0;
				if(ans.isEmpty()==false){
					b = ans.getLast();ans.removeLast();
				}else return 0;
				ans.addLast(a*b);
				break;
			case "-":
				if(ans.isEmpty()==false){
					a = ans.getLast();ans.removeLast();
				}else return 0;
				if(ans.isEmpty()==false){
					b = ans.getLast();ans.removeLast();
				}else return 0;
				ans.addLast(b-a);
				break;
			case "+":
				if(ans.isEmpty()==false){
					a = ans.getLast();ans.removeLast();
				}else return 0;
				if(ans.isEmpty()==false){
					b = ans.getLast();ans.removeLast();
				}else return 0;
				ans.addLast(a+b);
				break;
			default:
				ans.addLast(Integer.parseInt(temp));
			}
		}
		return ans.getLast();
	}
	
	public static void main(String[] args) {
		
		String [] tokens = {"2", "1", "/", "3", "*"};
		System.out.println(new EvaluateReversePolishNotation150().evalRPN(tokens));
		
		
	}
}

package qiang.leetcode;

import java.util.LinkedList;

public class BasicCalculatorII227 {

 
    public int calculate(String s) { 
    	
    	if(s == null || "".equals(s)) return 0;
    	LinkedList<Integer> tempAns = new LinkedList<>();
    	LinkedList<Character> oper = new LinkedList<>();
    	
    	int size = s.length();
    	char cur,op;
    	int b,numBeginIndex = 0,a = 1;
    	for(int i = 0 ; i < size;){
    		cur = s.charAt(i);
    		if(cur ==' '){
    			i++;
    			continue;
    		}
    		// 读取到数字就压栈。
    		if(Character.isDigit(cur)){
    			numBeginIndex = i;
    			i++;
    			while(i<size && Character.isDigit(s.charAt(i))){
    				i++;
    			}
    			tempAns.add( Integer.parseInt(s.substring(numBeginIndex,i)));
    			//i++;
    		}else{
    			switch(cur){
        		case '*':
        		case '/':
        			op = cur;
        			i++;
        			while(i<size && s.charAt(i) == ' ')i++;
        			cur = s.charAt(i);
        			if(Character.isDigit(cur)){
            			numBeginIndex = i;
            			i++;
            			while(i<size && Character.isDigit(s.charAt(i))){
            				i++;
            			}
            			a = Integer.parseInt(s.substring(numBeginIndex,i));
        			}
        			//if(tempAns.isEmpty()) return a;
        			b = tempAns.getLast();
        			tempAns.removeLast();
        			tempAns.addLast(calPart(b, a, op));
        			//i++;
        			break;
        		case '+':
        		case '-':
        			// 如果此时tempAns的size大于1，那么计算。
        			if(tempAns.size() >1){
        				a = tempAns.getLast();
            			tempAns.removeLast();
            			b = tempAns.getLast();
            			tempAns.removeLast();
            			op = oper.getLast();
            			oper.removeLast();
            			tempAns.addLast(calPart(b, a, op));
        			}
        			oper.addLast(cur);
        			i++;
        		}
    			
    		}
    	}
    	if(oper.isEmpty())
    		return tempAns.getLast();
    	a = tempAns.getLast();
		tempAns.removeLast();
		b = tempAns.getLast();
		tempAns.removeLast();
		op = oper.getLast();
		oper.removeLast();
		return  (calPart(b, a, op));
    }
     
    public int calPart(int a,int b,char op){
    	switch(op){
    	case '+': 
    		return a+b;
    	case '-':
    		return a-b;
    	case '*':
    		return a*b;
    	case '/':
    		return a/b;
    	}
    	return 0;
    }
	
	public static void main(String[] args) {
		BasicCalculatorII227 bc = new BasicCalculatorII227();
		System.out.println(bc.calculate("3+5/9+2"));
	}
}

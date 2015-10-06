package qiang.leetcode;

import java.util.LinkedList;

public class BasicCalculator224_2 {

 
    public int calculate(String s) { 
    	
    	if(s == null || "".equals(s)) return 0;
    	LinkedList<Integer> tempAns = new LinkedList<>();
    	LinkedList<Character> oper = new LinkedList<>();
    	
    	int size = s.length();
    	char cur,op;
    	int b,numBeginIndex,a;
    	for(int i = 0 ; i < size;){
    		cur = s.charAt(i);
    		if(cur ==' '){
    			i++;
    			continue;
    		}
    		if(Character.isDigit(cur)){
    			numBeginIndex = i;
    			i++;
    			while(i<size && Character.isDigit(s.charAt(i))){
    				i++;
    			}
    			if(tempAns.isEmpty())
    				tempAns.add( Integer.parseInt(s.substring(numBeginIndex,i)));
    			else{
    				// 遇到数字，如果不为空就弹出一个数
    				a =Integer.parseInt(s.substring(numBeginIndex,i));
    				b = tempAns.getLast();
    				tempAns.removeLast();
    				op = oper.getLast();
    				oper.removeLast();
    				tempAns.add(calPart(b, a, op));
    			}
    			//i++;
    		}else{
    			switch(cur){
        		case '(':
        			// 
        			while(i<size && s.charAt(i) ==' ')i++;
        			cur = s.charAt(++i);
        			if(Character.isDigit(cur)){
            			numBeginIndex = i;
            			i++;
            			while(i<size && Character.isDigit(s.charAt(i))){
            				i++;
            			}
            			tempAns.add( Integer.parseInt(s.substring(numBeginIndex,i)));
            		}
        			break;
        		
        		case ')':
        			if(tempAns.size()==1){
        				i++;
        				break;
        			}
        			a = tempAns.getLast();
        			tempAns.removeLast();
        			//if(tempAns.isEmpty()) return a;
        			b = tempAns.getLast();
        			tempAns.removeLast();
        			op = oper.getLast();
        			oper.removeLast();
        			tempAns.addLast(calPart(b, a, op));
        			i++;
        			break;
        		case '+':
        		case '-':
        			oper.addLast(cur);
        			i++;
        		}
    			
    		}
    	}
    	return tempAns.getLast();
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
		BasicCalculator224_2 bc = new BasicCalculator224_2();
		System.out.println(bc.calculate("(1+(4+5+2)-3)+(6+8)"));
	}
}

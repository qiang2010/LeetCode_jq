package qiang.leetcode;

import java.util.LinkedList;

public class BasicCalculator224 {

	
	
    public int calculate(String s) {
    
    	
    	LinkedList<String>   rpn = getRPN( s);
    	LinkedList<Integer> ans = new LinkedList<Integer>();
    	int size = rpn.size();
    	int a,b;
    	String cur;
    	for(int i = 0 ; i<size; i++){
    		cur = rpn.get(i);
    		if(cur.equals("+")){
    			if(ans.size() > 1){
    				a = ans.getLast();
        			ans.removeLast();
        			b = ans.getLast();
        			ans.removeLast();
        			ans.add(a+b);
    			}
    		
    		}else{
    			if(cur.equals("-")){
    				if(ans.size() > 1){
        				a = ans.getLast();
            			ans.removeLast();
            			b = ans.getLast();
            			ans.removeLast();
            			ans.add(b-a);
        			}
    			}else{
    				ans.add(Integer.parseInt(cur));
    			}
    		}
    		
    	}
    	return ans.getLast();
    }
	
    // 将中序表达式转成成后序表达式
    LinkedList<String>  getRPN(String s){
    	LinkedList<String> ans = new LinkedList<>();
    	LinkedList<Character> stack = new LinkedList<>();
    	if(s == null || "".equals(s) ) return ans;
    	int size = s.length();
    	int numBeginIndex;
    	char cur;
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
    				//num.append(s.charAt(i++));
    			}
    			ans.add(s.substring(numBeginIndex,i));
    		}else{
    			switch(cur){
    				case  ')':
    					while(stack.isEmpty()==false && stack.getLast()!='('){
    						ans.add(stack.getLast()+"");
    						stack.removeLast();
    					}
    					if(stack.isEmpty()==false){
    						stack.removeLast();
    					}
    					break;
    				case '+':
    				case '-':
    					if(stack.isEmpty() == false && stack.getLast()!='('){
    						ans.add(stack.getLast()+"");
    						stack.removeLast();
    					} 
    					stack.add(cur);
    					break;
    				default: stack.add(cur);
    			}
    			i++;
    		}
    	}
    	while(stack.isEmpty()==false ){
			ans.add(stack.getLast()+"");
			stack.removeLast();
		}
    	return ans;
    }
	
	public static void main(String[] args) {
		BasicCalculator224 bc = new BasicCalculator224();
		System.out.println(bc.calculate("(1+(4+5+2)-3+()6+8)"));
		
	}
}

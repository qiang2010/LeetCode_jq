package qiang.maxStackQueue;

import java.util.LinkedList;

public class MinStack55 {
	
	LinkedList<Integer> stack1 = new LinkedList<>();
	LinkedList<Integer> stack2 = new LinkedList<>();
	
    public void push(int x) {
    	stack1.addLast(x);
        if(stack2.isEmpty()){
        	stack2.addLast(x);
        	return;
        }
        int top = stack2.getLast();
        if(x < top)
        	stack2.addLast(x);
        else
    	stack2.addLast(top);
        
    }

    public void pop() {
        if(!stack1.isEmpty()){
        	stack1.removeLast();
        	stack2.removeLast();
        }
    }

    public int top() {
        if(!stack1.isEmpty()){
        	return stack1.getLast();
        }
        return -1;
    }

    public int getMin() {
        if(!stack2.isEmpty()){
        	return stack2.getLast();
        }
        return -1;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

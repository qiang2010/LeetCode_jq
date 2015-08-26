package qiang.leetcode;

import java.util.LinkedList;
import java.util.List;

public class ImplementStackUsingQueues225 {

	LinkedList<Integer> queue1 = new LinkedList<Integer>();
	LinkedList<Integer> queue2 = new LinkedList<Integer>();
	
	
	 // Push element x onto stack.
    public void push(int x) {
        queue1.add(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        if(queue1.isEmpty()){
        	while(queue2.size()>1){
        		queue1.addLast(queue2.getFirst());
        		queue2.removeFirst();
        	}
        	queue2.removeFirst();
        }else{
        	while(queue1.size()>1){
        		queue2.addLast(queue1.getFirst());
        		queue1.removeFirst();
        	}
        	queue1.removeFirst();
        }
    }

    // Get the top element.
    public int top() {
        if(queue1.isEmpty()){
        	while(queue2.size()>1){
        		queue1.addLast(queue2.getFirst());
        		queue2.removeFirst();
        	}
        	int ans = queue2.getFirst();
        	queue2.removeFirst();
        	queue1.addLast(ans);
        	return ans;
        }else{
        	while(queue1.size()>1){
        		queue2.addLast(queue1.getFirst());
        		queue1.removeFirst();
        	}
        	int ans = queue1.getFirst();
        	queue1.removeFirst();
        	queue2.addLast(ans);
        	return ans;
        }
    }

    // Return whether the stack is empty.
    public boolean empty() {
        if(queue1.isEmpty() && queue2.isEmpty()){
        	return true;
        }
        return false;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ImplementStackUsingQueues225 myStack = new ImplementStackUsingQueues225();
		myStack.push(2);
		myStack.push(222);
		myStack.push(212);
		System.out.println(myStack.top());
		
		myStack.pop();
		System.out.println(myStack.top());
	}

}

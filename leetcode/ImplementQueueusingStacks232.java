package qiang.leetcode;
import java.util.*;

public class ImplementQueueusingStacks232 {

	LinkedList<Integer> stack1 = new LinkedList<Integer>();
	LinkedList<Integer> stack2= new LinkedList<Integer>();
	 // Push element x to the back of queue.
    public void push(int x) {
    	while(!stack2.isEmpty()){
    		stack1.addLast(stack2.getLast());
    		stack2.removeLast();
    	}
        stack1.addLast(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        if(!stack2.isEmpty()) stack2.removeLast();
        else{
        	 while(!stack1.isEmpty()){
             	stack2.addLast(stack1.getLast());
             	stack1.removeLast();
             }
             stack2.removeLast();
        }
       
    }

    // Get the front element.
    public int peek() {
        if(!stack2.isEmpty()){
        	return stack2.getLast();
        }
        while(!stack1.isEmpty()){
        	stack2.addLast(stack1.getLast());
        	stack1.removeLast();
        }
        return stack2.getLast();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
    public void printQueue(){
    	LinkedList<Integer> s = stack1.isEmpty()?stack2:stack1;
  
    	for(int x:s){
    		System.out.print(x+" ");
    	}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ImplementQueueusingStacks232 queue = new ImplementQueueusingStacks232();
		
		queue.push(3);
		System.out.println(queue.peek());
		queue.push(2);
//		queue.push(4);
		System.out.println(queue.peek());
//		queue.();
//		queue.push(0);
		queue.printQueue();
		queue.pop();
		queue.pop();
//		System.out.println(queue.peek());
		queue.printQueue();
		System.out.println(queue.empty());
		
		
	}

}

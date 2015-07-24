package qiang.maxStackQueue;


import java.util.LinkedList;

/**
 *  可以在常数时间内得到栈中最大值。
 * 
 * @author MLS
 *
 */
public class MaxStack {

	LinkedList<Integer> stack = new LinkedList<Integer>();
	LinkedList<Integer> maxFlag = new LinkedList<Integer>();
	
	public int pop(){
		if(stack.isEmpty()) return -1;
		int re =  stack.getLast();
		stack.removeLast();
		maxFlag.removeLast();
		return re;
	}
	public void push(int x){
		if(stack.isEmpty()){
			stack.addLast(x);
			maxFlag.addLast(x);
			return ;
		}
		
		int top = maxFlag.getLast();
		stack.addLast(x);
		if(top > x){
			
			maxFlag.addLast(top);
		}else{
			maxFlag.addLast(x);
		}
	}
	public int getMaxElement(){
		return maxFlag.getLast();
	}
	
	public boolean isEmpty(){
		return stack.isEmpty();
	}
	public int size(){
		return stack.size();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaxStack maxStack = new MaxStack();
		maxStack.push(12);
		maxStack.push(3);
		maxStack.push(6);
		maxStack.push(111);
		maxStack.pop();
		System.out.println(maxStack.getMaxElement());
		
	}
	
}

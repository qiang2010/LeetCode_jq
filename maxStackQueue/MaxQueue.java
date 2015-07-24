package qiang.maxStackQueue;



public class MaxQueue {

	MaxStack queue1 = new MaxStack();
	MaxStack queue2 = new MaxStack();
	public void push(int x){
		queue1.push(x);
	}
	public int  pop(){
		if(!queue2.isEmpty()){
			return queue2.pop();
		}
		while(!queue1.isEmpty()){
			queue2.push(queue1.pop());
		}
		return queue2.pop();
	}
	
	public int max(){
		if(queue1.isEmpty()){return queue2.getMaxElement();}
		if(queue2.isEmpty()){return queue1.getMaxElement();}
		
		int max1 = queue1.getMaxElement();
		int max2 = queue2.getMaxElement();
		return max1>max2? max1:max2;
		}
	public int size(){
		return queue1.size()+queue2.size();
	}
	
	public void  printQueue() {
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaxQueue maxqueue = new MaxQueue();
		maxqueue.push(12111);
		maxqueue.push(21);
		maxqueue.push(2);
		maxqueue.push(148);
		System.out.println(maxqueue.max());
		System.out.println(maxqueue.size());
		System.out.println(maxqueue.pop());
		System.out.println(maxqueue.size());
		System.out.println(maxqueue.max());
	}

}

package qiang.leetcode.test;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueTest {

	
	static	Comparator<Integer> com = new Comparator<Integer>() {

		@Override
		public int compare(Integer arg0, Integer arg1) {
			if(arg0 > arg1) return -1;
			else return  1;
		}
	};
	public static void main(String[] args) {
		
		PriorityQueue<Integer> minQueue = new PriorityQueue<Integer>(7);
		for(int i = 0 ; i <7; i++){
			minQueue.add((int)(Math.random()*100));
		}
		
		for(int i = 0 ; i <7; i++){
			System.out.println(minQueue.poll());// 获取并移除头
			//minQueue.remove();
		}
		 
		System.out.println("Max Queue:");
		
		PriorityQueue<Integer> maxQueue = new PriorityQueue<>(7,com);
		for(int i = 0 ; i <7; i++){
			maxQueue.add((int)(Math.random()*100));
		}
		for(int i = 0 ; i <7; i++){
			System.out.println(maxQueue.poll());// 获取并移除头
			//minQueue.remove();
		}
	}
	
	
}

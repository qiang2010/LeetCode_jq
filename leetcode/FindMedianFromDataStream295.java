package qiang.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class FindMedianFromDataStream295 {

	public static void main(String[] args) {
		
		FindMedianFromDataStream295 ff = new FindMedianFromDataStream295();
		ff.addNum(1);
		ff.addNum(12);
		ff.addNum(3);
		ff.addNum(4);
		ff.addNum(5);
		ff.addNum(10);
		System.out.println(ff.findMedian());
	}

	PriorityQueue<Integer> min = new PriorityQueue<>();
	PriorityQueue<Integer> max = new PriorityQueue<>(new Comparator<Integer>() {
		@Override
		public  int compare(Integer a, Integer b) {
			if(a > b) return -1;
			if( a < b) return 1;
			return 0;
		}
	});
	int minTop;
	int maxTop;
	
	public FindMedianFromDataStream295(){
		min.add(Integer.MAX_VALUE);
		max.add(Integer.MIN_VALUE);
	}
	
    // Adds a number into the data structure.
    public void addNum(int num) {


        minTop  = min.peek();
        maxTop = max.peek();
    	if(num > minTop){
    		min.add(num);
    	}else{
    		if(num < maxTop){
    			max.add(num);
    		}else{
    			int s1 = max.size();
        		int s2 = min.size();
        		if(s1==s2 || s1 < s2){
        			max.add(num);
        		}else if(s1 > s2){
        			min.add(num);
        		}
    		}
    	}
    	balance();
    }

    // Returns the median of current data stream
    public double findMedian() {
    	int s1 = max.size()-1;
		int s2 = min.size()-1;
		int s = s1+s2;
		if(s == 0){
			return 0;
		}
		if(s % 2 == 0){
			minTop = min.peek();
			maxTop = max.peek();
			return (minTop*1.0)/2+maxTop*1.0/2;
		}
		if(s % 2 == 1){
			if(s1 > s2){
				return max.peek();
			}
			return min.peek();
		}
		return -1;
    }
    // 每次添加元素后都调用该函数，因此大小堆的大小应该不会超过2.
    private void balance(){
    	int s1 = max.size();
		int s2 = min.size();
		if(Math.abs(s1-s2) <2)return;
		if(s1 > s2){
			min.add(max.poll());
			return;
		}
		max.add(min.poll());
    }

}

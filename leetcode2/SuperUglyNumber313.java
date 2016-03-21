package qiang.leetcode2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SuperUglyNumber313 {
    
	public static void main(String[] args) {
		
		SuperUglyNumber313 ss = new SuperUglyNumber313();
		int []primes= {2, 7, 13, 19};
		System.out.println(ss.nthSuperUglyNumber(12, primes));
		
	}
	/**
	 * 使用多路归并
	 * @param n
	 * @param primes
	 * @return
	 */
	public int nthSuperUglyNumber(int n, int[] primes) {
		if(primes == null || primes.length == 0)return 0;
		if(n <2)return 1;
		List<LinkedList<Integer>> lists = new ArrayList<>();
		LinkedList<Integer> temp;
		for(int i = 0 ; i < primes.length;i++){
			temp = new LinkedList<Integer>();
			temp.add(1);
			lists.add(temp);
		}
		int cur=1;
		for(int i = 0;i<n;i++){
			cur = getNewUgly(lists);
			addOne(lists, cur, primes);
			remove(lists, cur);
		}
		return cur;
	}
	
	/**
	 * 为每个链表，将新的丑数乘以每个链表的base，然后加入到尾部
	 * @param lists
	 * @param givenNum
	 */
	void addOne(List<LinkedList<Integer>> lists,int givenNum,int []primes){
		
		for(int i = 0 ;i< primes.length;i++){
			lists.get(i).addLast(givenNum*primes[i]);
		}
	}
	
	void remove(List<LinkedList<Integer>> lists,int givenNum){
		
		int cur;
		for(LinkedList<Integer> ll:lists){
			cur = ll.getFirst();
			if(cur == givenNum)ll.removeFirst();
		}
	}
	
	int getNewUgly(List<LinkedList<Integer>> lists){
		int min = Integer.MAX_VALUE;
		int cur;
		for(LinkedList<Integer> ll:lists){
			cur = ll.getFirst();
			min = min > cur? cur:min;
		}
		return min;
	}
}

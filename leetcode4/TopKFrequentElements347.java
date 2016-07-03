package qiang.leetcode4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements347 {

	public static void main(String[] args) {

		
		
	}
	class One{
		int num;
		int count;
		One(int n,int c){
			num = n;count = c;
		}
	}
    public List<Integer> topKFrequent(int[] nums, int k) {
        
    	LinkedList<Integer> ans = new LinkedList<>();
    	if(nums ==null || nums.length ==0 ) return ans;
    	
    	Map<Integer,Integer> count = new HashMap<>();
    	for(int a : nums){
    		if(count.containsKey(a)){
    			count.put(a, count.get(a)+1);
    		}else{
    			count.put(a, 1);
    		}
    	}
    	Comparator<One> com = new Comparator<One>(){
    		@Override
    		public int compare(One o1,One o2){
    			return Integer.compare(o1.count, o2.count);
    		}
    		
    	};
    	PriorityQueue<One> pq = new PriorityQueue<>(com); // 默认小堆
    	int minTop = Integer.MAX_VALUE;
    	// 也可以先放入k个元素。
    	int curC;
    	One top;
    	for(int ky:count.keySet()){
    		curC = count.get(ky);
    		if(pq.size() < k ){
    			pq.add(new One(ky,curC));
    		}else{
    			top = pq.peek();
    			if(curC > top.count){
    				pq.poll();
    				pq.add(new One(ky,curC));
    			}
    		}
    	}
    	while(pq.isEmpty()==false){
    		ans.addFirst(pq.poll().num);
    	}
    	return ans;
    }
	
    public List<Integer> topKFrequent2(int[] nums, int k) {

    	LinkedList<Integer> ans = new LinkedList<>();
    	if(nums ==null || nums.length ==0 ) return ans;
    	Map<Integer,Integer> count = new HashMap<>();
    	for(int a:nums){
    		if(count.containsKey(a))count.put(a, count.get(a)+1);
    		else count.put(a, 1);
    	}
    	int maxC = -1;
    	Map<Integer,List<Integer>> countM = new HashMap<>();
    	List<Integer> li;
    	for(int a :count.keySet()){
    		int c = count.get(a);
    		maxC = Math.max(maxC,c);
    		li = countM.get(c);
    		if(li == null) li = new ArrayList<>();
    		li.add(a);
    		countM.put(c, li);
    	}
    	for(int i = maxC;i>0;i--){
    		li = countM.get(i);
    		if(li != null){
    			ans.addAll(li);
    			if(ans.size() >= k) break;
    		}
    	}
    	while(ans.size() > k){
    		ans.removeLast();
    	}
    	return ans;
    }
    
}

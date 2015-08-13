package qiang.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class ContainsDuplicateIII_220 {

	/**
 
	 * @param nums
	 * @param k
	 * @return
	 */
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
    	boolean flag = false;
    	int size = nums.length;
    	if(size <= 1 || k ==0 )return flag;
    	HashMap<Integer,Integer>  map = new HashMap<Integer,Integer>();
    	map.put(nums[0], 0);
    	for(int i = 1 ; i < size;i++){
    		if(map.containsKey(nums[i])){
    			int j = map.get(nums[i]);
    			if(i-j<= k) return true;
    		}
    		map.put(nums[i], i);
    	}
    	return false;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []nums = {-1,1,-1,0,0};
		
		System.out.println(containsNearbyDuplicate(nums,1));
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(3);
		list.add(31);
		list.add(311);
		list.add(31111);
		Collections.sort(list);
		System.out.println(list.get(0));// sort默认由小到大排序的
		
	}

}

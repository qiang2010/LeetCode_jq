package qiang.leetcode3;

import java.util.HashMap;

public class TowSum1 {

	
	
    public static  int[] twoSum(int[] nums, int target) {
    	int [] res = new int[2];
    	res[0] = -1;
    	res[1] = -1;
    	if(nums == null || nums.length <2 ) return res; 
        int size = nums.length;
    	HashMap<Integer,Integer> leftNumbers = new HashMap<Integer,Integer>();
    	leftNumbers.put(target-nums[0], 0);
    	int tempLeft; 
    	for(int i = 1; i < size ; i++){
    		if(leftNumbers.containsKey(nums[i])){
    			res[0] = leftNumbers.get(nums[i]) +1;
    			res[1] = i +1;
    			return res;
    		}
    		tempLeft = target - nums[i];
    		leftNumbers.put(tempLeft,i);
    	}
    	
    	return res;
    }
	boolean isValid(String s){
		if(s == null || s.length()==0) return true;
		int count =0;
		for(int i =0;i< s.length();i++){
			char c = s.charAt(i);
			if(c == '(') count++;
			else if(c ==')')count--;
			if(count < 0) return false;
		}
		return count == 0;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] nums = {2, 7, 11, 15};
		int target = 9;
		int [] res = TowSum1.twoSum(nums, target);
		System.out.println( res[0] + "  " + res[1]);
	}

}

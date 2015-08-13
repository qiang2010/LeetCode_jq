package qiang.leetcode;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate_217 {
		
    public boolean containsDuplicate(int[] nums) {
    	if ( nums == null || nums.length == 0 ) return false;
        Set<Integer> allNums = new HashSet<Integer>();
    	for(int i = 0 ; i < nums.length ; i++){
    		if(allNums.contains(nums[i])) return true;
    		allNums.add(nums[i]);
    	}
    	return false;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []nums = {-1,-1};
		System.out.println( );
	}

}

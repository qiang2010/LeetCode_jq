package qiang.leetcode5;

import java.util.Arrays;

public class RemoveDuplicatesfromSortedArrayII80 {

	
	
	
	
    public static int removeDuplicates(int[] nums) {
        
    	if(nums == null || nums.length == 0 ) return 0;
    	int size = nums.length;
    	
    	int curPro = 0;
    	int curPos = 0;
    	boolean du = false;
    	int last ;
    	while(curPro < size){
    		
    		last = curPro+1 ;
    		du = false;
    		while(last < size && nums[last] == nums[curPro] ){
    			last++;
    			du = true;
    		}
    		// 有重复
    		if(du){
    			nums[curPos] = nums[curPro];
    			curPos++;
    		}
    		nums[curPos++] = nums[curPro];
    		
    		curPro = last;
    	}
    	return curPos;
    }	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []nums = {4,4,4};
		System.out.println(removeDuplicates(nums));
		System.out.println(Arrays.toString(nums));
	}

}

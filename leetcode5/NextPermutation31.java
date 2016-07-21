package qiang.leetcode5;

import java.util.Arrays;

public class NextPermutation31 {
    
	public static void nextPermutation(int[] nums) {
        
    	if(nums == null || nums.length <=1) return;
    	int size = nums.length;
    	int i,j;
    	for(i =size-1; i >-1; i--){
    		//for(  j= i-1; j>-1; j--){
    		if(i==0){
    		 	// 不存在 一个数，其左侧存在比起小的数。
    	    	for( i =0;i<size/2;i++){
    	    		j = nums[i];
    	    		nums[i] = nums[size-1-i];
    	    		nums[size-1-i] = j;
    	    	}
    	    	return ;
    		}
    		// 在左侧找到一个小于nums[i]的数
    		if(nums[i-1] <nums[i]){
    			
    			// 遍历 i到size-1 之间的数，找到刚好大于 nums[i-1]的数。
    			int minGreater = nums[i]; // 初始化为nums[i]
    			int n,minPos = i;
    			
    			for( n =  i+1; n < size; n++){
    				if(nums[n]> nums[i-1] && nums[n] < minGreater){
    					minGreater = nums[n];
    					minPos = n;
    				}
    			}
    			
    			int k = nums[i-1];
    			nums[i-1] = nums[minPos];
    			nums[minPos] = k;
    			Arrays.sort(nums, i, size);
    			return ;
    		}
    		//}
    		
    	}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []nums = {1,3,2};
		nextPermutation(nums);
		int i = 0;
		while(i < nums.length){
			System.out.println(nums[i++]);
		}
	
	}

}

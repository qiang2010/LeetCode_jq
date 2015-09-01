package qiang.leetcode;

import java.util.Arrays;

public class SortColors75 {

	
	
    public static void sortColors(int[] nums) {
        if(nums == null || nums.length ==0) return;
    	int []ans = new int[3];
    	int s = nums.length;
    	for(int i=0; i <s; i++){
    		ans[nums[i]]++;
    	}
    	int count =0;
    	for(int j =0 ; j < 3; j++){
    		for(int k=0; k < ans[j]; k++){
    			nums[count++] = j; 
    		}
    			 
    	}
    }
    
    public static void main(String[] args) {
		int []nums = {1,2,0,0,2,1,1,1,0,1};
		sortColors(nums);
		System.out.println(Arrays.toString(nums));
	}
}

package qiang.leetcode2;

import java.util.Arrays;

public class WiggleSort280 {
	public void wiggleSort(int []nums){
		if(nums == null || nums.length <3)return ;
		Arrays.sort(nums);
		int []temp = new int[nums.length];
		int big = nums.length-1;
		int small = (nums.length+1)>>1;
		int i = 0;
		for(i = 0;i< nums.length;i++){
			temp[i] = ((i&1)==0)? nums[small--]:nums[big--];
		}
		for(i = 0;i< nums.length;i++)nums[i] =  temp[i];
	}
	
	public void wiggleSort2(int []nums){
		if(nums == null || nums.length < 2)return;
		for(int i =1;i<nums.length;i++){
			if((i&1)==0 && nums[i] > nums[i-1]){
				swap(nums,i,i-1);
			}
			if((i&1)==1 && nums[i] < nums[i-1]){
				swap(nums,i,i-1);
			}
			
		}
		
	}
	void swap(int []nums,int i ,int j){
		
		int t = nums[i];
		nums[i] =  nums[j];
		nums[j] = t;
		
	}
}

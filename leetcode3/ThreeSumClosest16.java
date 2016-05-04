package qiang.leetcode3;

import java.util.Arrays;

/**
 * 
 * Given an array S of n integers, 
 * find three integers in S such that the sum is closest to a given number,
 *  target. Return the sum of the three integers. 
 * You may assume that each input would have exactly one solution.
 * @author jq
 */
public class ThreeSumClosest16 {

	public static int threeSumClosest(int[] nums, int target) {
		int ans = Integer.MAX_VALUE;
		if(nums == null || nums.length <3) return ans;
		int size = nums.length;
		int j ,k,diff;
		int lastDiff = ans;
		Arrays.sort(nums); 
		for(int i = 0 ; i < size; i++){
			j = i+1;
			k = size-1;
			if(i > 0 && nums[i] == nums[i-1] ) continue;
			while(j < k){
				if(j>i+1&&nums[j]==nums[j-1]){
					j++;
					continue;
				}
				if(k<size-1 && nums[k] == nums[k+1]){
					k--;continue;
				}
				int tempSum = nums[i] + nums[j] + nums[k];
				diff = (tempSum - target);
				if(diff >0){
					k--;
				}else{
					j++;
				}
				diff = diff >0 ?diff: -diff;
				if(diff < lastDiff){
					ans = tempSum; lastDiff = diff;
				}
			}
			
		}
		return ans;
    }
	public static void main(String[]args){
		int []nums = {-1,2,1,-4};
		System.out.println(ThreeSumClosest16.threeSumClosest(nums, 1));
	}
}

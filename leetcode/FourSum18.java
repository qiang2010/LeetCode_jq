package qiang.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum18 {

	
   public static List<List<Integer>> fourSum(int[] nums, int target) {
	   List<List<Integer>> ans = new ArrayList<List<Integer>>();
	   
	   if(nums == null || nums.length <4) return ans;
	   List<List<Integer>> part3SumAns ;
	   Arrays.sort(nums);
	   for(int i = 0 ; i < nums.length ; i++){
		   if(i!=0 && nums[i]==nums[i-1])continue;
		   part3SumAns = Q3Sum15.threeSum5(nums, i+1, nums.length, target-nums[i]);
			int partSize = part3SumAns.size();
			for(int j = 0 ; j<partSize;j++){
				List<Integer> tempAns =new ArrayList<Integer>();
				tempAns.add(nums[i]);
				tempAns.addAll(part3SumAns.get(j));
				ans.add(tempAns);
			}
	   }
	   
	   return ans;
   }	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []nums = {2,1,0,-1};
		List<List<Integer>> ans = FourSum18.fourSum(nums, 2);
		System.out.println(ans.size());
	}

}

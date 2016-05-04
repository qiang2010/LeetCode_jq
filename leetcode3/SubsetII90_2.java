package qiang.leetcode3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import qiang.leetcode.util.PrintUtil;

public class SubsetII90_2 {
	  
	public static void main(String[] args) {
		
		SubsetII90_2 sb = new SubsetII90_2();
		int []nums = {1,2,2};
		List<List<Integer>> ans = sb.subsetsWithDup(nums);
		PrintUtil.print2DList(ans);
	}
	public List<List<Integer>> subsetsWithDup(int[] nums) {
	        
		Arrays.sort(nums);
	
		List<List<Integer>> ans = new LinkedList<List<Integer>>();
		ans.add(new LinkedList<Integer>()); // 选0个
		int begin =0;
		for(int i =0;i<nums.length;i++){
			if(i==0 || nums[i]!=nums[i-1])begin =0;
			int size = ans.size();
			for(int j =begin;j< size; j++){
				List<Integer> temp = new ArrayList<>(ans.get(j));
				temp.add(nums[i]);
				ans.add(temp);
			}
			begin = size;
		}
		return ans;
	}
	
	 
}

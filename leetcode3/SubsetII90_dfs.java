package qiang.leetcode3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import qiang.leetcode.util.PrintUtil;

public class SubsetII90_dfs {
	  
	public static void main(String[] args) {
		
		SubsetII90_dfs sb = new SubsetII90_dfs();
		int []nums = {1,2,3};
		List<List<Integer>> ans = sb.subsetsWithDup(nums);
		PrintUtil.print2DList(ans);
	}
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> ans = new LinkedList<List<Integer>>();
		dfs(nums,0,new LinkedList<Integer>(),ans);
		return ans;
	}
	void dfs(int nums[],int index,LinkedList<Integer> tempA,List<List<Integer>> ans){
		ans.add(new ArrayList<Integer>(tempA));
		for(int i =index; i < nums.length;i++){
			if(i!=index && nums[i]==nums[i-1])continue;
			tempA.addLast(nums[i]);
			dfs(nums,i+1,tempA,ans);
			tempA.removeLast();
		}
	}
	 
}

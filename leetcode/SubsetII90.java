package qiang.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import qiang.leetcode.util.PrintUtil;

public class SubsetII90 {
	  
	public static void main(String[] args) {
		
		SubsetII90 sb = new SubsetII90();
		int []nums = {1};
		List<List<Integer>> ans = sb.subsetsWithDup(nums);
		PrintUtil.print2DList(ans);
	}
	public List<List<Integer>> subsetsWithDup(int[] nums) {
	        
		Arrays.sort(nums);
	
		List<List<Integer>> ans = new LinkedList<List<Integer>>();
		ans.add(new LinkedList<Integer>()); // 选0个
		for(int i = 1;i<nums.length+1;i++){
			subSetK(ans, nums, i);
		}
		return ans;
	}
	
	/**
	 * 从nums中选出k个元素，且组合唯一
	 * @param nums
	 * @param k
	 */
	void subSetK(List<List<Integer>>  ans, int []nums,int k){
		
		int []tempPos = new int[k];
		for(int i =0;i<k;i++){
			tempPos[i] = i;
		}
		
		LinkedList<Integer> oneAns ;
		for(;;){
			oneAns = new LinkedList<>();
			for(int i =0;i<k;i++){
				oneAns.addLast(nums[tempPos[i]]);
			}
			ans.add(oneAns);
			
			int m = k-1;
			int mk = nums.length-1;
			while( m > -1 && tempPos[m] == mk){
				m--;
				mk--;
			}
			if(m == -1){
				return;
			}
			while(m > -1){
				int tempPosOne = tempPos[m];
				tempPos[m]++;
				while(tempPos[m] < mk+1  && nums[tempPosOne] == nums[tempPos[m]]){
					tempPos[m]++;
				}
				if(tempPos[m] == mk+1){
					m--;
				}else{
					break;
				}
			}
			if(m == -1) return;
			
			for(int i = m+1;i<k;i++){
				tempPos[i] = tempPos[i-1]+1;
			}
		}
	}
}

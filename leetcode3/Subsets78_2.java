package qiang.leetcode3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import qiang.leetcode.util.PrintUtil;

public class Subsets78_2 {

	
    public  List<List<Integer>> subsets(int[] nums) {
    	Arrays.sort(nums);
    	List<List<Integer>> ans = new LinkedList<List<Integer>>();
    	ans.add(new LinkedList<Integer>());
    	List<Integer> tempList;
    	for(int i =0; i < nums.length;i++){
    		int size = ans.size();
    		for(int j=0;j<size;j++){
    			tempList = new ArrayList<>(ans.get(j));
    			tempList.add(nums[i]);
    			ans.add(tempList);
    		}
    	}
    	return ans;
    }
   
    
	public List<List<Integer>> subsets3(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> ans = new LinkedList<List<Integer>>();
		dfs(nums,0,new LinkedList<Integer>(),ans);
		return ans;
	}
	void dfs(int nums[],int index,LinkedList<Integer> tempA,List<List<Integer>> ans){
		ans.add(new ArrayList<Integer>(tempA));
		for(int i =index; i < nums.length;i++){
			tempA.addLast(nums[i]);
			dfs(nums,i+1,tempA,ans);
			tempA.removeLast();
		}
	}
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Subsets78_2 sub = new Subsets78_2();
		int []nums = {1,2,3};
		
		PrintUtil.print2DList(sub.subsets(nums));
	}

}

package qiang.leetcode;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum39 {

	
	List<List<Integer>> ans;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
    	ans= new ArrayList<List<Integer>>();
    	if(candidates == null || candidates.length == 0) return ans;
    	
    	
        return ans;
    }
    private void dfs(int []nums,List<Integer> partAns,int target,int curPos,int left){
   
    	
    	if(left ==0){
    		List<Integer> tempAns = new ArrayList<Integer>();
    		tempAns.addAll(partAns);
    		ans.add(tempAns);
    		return ;
    	}
    		
    	// 回溯
    	int lastPos = partAns.size()-1;
        left += nums[curPos];
        partAns.remove(lastPos);
        if(curPos+1 < nums.length){
        	curPos ++;
       		left -= nums[curPos];
       	}
    	if(left - nums[curPos] >= 0 ){
    		left -= nums[curPos];
    		partAns.add(nums[curPos]);
    		dfs(nums, partAns, target, curPos, left);
    		
    	}
    }
    
    public static void main(String[]args){
    	
    	
    	
    }
	
}

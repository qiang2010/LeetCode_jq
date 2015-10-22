package qiang.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import qiang.leetcode.util.PrintUtil;

public class CombinationSum39 {
    
	public static void main(String[] args) {
		int []candidates ={2,3,6,7};
		int target =7;
		List<List<Integer>> ans = new CombinationSum39().combinationSum(candidates, target);
		System.out.println(ans.size());
		PrintUtil.print2DList(ans);
	}
	
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
    	
		// 如果cand中有重复元素，会出现重复解。
    	  Arrays.sort(candidates);
    	  
    	  List<List<Integer>> ans = new LinkedList<List<Integer>>();
    	  dfs(ans, candidates,0, new LinkedList<Integer>(), target);
    	  return ans;
    }
	void dfs( List<List<Integer>> ans,int[] candidates, int i,LinkedList<Integer> oneAns,int target){
		if(target < 0 ) return ;
		if(target ==0){
			List<Integer> one = new ArrayList<>();
			one.addAll(oneAns);
			ans.add(one);
			return ;
		}
		if( i > candidates.length-1)return;
		int c = target/candidates[i];
		if(c==0)return;
		for(int j=c;j>-1;j--){
			for(int k=0;k<j;k++)
				oneAns.addLast(candidates[i]);
			dfs(ans, candidates, i+1, oneAns, target-j*candidates[i]);
			for(int k=0;k<j;k++)
				oneAns.removeLast();
		}
	}
	
}

package qiang.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import qiang.leetcode.util.PrintUtil;

public class CombinationSum40 {
    
	public static void main(String[] args) {
		int []candidates ={10,1,2,7,6,1,5};
		int target =8;
		List<List<Integer>> ans = new CombinationSum40().combinationSum2(candidates, target);
		System.out.println(ans.size());
		PrintUtil.print2DList(ans);
	}
	
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    	
    	  Arrays.sort(candidates);
    	  Set<Integer> ansSet = new HashSet<Integer>();
    	  List<List<Integer>> ans = new LinkedList<List<Integer>>();
    	  dfs( ansSet,ans, candidates,0, new LinkedList<Integer>(), target);
    	  return ans;
    }
	void dfs( Set<Integer> ansSet, List<List<Integer>> ans,int[] candidates, int i,LinkedList<Integer> oneAns,int target){
		if(target < 0 ) return ;
		if(target ==0){
			List<Integer> one = new ArrayList<>();
			int a=0,base=1;
			for(int b:oneAns){
				a+=b*base;
				base*=10;
			}
			if(ansSet.contains(a))return;
			ansSet.add(a);
			one.addAll(oneAns);
			ans.add(one);
			return ;
		}
		int j=1;
		if( i > candidates.length-1)return;
		if(i> 0 && candidates[i-1]==candidates[i]&&oneAns.size()>0&&oneAns.getLast()==0)return;
		for(;j>-1;j--){
			if(j==1)
				oneAns.addLast(candidates[i]);
			dfs(ansSet,ans, candidates, i+1, oneAns, target-j*candidates[i]);
			if(j==1)
				oneAns.removeLast();
		}
	}
	
}

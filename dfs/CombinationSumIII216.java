package qiang.dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import qiang.leetcode.util.PrintUtil;

public class CombinationSumIII216 {
    
	public static void main(String[] args) {
		List<List<Integer>> ans = new CombinationSumIII216().combinationSum3(3, 15);
		System.out.println(ans.size());
		PrintUtil.print2DList(ans);
	}
	
	public List<List<Integer>> combinationSum3(int k, int n) {
    	
		List<List<Integer>>  ans = new LinkedList<List<Integer>>();
		dfs(ans, new LinkedList<Integer>(), 1, k, n);
		return ans;
    }
	
	/**
	 * 
	 * @param ans
	 * @param oneAns
	 * @param index	已经处理到第几个数字 1 到9
	 * @param k	还需要几个数来组合成最后的解
	 * @param left  用oneAns中的数组合后，还剩多少
	 */
	public void dfs(List<List<Integer>> ans,LinkedList<Integer> oneAns,int index,int k,int left){
		//if(index >9) return;
		if(k < 0) return;
		
		if(k==0){
			if(left !=0)return;
			List<Integer> tempAns = new ArrayList<>();
			tempAns.addAll(oneAns);
			ans.add(tempAns);
			return;
		}
		if(index > left) return;
		for(int i = index; i <10;i++){
			oneAns.addLast(i);
			dfs(ans, oneAns, i+1, k-1, left-i);
			oneAns.removeLast();
		}
		
	}
	
}

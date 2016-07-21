package qiang.leetcode6;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import qiang.leetcode.util.PrintUtil;

public class FactorCombinations254_2 {

	public static void main(String[] args) {
		
		FactorCombinations254_2 fa = new FactorCombinations254_2();
		PrintUtil.print2DList(fa.getFactors(32));
	} 
	
	public List<List<Integer>> getFactors(int n) {
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		if(n < 3)return ans; 
		LinkedList<Integer> par = new LinkedList<Integer>();
		dfs(ans,par, 2, n);
		return  ans;
	}
	void dfs(List<List<Integer>> ans,LinkedList<Integer> partAns,int start,int left){
//		if(left<lastNum) return;
		if(left == 1) {
			if(partAns.size()>1)
			ans.add(new LinkedList<>(partAns));
			return;
		}
		for(int i = start;i<=left;i++){
			if(left % i == 0){
				partAns.addLast(i);
				dfs(ans, partAns, i, left/i);
				partAns.removeLast();
			}
		}
	}
}

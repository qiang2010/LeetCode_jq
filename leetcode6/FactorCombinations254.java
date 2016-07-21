package qiang.leetcode6;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import qiang.leetcode.util.PrintUtil;

public class FactorCombinations254 {

	public static void main(String[] args) {
		
		FactorCombinations254 fa = new FactorCombinations254();
		PrintUtil.print2DList(fa.getFactors(32));
	} 
	
	public List<List<Integer>> getFactors(int n) {
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		if(n < 3)return ans; 
		int stop = (int)Math.sqrt(n)+1;
		for(int i =2;i<stop;i++){
			// i是其一个因子
			if(n%i==0){
				 LinkedList<Integer> par = new LinkedList<Integer>();
				 par.addLast(i);
				dfs(ans,par, i, n/i);
			}
		}
		return  ans;
	}
	void dfs(List<List<Integer>> ans,LinkedList<Integer> partAns,int lastNum,int left){
		if(left<lastNum) return;
		if(left ==1) return;
		partAns.addLast(left);
		ans.add(new ArrayList<Integer>(partAns));
		partAns.removeLast();
		for(int i = lastNum;i<Math.sqrt(left)+1;i++){
			if(left % i == 0){
				partAns.addLast(i);
				dfs(ans, partAns, i, left/i);
				partAns.removeLast();
			}
		}
	}
}

package qiang.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import qiang.leetcode.util.PrintUtil;

public class CombinationSumIII216 {
    
	public static void main(String[] args) {
		int []candidates ={10,1,2,7,6,1,5};
		int target =8;
		List<List<Integer>> ans = new CombinationSumIII216().combinationSum3(candidates, target);
		System.out.println(ans.size());
		PrintUtil.print2DList(ans);
	}
	
	public List<List<Integer>> combinationSum3(int k, int n) {
    	
		
   
    }
}

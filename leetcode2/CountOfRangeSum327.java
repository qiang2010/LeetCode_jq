package qiang.leetcode2;

import java.util.SortedSet;
import java.util.TreeSet;

public class CountOfRangeSum327 {

	public static void main(String[] args) {
		
		int []nums = {2147483647,-2147483648,-1,0};
		System.out.println(countRangeSum(nums, -1,0));
		
	}
	   
	public static  int countRangeSum(int[] nums, int lower, int upper) { 
		
		if(nums == null || nums.length==0)return 0;
		BST327 bst = new BST327();
		long pSum =0;
		int ans =0;
		bst.insertOneNum(pSum);
		for(int n:nums){
			pSum +=n;
			long ff = pSum-(long)lower;
			long ss = pSum-(long)upper;
			int f1 = bst.findLessThanEqal(ff);
			int f2 = bst.findLessThanEqal(ss-1);
			ans +=f1-f2;
			bst.insertOneNum(pSum);
			bst.print();System.out.println();
		}
//		ans +=(bst.findLessThanEqal(pSum-lower)-bst.findLessThan(pSum-upper));
		return ans;
	}
	
}

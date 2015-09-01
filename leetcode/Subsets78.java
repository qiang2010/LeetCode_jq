package qiang.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import qiang.leetcode.util.PrintUtil;

public class Subsets78 {

	List<List<Integer>> ans = new LinkedList<List<Integer>>();
    public  List<List<Integer>> subsets(int[] nums) {
     
    	Arrays.sort(nums);
    	ans.add(new LinkedList<Integer>());
    	for(int i =1; i < nums.length+1;i++){
    		subsetK(nums,i);
    	}
    	return ans;
    }
    
    private void subsetK(int []nums,int k){
    	int n = nums.length;
    	int []tempPos = new int[k];
    	for(int i =0 ; i < k; i++){
    		tempPos[i] = i;
    	}
    	LinkedList<Integer> tempAns ;
    	while(true){
    		tempAns  = new LinkedList<Integer>();
    		for(int j : tempPos){
    			tempAns.add(nums[j]);
    		}
    		ans.add(tempAns);
    		int m = k-1;
    		int mk = n-1;
    		while(m>-1 && mk > -1 && tempPos[m]== mk){
    			m--;mk--;
    		}
    		// 已经结束
    		if(m==-1) return;
    		tempPos[m]++;
    		for(int i = m+1; i<k;i++){
    			tempPos[i] = tempPos[i-1]+1;
    		}
    	}
    	
    	
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Subsets78 sub = new Subsets78();
		int []nums = {1,2,3};
		sub.subsets(nums);
		PrintUtil.print2DList(sub.ans);
	}

}

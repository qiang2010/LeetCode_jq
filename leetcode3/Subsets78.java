package qiang.leetcode3;

import java.util.ArrayList;
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
    
    public List<List<Integer>> subsets2(int[] nums) {
        
        List<List<Integer>> ans = new ArrayList<>();
        dfs(new ArrayList<Integer>(),nums,0,ans);
        return ans;
    }
    void dfs(List<Integer> tempA, int []nums, int index, List<List<Integer>> ans){
        
        if(index == nums.length){
            ans.add(tempA);
            return;
        }
        List<Integer> newT = new ArrayList<>(tempA);
        newT.add(nums[index]);
        dfs(newT,nums,index+1,ans);
        dfs(tempA,nums,index+1,ans);
        
    }
    /**
     * 这里使用的时候dp的方法
     * 
     * 
     * */
    public List<List<Integer>> subsets3(int[] nums) {
        Arrays.sort(nums); // 首先排序
        List<List<Integer>> lastA = new LinkedList<>();
        lastA.add(new LinkedList<Integer>());
        
        for(int i =0;i< nums.length;i++){
            List<List<Integer>> curA = new LinkedList<>();
            curA.addAll(lastA);
            for(List<Integer> ll:lastA){
                List<Integer> curOne = new ArrayList<>(ll);
                curOne.add(nums[i]);
                curA.add(curOne);
            }
            lastA = curA;
        }        
        return lastA;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Subsets78 sub = new Subsets78();
		int []nums = {1,2,3};
		sub.subsets(nums);
		PrintUtil.print2DList(sub.ans);
	}

}

package qiang.leetcode2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import qiang.leetcode.util.PrintUtil;

public class CountofSmallerNumbersAfterSelf315_BST {

	
	public static void main(String[] args) {
		
		int []nums = {5, 2, 6, 1};
		CountofSmallerNumbersAfterSelf315_BST cc = new CountofSmallerNumbersAfterSelf315_BST();
		PrintUtil.printList(cc.countSmaller3(nums));
	}
	
	/**
	 * 使用BST的方法来求
	 * @param nums
	 * @return
	 */
    public  List<Integer> countSmaller(int[] nums) {
    	LinkedList<Integer> ans = new LinkedList<>();
    	if(nums == null || nums.length ==0)return ans;
    	BST315 bst = new BST315();
    	for(int i =nums.length-1;i >-1;i--){
    		ans.addFirst(bst.findLess(nums[i]));
    		bst.insert(nums[i]);
    	}
    	return ans;
    }
    /**
     *  采用归并排序的思想
     * 1. 使用索引排序
     * 2. 归并两个数组的时候顺便统计每个索引对应的数的leftSmaller
     * 
     * 
     * */
    List<Integer> leftSmaller ;
    public  List<Integer> countSmaller3(int[] nums) { 
        leftSmaller = new ArrayList<>();
        if(nums == null || nums.length < 2) return leftSmaller;   
        int []index = new int[nums.length];
        for(int i = 0;i<nums.length;i++){
            leftSmaller.add(0);
            index[i] = i;
        }
        this.mergeSort(nums,0,nums.length-1,index);
        return leftSmaller;
        
    }
    public void mergeSort(int []nums,int begin,int end,int []index){
        if(begin>=end)return;
        int mid = (begin + end)/2;
        mergeSort(nums,begin,mid,index);
        mergeSort(nums,mid+1,end,index);
        int left = begin;
        int right = mid+1;
        int rightCount = 0;
        int newCount = 0;
        int []newindex = new int[end-begin+1];
        while(left < mid+1 && right < end+1){
            if(nums[index[left]] <= nums[index[right]]){
                newindex[newCount] = index[left];
                leftSmaller.set(index[left],leftSmaller.get(index[left])+rightCount);
                left++;
            } else{
                rightCount++;
                newindex[newCount] = index[right];
                right++;
            }
             newCount++;
        }
        while(left < mid+1){
             newindex[newCount++] = index[left];
             leftSmaller.set(index[left],leftSmaller.get(index[left])+rightCount);
             left++;
        }
        while(right < end+1){
             newindex[newCount++] = index[right++]; 
        }
        for(int k = begin;k<end+1;k++){
            index[k] = newindex[k-begin];
        }
        return;
    }
    
 
}

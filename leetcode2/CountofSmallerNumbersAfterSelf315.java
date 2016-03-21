package qiang.leetcode2;

import java.util.ArrayList;
import java.util.List;

import qiang.leetcode.util.PrintUtil;

public class CountofSmallerNumbersAfterSelf315 {

	
	public static void main(String[] args) {
		
		int []nums = {2,4,5,1};
		CountofSmallerNumbersAfterSelf315 cc = new CountofSmallerNumbersAfterSelf315();
		PrintUtil.printList(cc.countSmaller(nums));
	}
	
	/**
	 * 使用merger sort的方法来求
	 * @param nums
	 * @return
	 */
	 int countSmaller[];
    public  List<Integer> countSmaller(int[] nums) {
        
    	List<Integer> ans = new ArrayList<>();
    	if(nums == null || nums.length ==0)return ans;
    	if(nums.length==1){
    		ans.add(0);
    		return ans;
    	}
    	countSmaller = new int[nums.length];
    	int []indexSort = new int[nums.length];
    	for(int i = 0 ; i < nums.length;i++)indexSort[i] = i;
    	this.mergeSort(nums, indexSort, 0, nums.length-1);
    	for(int k:countSmaller){
    		ans.add(k);
    	}
    	return ans;
    }
    
    /**
     * 包括begin 和 end
     * @param nums
     * @param index
     * @param begin
     * @param end
     */
    void mergeSort(int []nums,int []index,int begin,int end){
    	
    	if(end <= begin) return ; // 小于1个元素不用排序了
    	
    	int mid = (begin+end)/2;
    	mergeSort(nums, index, begin, mid);
    	mergeSort(nums, index, mid+1, end);
    	int newIndex[] = new int[end-begin+1];
    	int left = begin;
    	int right = mid+1;
    	int countRight = 0;
    	int countNew=0;
    	while(left < mid+1 && right < end+1){
    		if(nums[index[right]] < nums[index[left]]){
    			newIndex[countNew] = index[right];
    			right++;
    			countNew++;
    			countRight++;
    		}else{
    			newIndex[countNew] = index[left];
    			countSmaller[index[left]] +=countRight;
    			left++;
    			countNew++;
    		}
    		
    	}
    	while(left < mid+1){
    		newIndex[countNew++] = index[left];
    		countSmaller[index[left]]+=countRight;
    		left++;
    	}
    	while(right < end+1){
    		newIndex[countNew++] = index[right++];
    	}
    	for(int i = begin;i<end+1;i++){
    		index[i] = newIndex[i-begin];
    	}
    }
 
}

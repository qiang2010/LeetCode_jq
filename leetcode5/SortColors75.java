package qiang.leetcode5;

import java.util.Arrays;

public class SortColors75 {

	
	/**
	 * 下面这个方法是统计了 0 1 2 的次数，然后遍历第二遍，重新将数组设置一些就ok
	 * 由于题目follow up要求不能这样做。
	 * @param nums
	 */
    public static void sortColors(int[] nums) {
        if(nums == null || nums.length ==0) return;
    	int []ans = new int[3];
    	int s = nums.length;
    	for(int i=0; i <s; i++){
    		ans[nums[i]]++;
    	}
    	int count =0;
    	for(int j =0 ; j < 3; j++){
    		for(int k=0; k < ans[j]; k++){
    			nums[count++] = j; 
    		}
    			 
    	}
    }
    /** 
      *  这里遍历一遍，使用两个指针
      *  可以使用三个指针，一个从最左边指向左边的第一个非0的位置i，一个从右侧开始指向第一个非2的位置j，
      *  当确定这两个以后，从i开始，找到第一个非1的位置k。
      *  那么k的位置的数字 可能是：  0或者2,
      *  那么i的位置的数字 可能是：  1或者2,
      *  那么j的位置的数字 可能是：  0或者1,
      *  如果k的位置是0，就和i的位置上的元素交换，然后i向前继续找到第一个非0的数字，如果这个时候i超过k，那么更新k为i后面的第一个非1的位置。
      *  如果k的位置是2，那么k就和j位置上的元素交换，然后j的位置向前移动，当k和j交错的时候，停止。
      * @param nums
      */
    public static void sortColors2(int[] nums) {
        if(nums == null || nums.length < 2) return;
    	int s = nums.length;
    	int i =0,j = s-1;
    	int k =0;
    	while(i <= j){
    		
    		while(i < s && nums[i] ==0) i++;
    		while(j > -1 && nums[j]==2)j--;
    		if(i > j) return;
    		if(k<i) // 这个时候需要更新k
    			k = i;
    		while(k <= j && nums[k]==1)k++;
    		if(k >j) return;
    		// 0 就和i位置交换，2 就和 j位置交换。
    		if(nums[k]==0){      
    			swap(nums,k,i);
    			i++;
    		}else{
    			if(nums[k] == 2){
    				swap(nums,k,j);
    				j--;
    			}
    		}
    	}
    }
    public static void swap(int []nums,int i,int j){
    	int s = nums.length;
    	if(i < 0 || i > s) return;
    	if(j < 0 || j > s )return;
    	int a = nums[i];
    	nums[i] = nums[j];
    	nums[j] = a;
    }
    
    public static void main(String[] args) {
		int []nums = {2,1};//{1,2,0,0,2,1,1,1,0,1};
		sortColors2(nums);
		System.out.println(Arrays.toString(nums));
	}
}

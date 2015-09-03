package qiang.leetcode;

public class FindMinimumInRotatedSortedArray153 {

    public static int findMin(int[] nums) {
     
//    	if(nums == null || nums.length == 0) return -1;
    	int size = nums.length;
    	int left = 0 ; 
    	int right = size-1;
    	int mid ;
    	int min = Integer.MAX_VALUE;
    	while(left < right +1){
    		mid = (left + right)/2;
    		if(nums[mid] >= nums[left] ){
    			if(min >  nums[left]){
    				min = nums[left];
    			}
    		left = mid+1;
    		}else{
    			//mid 到 right是有序的
    			if(nums[mid] < min){
    				min = nums[mid];
    			}
    		 right =mid-1;
    		}
    	}
    	return min;
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []nums = {4,2};
		System.out.println(findMin(nums));
	}

}

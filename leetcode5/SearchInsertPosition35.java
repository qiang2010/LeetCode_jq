package qiang.leetcode5;

public class SearchInsertPosition35 {

	
    public int searchInsert(int[] nums, int target) {

    	if(nums.length == 0) return 0;
    	int left = 0 ; 
    	int right = nums.length ;
    	int mid;
    	while(left < right){
    		mid = (left + right) /2;
    		if(nums[mid] == target)
    			return mid;
    		if(nums[mid] < target){
    			left = mid+1;
    		}else{
    			right = mid ;
    		}
    	}
    	return left;
    	
    	
    }	
    
   
    
    
    public int binarySearch2(int []nums,int left,int right,int target){
    	if(left<0 || right <0) return 0;
    	if(left > nums.length || right > nums.length ) return nums.length;
    	if(right == left ){
    		if(target == nums[left]) return left;
    		if(target < nums[right] )
    			return left-1;
    		else
    			return left+1;
    	}	
    	int k = (left + right)/2;
    	if(nums[k] == target) return k;
    	if(nums[k] < target) {
    		return binarySearch2(nums, k+1, right, target);
    	}else{
    		return binarySearch2(nums, left, k-1, target);
    	}
    	
    }
    
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SearchInsertPosition35 sp = new SearchInsertPosition35();
		int []nums = {3,5};
		int target = 1;
		System.out.println(sp.searchInsert(nums, target));
	}

}

package qiang.leetcode5;

public class SearchInRotatedSortedArray33 {

	/**
	 * 有序的数组分成两半A和B，每一半都有序的，并且其中一半完全小于另外一半A<B，那么 组合有 AB 或者BA：
	 * 假设是 AB，那么我们比较 mid 和 位置 left位置 ，必然有a[left] < a[mid] ，无论，mid是在A中，还是B中。
	 * 假设是BA，mid如果在B中，那么必有 a[mid]>a[left]，如果在A中，有 a[mid] < a[left].
	 * 因此，只要有a[mid] > a[left]，那么left到mid直接必然是有序的。
	 * 同时a[left]也是left到mid直接最小的。那么我们需要在mid+1  到right之间继续找。同时和a[left]比较。
	 * @param nums
	 * @param target
	 * @return
	 */
	
    public int search(int[] nums, int target) {
    	if(nums == null || nums.length == 0) return -1;
    	int pivot = searchPivot(nums);
    	System.out.println(pivot);
    	if(pivot==0){
    		return binarySearch(nums, 0, nums.length-1, target);
    	}
    	if(target >= nums[0] ){
    		return binarySearch(nums,0, pivot, target);
    	}
    	return binarySearch(nums, pivot, nums.length-1, target);
    	
    }	
	
    public int binarySearch(int nums[],int left,int right,int target){
    	
    	int mid;
    	while(left <= right){
    		mid = (left + right)/2;
    		if(nums[mid] == target ){
    			return mid;
    		}
    		if(nums[mid]< target){
    			left = mid +1;
    		}else{
    			right = mid-1;
    		}
    	}
    	return -1;
    }
    
    public int searchPivot(int []nums){

    	if(nums == null || nums.length == 0 ) {
    		return -1;
    	}
//    	if(nums.length == 1) return 0;
    	int ans=Integer.MAX_VALUE,pos = 0;
    	int left = 0;
    	int right = nums.length-1;
    	int mid;
    	while(left <= right){
    		mid= (left+right)/2;
    		// left 到 mid 是 有序的
    		if(nums[mid] >= nums[left]){
    			if(ans > nums[left] ){
    				ans = nums[left];
    				pos = left;
    			}
    			left = mid+1;
    		}else{
    			if(nums[mid] < ans){
    				ans = nums[mid];
    				pos = mid;
    			}
    			right = mid-1;
    		}
    	}
    	return pos;
    
    }
	public static void main(String[] args) {
		SearchInRotatedSortedArray33 sr = new SearchInRotatedSortedArray33();
		int []nums={1,2,3};
		int target = 1;
		System.out.println(sr.search4(nums, target)); 
	}
	 public static int search4(int[] nums, int target) {
	        
	    	if(nums == null || nums.length == 0) return -1;
	     
	        int left =0,right = nums.length-1;
	        while(left <= right){
	            int mid = left +((right-left)>>1);
	            if(nums[mid]==target) return mid;
	            else{
	                if(nums[left] <= nums[mid]){
	                    if(nums[left] <= target  && nums[mid] > target){
	                        right = mid-1;
	                    }else{
	                        left = mid+1;
	                    }
	                }else{
	                    if(nums[mid] < target && nums[right] >= target){
	                        left = mid+1;
	                    }else{
	                        right = mid-1;
	                    }
	                }
	            }
	            
	        }
	        
	        return -1;    	
	    
	    }
	    
}

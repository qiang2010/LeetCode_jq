package qiang.leetcode;

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
     
    	if(nums == null || nums.length == 0 ) {
    		return -1;
    	}
    	int ans=-1,pos = -1;
    	int left = 0;
    	int right = nums.length;
    	int mid;
    	while(left < right){
    		mid= (left+right)/2;
    		// left 到 mid 是 有序的
    		if(nums[mid] > nums[left]){
    			if(ans > nums[left] ){
    				ans = nums[left];
    				pos = left;
    			}
    			left = mid+1;
    		}else{
    			// mid 到 right是有序的
    			if(nums[right])
    		}
    		
    		
    	}
    	return ans;
    }	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

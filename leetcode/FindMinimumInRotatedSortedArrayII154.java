package qiang.leetcode;

public class FindMinimumInRotatedSortedArrayII154 {

	public static void main(String[] args) {
		FindMinimumInRotatedSortedArrayII154 sb = new FindMinimumInRotatedSortedArrayII154();
		int []nums = {};
		System.out.println(sb.findMin(nums));
		
	}
	
    
	int min = Integer.MAX_VALUE;
	public int findMin(int[] nums) {
    	
    	findMinInNums(nums, 0, nums.length-1);
    	return min;
        
    }
	void findMinInNums(int []nums,int left,int right){
		
		if(left > right ) return;
		if(left < 0 || right < 0 || left > nums.length-1 || right > nums.length-1) return;
		int mid = (left + right)/2;
		// 严格小于，left到mid是有序的
		if(nums[left] < nums[mid]){
			if(min > nums[left]){
				min = nums[left];
			}
			findMinInNums(nums, mid+1, right);
			return;
		}

		if(nums[left] > nums[mid]){
			if(nums[mid] < min){
				min = nums[mid];
			}
			findMinInNums(nums, left, mid-1);
			return;
		}
		// 相等的时候
		if(nums[mid] < nums[right]){
			if(nums[mid] < min){
				min = nums[mid];
			}
			findMinInNums(nums, left, mid-1);
			return;
		}
		
		if(nums[mid] > nums[right]){
			if(nums[left] < min){
				min = nums[left];
			}
			findMinInNums(nums, mid+1, right);
			return;
		}
		if(nums[mid] < min){
			min = nums[mid];
		}
		findMinInNums(nums, left, mid-1);
		findMinInNums(nums, mid+1, right);
	}
	
}

package qiang.leetcode;

public class FindPeekElement162 {

	
	   
	
	public int findPeakElement(int[] nums) {
		
		if(nums == null) return -1;
		if(nums.length ==1) return 0;
		if(nums[0] > nums[1]) return 0;
		for(int i =1;i<nums.length-1;i++){
			
			if(nums[i] > nums[i-1] && nums[i]>nums[i+1]){
				return i;
			}
		}
		if(nums[nums.length-1] > nums[nums.length-2]) return nums.length-1;
		return -1;
	}
	   
	public static void main(String[] args) {
	
		int []nums = {2,5,1};
		System.out.println(new FindPeekElement162().findPeakElement(nums));
		   
	}
	   
}

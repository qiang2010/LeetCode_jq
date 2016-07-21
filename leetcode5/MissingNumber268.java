package qiang.leetcode5;

public class MissingNumber268 {
	  
	public static void main(String[] args) {
		
		int []nums = {1,2,0,4,5};
		System.out.println(new MissingNumber268().missingNumber(nums));
		
	}
	
	public int missingNumber(int[] nums) {
		
		if(nums == null || nums.length==0) return 0;
		int size = nums.length;
		int sum = size*(size+1)/2;
		int sum0=0;
		for(int a:nums){
			sum0+=a;
		}
		return sum-sum0;
	
	}
}

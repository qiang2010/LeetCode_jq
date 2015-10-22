package qiang.leetcode;

public class MinimunSizeSubarraySum209 {

	
	  
	
	public int minSubArrayLen2(int s, int[] nums) {
		
		if(nums == null || nums.length == 0) return 0;
		int ans = nums.length+1;
		int tempSum =0;
		int begin = 0;

		for(int i =0;i < nums.length;){
					
			while(i<nums.length && tempSum <s){
				tempSum+=nums[i];
				i++;
			}
			if(tempSum>=s){
				if(i-begin < ans){
					ans=i-begin;
				}
				while(tempSum>=s){
					tempSum-=nums[begin++];
				}
				if(i-begin+1 < ans){
					ans=i-begin+1;
				}
			}else{
				break;
			}
		}
		if(ans > nums.length)return 0;
		return ans;
	}
	
	public int minSubArrayLen(int s, int[] nums) {
	
		if(nums == null || nums.length == 0) return 0;
		int ans = nums.length+1;
	
		for(int i=0;i<nums.length;i++){
			int tempSum = 0;
			for(int j = i;j<nums.length;j++){
				if(j-i+1 >= ans) break;
				tempSum+=nums[j];
				if(tempSum >= s){
					if(j-i+1<ans){
						ans = j-i+1;
					}
				}
			}
		}
	
		if(ans > nums.length)return 0;
		return ans;
	}
	public static void main(String[] args) {
		int []nums = {2,3,1,2,4,3,7};
		System.out.println(new MinimunSizeSubarraySum209().minSubArrayLen(7, nums));
		System.out.println(new MinimunSizeSubarraySum209().minSubArrayLen2(7, nums));
	}
}

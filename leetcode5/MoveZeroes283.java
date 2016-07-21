package qiang.leetcode5;

public class MoveZeroes283 {
    
	public static void main(String[] args) {
		
		int [] nums = {0,0,0,0,0,0,0};
		new MoveZeroes283().moveZeroes(nums);
		for(int a:nums){
			System.out.println(a);
		}
		
	}
	public void moveZeroes(int[] nums) {
		
		if(nums == null || nums.length < 2) return ;
		int zeroIndex=0;
		int nonZeroIndex =0;
		int s =  nums.length;
		while(nonZeroIndex < s){
			while(zeroIndex < s && nums[zeroIndex] !=0){
				zeroIndex++;
			}
			if(zeroIndex == s){
				return;
			}
			nonZeroIndex = zeroIndex;
			while(nonZeroIndex<s && nums[nonZeroIndex]==0){
				nonZeroIndex++;
			}
			if(nonZeroIndex == s){
				return;
			}
			nums[zeroIndex] = nums[nonZeroIndex];
			nums[nonZeroIndex] = 0;
			zeroIndex++;
			nonZeroIndex++;
		}
    
	
	}
}

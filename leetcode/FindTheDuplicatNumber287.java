package qiang.leetcode;

public class FindTheDuplicatNumber287 {
   
	public static void main(String[] args) {
		
		int []nums = {1,2};
		System.out.println(new FindTheDuplicatNumber287().findDuplicate(nums));
	}
	
	public int findDuplicate(int[] nums) {
        
		if(nums == null || nums.length==0) return 0;
		
		int ans =0;
		for(int i=0;i<nums.length;i++){
			int index = Math.abs(nums[i]);
			if(nums[index] < 0){
				ans = index;
				break;
			}else{
				nums[index] = -nums[index];
			}
		}
		for(int i =0;i< nums.length;i++){
			nums[i]= Math.abs(nums[i]);
		}
		return ans;
	}
}

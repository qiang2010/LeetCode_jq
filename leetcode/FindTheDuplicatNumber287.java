package qiang.leetcode;

public class FindTheDuplicatNumber287 {
   
	public static void main(String[] args) {
		
		int []nums = {2,5,9,6,9,3,8,9,7,1};
		System.out.println(new FindTheDuplicatNumber287().findDuplicate(nums));
		System.out.println(new FindTheDuplicatNumber287().findDuplicate2(nums));
	}
	
	
	public int findDuplicate2(int[] nums) {
		
		if(nums == null || nums.length==0) return 0;
		int fast =0,slow = 0;
		for(;;){
			fast = nums[fast];
			fast = nums[fast];
			slow = nums[slow];
			if(fast == slow) break;
		}
		slow = 0;
		for(;;){
			slow = nums[slow];
			fast = nums[fast];
			if(slow == fast) return fast;
		}
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

package qiang.leetcode;

public class FindTheDuplicatNumber287 {
   
	public static void main(String[] args) {
		
//		int []nums = {2,5,9,6,9,3,8,9,7,1};
		int []nums = {1,3,4,2,2};
//		System.out.println(new FindTheDuplicatNumber287().findDuplicate(nums));
//		System.out.println(new FindTheDuplicatNumber287().findDuplicate2(nums));
		System.out.println(new FindTheDuplicatNumber287().findDup(nums));
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
	
	/**
	 * 这里使用鸽巢原理来做。
	 * @param nums
	 * @return
	 */
	public int findDup(int []nums){
		int left = 1;
		int right = nums.length-1;
		int mid=0;
		while(left < right){
			mid = (left + ((right-left)>>1));
			int c = 0;
			for(int n:nums){
				if(n <= mid) c++;
			}
			if(c <= mid){
				left = mid+1;
			}else{
				right = mid;
			}
		}
		System.out.println(mid+"\t"+left+"\t"+right);
		return left;
	}
	
}

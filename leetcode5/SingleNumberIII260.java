package qiang.leetcode5;

public class SingleNumberIII260 {

	public static void main(String[] args) {
		
		int []nums ={ 6,8};
		int []ans = new SingleNumberIII260().singleNumber(nums);
		System.out.println(ans[0]+" "+ans[1]);
	}

	
	 
	public int[] singleNumber(int[] nums) {
	        
		int []ans = {0,0};
		if(nums == null )return ans;
		if(nums.length == 2 ){
			return nums;
		}
	
		int c = nums[0];
		for(int i =1;i<nums.length;i++){
			c^=nums[i];
		}
		int mask = c&(~(c-1)); // 找到一个1
		int a =0,b=0;
		for(int i =0;i<nums.length;i++){
			if((mask &nums[i]) == 0){
				a^=nums[i];
			}else{
				b^=nums[i];
			}
		}
		ans[0]=a;
		ans[1]=b;
		return ans;
	}
	
	
}

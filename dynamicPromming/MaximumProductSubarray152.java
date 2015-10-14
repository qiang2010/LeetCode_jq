package qiang.dynamicPromming;

public class MaximumProductSubarray152 {

	
	/**
	 *  maxProduct 超时了，可能是判断的时候有多余的判断。
	 * @param nums
	 * @return
	 */
	public int maxProduct2(int[] nums) {
        
		if(nums == null || nums.length == 0) return 0;
		int size = nums.length;
		int []max = new int[size];
		int []min = new int[size];
		
		int ans = nums[0];
		max[0] = min[0] = nums[0];
		int tempMax ;
		int tempMin ,nextMax,nextMin;
		for(int i=1;i <size; i++){
			nextMax = nums[i]*max[i-1];
			nextMin = nums[i]*min[i-1];
			
			if(nums[i] < nextMax){
				tempMax = nextMax;
				tempMin = nums[i];
			}else{
				tempMin = nextMax;
				tempMax = nums[i];
			}
			if(tempMin > nextMin){
				tempMin = nextMin;
			}
			if(tempMax < nextMin){
				tempMax  = nextMin;
			}
			
			ans = ans > tempMax ? ans:tempMax;
			max[i] = tempMax;
			min[i] = tempMin;
		}
	
		return ans; 
	}
	
	public int maxProduct(int[] nums) {
	        
		if(nums == null || nums.length == 0) return 0;
		int size = nums.length;
		int []max = new int[size];
		int []min = new int[size];
		
		int ans = nums[0];
		max[0] = min[0] = nums[0];
		int tempMax ;
		int tempMin ,nextMax,nextMin;
		for(int i=1;i <size; i++){
			tempMax = tempMin = nums[i];
			nextMax = nums[i]*max[i-1];
			nextMin = nums[i]*min[i-1];
			tempMax = tempMax > nextMax ? tempMax:nextMax;
			tempMax = tempMax > nextMin ? tempMax:nextMin;
			ans = ans > tempMax ? ans:tempMax;
			tempMin = tempMin > nextMax? nextMax:tempMin;
			tempMin = tempMin > nextMin? nextMin:tempMin;
			max[i] = tempMax;
			min[i] = tempMin;
		}
	
		return ans; 
	}
	
	public static void main(String[] args) {

		int nums[] = {2,-9};
		System.out.println(new MaximumProductSubarray152().maxProduct2(nums));
		
	}

}

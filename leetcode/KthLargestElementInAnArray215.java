package qiang.leetcode;

public class KthLargestElementInAnArray215 {

	public static void main(String[] args) {
		
		int [] nums = {2,1};
		System.out.println(new KthLargestElementInAnArray215().findKthLargest(nums, 1));
		
	}
	   
	public int findKthLargest(int[] nums, int k) {
	        
		int left = 0,right = nums.length-1;
		int par = -2;
		while(k != par+1 ){
			par = partation(nums, left, right);
			if( k == par+1){
				return nums[par];
			}
			if( k < par+1){
				right = par-1;; 
			}else{
				left = par+1;
				//k = k -par-1;
			}
		}
		return nums[par];
	}
	
	int partation(int[]nums,int i,int j){
		int tempI = i,tempJ=j;
		i++;
		while(i <= j){
			
			while(i<=tempJ && nums[i] >= nums[tempI]){
				i++;
			}
			while(j>=tempI && nums[j] < nums[tempI]){
				j--;
			}
			if(i<j){
				int temp = nums[i];
				nums[i] = nums[j];
				nums[j] = temp;
			}
		}
		i = i >tempJ? tempJ:i;
		j = j < tempI? tempI:j;
		// 和j的位置上交换
		int tempINum = nums[tempI];
		nums[tempI] = nums[j];
		nums[j] = tempINum;
		return j;
	}
}

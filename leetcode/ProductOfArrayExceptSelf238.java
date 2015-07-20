package qiang.leetcode;

public class ProductOfArrayExceptSelf238 {

	public static  int[] productExceptSelf(int[] nums) {
		
		int [] result = new int[nums.length];
		for (int j =0 ; j<result.length; j++) {
			result[j] = 1;
		}
		
		int baseLeft=1,baseRight = 1;
		for(int i = 0 ; i < nums.length ; i++){
			result[i] *= baseLeft;
			result[nums.length -i -1]*= baseRight;
			
			baseLeft = baseLeft*nums[i];
			baseRight = baseRight* nums[nums.length - i-1];
		}

		return result;
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []a = {9,0,-2 };
		int []res = productExceptSelf(a);
		for(int i: res){
			System.out.println(i);
		}
	}

}

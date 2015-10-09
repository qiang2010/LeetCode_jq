package qiang.leetcode;

public class RotateArray189 {

	
    
	public void rotate(int[] nums, int k) {
    
		if(nums == null || nums.length < 2 )return;
		int size = nums.length;
		if(k > size ) k %=size;
		int firstPartSize = size -k ;
		int secondPartSize = k;
		int []tempPart ;
		if(firstPartSize > secondPartSize){
			tempPart = new int[secondPartSize];
			for(int i = 0; i<secondPartSize;i++){
				tempPart[i] = nums[size-k+i];
			}
			
			for(int j = size-k-1 ; j > -1;j--){
				nums[j+k] = nums[j];
			}
			for(int i = 0 ; i < secondPartSize;i++){
				nums[i] = tempPart[i];
			}
		}else{
			tempPart = new int[firstPartSize];
			for(int i = 0; i<firstPartSize;i++){
				tempPart[i] = nums[i];
			}
			for(int j = size-k ; j < size;j++){
				nums[j-size+k] = nums[j];
			}
			for(int i = 0; i<firstPartSize;i++){
				nums[k+i] = tempPart[i];
			}
		}
		
    }
	public static void main(String[] args) {
		int []nums = {1,2,3,4,5,6,7};
		new RotateArray189().rotate(nums, 0);
		for(int a:nums){
			System.out.println(a);
		}
	}
	
}

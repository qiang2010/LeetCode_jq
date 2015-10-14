package qiang.leetcode;

public class RotateArray189 {

	
	
	
	public void rotate2(int[] nums, int k) {
		
		if(nums == null || nums.length < 2 || k ==0 )return;
		int size = nums.length;
		if(k > size ) k %=size;
		
		reverse(nums, 0, size-1);
		
		reverse(nums, 0, k-1);
		reverse(nums, k, size-1);
		
	}
	
	public void reverse(int []nums,int begin,int end){
		
		if(end < begin ) return ;
		int mid = (begin+end)/2;
		int temp;
		for(int i = begin,j = end; i<= mid; i++,j--){
			temp = nums[i];
			nums[i] = nums[j];
			nums[j] = temp;
		}
	}
	
    
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
		int []nums = {1,2};
		new RotateArray189().rotate2(nums,1);
		for(int a:nums){
			System.out.println(a);
		}
	}
	
}

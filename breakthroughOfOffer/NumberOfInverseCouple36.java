package qiang.breakthroughOfOffer;

public class NumberOfInverseCouple36 {

	public static void main(String[] args) {
		
		int nums[] = {7,5};
		System.out.println(new NumberOfInverseCouple36().countInverse(nums));
		
	}
	
	int countInverse(int nums[]){
		
		return countInv(nums, 0, nums.length-1);
		
	}
	
	int countInv(int []nums,int left,int right){
		
		if(left > right) return 0;
		if(left > nums.length-1 || right > nums.length-1)return 0;
		if(left == right) return 0;
		if(left +1 == right ) return nums[left]>nums[right]?1:0;
		
		int mid = (left+right)/2;
		int leftC = countInv(nums, left, mid);
		int rightC = countInv(nums, mid+1, right);
		int midC = 0;
		for(int i =left;i<mid+1;i++){
			for(int j = mid+1;j<right+1;j++){
				if(nums[i] >  nums[j]) midC++;
			}
		}
		return leftC + rightC + midC;
	}
	
}

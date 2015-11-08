package qiang.breakthroughOfOffer;

public class CountNumTimes38 {

	public static void main(String[] args) {
		
		int []nums = {1,2,3,3,3,3,3,4,5};
		System.out.println(new CountNumTimes38().countNums(nums, 3));
		
	}
	
	

	int countNums(int []nums,int target){
		
		int leftSide = getLeftSide(nums, 0, nums.length-1, target);
		int rightSide = getRightSide(nums, 0, nums.length-1, target); 
		//if(leftSide == - 1|| rightSide == -1) return 1;
		return rightSide - leftSide +1;
	}
	int  getLeftSide(int []nums,int left,int right,int target){
		
		if(left > right) return -1;
		if(left > nums.length-1 || left < 0 || right <0 || right > nums.length-1) return -1;
		if(left == right &&  nums[left]  == target){
			 return left;
		}
		int mid = (left + right) /2;
		if(nums[mid] == target){
			if(mid == 0 || nums[mid-1]!=target){
				return mid;
			}else{
				return getLeftSide(nums, left, mid-1, target);
				}
			
		}else{
			if(nums[mid] < target){
				return getLeftSide(nums, mid+1, right, target);
			}else{
				return getLeftSide(nums, left, mid-1, target);
			}
		}
	}
	
	int getRightSide(int []nums,int left,int right,int target){
		
		if(left > right) return -1;
		if(left > nums.length-1 || left < 0 || right <0 || right > nums.length-1) return -1;
		if(left == right &&  nums[left]  == target){
			 return left;
		}
		int mid = (left + right)/2;
		if(nums[mid] == target){
			if(mid == nums.length-1 || nums[mid+1]!=target){
				return mid;
			}else{
				return getRightSide(nums, mid+1, right, target);
				}
		}else{
			if(nums[mid] < target){
				return getRightSide(nums, mid+1, right, target);
			}else{
				return getRightSide(nums, left, mid-1, target);
			}
		}
		
	}
	
	
}

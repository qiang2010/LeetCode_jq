package qiang.leetcode;

public class FirstMissingPositive41 {

	
	 public int firstMissingPositive(int[] nums) {
		 
		 if(nums == null || nums.length ==0) return 1;
		 
		 int temp;
		 int i=0;
		 while(i < nums.length){
			 
			 if(nums[i] > 0 &&nums[i]!= i+1 && nums[i]-1<nums.length && nums[i] != nums[nums[i]-1]){
				 temp = nums[i];
				 nums[i] = nums[temp-1];
				 nums[temp-1] = temp;
			 }else{
				 i++;
			 }
			 
		 }
		 
		 int j=0;
		 while( j< nums.length && j+1 == nums[j]){
			 j++;
		 }
		 return j+1;
	 }
	
	
	
	/**
	 *  下面的想法也是错误的 
	 * @param nums
	 * @return
	 */
	 public int firstMissingPositive3(int[] nums) {
		 
		 if(nums == null || nums.length == 0) return 1; 
		  int size = nums.length;
		  int minP=nums[0],maxP = nums[0];
		  // 第一遍遍历找到最大最小值。  ===》 这里要找的是正数中的最大最小值。
		  for(int i =1 ; i < size; i++){
			  if(nums[i] <= 0 )continue;
			  if(nums[i] > maxP ){
				  maxP = nums[i];
			  }
			  
			  if(minP < 1) minP = nums[i];
			  if(nums[i] < minP){
				  minP = nums[i];
			}
		 }
		  // 第二次遍历交换位置
		  int swapPos;
		  for(int j = 0 ; j < size; j++){
			  if(nums[j] > 0){
				  swapPos = nums[j]-minP;
				  if(swapPos > size-1){
				  	swapPos = size -1 -(maxP - nums[j]);
				  }
				  // 交换
				  int temp = nums[j];
				  nums[j]= nums[swapPos];
				  nums[swapPos] = temp;
			  }
		  }
		  
		  if(nums[0]>0 && nums[0]!=1) return 1;
		  
		  // 第三遍找到 目标结果
		  int k =0;
		  while(k<size && nums[k]<1  ){
			  k++;
		  }
		  // 所有的都不是正数
		  if(k==size) return 1;
		  k++; // 指向下一个数的位置。
		  
		  for(; k < size; k++){
			  if(nums[k] == nums[k-1]) return nums[k]+1;
			  if(nums[k]<1) return nums[k-1]+1;
			  if(nums[k] != nums[k-1]+1 ){
				  return nums[k-1]+1;
			  }
		  }
		  return nums[k-1] +1;
	 }

	
	/**
	 * 
	 * 下面的这个是错误的解法
	 * @param nums
	 * @return
	 */
    public int firstMissingPositive2(int[] nums) {
    	if(nums == null || nums.length ==0) return 1;
    	int minP = nums[0];
    	int maxP = nums[0];
    	int pSum = 0;
    	int pNum = 0 ;
    	int size = nums.length;
    	for(int i = 0; i < size; i++){
    		if(nums[i] >0){
    			pNum ++;
    			pSum += nums[i];
    			if(minP > nums[i]){
    				minP = nums[i];
    			}else{
    				if(maxP < nums[i]){
    					maxP = nums[i];
    				}
    			}
    		}
    	}
    	if(maxP < 1 ) return 1;
    	int gap = maxP - minP +1;
    	if(gap == pNum){
    		if(minP != 1){
    			return 1;
    		}else{
    			return maxP +1;
    		}
    	}
    	return (minP+maxP)*(gap)/2 - pSum;
    }	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		int nums[]={10,4,16,54,17,-7,21,15,25,31,61,1,6,12,21,46,16,56,54,12,23,20,38,63,2,27,35,11,13,47,13,11,61,39,0,14,42,8,16,54,50,12,-10,43,11,-1,24,38,-10,13,60,0,44,11,50,33,48,20,31,-4,2,54,-6,51,6};
		//int nums[]={0,1,2};
		//System.out.println(nums.length);
		FirstMissingPositive41 fm = new FirstMissingPositive41();
		System.out.println(fm.firstMissingPositive(nums));
	}

}

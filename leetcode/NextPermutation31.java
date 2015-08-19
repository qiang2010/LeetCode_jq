package qiang.leetcode;

public class NextPermutation31 {
    
	public static void nextPermutation(int[] nums) {
        
    	if(nums == null || nums.length <=1) return;
    	int size = nums.length;
    	int i,j;
    	for(i =size-1; i >-1; i--){
    		//for(  j= i-1; j>-1; j--){
    		if(i==0){
    		 	// 不存在 一个数，其左侧存在比起小的数。
    	    	for( i =0;i<size/2;i++){
    	    		j = nums[i];
    	    		nums[i] = nums[size-1-i];
    	    		nums[size-1-i] = j;
    	    	}
    	    	return ;
    		}
    		if(nums[i-1] <nums[i])break;
    		//}
    		// 在左侧找到一个小于nums[i]的数
    		if(j>-1){
    			int k = nums[j];
    			nums[j] = nums[i];
    			nums[i] = k;
    			for(int m =0; m < (size-1-j)/2 ;m++){
    				k = nums[j+1+m];
    				nums[j+1+m] = nums[size-1-m];
    				nums[size-1-m] = k;
    			}
    			return ;
    		}
    	}
   
    	
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []nums = {4,2,0,2,3,2,0};
		nextPermutation(nums);
		int i = 0;
		while(i < nums.length){
			System.out.println(nums[i++]);
		}
	
	}

}
